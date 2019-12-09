package jogadores;

import java.util.ArrayList;

import Tabuleiro.Empresas;
import Tabuleiro.Terreno;
import observer.Events;
import observer.Listeners;

public class Jogador implements Listeners{
		
	private String nome;
	private String cor;
	private String status;
	private int dinheiro;
	private int casa;
	private Fila dadosJogados;
	private boolean cartaLiberdade;
	private ArrayList<Terreno> terrenos= new ArrayList<Terreno>();
	private ArrayList<Empresas> empresas= new ArrayList<Empresas>();
	
	public Jogador(String n) {
		this.nome=n;
		this.cor="";
		this.status="";
		this.dinheiro=1500;
		this.casa=39;
		this.dadosJogados = new Fila();
		cartaLiberdade=false;
	}
	
	public Jogador() {

	}
	
	public void addStatus(String s) {//Adiciona uma string ao status do jogador
		this.status+=s+"\n";
	}
	
	public String getNome() {//Retorna nome
		return this.nome;
	}
	
	public String getCor() {//Retorna cor do jogador
		return this.cor;
	}
	
	public String getStatus(){//Retorna o status do jogador
		return this.status;
	}
	
	public int ganhaDinheiro(int money) {//Adiciona dinheiro ao jogador
		this.dinheiro+=money;
		return this.dinheiro;
	}
	
	public int perdeDinehiro(int money)throws SemSaldoException {//Retira dinheiro do jogador
		if(money>this.dinheiro) {
			throw new SemSaldoException();
		}else {
			this.dinheiro-=money;
			return this.dinheiro;
		}
	}
	
	public void setCor(String cor) {//seta uma cor ao jogador
		this.cor=cor;
	}
	
	public String toString() {//retorna string com as info do jogador
		return "Nome do jogador: "+this.nome+"\nCor: "+this.cor+"\nStatus: "+this.status
				+"\nDinheiro: "+this.dinheiro;
	}
	
	public int getCasa() {//retorna a posição atual do jogador no tabuleiro
		return this.casa;
	}
	
	public void setCasa(int c) {//Move o jogador para uma casa específica
		this.casa=c;
	}
	
	public int getDinheiro() {//retorna o dinheiro do jogador
		return this.dinheiro;
	}
	
	public void addDados(String dados) {//adiciona dados na lista de dados
		dadosJogados.enfileirar(dados);
	}
	
	public String [] getAll() {//retorna todos os dados
		return this.dadosJogados.getAll();
	}
	
	public void apagaTudoDados() {//reseta os dados
		dadosJogados = new Fila();
	}
	
	public String getUltimoDado() {//retorna apenas o último dado jogado
		String[] aux = this.dadosJogados.getAll();
		if(aux.length==3) {
			return aux[2];
		}else if(aux.length==2) {
			return aux[1];
		}else return aux[0];
	}
	
	public int qntdDados() {//retorna a quantidade de vezes jogada
		return dadosJogados.tamanho();
	}
	
	public void adereCartaLiberdade() {//adiciona a carta de passe livre da prisão ao jogador
		this.cartaLiberdade=true;
	}
	
	public boolean getValorCarta() {//verifica se jogador tem carta de passe livre da prisão
		return this.cartaLiberdade;
	}
	
	public void usouCarta() {//jogador utilizou sua carta e agora não a possui
		this.cartaLiberdade=false;
	}
	
	public void addTerreno(Terreno t) {//adiciona um terreno a lista de terrenos do  jogador
		this.terrenos.add(t);
	}
	
	public void addEmpresa(Empresas e) {//adiciona uma empresa a lista de empresas do jogador
		this.empresas.add(e); 
	}
	
	public boolean temTerreno() {//verifica se jogador tem algum terreno
		if(this.terrenos.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public ArrayList<Terreno> getTerrenos(){//retorna todos os terrenos do jogador
		return this.terrenos;
	}
	
	public boolean verificaCasas() {//verifica se jogador tem algum terreno com casas
		for(Terreno i: terrenos) {
			if(i.getCasas()!=0) return true;
		}
		return false;
	}

	public void eventoMonopolio(Events eventoMonopolio) {//Evento do observer 
		System.out.println(eventoMonopolio.getStringEvento());
	}

	public void eventoPreMonopolio(Events eventoPreMonopolio) {//Evendo do observer
		System.out.println(eventoPreMonopolio.getStringEvento());
	}
	
	public Terreno getUltimoTerreno() {
		return this.terrenos.get(this.terrenos.size()-1);
	}

	@Override
	public void eventoPreHotel(Events eventoPreHotel) {
		System.out.println(eventoPreHotel.getStringEvento());
	}
}
