package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Tabuleiro.LucrosOuDividendo;
import jogadores.Jogador;
import jogadores.JogadorJaExisteException;
import jogadores.Jogadores;

class TestLucrosOuDividendos {
	LucrosOuDividendo ld;
	Jogador j;
	int di;//dinheiro inicial de todo jogador
	Jogadores js = Jogadores.getInstance();
	
	@BeforeEach
	public void setUp() {
		ld = new LucrosOuDividendo();
		j = new Jogador("Leo");
		di = 1500;
		try {
			js.cadastraJogador(j);
		} catch (JogadorJaExisteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testFazAcao() {
		assertEquals(di, js.getJogadorDaVez().getDinheiro());
		ld.fazAcao();
		assertEquals(di+200, js.getJogadorDaVez().getDinheiro());
	}

}
