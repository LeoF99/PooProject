package observer;

import Tabuleiro.Terreno;

public class EventoPreMonopolio extends Events {

	
	
	public EventoPreMonopolio(Terreno t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	public String getStringEvento() {
		return "O monop�lio do terreno do tipo "+terreno.getCor()+" est� quase completo!. Continue comprando. "
				+ "\nQuando completar o tipo poder� construir casas.";
	}


	
	

}
