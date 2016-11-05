package dojo.amil.logic;

import dojo.amil.model.Jogador;
import dojo.amil.model.Partida;
import dojo.amil.model.Weapon;
import dojo.amil.logic.wrapper.WrapperPartida;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe responsavel por processar o arquivo de Log e transforma-los em objetos java.
 * @author Bruno
 */
public class LogReader {        

    /**
     *Expressão regular utilizada para agrupar partidas
     */
    public final static String REGEX_PARTIDA  = "(?<partida>(?<begin>(?<datetimebegin>\\d{2}\\/\\d{2}\\/\\d{4} \\d{2}:\\d{2}:\\d{2})"
                                                  + " - New match (?<idbegin>\\d+?) has started)(?<game>.*?)(?<end>(?<datetimeend>\\d{2}\\/\\d{2}\\/\\d{4} \\d{2}:\\d{2}:\\d{2})"
                                                  + " - Match (?<idend>\\d+?) has ended))";
        
    /**
     *Expressão regular utilizada para agrupar eventos de cada partida
     */
    public final static String REGEX_EVENTO  = "(?<dateTime>\\d{2}\\/\\d{2}\\/\\d{4} \\d{2}:\\d{2}:\\d{2})"
                                                 + " - (?<killer>.*?) (?<action>[killed]{1,}) (?<killed>[\\w]{0,})"
                                                 + " ([using|by]{0,}) (?<gun>[\\w]{0,})";
        
    /**    
    *Processa a expressao regular
    *@param regex padrão da expressão regular a sercompilada
    *@param input input em texto a ser processado
    *@return Matcher objeto com os dados do input agrupados
    */
    private Matcher getMatcher(String regex,String input){
        return Pattern.compile(regex,Pattern.DOTALL).matcher(input);        
    };
        
    /**
     * Converte o input em texto para uma lista 
     * @param input texto a ser processado
     * @return Lista do Objeto WrapperPartida
     * @throws ParseException
     */
    public List<WrapperPartida> serializarPartida(String input) throws ParseException {
        Matcher matcher = getMatcher(REGEX_PARTIDA, input);
        List<WrapperPartida> l = new ArrayList<>();
        int i = 0;
        while (matcher.find()) {
            Partida partida = new Partida();
            partida.setId(Integer.parseInt(matcher.group("idbegin")));
            partida.setInicio(matcher.group("datetimebegin"));
            partida.setFim(matcher.group("datetimeend"));
            partida.setJogadores(serializarJogador(matcher.group("game")));
            l.add(new WrapperPartida(partida, i++));
        }
        return l;
    }

    /**
     * Converte o input de eventos de uma partida para um hashmap
     * @param game texto a ser processado
     * @return HashMap dos jogadores participantes
     * @throws ParseException
     */    
    private HashMap<String, Jogador> serializarJogador(String game) throws ParseException {
        Matcher matcher = getMatcher(REGEX_EVENTO, game);
        HashMap<String, Jogador> hash = new HashMap<>();
        while (matcher.find()) {
            String nome = matcher.group("killer");
            String dateTime = matcher.group("dateTime");
            //Acrescento o kill
            Jogador jogador = hash.get(nome);
            if (jogador == null) {
                jogador = new Jogador();
            }
            jogador.setNome(nome);
            jogador.setKills(jogador.getKills() + 1);
            jogador.setStreak(jogador.getStreak() + 1);
            SimpleDateFormat dt = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
            jogador.getKillTime().add(dt.parse(dateTime));

            //Em kill incremento a quantidade de mortes com aquela arma			
            String weaponName = matcher.group("gun");
            Weapon weapon = jogador.getWeapons().get(weaponName);
            if (weapon == null) {
                weapon = new Weapon();
            }
            weapon.setNome(weaponName);
            weapon.setKills(weapon.getKills() + 1);
            jogador.getWeapons().put(weaponName, weapon);

            //Adiciono o jogador
            hash.put(nome, jogador);

            //Acrescento a death
            nome = matcher.group("killed");
            jogador = hash.get(nome);
            if (jogador == null) {
                jogador = new Jogador();
            }
            jogador.setNome(nome);
            jogador.setDeaths(jogador.getDeaths() + 1);
            if (jogador.getStreak() > jogador.getRecordStreak()) {
                jogador.setRecordStreak(jogador.getStreak());
            }
            jogador.setStreak(0);
            hash.put(nome, jogador);
        }
        return hash;
    }           
    
}
