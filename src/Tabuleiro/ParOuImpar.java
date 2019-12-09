package Tabuleiro;

import jogadores.Jogadores;
import jogadores.SemSaldoException;

public class ParOuImpar implements Casa{
	public ParOuImpar() {
		
	}
	
	public void fazAcao() {
		Jogadores temp= Jogadores.getInstance();
		System.out.println(toString());
		String aux = temp.getJogadorDaVez().getUltimoDado();
		int soma = Integer.parseInt(aux, aux.charAt(0)) + Integer.parseInt(aux, aux.charAt(1));
		if(soma%2 == 0) {
			temp.getJogadorDaVez().ganhaDinheiro(100);
			System.out.println("N�mero par, ganhou 100");
		}else {
			try {
				temp.getJogadorDaVez().perdeDinehiro(100);
			} catch (SemSaldoException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("N�mero �mpar, paga 100");
		}
	}
	
	public String toString() {
		return "Recebe 100 se tirou o n�mero par da soma dos dados e paga 100 caso contr�rio"; 
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}
}
