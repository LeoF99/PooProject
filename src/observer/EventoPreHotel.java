package observer;

import Tabuleiro.Terreno;

public class EventoPreHotel extends Events{

	public EventoPreHotel(Terreno t) {
		super(t);
	}

	@Override
	public String getStringEvento() {
		return "Voc� est� quase comprando um hotel para o terreno "+terreno.getNome()+"."+
				"\nQuando compro-lo, seu terreno valer� uma fortuna!";
	}
	
}
