package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Tabuleiro.CartasGenericas;
import Tabuleiro.FilaCartas;

class TestFilaCartas {
	FilaCartas f;
	CartasGenericas a, b;
	
	@BeforeEach
	public void setUp() {
		f = new FilaCartas();
		a = new CartasGenericas("Sua empresa foi multada por poluir demais", 200, 0);
		b = new CartasGenericas("Suas ações na bolsa de valores estão em alta", 0, 100);
	}
	
	@Test
	public void testEnfileirar() {
		assertEquals(0, f.tamanho());//Verifica se fila tem tamanho 0
		f.enfileirar(a);
		assertEquals(1, f.tamanho());//Verifica se fila tem tamanho 1
		f.enfileirar(b);
		assertEquals(2, f.tamanho());//Verifica se fila tem tamanho 2
	}
	
	@Test
	public void testVazio() {
		assertEquals(0, f.tamanho());//Verifica se fila não tem elementos
		assertTrue(f.vazio());
	}

}
