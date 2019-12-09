package Tabuleiro;

public class ParadaLivre implements Casa {

	@Override
	public String getNome() {
		 return "Parada Livre";
	}

	@Override
	public void fazAcao() {
		System.out.println(getNome());
		
	}

	
}
