package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jogadores.Jogador;
import jogadores.JogadorJaExisteException;
import jogadores.Jogadores;

class TestJogadores {
	Jogadores jogadores;
	Jogador j;
	
	@BeforeEach
	public void setUp() {
		jogadores = Jogadores.getInstance();
		j = new Jogador("Leo");
	}
	
	@Test
	public void testCadastraJogador() throws JogadorJaExisteException {
		assertEquals(0, jogadores.getJogadores().size());//Verifica se possui 0 jogadores na lista
		jogadores.cadastraJogador(j);//cadastra jogador j na lista
		assertEquals(1, jogadores.getJogadores().size());//verifica de possui 1 jogador na lista
	}
	
	@Test
	public void testRetiraJogador() throws JogadorJaExisteException {
		jogadores.cadastraJogador(j);//cadastra jogador j na lista
		assertEquals(1, jogadores.getJogadores().size());// verifica de possui 1 jogador na lista
		jogadores.retiraJogador(j);//tenta retirar jogador j da lista
		assertEquals(0, jogadores.getJogadores().size());//verifica se retirou jogador da lista
	}
	
	@Test
	public void testSize() {
		assertEquals(jogadores.getJogadores().size(), jogadores.size());//Verifica se tamanho da lista é igual a quantidade de jogadores
	}

}
