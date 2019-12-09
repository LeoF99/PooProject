package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Tabuleiro.TerrenoVerde;
import jogadores.Jogador;
import jogadores.SemSaldoException;


class TestTerreno {
	TerrenoVerde terreno;
	Jogador j1;
	Jogador j2;
	
	@BeforeEach
	public void setUp() {
		terreno = new TerrenoVerde("Lapa", 400, 100, 160, 220, 400, 500, 600, 200, 50);
		j1 = new Jogador("Leo");
		j2 = new Jogador("Vinicius");
	}
	
	@Test
	public void testCompraCasa() throws SemSaldoException {
		assertEquals(0, terreno.getCasas());//verifica se quantidade de casas no terreno é zero
		terreno.compraCasa(j1);//j1 compra casa em terreno
		assertEquals(1, terreno.getCasas());//verifica se quantidade de casas é um
		terreno.compraCasa(j1);//j1 compra casa em terreno
		assertEquals(2, terreno.getCasas());//verifica se quantidade de casas é dois
	}
	
	@Test
	public void testPagaAluguel() throws SemSaldoException {
		assertEquals(1500, j1.getDinheiro());//verifica o dinheiro do primeiro jogador
		assertEquals(1500, j2.getDinheiro());//verifica o dinheiro do segundo jogador
		terreno.pagaAluguel(j2, j1);//j2 faz o pagamento do aluguel para j1
		assertEquals(1600, j2.getDinheiro());//verifica se o saldo de j2 diminuiu
		assertEquals(1400, j1.getDinheiro());//verifica se saldo de j1 aumentou
	}
	
	@Test
	public void testCompra() throws SemSaldoException {
		terreno.compra(j1);//j1 compra terreno
		assertEquals("Leo", terreno.getProprietario().getNome());//verifica se j1.nome é igual ao proprietário do terreno
	}
}
