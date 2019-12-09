package Tabuleiro;

public class PontoDePartida implements Casa {
	
	public PontoDePartida() {
		
	}

	@Override
	public String getNome() {
		return "Ponto de Partida";
	}

	@Override
	public void fazAcao() {
		System.out.println(getNome());
		
	}
	

}
