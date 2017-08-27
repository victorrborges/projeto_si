package exceptions;

public class Rep extends Exception {

	public Rep(String erro) {
		super("ExcecaoDados: " + erro);
	}
}
