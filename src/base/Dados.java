package base;

import java.util.Random;
import jogadores.Jogador;

public class Dados {

	private static Dados instance;
	
	private Dados() {}
	
	public int [] jogaDados() {//Rola os dados
		int [] numeros=new int [2];
		Random random= new Random();
		numeros[0]= random.nextInt(6)+1;
		numeros[1]= random.nextInt(6)+1;
		return numeros;
	}
	
	public boolean verificaHistoricoDeDados(Jogador j) {//Verifica se os dados foram iguais
		if(j.qntdDados()==3) {
		String [] aux= j.getAll();
			if(aux[0].charAt(0)== aux[0].charAt(2)) {
				if(aux[1].charAt(0)==aux[1].charAt(2)) {
					if(aux[2].charAt(0)==aux[2].charAt(2)) return true;
					else return false;}
				else return false;}
			else return false;}
		else return false;
	}
	
	public static Dados getInstance() {
		if(instance==null) instance = new Dados();
		return instance;
	}
}
