package Tabuleiro;

import jogadores.Jogador;
import jogadores.Jogadores;
import jogadores.SemSaldoException;

public class DiaDoCasamento implements Casa{
	
	public DiaDoCasamento() {
	}
	
	public void fazAcao() {
		System.out.println(toString());
		Jogadores temp= Jogadores.getInstance();
		for(Jogador j :temp.getJogadores()) {
			if(!j.equals(temp.getJogadorDaVez())) {
				try {
					j.perdeDinehiro(50);
				} catch (SemSaldoException e) {
					System.out.println(e.getMessage());
				}
				temp.getJogadorDaVez().ganhaDinheiro(50);
			}
		}
	}
	
	public String toString() {
		return "O seu dia do casamento chegou, receba os presentes"+
				"\nCada jogador paga 50 ao noivo/ noiva";
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}
}
