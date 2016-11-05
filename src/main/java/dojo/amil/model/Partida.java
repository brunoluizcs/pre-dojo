package dojo.amil.model;

import java.util.HashMap;

/**
 * Modela a partida indentificada no input
 * @author Bruno
 */
public class Partida {	
	private int id = 0;
	private String inicio = "";
	private String fim = "";
	private HashMap<String, Jogador> jogadores = new HashMap<>();            
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFim() {
		return fim;
	}
	public void setFim(String fim) {
		this.fim = fim;
	}
	public HashMap<String, Jogador> getJogadores() {
		return jogadores;
	}
	public void setJogadores(HashMap<String, Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	
}
