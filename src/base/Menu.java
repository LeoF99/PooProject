package base;

import Tabuleiro.FachadaTabuleiro;
import jogadores.*;

public class Menu {

	public static void main(String[] args)  {
			
		System.out.println("X--------------- BANCO IMOBILIARIO ---------------X\n");
		System.out.println("Prof Fabio Moraes");
		System.out.println("Team itaipava:  Leo Ferreira e Vinicius Andrade \n");
		
		
		Jogadores jogadores = Jogadores.getInstance();
		Jogador usual = new Jogador();
		FachadaTabuleiro fachadaT = FachadaTabuleiro.getInstance();
		FachadaComunicacao comunicacao= FachadaComunicacao.getInstance();
		Comandos cmd= Comandos.getInstance();
		GeraString geraString = GeraString.getInstance();
		
		
		boolean verificaNum=true;
		
		int numeroJogadores= comunicacao.inputInt("Quantidade de Jogadores [2-8]:");
		
		while(verificaNum) {
			
			try {
				verificaJogadores(numeroJogadores);
				verificaNum=false;
			}catch (NumJogadoresNaoSup e1) {
				System.out.println(e1.getMessage());
				numeroJogadores= comunicacao.inputInt("Quantidade de Jogadores [2-8]:");
			}
		}
			
		int cont=0;
			
		while(cont<numeroJogadores) {
			String nomeJogador=comunicacao.inputString("Nome do Jogador: " +cont+1);
			String corJogador= comunicacao.inputString("Cor do jogador "+(cont+1)
						+"[preto][branco][vermelho][verde][azul][amarelo][laranja][rosa]");
				
			usual= new Jogador(nomeJogador);
			try {
				confereCor(corJogador);
				usual.setCor(corJogador);
				jogadores.cadastraJogador(usual);
				cont+=1;
			}catch (JogadorJaExisteException | corNaoSuportadaException e) {
				System.out.println(e.getMessage());
			}
		}
		String comando="";
			
		System.out.println("O jogo vai começar");
			
		while(jogadores.size()>1) {
				
			comando = comunicacao.inputString(geraString.geraInicioDaJogada(jogadores.getJogadorDaVez()));
		
		    if(fachadaT.procuraPrisioneiro(jogadores.getJogadorDaVez())) {
		    	switch(comando) {
		    		case("Pagar"):
		    			cmd.comandoPagar();
			    		break;
			    	case("Carta"):
			   			cmd.comandoCarta();
			   			break;
			   		default:
			   			break;
			    }
		    }
		    switch(comando) {
		    	case("sair"):
		    		cmd.comandoSair();
		    		break;
			    case("status"):
			   		cmd.comandoStatus();
			   		continue;
			   	case("construir"):
			   		cmd.comandoConstruir();
		    		continue;
		    	case("vender"):
		    		cmd.comandoVender();
		    		continue;
			    case("jogar"):
			   		cmd.comandoJogar();
			    	break;
				default:
					continue;
			}
		}
	}

	private static void verificaJogadores(int n) throws NumJogadoresNaoSup {
		if(n<2 || n>8) throw new NumJogadoresNaoSup();
		
	}

	private static void confereCor(String cor) throws corNaoSuportadaException{
		if(cor.equals("azul") || cor.equals("preto") || cor.equals("branco") || cor.equals("vermelho")
				|| cor.equals("verde") || cor.equals("amarelo") || cor.equals("laranja") || cor.equals("rosa")) ;
		else throw new corNaoSuportadaException();
		
	}	
}
