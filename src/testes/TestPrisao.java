package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Tabuleiro.Prisao;
import jogadores.Jogador;


class TestPrisao {
	Prisao p = Prisao.getInstance();
	Jogador j;
	
	@BeforeEach
	public void setUp() {
		j = new Jogador("Leo");
	}
	
	@Test
	public void testAddPrisioneiro() {
		assertEquals(1, p.getPresos().size());//Testa se a quantidade de presos é 0
		p.addPrisioneiro(j);//Adiciona jogador j a prisão
		assertEquals(2, p.getPresos().size());//Testa se a quantidade de presos é 1
	}
	
	@Test
	public void testProcuraPrisioneiro() {
		p.addPrisioneiro(j);//Adiciona jogador j a prisão
		assertTrue(p.procuraPrisioneiro(j));//Verifica se jogador j, está na prisão
	}
	
}
