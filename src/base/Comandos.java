package base;

import Tabuleiro.*;
import jogadores.Jogadores;
import observer.Mediador;

public class Comandos {

	private static Comandos instance;
	private FachadaComunicacao comunicacao= FachadaComunicacao.getInstance();
	private Jogadores jogadores= Jogadores.getInstance();
	private GeraString geraString = GeraString.getInstance();
	private FachadaTabuleiro fachadaT= FachadaTabuleiro.getInstance();
	private Mediador mediador = Mediador.getInstance();
	
	
	private Comandos() {}
	
	public static Comandos getInstance() {
		if(instance==null) instance = new Comandos();
		return instance;
	}
	
	public void comandoSair() {//sai do jogo
		String comando=comunicacao.inputString("Você deseja mesmo sair?[s] [n]");
		if(comando.equals("s")) {
			jogadores.retiraJogador(jogadores.getJogadorDaVez());
			jogadores.passaVez();
		}
	}
	
	public void comandoStatus() {//mostra status do jogador da vez
		Jogadores temp= Jogadores.getInstance();
		System.out.println(temp.getJogadorDaVez().toString());
	}
	
	public void comandoConstruir() {//leva usuário para as opções de construção de casas em terrenos, se possível
		if(fachadaT.verificaMonopolio(jogadores.getJogadorDaVez())) {
			int numEscolhido=comunicacao.inputInt(jogadores.getJogadorDaVez()+" tem um saldo de " +jogadores.getJogadorDaVez().getDinheiro()+
			"\n" +geraString.getStringConstrucao(jogadores.getJogadorDaVez()));
			if(numEscolhido<=0) return;
			try {
				fachadaT.compraCasa(geraString.getTerreno(numEscolhido-1), jogadores.getJogadorDaVez());
				if(geraString.getTerreno(numEscolhido-1).getCasas() == 4) {
					mediador.EventoPreHotel(geraString.getTerreno(numEscolhido-1));
				}
			} catch (IndexNaoSuportadoEx e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Casa construida com sucesso!");
		}
	}
	
	public void comandoVender() {//leva usuário para opções de venda de casas em terrenos, se possível
		if(jogadores.getJogadorDaVez().temTerreno()) {
			int contador = 0;
			for(Terreno t : jogadores.getJogadorDaVez().getTerrenos()) {
				if(t.getCasas() > 0) {
					contador += 1;
					break;
				}
			}
			if(contador == 1) {
				int temp = comunicacao.inputInt(geraString.getStringVenda(jogadores.getJogadorDaVez()));
				if(temp > 0) {
					Terreno terreno;
					try {
						terreno = geraString.getTerreno(temp-1);
						fachadaT.vendeCasa(terreno);
					}catch (IndexNaoSuportadoEx e) {
						System.out.println(e.getMessage());
					}
					System.out.println("Casa vendida com sucesso!");
				}else {
					System.out.println("Opção inválida!");
				}
			}
		}
	}
	
	public void comandoJogar() {//jogador fazz jogada
		
		Dados dado= Dados.getInstance();
		int [] dadosJogados= dado.jogaDados();
		String aux = Integer.toString(dadosJogados[0])+" "+Integer.toString(dadosJogados[1]);
		if(dado.verificaHistoricoDeDados(jogadores.getJogadorDaVez())) {
			fachadaT.vaiPraPrisao();
			jogadores.getJogadorDaVez().setCasa(9);
			jogadores.passaVez();
			return ;
		}
		if(fachadaT.procuraPrisioneiro(jogadores.getJogadorDaVez())) {
			fachadaT.tentaSairPrisao(aux);
		}
		else if(jogadores.getJogadorDaVez().getCasa()+dadosJogados[0]+dadosJogados[1]>39) {
			
			jogadores.getJogadorDaVez().setCasa(jogadores.getJogadorDaVez().getCasa()+dadosJogados[0]+dadosJogados[1]-40);
			System.out.println("Jogador "+ jogadores.getJogadorDaVez().getNome()+ " tirou ["+dadosJogados[0]+" "+dadosJogados[1]
					+"] e caiu na casa: "+fachadaT.getCasaTabuleiro(jogadores.getJogadorDaVez().getCasa()).getNome());
		}else{
			jogadores.getJogadorDaVez().setCasa(jogadores.getJogadorDaVez().getCasa()+dadosJogados[0]+dadosJogados[1]);
			System.out.println("Jogador "+ jogadores.getJogadorDaVez().getNome()+ " tirou ["+dadosJogados[0]+" "+dadosJogados[1]+"] e caiu na casa: "+
			fachadaT.getCasaTabuleiro(jogadores.getJogadorDaVez().getCasa()).getNome());	
			}

		Casa casaAtual = fachadaT.getCasaTabuleiro(jogadores.getJogadorDaVez().getCasa());
		casaAtual.fazAcao();
		jogadores.passaVez();
	}
		
	public void comandoPagar() {//faz pagamento para usuário preso no prisão
		System.out.println("Pagamento conluído. Proxima rodada poderá se mover normalmente.");
		fachadaT.retiraJogadorDaPrisao(jogadores.getJogadorDaVez());
		jogadores.passaVez();
	}
	
	public void comandoCarta() {//utiliza carta de passe livre da prisão
		if(jogadores.getJogadorDaVez().getValorCarta()) {
			System.out.println("Você usou a carta do Passe livre. Ela voltou para o monte de Sorte Ou Revés");
		}else {
			System.out.println("Você não possui a carta do Passe livre.");
		}
		jogadores.passaVez();
	}
	
}
