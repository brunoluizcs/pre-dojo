package dojo.amil.logic.wrapper;

import dojo.amil.model.Awards;
import dojo.amil.model.Jogador;
import dojo.amil.model.Weapon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Classe aplica regra de negócio, e é modelada de acordo com o padrão que vai ser retornado para view 
 * @author Bruno
 */
public class WrapperJogador extends Wrapper{    
    private int colocacao = 0;
    private String nome = "";
    private int kills = 0;
    private int deaths = 0;
    private int streak = 0;    
    private Awards awards = new Awards();
    private String armaFavorita = "";
    private List<Weapon> weapons = new ArrayList<>();       

    /**
     * Constroi o objeto com base no objeto Jogador
     * @param jogador
     */
    public WrapperJogador(Jogador jogador) {                
        nome = jogador.getNome();
        kills = jogador.getKills();
        deaths = jogador.getDeaths();
        streak = jogador.getStreak() > jogador.getRecordStreak() ? jogador.getStreak() : jogador.getRecordStreak();                
        for(Weapon w : jogador.getWeapons().values()){
            weapons.add(w);
        }
        Collections.sort(weapons,new Comparator<Weapon>() {
            @Override
            public int compare(Weapon o1, Weapon o2) {
                return o2.getKills() - o1.getKills();
            }
        });         
        super.setAwardAxeMurderer(jogador,this);            
    }           

    public int getColocacao() {
        return colocacao;
    }

    public void setColocacao(int colocacao) {
        this.colocacao = colocacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getStreak() {
        return streak;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    public Awards getAwards() {
        return awards;
    }

    public void setAwards(Awards awards) {
        this.awards = awards;
    }

    public String getArmaFavorita() {
        return armaFavorita;
    }

    public void setArmaFavorita(String armaFavorita) {
        this.armaFavorita = armaFavorita;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }
    
    
    
}
