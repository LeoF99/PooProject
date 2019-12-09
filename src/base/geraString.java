package base;

import java.util.ArrayList;

import Tabuleiro.*;
import jogadores.Jogador;

public class GeraString {

	private static GeraString instance = null;
	private ArrayList<Terreno> construcoes = new ArrayList<Terreno>();
	
	private GeraString() {
		
	}
	
	public static GeraString getInstance() {
		if(instance == null) instance = new GeraString();
		return instance;
	}
	
	public String geraInicioDaJogada(Jogador j) {//gera a string das opções do jogador de acordo com sua situação no jogo
		FachadaTabuleiro fachadaT = FachadaTabuleiro.getInstance();
		System.out.println("Vez do jogador "+j.getNome()+" De cor ("
				+j.getCor()+").");
		if(fachadaT.procuraPrisioneiro(j)) {
			if(j.getValorCarta()) return "[pagar][status][sair][carta][jogar]";
			return "[pagar][status][sair][jogar]";
		}
		else if(fachadaT.verificaMonopolio(j)) {
			if(j.verificaCasas()) {
				return "[jogar][status][sair][construir][vender]";
			}else {
				this.construcoes=new ArrayList<Terreno>();
				return "[jogar][status][sair][construir]";
				}
		}
		return "[jogar][status][sair]";
	}
	
	public String getStringConstrucao(Jogador j) {//retorna a string com todas as propriedades que estão disponíveis para construção de casa
		int cont=0;
		FachadaTabuleiro temp = FachadaTabuleiro.getInstance();
		String propriedades="[Digite o numero do terreno para construir]['0' para sair] \n";
		if(temp.verificaAmarelo(j)) {
			for(TerrenoAmarelo i: temp.getTerrenoAmarelo()) { 
				propriedades+=++cont +"- "+i.getNome()+" Casas: "+i.getCasas()+ "Preço da casa: "+ i.getPrecoCasa()+"\n";
				construcoes.add(i);
			}
		}
		if(temp.verificaAzul(j)) {
			for(TerrenoAzul i: temp.getTerrenoAzul()) { 
				propriedades+= ++cont +"- "+i.getNome()+" Casas: "+i.getCasas()+ "Preço da casa: "+ i.getPrecoCasa()+"\n";
				construcoes.add(i);
			}
		}
		if(temp.verificaCiano(j)) {
			for(TerrenoCiano i: temp.getTerrenoCiano()) { 
				propriedades+= ++cont +"- "+i.getNome()+" Casas: "+i.getCasas()+ "Preço da casa: "+ i.getPrecoCasa()+"\n";
				construcoes.add(i);
			}
		}
		if(temp.verificaLaranja(j)) {
			for(TerrenoLaranja i: temp.getTerrenoLaranja()) { 
				propriedades+= ++cont +"- "+i.getNome()+" Casas: "+i.getCasas()+ "Preço da casa: "+ i.getPrecoCasa()+"\n";
				construcoes.add(i);
			}
		}
		if(temp.verificaRosa(j)) {
			for(TerrenoRosa i: temp.getTerrenoRosa()) { 
				propriedades+= ++cont +"- "+i.getNome()+" Casas: "+i.getCasas()+ "Preço da casa: "+ i.getPrecoCasa()+"\n";
				construcoes.add(i);
			}
		}
		if(temp.verificaRoxo(j)) {
			for(TerrenoRoxo i: temp.getTerrenoRoxo()) { 
				propriedades+= ++cont +"- "+i.getNome()+" Casas: "+i.getCasas()+ "Preço da casa: "+ i.getPrecoCasa()+"\n";
				construcoes.add(i);
			}
		}
		if(temp.verificaVerde(j)) {
			for(TerrenoVerde i: temp.getTerrenoVerde()) { 
				propriedades+= ++cont +"- "+i.getNome()+" Casas: "+i.getCasas()+ "Preço da casa: "+ i.getPrecoCasa()+"\n";
				construcoes.add(i);
			}
		}
		if(temp.verificaVermelho(j)) {
			for(TerrenoVermelho i: temp.getTerrenoVermelho()) { 
				propriedades+= ++cont+"- "+i.getNome()+" Casas: "+i.getCasas()+ "Preço da casa: "+ i.getPrecoCasa()+"\n";
				construcoes.add(i);
			}
		}
	return propriedades;
	}
	
	public String getStringVenda(Jogador j) {//retorna string de terrenos com casa disponíveis para venda
		int cont=0;
		FachadaTabuleiro temp = FachadaTabuleiro.getInstance();
		String propriedades="[Digite o numero do terreno para realizar a venda da casa]['0' para sair] \n";
		if(temp.verificaAmarelo(j)) {
			for(TerrenoAmarelo i: temp.getTerrenoAmarelo()) {
				if(i.getCasas() > 0) {
					propriedades += ++cont+"- "+i.getNome()+" Casas: "+i.getCasas()+ "Preço de venda da casa: "+ i.getPrecoCasa()/2+"\n";
					construcoes.add(i);
				}
			}
		}
		if(temp.verificaAzul(j)) {
			for(TerrenoAzul i: temp.getTerrenoAzul()) {
				if(i.getCasas() > 0) {
					propriedades += ++cont+"- "+i.getNome()+" Casas: "+i.getCasas()+ "Preço de venda da casa: "+ i.getPrecoCasa()/2+"\n";
					construcoes.add(i);
				}
			}
		}
		if(temp.verificaCiano(j)) {
			for(TerrenoCiano i: temp.getTerrenoCiano()) { 
				if(i.getCasas() > 0) {
					propriedades += ++cont+"- "+i.getNome()+" Casas: "+i.getCasas()+ "Preço de venda da casa: "+ i.getPrecoCasa()/2+"\n";
					construcoes.add(i);
				}
			}
		}
		if(temp.verificaLaranja(j)) {
			for(TerrenoLaranja i: temp.getTerrenoLaranja()) { 
				if(i.getCasas() > 0) {
					propriedades += ++cont+"- "+i.getNome()+" Casas: "+i.getCasas()+ "Preço de venda da casa: "+ i.getPrecoCasa()/2+"\n";
					construcoes.add(i);
				}
			}
		}
		if(temp.verificaRosa(j)) {
			for(TerrenoRosa i: temp.getTerrenoRosa()) { 
				if(i.getCasas() > 0) {
					propriedades += cont+"- "+i.getNome()+" Casas: "+i.getCasas()+ "Preço de venda da casa: "+ i.getPrecoCasa()/2+"\n";
					cont++;
					construcoes.add(i);
				}
			}
		}
		if(temp.verificaRoxo(j)) {
			for(TerrenoRoxo i: temp.getTerrenoRoxo()) { 
				if(i.getCasas() > 0) {
					propriedades += ++cont+"- "+i.getNome()+" Casas: "+i.getCasas()+ "Preço de venda da casa: "+ i.getPrecoCasa()/2+"\n";
					construcoes.add(i);
				}
			}
		}
		if(temp.verificaVerde(j)) {
			for(TerrenoVerde i: temp.getTerrenoVerde()) { 
				if(i.getCasas() > 0) {
					propriedades += ++cont+"- "+i.getNome()+" Casas: "+i.getCasas()+ "Preço de venda da casa: "+ i.getPrecoCasa()/2+"\n";
					construcoes.add(i);
				}
			}
		}
		if(temp.verificaVermelho(j)) {
			for(TerrenoVermelho i: temp.getTerrenoVermelho()) { 
				if(i.getCasas() > 0) {
					propriedades += ++cont+"- "+i.getNome()+" Casas: "+i.getCasas()+ "Preço de venda da casa: "+ i.getPrecoCasa()/2+"\n";
					construcoes.add(i);
				}
			}
		}
		return propriedades;
	}
	
	public Terreno getTerreno(int i) throws IndexNaoSuportadoEx{//retorna terreno específico
		return this.construcoes.get(i);
	}
}
