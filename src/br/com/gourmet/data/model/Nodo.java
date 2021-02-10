package br.com.gourmet.data.model;

public class Nodo {

	String descricao;
	Nodo nodoFilhoRespostaSim;
	Nodo nodoFilhoRespostaNao;

	public Nodo(String descricao, Nodo nodoFilhoRespostaSim, Nodo nodoFilhoRespostaNao) {
		this.descricao = descricao;
		this.nodoFilhoRespostaSim = nodoFilhoRespostaSim;
		this.nodoFilhoRespostaNao = nodoFilhoRespostaNao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Nodo getNodoFilhoRespostaSim() {
		return nodoFilhoRespostaSim;
	}

	public void setNodoFilhoRespostaSim(Nodo nodoFilhoRespostaSim) {
		this.nodoFilhoRespostaSim = nodoFilhoRespostaSim;
	}

	public Nodo getNodoFilhoRespostaNao() {
		return nodoFilhoRespostaNao;
	}

	public void setNodoFilhoRespostaNao(Nodo nodoFilhoRespostaNao) {
		this.nodoFilhoRespostaNao = nodoFilhoRespostaNao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nodoFilhoRespostaNao == null) ? 0 : nodoFilhoRespostaNao.hashCode());
		result = prime * result + ((nodoFilhoRespostaSim == null) ? 0 : nodoFilhoRespostaSim.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nodo other = (Nodo) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nodoFilhoRespostaNao == null) {
			if (other.nodoFilhoRespostaNao != null)
				return false;
		} else if (!nodoFilhoRespostaNao.equals(other.nodoFilhoRespostaNao))
			return false;
		if (nodoFilhoRespostaSim == null) {
			if (other.nodoFilhoRespostaSim != null)
				return false;
		} else if (!nodoFilhoRespostaSim.equals(other.nodoFilhoRespostaSim))
			return false;
		return true;
	}
}
