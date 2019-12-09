package Tabuleiro;

import jogadores.Jogadores;

public class VaAteOInicio implements Casa{
	public VaAteOInicio() {
		
	}
	
	public void fazAcao() {
		Jogadores temp= Jogadores.getInstance();
		System.out.println(toString());
		temp.getJogadorDaVez().setCasa(39);
		temp.getJogadorDaVez().ganhaDinheiro(200);
	}
	
	public String toString() {
		return "Vá até o início e receba 200";
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}
}
