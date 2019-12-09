package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jogadores.Jogador;
import jogadores.SemSaldoException;

class TestJogador {
	Jogador j;
	int money, a, b;
	
	@BeforeEach
	public void setUp() {
		j = new Jogador("Leo");
		money = 100;
		a = 1600;
		b = 1400;
	}
	
	@Test
	public void testGanhaDinheiro() {
		assertEquals(a, j.ganhaDinheiro(money));//verifica se jogador ganhou dinheiro
	}
	
	@Test
	public void testPerdeDinheiro() throws SemSaldoException {
		assertEquals(b, j.perdeDinehiro(money));//verifica se jogador perdeu dinheiro
	}
	
	@Test
	public void testAddStatus() {
		assertEquals(0, j.getStatus().length());//verifica se status está vazio
		j.addStatus("Preso");//adiciona algo ao status
		assertEquals(6, j.getStatus().length());//verifica se status não está mais vazio
	}
	
}
