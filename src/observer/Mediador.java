package observer;

import Tabuleiro.Terreno;
import jogadores.Jogadores;


public class Mediador {
	
	private static Mediador instance;
	private Jogadores jogadores = Jogadores.getInstance();
	private Observer observer = Observer.getInstance();
	
	private Mediador() {}
	
	public void confereEventoMonopolio() {
		Terreno temp = this.jogadores.getJogadorDaVez().getUltimoTerreno();
		if(temp.verificaMonopolioPorCor(this.jogadores.getJogadorDaVez())) {
			Events evento = new EventoMonopolio(temp);
			this.observer.fireEventoMonopolio(evento);
		}
	}
	
	public void confereEventoPreMonopolio() {
		Terreno temp = this.jogadores.getJogadorDaVez().getUltimoTerreno();
		if(temp.verificaPreMonopolioPorCor(this.jogadores.getJogadorDaVez())) {
			Events evento = new EventoPreMonopolio(temp);
			this.observer.fireEventoPreMonopolio(evento);
		}
	}
	
	public void EventoPreHotel(Terreno t) {
		Events evento = new EventoPreHotel(t);
		this.observer.fireEventoPreHotel(evento);
	}
	
	public static Mediador getInstance() {
		if(instance==null) instance= new Mediador();
		return instance;
	}
	
	public void confereDoisTipoMonopolio() {
		confereEventoMonopolio();
		confereEventoPreMonopolio();
	}
}
