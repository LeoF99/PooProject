package Tabuleiro;

import jogadores.Jogadores;
import jogadores.SemSaldoException;

public class ImpostoDeRenda implements Casa {

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "Imposto de Renda";
	}

	@Override
	public void fazAcao() {
		Jogadores temp= Jogadores.getInstance();
		System.out.println("Terá que pagar 200$ para o imposto de Renda");
		try {
			temp.getJogadorDaVez().perdeDinehiro(200);
		} catch (SemSaldoException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Saldo Atual: "+temp.getJogadorDaVez().getDinheiro() );
		
	}		

}
