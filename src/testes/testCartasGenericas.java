package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Tabuleiro.CartasGenericas;
import jogadores.Jogador;
import jogadores.JogadorJaExisteException;
import jogadores.Jogadores;

class testCartasGenericas {
	CartasGenericas cgPaga;
	CartasGenericas cgRecebe;
	Jogadores js = Jogadores.getInstance();
	Jogador j;
	
	@BeforeEach
	public void setUp() {
		cgPaga = new CartasGenericas("Sua empresa foi multada por poluir demais", 200, 0);
		cgRecebe = new CartasGenericas("Suas ações na bolsa de valores estão em alta", 0, 100);
		Jogador j = new Jogador("Leo");
		try {
			js.cadastraJogador(j);
		} catch (JogadorJaExisteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testFazAcao() {
		assertEquals(1500, js.getJogadorDaVez().getDinheiro());
		cgPaga.fazAcao();
		assertEquals(1300, js.getJogadorDaVez().getDinheiro());
		cgRecebe.fazAcao();
		assertEquals(1400, js.getJogadorDaVez().getDinheiro());
	}
}
