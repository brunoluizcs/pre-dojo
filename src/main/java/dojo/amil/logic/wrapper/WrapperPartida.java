package dojo.amil.logic.wrapper;

import dojo.amil.model.Jogador;
import dojo.amil.model.Partida;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Classe aplica regra de negócio,é modelada de acordo com o padrão que vai ser retornado para view 
 * @author Bruno
 */
public class WrapperPartida extends Wrapper {
    private long index = 0;//Utilizado como identificador unico do registro
    private int id = 0;
    private String inicio = "";
    private String fim = "";    
    private Collection<WrapperJogador> jogadores = new ArrayList<>();
    
    /**
     * Constroi o objeto com base no objeto Partida
     * @param partida
     * @param index indice único da partida independe do id
     */    
    public WrapperPartida(Partida partida,int index) {
        this.index = index;
        id = partida.getId();
        inicio = partida.getInicio();
        fim = partida.getFim();              
        
        for(Jogador j: partida.getJogadores().values()) {
            if (!"<WORLD>".equals(j.getNome())) {
                jogadores.add(new WrapperJogador(j));    
            }            
        }         
        Collections.sort((List<WrapperJogador>) jogadores,new Comparator<WrapperJogador>() {
            @Override
            public int compare(WrapperJogador o1, WrapperJogador o2) {
                if (o2.getKills() == o1.getKills()) {
                    return (o2.getKills() - o2.getDeaths()) - (o1.getKills() - o1.getDeaths());    
                }else{
                    return o2.getKills() - o1.getKills();    
                }                
            }
        });             
        super.setAwardImortal(jogadores);        
        super.setArmaFavorita(jogadores); 
        super.setColocacao(jogadores);
    }  

    public Collection<WrapperJogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(Collection<WrapperJogador> jogadores) {
        this.jogadores = jogadores;
    }
    
    
    
}
