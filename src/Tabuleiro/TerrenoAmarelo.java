package Tabuleiro;

import jogadores.Jogador;

public class TerrenoAmarelo extends Terreno implements Casa,Comercial {
	private GerenciamentoDeTerreno gerenciador = GerenciamentoDeTerreno.getInstance();

	public TerrenoAmarelo(String nome, int preco, int aluguel, int aluguel1Casa, int aluguel2Casas, int aluguel3Casas,
			int aluguel4Casas, int aluguelHotel, int hipoteca, int precoCasa) {
		
		super(nome, preco, aluguel, aluguel1Casa, aluguel2Casas, aluguel3Casas, aluguel4Casas, aluguelHotel, hipoteca,
				precoCasa);
		
	}
	
	public String getCor() {
		return "Amarelo";
	}

	public boolean verificaMonopolioPorCor(Jogador j) {
		return gerenciador.verificaAmarelo(j);
	}

	@Override
	public boolean verificaPreMonopolioPorCor(Jogador j) {
		return gerenciador.verificaAmareloPre(j);
	}
}
