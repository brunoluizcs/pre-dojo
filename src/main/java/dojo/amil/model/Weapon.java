package dojo.amil.model;

/**
 * Modela a arma utilizada pelo jogador
 * @author Bruno
 */
public class Weapon {
	private String nome = "";
	private int kills = 0;
	
	
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
	
	

}
