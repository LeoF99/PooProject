package jogadores;

import java.util.ArrayList;

public class Jogadores{

	private ArrayList<Jogador> jogadores;
	private static Jogadores instance;
	private int vez;
	
	private Jogadores() {
		this.jogadores=new ArrayList<Jogador>();
		vez=0;
	}
	
	public static Jogadores getInstance() {//Método p/ pegar instancia uníca do Singleton
		if(instance==null) instance = new Jogadores();
		return instance;
	}
	
	public void cadastraJogador(Jogador j1) throws JogadorJaExisteException{//Cadastra um novo jogador
		if(this.jogadores.isEmpty()) {
			jogadores.add(j1);
		}else {
			for(Jogador i: this.jogadores) {
				if(i.equals(j1)) throw new JogadorJaExisteException();
			}
			this.jogadores.add(j1);
		}
		
	}
	public void retiraJogador(Jogador j1) {//Remove um jogador
		this.jogadores.remove(j1);
	}
	
	public void toStrings() {//Imprime as informações do jogador
		for(Jogador i: this.jogadores) {
			System.out.println(i.toString());
		}
		
	}
	public int size() {//Retorna qntd de jogadores
		return this.jogadores.size();
	}
	
	public Jogador getJogador(int i) {//Retorna jogador específico
		return this.jogadores.get(i);
	}
	
	public ArrayList<Jogador> getJogadores(){//Retorna lista de jogadores
		return this.jogadores;
	}
	
	public void passaVez() {//Passa a rodada para o próximo jogador
		if(++vez==jogadores.size()) vez=0;
	}
	
	public Jogador getJogadorDaVez() {//Retorna o jogador da rodada atual
		return jogadores.get(vez);
	}
}
