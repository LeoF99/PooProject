package observer;

import Tabuleiro.Terreno;
import jogadores.Jogadores;

public class EventoMonopolio extends Events {
	 
	
	
	public EventoMonopolio(Terreno t) {
		super(t);
	
	}

	public String getStringEvento() {
		 Jogadores temp = Jogadores.getInstance();
		 return "Jogador "+ temp.getJogadorDaVez().getNome()+" acaba de comprar todos os terrenos da classe " + terreno.getCor()+". Em sua próxima \n"
		 		+ "jogada poderá usar o comando [construir] para adiquirir casas.";
	 }
}
