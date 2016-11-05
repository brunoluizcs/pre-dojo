package dojo.amil.logic.wrapper;

import dojo.amil.model.Jogador;
import dojo.amil.model.Weapon;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Classe para aplicar regra de negócio 
 * @author Bruno
 */
public class Wrapper {
    
    /**
     * Aplica o award de acordo com o critério: Jogadores que matarem 5 vezes em 1 minuto devem ganhar um "award 
     * @param jogador
     * @param mWrapper
     */
    protected void setAwardAxeMurderer(Jogador jogador,WrapperJogador mWrapper) {        
        if (jogador.getKillTime().size() >= 5){            
            Date firstDate;
            Date lastDate;
            for (int i = 0; i < jogador.getKillTime().size(); i++) {
                int limit = i;                    
                int offset = i + 4;
                
               if (jogador.getKillTime().size() -1 < offset) {
                    break;
                }                                 
                firstDate = jogador.getKillTime().get(i);             
                lastDate  = jogador.getKillTime().get(offset);                

                long intervalo = (lastDate.getTime() - firstDate.getTime()) / 1000;                                                  
                if (intervalo <= 60) {                                       
                    mWrapper.getAwards().setAxeMurderer(true);
                    break;
                }                                                   
            }       
        }        
    }    
    
    /**
     * Aplica o award de acordo com o critério: Jogadores que vencerem uma partida sem morrerem devem ganhar um "award";
     * @param jogadores
     */
    protected void setAwardImortal(Collection<WrapperJogador> jogadores) {
        if (jogadores.size() > 0) {
            WrapperJogador campeao = ((List<WrapperJogador>)jogadores).get(0);
            if(campeao.getDeaths() == 0){
                ((List<WrapperJogador>)jogadores).get(0).getAwards().setiAmImortal(true);
            }            
        }
    }       
    
    /**
     * Aplica a colocação dos vencedores,esse metodo exige que a lista já esteja ordenada
     * @param jogadores
     */
    protected void setColocacao(Collection<WrapperJogador> jogadores){
        int i = 1;
        for(WrapperJogador j : jogadores){
            j.setColocacao(i);
            i++;
        }
    }

    /**
     * Descobre a arma preferida(a que mais matou) do vencedor esse metodo espera a lista ja ordenada
     * @param jogadores
     */
    protected void setArmaFavorita(Collection<WrapperJogador> jogadores) {
        if (jogadores.size() > 0) {
            WrapperJogador campeao = ((List<WrapperJogador>)jogadores).get(0);
            if (campeao.getWeapons().size() > 0) {
                Weapon weapon = ((List<Weapon>)campeao.getWeapons()).get(0);
                campeao.setArmaFavorita(String.format("%s KILLS: %d", weapon.getNome(),weapon.getKills()));
                 
            }
        }       
    }    
    
}
