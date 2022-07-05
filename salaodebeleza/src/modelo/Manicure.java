package modelo;

public class Manicure extends Funcionario {
	
	private Integer produtividade;

	public Manicure() {
		super();
	}


	public Manicure(Integer produtividade) {
		super();
		this.produtividade = produtividade;
	
	}

	public Integer getProdutividade() {
		return produtividade;
	}


	public void setProdutividade(Integer produtividade) {
		this.produtividade = produtividade;
	}


	@Override
	public String toString() {
		return super.toString() + " [produtividade=" + produtividade + "]";
	}


	public Double comporSalario(Double valor) {
		Double bonus=0.0;
		if (valor < 1000)
			bonus = 100.0;
		else
			if (valor < 2000)
				bonus = 200.0;
			else bonus = 300.0;
		return super.getSalarioBase() + bonus;
	}

	
}
