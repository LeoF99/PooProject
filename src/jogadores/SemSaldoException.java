package jogadores;

public class SemSaldoException extends Exception {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SemSaldoException(String e) {
		super(e);
	}
	
	public SemSaldoException() {
		super("Saldo insuficiente: Impossivel fazer a transferência");
	}
}
