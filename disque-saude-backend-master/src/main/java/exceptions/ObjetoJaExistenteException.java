package exceptions;

public class ObjetoJaExistenteException extends Exception {

	public ObjetoJaExistenteException(String erro) {
		super("ExcecaoDados: " + erro);
	}
}
