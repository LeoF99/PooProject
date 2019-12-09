package Tabuleiro;

import java.util.ArrayList;

import jogadores.Jogador;
import jogadores.SemSaldoException;

public class FachadaTabuleiro {

	private static FachadaTabuleiro instance;
	
	private FachadaTabuleiro(){}
	
	public static FachadaTabuleiro getInstance() {
		if(instance==null) instance = new FachadaTabuleiro();
		return instance;
	}

	public void tentaSairPrisao(String aux) {
		Prisao temp= Prisao.getInstance();
		temp.tentaSairPrisao(aux);
		
	}
	
	public void vaiPraPrisao() {
		Prisao temp= Prisao.getInstance();
		temp.vaiPraPrisao();
	}
	
	public boolean procuraPrisioneiro(Jogador j) {
		Prisao temp = Prisao.getInstance();
		return temp.procuraPrisioneiro(j);
	}
	
	public Casa getCasaTabuleiro(int v) {
		Tabuleiro temp= Tabuleiro.getInstance();
		return temp.getCasa(v);
	}
	
	
	public void retiraJogadorDaPrisao(Jogador j) {
		Prisao temp= Prisao.getInstance();
		temp.retiraPrisioneiro(j);
	}
	
	public boolean verificaMonopolio(Jogador j) {
		GerenciamentoDeTerreno temp = GerenciamentoDeTerreno.getInstance();
		return temp.verificaMonopolio(j);
	}
	
	public boolean verificaAmarelo(Jogador j) {
		GerenciamentoDeTerreno temp = GerenciamentoDeTerreno.getInstance();
		return temp.verificaAmarelo(j);
	}
	
	public boolean verificaAzul(Jogador j) {
		GerenciamentoDeTerreno temp = GerenciamentoDeTerreno.getInstance();
		return temp.verificaAzul(j);
	}
	
	public boolean verificaCiano(Jogador j) {
		GerenciamentoDeTerreno temp = GerenciamentoDeTerreno.getInstance();
		return temp.verificaCiano(j);
	}
	
	public boolean verificaRoxo(Jogador j) {
		GerenciamentoDeTerreno temp = GerenciamentoDeTerreno.getInstance();
		return temp.verificaRoxo(j);
	}
	
	public boolean verificaRosa(Jogador j) {
		GerenciamentoDeTerreno temp = GerenciamentoDeTerreno.getInstance();
		return temp.verificaRosa(j);
	}
	
	public boolean verificaLaranja(Jogador j) {
		GerenciamentoDeTerreno temp = GerenciamentoDeTerreno.getInstance();
		return temp.verificaLaranja(j);
	}
	
	public boolean verificaVermelho(Jogador j) {
		GerenciamentoDeTerreno temp = GerenciamentoDeTerreno.getInstance();
		return temp.verificaVermelho(j);
	}
	
	public boolean verificaVerde(Jogador j) {
		GerenciamentoDeTerreno temp = GerenciamentoDeTerreno.getInstance();
		return temp.verificaVerde(j);
	}
	
	public ArrayList<TerrenoAmarelo> getTerrenoAmarelo(){
		GerenciamentoDeTerreno temp = GerenciamentoDeTerreno.getInstance();
		return temp.getListAmarelo();
	}
	
	public ArrayList<TerrenoAzul> getTerrenoAzul(){
		GerenciamentoDeTerreno temp = GerenciamentoDeTerreno.getInstance();
		return temp.getListAzul();
	}
	
	public ArrayList<TerrenoRoxo> getTerrenoRoxo(){
		GerenciamentoDeTerreno temp = GerenciamentoDeTerreno.getInstance();
		return temp.getListRoxo();
	}
	
	public ArrayList<TerrenoRosa> getTerrenoRosa(){
		GerenciamentoDeTerreno temp = GerenciamentoDeTerreno.getInstance();
		return temp.getListRosa();
	}
	
	public ArrayList<TerrenoVerde> getTerrenoVerde(){
		GerenciamentoDeTerreno temp = GerenciamentoDeTerreno.getInstance();
		return temp.getListVerde();
	}
	
	public ArrayList<TerrenoVermelho> getTerrenoVermelho(){
		GerenciamentoDeTerreno temp = GerenciamentoDeTerreno.getInstance();
		return temp.getListVermelho();
	}
	
	public ArrayList<TerrenoLaranja> getTerrenoLaranja(){
		GerenciamentoDeTerreno temp = GerenciamentoDeTerreno.getInstance();
		return temp.getListLaranja();
	}
	
	public ArrayList<TerrenoCiano> getTerrenoCiano(){
		GerenciamentoDeTerreno temp = GerenciamentoDeTerreno.getInstance();
		return temp.getListCiano();
	}
	
	public void compraCasa(Terreno terreno, Jogador j) {
		try {
			terreno.compraCasa(j);
		} catch (SemSaldoException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void vendeCasa(Terreno terreno) {
		terreno.vendeCasa();
	}
}
