package Tabuleiro;

import jogadores.Jogador;
import jogadores.Jogadores;
import jogadores.SemSaldoException;

public class SorteReves implements Casa{
	
	private FilaCartas cartas;
	Casa cartaPrin= new PasseLivrePrisao();
	private static SorteReves instance;
	
	private SorteReves() {
		this.cartas = new FilaCartas();
		cartas.enfileirar(new CartasGenericas("Sua empresa foi multada por poluir demais", 200, 0));
		cartas.enfileirar(new DiaDoCasamento());
		cartas.enfileirar(new CartasGenericas("Reformou sua casa", 50, 0));
		cartas.enfileirar(new CartasGenericas("Seu livro será publicado", 0, 50));
		cartas.enfileirar(new PasseLivrePrisao());
		cartas.enfileirar(new VaParaPrisaoSR());
		cartas.enfileirar(new VaAteOInicio());
		cartas.enfileirar(new CartasGenericas("Suas ações na bolsa de valores estão em alta", 0, 100));
		cartas.enfileirar(new CartasGenericas("Curso de MBA", 20, 0));
		cartas.enfileirar(new CartasGenericas("Ferias com família", 20, 0));
		cartas.enfileirar(new CartasGenericas("Recebeu premio e ganhou carro", 0, 10));
		cartas.enfileirar(new JogueDadosNovamente());
		cartas.enfileirar(new CartasGenericas("Sua empresa irá patrocinar uma espedição a Antartica", 50, 0));
		cartas.enfileirar(new CartasGenericas("Vendeu parte de sua empresa", 0, 75));
		cartas.enfileirar(new CartasGenericas("Apostou no cavalo azarão e ganhou", 0, 100));
		cartas.enfileirar(new CartasGenericas("Falta de chuva prejudicou colheita", 45, 0));
		cartas.enfileirar(new CartasGenericas("Recebeu herança inesperada", 0, 75));
		cartas.enfileirar(new CartasGenericas("Seu filho decidiu fazer intercâmbio", 20, 0));
		cartas.enfileirar(new CartasGenericas("Sua casa será desapropriada e você recebeu indenização", 0, 60));
		cartas.enfileirar(new CartasGenericas("Venceu licitação de grande obra", 0, 150));
		cartas.enfileirar(new CartasGenericas("Seu iate afundou, você tinha seguro", 0, 25));
		cartas.enfileirar(new CartasGenericas("Seus funcionários entraram em greve", 30, 0));
		cartas.enfileirar(new CartasGenericas("Comprou obra de arte falsificada", 22, 0));
		cartas.enfileirar(new ParOuImpar());
		cartas.enfileirar(new CartasGenericas("Seu jatinho precisa de manutenção", 9, 0));
		cartas.enfileirar(new CartasGenericas("Renovou a frota de carros da sua empresa", 100, 0));
		cartas.enfileirar(new CartasGenericas("Ganhou na loteria sozinho", 0, 80));
		cartas.enfileirar(new CartasGenericas("Atualizou os computadores da sua empresa", 30, 0));
		cartas.enfileirar(new CartasGenericas("Um navio afundou com suas mercadorias", 40, 0));
		cartas.enfileirar(new CartasGenericas("Produção de leite das suas fazendas foi insuficiente", 60, 0));
		cartas.enfileirar(new CartasGenericas("Ficou em primeiro lugar no torneio de golf", 0, 100));
	}

	public static SorteReves getInstance() {
		if(instance==null) instance= new SorteReves();
		return  instance;
	}
	
	public String getNome() {
		return "Sorte ou Revés";
		
	}
	
	public void geraEfeito(Jogador j) throws SemSaldoException {
		Casa aux = cartas.getCarta();
		aux.fazAcao();
	}
	
	public void poePasseLivre() {
		cartas.addPasseLivre();
	}
	
	public void fazAcao() {
		Jogadores temp= Jogadores.getInstance();
		try {
			geraEfeito(temp.getJogadorDaVez());
		} catch (SemSaldoException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
