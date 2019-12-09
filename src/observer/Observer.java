package observer;

import jogadores.Jogadores;

public class Observer {
	private static Observer instance = null;
	private Jogadores jogadores = Jogadores.getInstance();
	
	private Observer() {}
	
	public static Observer getInstance() {
		if(instance == null) instance = new Observer();
		return instance;
	}
	
	public void fireEventoMonopolio(Events eventoMonopolio) {
		jogadores.getJogadorDaVez().eventoMonopolio(eventoMonopolio);
		
	}
	
	public void fireEventoPreMonopolio(Events eventoPreMonopolio) {
		jogadores.getJogadorDaVez().eventoPreMonopolio(eventoPreMonopolio);
		
	}
	
	public void fireEventoPreHotel(Events eventoPreHotel) {
		jogadores.getJogadorDaVez().eventoPreHotel(eventoPreHotel);
		
	}
	
	
}
