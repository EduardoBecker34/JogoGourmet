package br.com.gourmet.data.model;

public class Jogo {
	
	private static Nodo nodoInicial = montaNodoInicial();
	private Nodo nodoAtual;
	private Nodo nodoAnterior;
	private boolean encerramento;

	public Jogo() {
		this.nodoAtual = Jogo.nodoInicial;
		this.nodoAnterior = null;
		this.encerramento = false;
	}

	public Nodo getNodoAtual() {
		return nodoAtual;
	}

	public void setNodoAtual(Nodo nodoAtual) {
		this.nodoAtual = nodoAtual;
	}

	public Nodo getNodoAnterior() {
		return nodoAnterior;
	}

	public void setNodoAnterior(Nodo nodoAnterior) {
		this.nodoAnterior = nodoAnterior;
	}

	public boolean isEncerrado() {
		return encerramento;
	}

	public void setEncerramento(boolean encerramento) {
		this.encerramento = encerramento;
	}

	public static Nodo montaNodoInicial() {
		Nodo nodoLasanha = new Nodo("lasanha", null, null);
		Nodo nodoBolo = new Nodo("bolo de chocolate", null, null);
		Nodo nodoInicial = new Nodo("massa", nodoLasanha, nodoBolo);
		return nodoInicial;
	}
}
