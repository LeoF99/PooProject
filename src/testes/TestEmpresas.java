package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Tabuleiro.Empresas;
import jogadores.Jogador;
import jogadores.SemSaldoException;

class TestEmpresas {
	Empresas empresa;
	Jogador j1;
	
	@BeforeEach
	public void setUp() {
		empresa = new Empresas("TekFim", 200, 100, 2);
		j1 = new Jogador("1");
	}
	
	@Test
	public void testCompra() throws SemSaldoException {
		empresa.compra(j1);//faz a compra da empresa para o jogador j1
		assertEquals("Leo", empresa.getProprietario().getNome());////verifica se proprietário da empresa é jogador j1
	}
}
