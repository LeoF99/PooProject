package base;

public class corNaoSuportadaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public corNaoSuportadaException(String erro) {
		super(erro);
	}
	public corNaoSuportadaException() {
		super("Cor desejada n�o est� entre as op��es.");
	}
}
