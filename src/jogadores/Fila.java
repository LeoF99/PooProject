package jogadores;

import java.util.NoSuchElementException;

public class Fila {

	private String [] vetor; //fila
	private int numeroDeElementos; //total de elementos na fila
	private int primeiro; // index do primeiro elemento
	private int ultimo; // index do proximo espaço vazio
	
	public Fila() { //inicia
		this.vetor=  new String [3];
		this.numeroDeElementos=0;
		this.primeiro=0;
		this.ultimo=0;
	}
	
	public boolean vazio() { //ve se ta vazio
		return this.numeroDeElementos==0;
	}
	
	public int tamanho() { // qntd de elementos
		return this.numeroDeElementos;
	}
	
	public void enfileirar(String item) { //add item
		
		this.vetor[this.ultimo++]= item; // add o item
		
		if(this.ultimo==this.vetor.length) this.ultimo=0; //se estrapolar o ulyimo, começa do inicio
		
		if(numeroDeElementos<3) this.numeroDeElementos++;// add 1 na qntd pelo item q entrou
	}
	
	public String desenfileirar() { //tira
		if(vazio()) throw new NoSuchElementException ("Fila vazia");
		
		String item=this.vetor[this.primeiro]; //copia o conteudo
		
		this.vetor[this.primeiro]= null; 	//apaga o conteudo
		this.numeroDeElementos--;		//diminui a qntd de elementos
		this.primeiro ++; //readapta o index do primeiro
		
		if(this.primeiro==this.vetor.length) this.primeiro =0;//refazendo o ciclo
		
		return item;
	}
	
	public String [] getAll() {
		return vetor;
	}
}
