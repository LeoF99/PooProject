package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Tabuleiro.ImpostoDeRenda;
import jogadores.Jogador;
import jogadores.JogadorJaExisteException;
import jogadores.Jogadores;

class TestImpostoDeRenda {
	ImpostoDeRenda ir;
	Jogador j;
	Jogadores js = Jogadores.getInstance();
	
	@BeforeEach
	public void setUp() {
		ir = new ImpostoDeRenda();
		j = new Jogador("Leo");
		try {
			js.cadastraJogador(j);
		} catch (JogadorJaExisteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testFazAcao(){
		assertEquals(1500, js.getJogadorDaVez().getDinheiro());
		ir.fazAcao();
		assertEquals(1300, js.getJogadorDaVez().getDinheiro());
	}
	
}
