package jogadores;

public class JogadorJaExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JogadorJaExisteException(String erro) {
		super(erro);
	}
	public JogadorJaExisteException() {
		super("Erro: Jogador ja existe!"
				+ "\nInserir um jogador novo:");
	}
}
