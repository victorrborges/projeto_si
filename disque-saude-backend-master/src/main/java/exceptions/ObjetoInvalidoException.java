package exceptions;

public class ObjetoInvalidoException extends Exception {

	public ObjetoInvalidoException(String erro) {
		super("ExcecaoDados: " + erro);
	}
}

