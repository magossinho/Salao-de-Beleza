package modelo;

public class Cabeleireiro extends Funcionario {
	private Double comissao;

	public Cabeleireiro() {
		super();
	}
	
	public Cabeleireiro(Double comissao) {
		super();
		this.comissao = comissao;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	@Override
	public String toString() {
		return super.toString() + " [comissao=" + comissao + "]";
	}

	public Double comporSalario(Double valor) {
		return super.getSalarioBase() +
				this.comissao * valor / 100;
	}
	
}
