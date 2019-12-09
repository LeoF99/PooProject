package Tabuleiro;

import base.FachadaComunicacao;
import jogadores.Jogador;
import jogadores.Jogadores;
import jogadores.SemSaldoException;
import observer.Mediador;

public abstract class Terreno implements Comercial, Casa{
	private String nome;
	private int preco;
	private int aluguel;
	private int aluguel1Casa;
	private int aluguel2Casas;
	private int aluguel3Casas;
	private int aluguel4Casas;
	private int aluguelHotel;
	private int casas;
	private int hipoteca;
	private int precoCasa;
	private Jogador proprietario;
	
	
	public Terreno(String nome, int preco, int aluguel, int aluguel1Casa, int aluguel2Casas, int aluguel3Casas, int aluguel4Casas, int aluguelHotel,
			int hipoteca, int precoCasa) {
		this.nome = nome;
		this.preco = preco;
		this.aluguel = aluguel;
		this.aluguel1Casa = aluguel1Casa;
		this.aluguel2Casas = aluguel2Casas;
		this.aluguel3Casas = aluguel3Casas;
		this.aluguel4Casas = aluguel4Casas;
		this.aluguelHotel = aluguelHotel;
		this.casas = 0;
		this.hipoteca = hipoteca;
		this.precoCasa = precoCasa;
		this.proprietario=null;
	}
	
	public void compraCasa(Jogador j) throws SemSaldoException {//adiciona uma casa ao terreno
		if(this.casas == 0) {
			j.perdeDinehiro(precoCasa);
			this.aluguel = this.aluguel1Casa;
			this.casas += 1;
		}else if(this.casas == 1) {
			j.perdeDinehiro(precoCasa);
			this.aluguel = this.aluguel2Casas;
			this.casas += 1; 
		}else if(this.casas == 2) {
			j.perdeDinehiro(precoCasa);
			this.aluguel = this.aluguel3Casas;
			this.casas +=1;
		}else if(this.casas == 3) {
			j.perdeDinehiro(precoCasa);
			this.aluguel = this.aluguel4Casas;
			this.casas += 1;
		}else if(this.casas == 4) {
			j.perdeDinehiro(precoCasa);
			this.aluguel = this.aluguelHotel;
			this.casas += 1;
		}
	}
	
	public void vendeCasa() {//vende uma casa do terreno
		this.casas -= 1;
		this.proprietario.ganhaDinheiro(this.precoCasa/2);
	}
	
	public void pagaAluguel(Jogador recebe, Jogador paga) throws SemSaldoException {//paga aluguel da propriedade
		paga.perdeDinehiro(this.aluguel);
		recebe.ganhaDinheiro(this.aluguel);
		System.out.println("Jogador "+paga.getNome()+" caiu no terreno do jogador "+recebe.getNome()+" e irá pagar o aluguel.");
		System.out.println("Pagamento de "+ aluguel +" efetuado com Sucesso");
		System.out.println("Saldo atual do jogador "+recebe.getNome()+" é: "+ recebe.getDinheiro());
		System.out.println("Saldo atual do jogador "+paga.getNome()+" é : "+paga.getDinheiro());
	}
	
	public int getHipoteca() {//retorna hipoteca do terreno
		return this.hipoteca;
	}
	
	public Jogador getProprietario() {//retorn proprietário do terreno
		return this.proprietario;
	}
	public int getPreco() {//retorna preço do terreno
		return this.preco;
	}
	
	public String toString() {//retorna info do terreno
		return this.nome+": "+
					"\nPreço: "+this.preco+
					"\nAluguel: "+this.aluguel+
					"\nCasas: "+this.casas+
					"\nHipoteca: "+this.hipoteca+
					"\nProprietário: "+this.proprietario;
	}

	
	public String getNome() {//retorna nome do terreno
		return this.nome;
	}
	public void compra(Jogador j) throws SemSaldoException  {//faz ação de compra do terreno
		if(j.getDinheiro()>=this.preco) {
			j.perdeDinehiro(preco);
			this.proprietario = j;
			j.addTerreno(this);
			System.out.println("Compra feita com Sucesso!");
			System.out.println("Saldo atual: "+j.getDinheiro());}
		else throw new SemSaldoException();
	
		}
	
	public int getCasas() {//retorna quantidade de casas do terreno
		return this.casas;
	}
	
	public String getCor() {
		return null;
	}
	
	public int getPrecoCasa() {//retorna preço de uma casa no terreno
		return this.precoCasa;
	}
	public void fazAcao() {//faz a ação referente a Terreno
		Jogadores temp= Jogadores.getInstance();
		FachadaComunicacao fachada= FachadaComunicacao.getInstance();
		if(proprietario==null) {
			if(temp.getJogadorDaVez().getDinheiro()>=preco) {
				System.out.println("O titulo do terreno está disponível por: $"+preco);
    			System.out.println(temp.getJogadorDaVez().getNome()+" você possui $"+temp.getJogadorDaVez().getDinheiro());
    			String compra=fachada.inputString("Deseja comprar? [Sim] [Nao]");
    			if(compra.equals("sim") || compra.equals("Sim")|| compra.equals("s")) {
    				try {
    					compra(temp.getJogadorDaVez());
    					if(verificaMonopolioPorCor(temp.getJogadorDaVez()) || verificaPreMonopolioPorCor(temp.getJogadorDaVez())) {
    						Mediador mediadorObserver = Mediador.getInstance();
    						mediadorObserver.confereDoisTipoMonopolio();
    					}
    				} catch (SemSaldoException e) {
    					System.out.println(e.getMessage());
    				}
    			}
			}
		}
		else if(!proprietario.equals(temp.getJogadorDaVez())) {
    		try{
    			pagaAluguel(proprietario,temp.getJogadorDaVez());
    		}
    		catch (SemSaldoException e) {
    			System.out.println(e.getMessage());
    		}
		}
	}
	
	public abstract boolean verificaMonopolioPorCor(Jogador j);
	public abstract boolean verificaPreMonopolioPorCor(Jogador j);
}
	
