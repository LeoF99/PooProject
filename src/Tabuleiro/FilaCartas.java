package Tabuleiro;



public class FilaCartas {
	private Casa [] vetor; //fila
	private int numeroDeElementos; //total de elementos na fila
	private int contCircular;
	
	public FilaCartas() { //inicia
		this.vetor = new Casa [31];
		this.numeroDeElementos = 0;
		contCircular=0;
	}
	
	public boolean vazio() { //ve se ta vazio
		return this.numeroDeElementos == 0;
	}
	
	public int tamanho() { // qntd de elementos
		return this.numeroDeElementos;
	}
	
	public void enfileirar(Casa cartasGenericas) { //add item
		this.vetor[numeroDeElementos++]=cartasGenericas;
	}
	public void desenfileirar(Casa item) { //tira
		for(Casa i: vetor) {
			if(i.equals(item)) {
				
			}
		}
	}
	public Casa getCarta() {
		if(vetor[contCircular]==null) contCircular+=1;
		if(contCircular==numeroDeElementos) contCircular=0;
		if(vetor[contCircular] instanceof PasseLivrePrisao){
			Casa aux = vetor[contCircular];
			vetor[contCircular]=null;
			return aux;
		}
		return vetor[contCircular++];
	}
	
	public Casa [] getAll() {
		return this.vetor;
	}
	public void addPasseLivre() {
		for(Casa i: vetor) {
			if(i==null) i=(Casa) new PasseLivrePrisao();
			}
		}
	}
	

