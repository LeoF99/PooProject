package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Tabuleiro.VaAteOInicio;
import jogadores.Jogador;
import jogadores.JogadorJaExisteException;
import jogadores.Jogadores;

class TestVaAteOInicio {
	Jogador j;
	VaAteOInicio vi;
	Jogadores js = Jogadores.getInstance();
	
	@BeforeEach
	public void setUp() {
		j = new Jogador("Leo");
		vi = new VaAteOInicio();
		try {
			js.cadastraJogador(j);
		} catch (JogadorJaExisteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testFazAcao() {
		assertEquals(1500, js.getJogadorDaVez().getDinheiro());
		js.getJogadorDaVez().setCasa(5);
		assertEquals(5, js.getJogadorDaVez().getCasa());
		
		vi.fazAcao();
		
		assertEquals(1700, js.getJogadorDaVez().getDinheiro());
		assertEquals(39, js.getJogadorDaVez().getCasa());
	}

}
