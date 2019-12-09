package Tabuleiro;

import java.util.ArrayList;

public class Tabuleiro {
	
	private ArrayList<Casa> casas = new ArrayList<Casa>();
	private static Tabuleiro instance;
	
	
	private Tabuleiro() {
		TerrenoFactory fact= new TerrenoFactory();
		Casa sorte = SorteReves.getInstance();
		casas.add(fact.criaTerreno("Rosa","Leblon",100,6,30,90,270,400,500,50,50));
		casas.add(sorte);
		casas.add(fact.criaTerreno("Rosa","Av. Presidente Vargas", 60,2,10,30,90,160,250,30,50));
		casas.add(fact.criaTerreno("Rosa","Av. Nossa Senhora de Copacabana", 260,2,10,30,90,160,250,30,50));
		casas.add(new Empresas("Companhia Ferroviária",200,100,50));
		casas.add(fact.criaTerreno("Ciano","Av. Brigadeiro Faria lima",240,20,100,300,750,925,1100,120,150));
		casas.add(new Empresas("Companhia de Viação",200,100,50));
		casas.add(fact.criaTerreno("Ciano","Av. Rebouças",220,18,90,250,700,875,1050,110,150));
		casas.add(fact.criaTerreno("Ciano","Av. 9 de Julho",220,18,90,250,700,875,1050,110,150));
		casas.add(Prisao.getInstance());
		casas.add(fact.criaTerreno("Roxo","Av. Europa", 200,16,80,220,600,800,1000,100,100));
		casas.add(sorte);
		casas.add(fact.criaTerreno("Roxo","Rua Augusta",180,14,70,200,550,750,950,90,100));
		casas.add(fact.criaTerreno("Roxo","Av. Pacaembu",180,14,70,200,550,750,950,90,100));
		casas.add(new Empresas("Companhia de Táxis",150,75,40));
		casas.add(sorte);
		casas.add(fact.criaTerreno("Laranja","Interlagos",350,35,175,500,1100,1300,1500,175,200));
		casas.add(new LucrosOuDividendo());
		casas.add(fact.criaTerreno("Laranja","Morumbi",400,50,200,600,1400,1700,2000,200,200));
		casas.add(new ParadaLivre());
		casas.add(fact.criaTerreno("Vermelho","Flamengo",120,8,40,100,300,450,600,60,50));
		casas.add(sorte);
		casas.add(fact.criaTerreno("Vermelho","Botafogo",100,6,30,90,270,400,500,50,50));
		casas.add(new ImpostoDeRenda());
		casas.add(new Empresas("Companhia de Navegação",150,75,40));
		casas.add(fact.criaTerreno("Amarelo","Av. Brasil",160,12,60,180,500,700,900,80,100));
		casas.add(sorte);
		casas.add(fact.criaTerreno("Amarelo","Av. Paulista",140,10,50,150,450,625,750,70,100));
		casas.add(fact.criaTerreno("Amarelo","Jardim Europa",140,12,60,180,500,700,900,80,100));
		casas.add(new VaPraPrisao());
		casas.add(fact.criaTerreno("Verde","Copacabana",260,22,110,330,800,975,1150,130,150));
		casas.add(new Empresas("Companhia de Aviação",200,100,50));
		casas.add(fact.criaTerreno("Verde","Av. Vieira Souto",320,28,150,450,1000,1200,1400,160,200));
		casas.add(fact.criaTerreno("Verde","Av. Atlântica",300,26,130,390,900,1100,1275,150,200));
		casas.add(new Empresas("Companhia de Táxi Aério",200,100,50));
		casas.add(fact.criaTerreno("Verde","Ipanema",300,26,130,390,900,1100,1275,150,200));
		casas.add(sorte);
		casas.add(fact.criaTerreno("Azul","Jardim Paulista",280,24,120,360,850,1025,1200,140,150));
		casas.add(fact.criaTerreno("Azul","Brooklin",260,22,110,330,800,975,1150,130,150));
		casas.add(new PontoDePartida());
	}
	public Casa getCasa(int v) {//retorna uma casa específica do tabuleiro
		return this.casas.get(v);
	}
	
	public static Tabuleiro getInstance() {
		if(instance==null) {
			instance= new Tabuleiro();
		}
		return instance;
	}
}

