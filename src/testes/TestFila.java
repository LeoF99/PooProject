package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jogadores.Fila;

class TestFila {
	Fila f;
	String a, b;
	
	@BeforeEach
	public void setUp() {
		f = new Fila();
		a = "1";
		b = "2";
	}
	
	@Test
	public void testEnfileirar() {
		assertEquals(0, f.tamanho());//Verifica se tamanho da fila é zero
		f.enfileirar(a);//Adiciona elemento na fila
		assertEquals(1, f.tamanho());//Verifica se tamanho da fila é um
		f.enfileirar(b);//Adiciona elemento na fila
		assertEquals(2, f.tamanho());//Verifica se tamanho da fila é 2
	}
	
	@Test
	public void TestVazio() {
		assertTrue(f.vazio());//Verifica se está vazio
	}
	
	@Test
	public void testDesenfileirar() {
		assertTrue(f.vazio());//Verifica se fila está vazia
		f.enfileirar(a);//Adiciona item
		f.enfileirar(b);//Adiciona item
		assertEquals(a, f.desenfileirar());
		assertEquals(b, f.desenfileirar());
	}
}
