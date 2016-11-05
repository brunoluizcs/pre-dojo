package dojo.amil.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Modela o jogador componente da partida
 * @author Bruno
 */
public class Jogador {
    private String nome = "";
    private int kills = 0;
    private int deaths = 0;
    private int streak = 0;
    private int recordStreak = 0;
    private Awards awards = new Awards();
    private HashMap<String, Weapon> weapons = new HashMap<>();
    private List<Date> killTime = new ArrayList<>();    
     

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

    public int getRecordStreak() {
        return recordStreak;
    }

    public void setRecordStreak(int recordStreak) {
        this.recordStreak = recordStreak;
    }

    public Awards getAwards() {
        return awards;
    }

    public void setAwards(Awards awards) {
        this.awards = awards;
    }

    public HashMap<String, Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(HashMap<String, Weapon> guns) {
        this.weapons = guns;
    }

    public List<Date> getKillTime() {
        return killTime;
    }

    public void setKillTime(List<Date> killTime) {
        this.killTime = killTime;
    }  
    

}
