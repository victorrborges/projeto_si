package exceptions;

public class ObjetoInexistenteException extends Exception {

	public ObjetoInexistenteException(String erro) {
		super("ExcecaoDados: " + erro);
	}
}

