package Tabuleiro;

import java.util.ArrayList;

import jogadores.*;

public class Prisao implements Casa {

	private ArrayList<Jogador> presos;
	private static Prisao instance;
	
	private Prisao() {
		presos=new ArrayList<Jogador>();
	}
	
	public static Prisao getInstance() {
		if(instance==null) instance= new Prisao();
		return instance;
	}

	public void addPrisioneiro(Jogador j) {
		presos.add(j);
		j.apagaTudoDados();
	}
	
	public String getNome() {
		return "Prisão, esta como visitante";
	}
	
	public boolean procuraPrisioneiro(Jogador j) {
		
		if(presos.isEmpty()) return false;
		else {
			for(Jogador i: this.presos) {
				if(i.equals(j)) return true;
				}
			return false;
		}
		
	}
	
	public void retiraPrisioneiro(Jogador j) {
		presos.remove(j);
	}
	
	public ArrayList<Jogador> getPresos(){
		return this.presos;
	}

	@Override
	public void fazAcao() {
	}
	
	public void tentaSairPrisao(String aux) {
		Jogadores temp= Jogadores.getInstance();
		if(aux.charAt(0)==(aux.charAt(2))) {
			System.out.println("Jogador " + temp.getJogadorDaVez().getNome()+" tirou  [" + aux.charAt(0) +","+ aux.charAt(1)+"] e saiu da prisão."
					+ "Em seu próximo turno poderá mover normalmente. Histórico de dados removidos." );
			temp.getJogadorDaVez().apagaTudoDados();
			this.retiraPrisioneiro(temp.getJogadorDaVez());
			
		}else {
			System.out.println("Jogador " + temp.getJogadorDaVez().getNome()+ " tirou os dados ["+aux.charAt(0)+", "+aux.charAt(1)+", infelizmente não saiu da prisão. ");
		}
		
	}
	
	public void vaiPraPrisao() {
		Jogadores jogadores= Jogadores.getInstance();
		String [] dados= jogadores.getJogadorDaVez().getAll();
		System.out.println("Por ter tirado 3 vezes números iguais nos dados o jogador foi jogado na prisão.");
		System.out.println("Dados: ["+dados[0].charAt(0)+","+dados [0].charAt(1)+"] , ["+dados[1].charAt(0)+","+dados[1].charAt(1)+"] , ["+dados[2].charAt(0)+","+dados[2].charAt(1)+"]");
		System.out.println("Em suas próximas jogadas ele poderá escolher pagar para sair, tentar acertar os dados iguais ou"
				+ "\nse possuir a carta de liberação ela poderá ser usada.");
		this.addPrisioneiro(jogadores.getJogadorDaVez());
	}


}
