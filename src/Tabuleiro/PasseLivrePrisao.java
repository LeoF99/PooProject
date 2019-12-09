package Tabuleiro;

import jogadores.Jogadores;

public class PasseLivrePrisao implements Casa{
	public PasseLivrePrisao() {
		
	}

	public void fazAcao(){
		Jogadores temp= Jogadores.getInstance();
		temp.getJogadorDaVez().adereCartaLiberdade();
		System.out.println("Você ganhou o passe Livre para sair da prisão, quando tiver na cadeia poderá usar-la");
	}
	public String getNome() {
		return "Passe Livre Da Prisão";
	}
}	
