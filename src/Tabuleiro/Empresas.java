package Tabuleiro;

import base.FachadaComunicacao;
import jogadores.Jogador;
import jogadores.Jogadores;
import jogadores.SemSaldoException;

public class Empresas implements Casa,Comercial{
	private String nome;
	private int preco;
	private int hipoteca;
	private int multiplicador;
	private Jogador proprietario;
	
	public Empresas(String nome, int preco, int hipoteca, int multiplicador) {
		this.nome = nome;
		this.preco = preco;
		this.hipoteca = hipoteca;
		this.multiplicador = multiplicador;
		this.proprietario=null;
	}
	
	public void compra(Jogador j) throws SemSaldoException  {//compra a empresa
		if(j.getDinheiro()>=this.preco) {
			j.perdeDinehiro(preco);
			this.proprietario = j;
			j.addEmpresa(this);
			System.out.println("Compra com Sucesso");
			System.out.println("Saldo atual: "+j.getDinheiro());}
		else throw new SemSaldoException();
	
		}
	
	
	public String toString() {//retorna as informações da empresa
		return this.nome+": "+
				"\nPreço: "+this.preco+
				"\nHipoteca: "+this.hipoteca+
				"\nProprietário: "+this.proprietario;
	}

	public String getNome() {//retorna nome da empresa
		return this.nome;
	}

	public int getPreco() {//retorna preço da empresa
	 return this.preco;
	}

	public Jogador getProprietario() {//retorna proprietário da empresa
		return this.proprietario;
	}
	
	public void pagaAluguel(Jogador recebe, Jogador paga) throws SemSaldoException {//paga aluguel para empresa
		if(recebe.equals(paga)) return ;
		String aux= paga.getUltimoDado();
		String[] a=aux.split(" ");
		int dadosSomados= Integer.parseInt(a[0])+Integer.parseInt(a[1]);
		paga.perdeDinehiro(dadosSomados*multiplicador);
		recebe.ganhaDinheiro(dadosSomados*multiplicador);
		System.out.println("Jogador "+paga.getNome() +" caiu na empresa de "+recebe.getNome()+ " e pagou " +dadosSomados*multiplicador+"\n");
		System.out.println("Saldo atual do jogador "+recebe.getNome()+" é: "+ recebe.getDinheiro());
		System.out.println("Saldo atual do jogador "+paga.getNome()+" é : "+paga.getDinheiro());
	}
	
	public void fazAcao() {//faz ação referente a Empresas
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
    				} catch (SemSaldoException e) {
    					System.out.println(e.getMessage());
    				}
    			}
			}
		}
		else {
    		try{
    			pagaAluguel(proprietario,temp.getJogadorDaVez());
    		}
    		catch (SemSaldoException e) {
    			System.out.println(e.getMessage());
    		}
		}
	}
		
}

	

