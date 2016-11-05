package dojo.amil.model;

/**
 * Modelo de objeto Awards que compoem um jogador
 * @author Bruno
 */
public class Awards {
    
    private boolean iAmImortal = false; //Award para jogadores que venceram a partida sem morrer
    private boolean axeMurderer  = false;//Award para jogadores que mataram 5 vezes em 1 minuto

    public boolean isiAmImortal() {
        return iAmImortal;
    }

    public void setiAmImortal(boolean iAmImortal) {
        this.iAmImortal = iAmImortal;
    }

    public boolean isAxeMurderer() {
        return axeMurderer;
    }

    public void setAxeMurderer(boolean axeMurderer) {
        this.axeMurderer = axeMurderer;
    }
    
    
    
}
