package Tabuleiro;

import jogadores.Jogadores;

public class VaPraPrisao implements Casa {



	
	
	public String getNome() {
		return "V� para a Pris�o";
	}

	@Override
	public void fazAcao() {
		Prisao prisao = Prisao.getInstance();
		Jogadores temp= Jogadores.getInstance();
		prisao.addPrisioneiro(temp.getJogadorDaVez());
		temp.getJogadorDaVez().setCasa(9);
		System.out.println("O jogador "+temp.getJogadorDaVez().getNome()+" pegou a carta de Rev�s 'V� para a prisao' e esta detido. Na sua proxima "
				+ "rodada, ter� mais comandos disponiveis.");
		
	}
}
