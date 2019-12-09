package testes;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Tabuleiro.DiaDoCasamento;
import jogadores.Jogador;
import jogadores.JogadorJaExisteException;
import jogadores.Jogadores;

class TestDiaDoCasamento {
	DiaDoCasamento dc;
	Jogadores js = Jogadores.getInstance();
	Jogador j1;
	Jogador j2;
	Jogador j3;	
	
	@BeforeEach
	public void setUp() {
		dc = new DiaDoCasamento();
		j1 = new Jogador("1");
		j2 = new Jogador("2");
		j3 = new Jogador("3");
		
		try {
			js.cadastraJogador(j1);
			js.cadastraJogador(j2);
			js.cadastraJogador(j3);
		} catch (JogadorJaExisteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testFazAcao() {
		assertEquals(1500, j1.getDinheiro());
		assertEquals(1500, j2.getDinheiro());
		assertEquals(1500, j3.getDinheiro());
		
		dc.fazAcao();
		
		assertEquals(1600, j1.getDinheiro());
		assertEquals(1450, j2.getDinheiro());
		assertEquals(1450, j3.getDinheiro());
	}
		
}
