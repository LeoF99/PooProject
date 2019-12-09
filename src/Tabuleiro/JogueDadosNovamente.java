package Tabuleiro;

import base.Comandos;
import jogadores.Jogadores;

public class JogueDadosNovamente implements Casa{
	
	public JogueDadosNovamente() {
		
	}

	public void fazAcao() {
		Jogadores temp= Jogadores.getInstance();
		System.out.println("Jogador "+ temp.getJogadorDaVez().getNome()+" tirou a carta 'Jogue os dados novamente'.");
		Comandos cmd= Comandos.getInstance();
		cmd.comandoJogar();
	}
	
	public String toString() {
		return "Jogue os dados novamente";
	}

	@Override
	public String getNome() {
		return toString();
	}
}
