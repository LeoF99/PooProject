package Tabuleiro;

import jogadores.Jogador;
import jogadores.Jogadores;

public class VaParaPrisaoSR implements Casa{
	public VaParaPrisaoSR() {
		
	}
	
	public void geraEfeito(Jogador j) {
}
	
	public String toString() {
		return "Vá para a prisão";
	}

	@Override
	public void fazAcao() {
		Prisao prisao = Prisao.getInstance();
		Jogadores temp= Jogadores.getInstance();
		prisao.addPrisioneiro(temp.getJogadorDaVez());
		temp.getJogadorDaVez().setCasa(9);
		System.out.println("O jogador "+temp.getJogadorDaVez().getNome()+" pegou a carta de Revés 'Va para a prisao' e esta detido. Na sua proxima "
				+ "rodada, terá mais comandos disponiveis.");
		
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}
}
