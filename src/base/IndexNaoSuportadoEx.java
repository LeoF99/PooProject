package base;

public class IndexNaoSuportadoEx extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IndexNaoSuportadoEx() {
		super("N�mero da constru��o n�o suportado, por favor escolher um n�mero v�lido. [Rodada reiniciada] ");
	}
	public IndexNaoSuportadoEx(String erro) {
		super(erro);
	}
}
 


