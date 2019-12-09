package base;

public class IndexNaoSuportadoEx extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IndexNaoSuportadoEx() {
		super("Número da construção não suportado, por favor escolher um número válido. [Rodada reiniciada] ");
	}
	public IndexNaoSuportadoEx(String erro) {
		super(erro);
	}
}
 


