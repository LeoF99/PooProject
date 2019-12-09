package base;

public class NumJogadoresNaoSup extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NumJogadoresNaoSup() {
		super("Número de Jogadores invaidos, por favor escolher entre 2 e 8.");
	}
	public NumJogadoresNaoSup(String erro) {
		super(erro);
	}
}
