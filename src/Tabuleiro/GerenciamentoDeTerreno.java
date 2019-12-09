package Tabuleiro;

import java.util.ArrayList;
import jogadores.Jogador;

public class GerenciamentoDeTerreno {

	private static GerenciamentoDeTerreno instance;
	private ArrayList<TerrenoAmarelo> ListAmarelo = new  ArrayList<TerrenoAmarelo>();
	private ArrayList<TerrenoAzul> ListAzul = new  ArrayList<TerrenoAzul>();
	private ArrayList<TerrenoCiano> ListCiano = new  ArrayList<TerrenoCiano>();
	private ArrayList<TerrenoLaranja> ListLaranja = new  ArrayList<TerrenoLaranja>();
	private ArrayList<TerrenoRosa> ListRosa = new  ArrayList<TerrenoRosa>();
	private ArrayList<TerrenoRoxo> ListRoxo = new  ArrayList<TerrenoRoxo>();
	private ArrayList<TerrenoVerde> ListVerde = new  ArrayList<TerrenoVerde>();
	private ArrayList<TerrenoVermelho> ListVermelho = new  ArrayList<TerrenoVermelho>();
	
	
	private GerenciamentoDeTerreno(){}
	
	public static GerenciamentoDeTerreno getInstance() {
		if(instance==null) instance = new GerenciamentoDeTerreno();
		return instance;
	}
	//verificaCor = verifica se proprietário tem todos os terrenos daquela cor
	public boolean verificaAmarelo(Jogador j) {
		int cont = 0;
		for(TerrenoAmarelo i :ListAmarelo) {
			if(i.getProprietario()==null) break;
			if(i.getProprietario().equals(j)) cont++ ;
			else break;
		}
		if(cont==ListAmarelo.size() && cont > 0) return true;
		else return false;
	}
	
	public boolean verificaAzul(Jogador j) {
		int cont = 0;
		for(TerrenoAzul i : ListAzul) {
			if(i.getProprietario()==null) break;
			if(i.getProprietario().equals(j)) cont++;
			else break;
		}
		if(cont==ListAzul.size() && cont > 0) return true;
		else return false;
	}
	
	public boolean verificaCiano(Jogador j) {
		int cont = 0;
		for(TerrenoCiano i : ListCiano) {
			if(i.getProprietario()==null) break;
			if(i.getProprietario().equals(j)) cont++;
			else break;
		}
		if(cont==ListCiano.size() && cont > 0) return true;
		else return false;
	}
	
	public boolean verificaLaranja(Jogador j) {
		int cont = 0;
		for(TerrenoLaranja i : ListLaranja) {
			if(i.getProprietario()==null) break;
			if(i.getProprietario().equals(j)) cont++;
			else break;
		}
		if(cont==ListLaranja.size() && cont > 0) return true;
		else return false;
	}
	
	public boolean verificaRosa(Jogador j) {
		int cont = 0;
		for(TerrenoRosa i : ListRosa) {
			if(i.getProprietario()==null) break;
			if(i.getProprietario().equals(j)) cont++;
			else break;
		}
		if(cont == ListRosa.size() && cont > 0) return true;
		else return false;
	}
	
	public boolean verificaRoxo(Jogador j) {
		int cont = 0;
		for(TerrenoRoxo i : ListRoxo) {
			if(i.getProprietario()==null) break;
			if(i.getProprietario().equals(j)) cont++;
			else break;
		}
		if(cont == ListRoxo.size() && cont > 0) return true;
		else return false;
	}
	
	public boolean verificaVerde(Jogador j) {
		int cont = 0;
		for(TerrenoVerde i : ListVerde) {
			if(i.getProprietario()==null) break;
			if(i.getProprietario().equals(j)) cont++;
			else break;
		}
		if(cont == ListVerde.size() && cont > 0) return true;
		else return false;
	}
	
	public boolean verificaVermelho(Jogador j) {
		int cont = 0;
		for(TerrenoVermelho i : ListVermelho) {
			if(i.getProprietario()==null) break;
			if(i.getProprietario().equals(j)) cont++;
			else break;
		}
		if(cont == ListVermelho.size() && cont > 0) return true;
		else return false;
	}
	
	public boolean verificaMonopolio(Jogador temp) {//verifica se jogador tem algum monopólio de  terrenos de certa cor
		if(verificaAmarelo(temp)) {
			return true;
		}if(verificaAzul(temp)) {
			return true;
		}if(verificaCiano(temp)) {
			return true;
		}if(verificaLaranja(temp)) {
			return true;
		}if(verificaRosa(temp)) {
			return true;
		}if(verificaRoxo(temp)) {
			return true;
		}if(verificaVerde(temp)) {
			return true;
		}if(verificaVermelho(temp)) {
			return true;
		}
		return false;
	}

	public ArrayList<TerrenoAmarelo> getListAmarelo() {
		return ListAmarelo;
	}

	public ArrayList<TerrenoAzul> getListAzul() {
		return ListAzul;
	}

	public ArrayList<TerrenoCiano> getListCiano() {
		return ListCiano;
	}

	public ArrayList<TerrenoLaranja> getListLaranja() {
		return ListLaranja;
	}

	public ArrayList<TerrenoRosa> getListRosa() {
		return ListRosa;
	}

	public ArrayList<TerrenoRoxo> getListRoxo() {
		return ListRoxo;
	}

	public ArrayList<TerrenoVerde> getListVerde() {
		return ListVerde;
	}

	public ArrayList<TerrenoVermelho> getListVermelho() {
		return ListVermelho;
	}
	
	public void addAmarelo(TerrenoAmarelo terreno) {
		ListAmarelo.add(terreno);
	}
	
	public void addAzul(TerrenoAzul t) {
		ListAzul.add(t);
	}
	
	public void addCiano(TerrenoCiano t) {
		ListCiano.add(t);
	}
	
	public void addLaranja(TerrenoLaranja t) {
		ListLaranja.add(t);
	}
	
	public void addRosa(TerrenoRosa t) {
		ListRosa.add(t);
	}
	
	public void addRoxo(TerrenoRoxo t) {
		ListRoxo.add(t);
	}
	
	public void addVerde(TerrenoVerde t) {
		ListVerde.add(t);
	}
	
	public void addVermelho(TerrenoVermelho t) {
		ListVermelho.add(t);
	}
	
	public boolean verificaAmareloPre(Jogador j) {
		int cont = 0;
		for(TerrenoAmarelo i :ListAmarelo) {
			if(i.getProprietario()==null) break;
			if(i.getProprietario().equals(j)) cont++ ;
			else break;
		}
		if(cont==ListAmarelo.size()-1 && cont > 0) return true;
		else return false;
	}
	
	public boolean verificaAzulPre(Jogador j) {
		int cont = 0;
		for(TerrenoAzul i : ListAzul) {
			if(i.getProprietario()==null) break;
			if(i.getProprietario().equals(j)) cont++;
			else break;
		}
		if(cont==ListAzul.size()-1 && cont > 0) return true;
		else return false;
	}
	
	public boolean verificaCianoPre(Jogador j) {
		int cont = 0;
		for(TerrenoCiano i : ListCiano) {
			if(i.getProprietario()==null) break;
			if(i.getProprietario().equals(j)) cont++;
			else break;
		}
		if(cont==ListCiano.size()-1 && cont > 0) return true;
		else return false;
	}
	
	public boolean verificaLaranjaPre(Jogador j) {
		int cont = 0;
		for(TerrenoLaranja i : ListLaranja) {
			if(i.getProprietario()==null) break;
			if(i.getProprietario().equals(j)) cont++;
			else break;
		}
		if(cont==ListLaranja.size()-1 && cont > 0) return true;
		else return false;
	}
	
	public boolean verificaRosaPre(Jogador j) {
		int cont = 0;
		for(TerrenoRosa i : ListRosa) {
			if(i.getProprietario()==null) break;
			if(i.getProprietario().equals(j)) cont++;
			else break;
		}
		if(cont == ListRosa.size()-1 && cont > 0) return true;
		else return false;
	}
	
	public boolean verificaRoxoPre(Jogador j) {
		int cont = 0;
		for(TerrenoRoxo i : ListRoxo) {
			if(i.getProprietario()==null) break;
			if(i.getProprietario().equals(j)) cont++;
			else break;
		}
		if(cont == ListRoxo.size()-1 && cont > 0) return true;
		else return false;
	}
	
	public boolean verificaVerdePre(Jogador j) {
		int cont = 0;
		for(TerrenoVerde i : ListVerde) {
			if(i.getProprietario()==null) break;
			if(i.getProprietario().equals(j)) cont++;
			else break;
		}
		if(cont == ListVerde.size()-1 && cont > 0) return true;
		else return false;
	}
	
	public boolean verificaVermelhoPre(Jogador j) {
		int cont = 0;
		for(TerrenoVermelho i : ListVermelho) {
			if(i.getProprietario()==null) break;
			if(i.getProprietario().equals(j)) cont++;
			else break;
		}
		if(cont == ListVermelho.size()-1 && cont > 0) return true;
		else return false;
	}
}
