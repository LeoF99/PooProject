package Tabuleiro;

public class TerrenoFactory {
	
	private GerenciamentoDeTerreno gt;
	
	public TerrenoFactory() {
		gt= GerenciamentoDeTerreno.getInstance();
	}
	
	public Casa criaTerreno (String cor,String nome, int preco, int aluguel, int aluguel1Casa, int aluguel2Casas, int aluguel3Casas,
			int aluguel4Casas, int aluguelHotel,int hipoteca, int precoCasa) {
		if(cor.equals("Amarelo")) {
			TerrenoAmarelo terreno=new TerrenoAmarelo(nome,preco,aluguel,aluguel1Casa,aluguel2Casas,aluguel3Casas,aluguel4Casas,aluguelHotel,hipoteca, precoCasa);
			gt.addAmarelo(terreno);
			return terreno;
		}else if(cor.equals("Azul")) { 
			TerrenoAzul terreno = new TerrenoAzul(nome,preco,aluguel,aluguel1Casa,aluguel2Casas,aluguel3Casas,aluguel4Casas,aluguelHotel,hipoteca, precoCasa);
			gt.addAzul(terreno);;
			return new TerrenoAzul(nome,preco,aluguel,aluguel1Casa,aluguel2Casas,aluguel3Casas,aluguel4Casas,aluguelHotel,hipoteca, precoCasa);
		}else if(cor.equals("Ciano")) {
			TerrenoCiano terreno =new TerrenoCiano(nome,preco,aluguel,aluguel1Casa,aluguel2Casas,aluguel3Casas,aluguel4Casas,aluguelHotel,hipoteca, precoCasa);
			gt.addCiano(terreno);;
			return  terreno;
		}else if(cor.equals("Laranja")) { 
			TerrenoLaranja terreno =new TerrenoLaranja(nome,preco,aluguel,aluguel1Casa,aluguel2Casas,aluguel3Casas,aluguel4Casas,aluguelHotel,hipoteca, precoCasa);
			gt.addLaranja(terreno);;
			return terreno;
		}else if(cor.equals("Rosa")) { 
			TerrenoRosa terreno=new TerrenoRosa(nome,preco,aluguel,aluguel1Casa,aluguel2Casas,aluguel3Casas,aluguel4Casas,aluguelHotel,hipoteca, precoCasa);
			gt.addRosa(terreno);;
			return terreno;
		}else if(cor.equals("Roxo")) { 
			TerrenoRoxo  terreno=new TerrenoRoxo(nome,preco,aluguel,aluguel1Casa,aluguel2Casas,aluguel3Casas,aluguel4Casas,aluguelHotel,hipoteca, precoCasa);
			gt.addRoxo(terreno);
			return terreno;
		}else if(cor.equals("Verde")) { 
			TerrenoVerde terreno=new TerrenoVerde(nome,preco,aluguel,aluguel1Casa,aluguel2Casas,aluguel3Casas,aluguel4Casas,aluguelHotel,hipoteca, precoCasa);
			gt.addVerde(terreno);;
			return terreno;
		}else if(cor.equals("Vermelho")) {
			TerrenoVermelho terreno=new TerrenoVermelho(nome,preco,aluguel,aluguel1Casa,aluguel2Casas,aluguel3Casas,aluguel4Casas,aluguelHotel,hipoteca, precoCasa);
			gt.addVermelho(terreno);
			return terreno;
		}
		return null;
	}
}