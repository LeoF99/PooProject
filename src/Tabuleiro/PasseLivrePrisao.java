package Tabuleiro;

import jogadores.Jogadores;

public class PasseLivrePrisao implements Casa{
	public PasseLivrePrisao() {
		
	}

	public void fazAcao(){
		Jogadores temp= Jogadores.getInstance();
		temp.getJogadorDaVez().adereCartaLiberdade();
		System.out.println("Voc� ganhou o passe Livre para sair da pris�o, quando tiver na cadeia poder� usar-la");
	}
	public String getNome() {
		return "Passe Livre Da Pris�o";
	}
}	
