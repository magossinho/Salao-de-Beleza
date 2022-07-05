package modelo;

public class Servico {
	private String descricao;
	private double valor;
	private int duracao;
	
	public Servico() {
		super();
	}

	public Servico(String descricao, double valor, int duracao) {
		super();
		this.descricao = descricao;
		this.valor = valor;
		this.duracao = duracao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	
	

}
