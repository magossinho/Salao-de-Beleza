package modelo;

public class Funcionario {
	private String nome;
	private double salarioBase;
	private double valorIR;
	
	public Funcionario() {
		super();
	}

	public Funcionario(String nome, double salarioBase) {
		super();
		this.nome = nome;
		this.salarioBase = salarioBase;
		calcularIR();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
		calcularIR();
	}

	
	public double getValorIR() {
		return valorIR;
	}

	void calcularIR() {
		if (this.salarioBase < 2000)
			this.valorIR=0.0;
		else if (this.salarioBase < 3000)
				this.valorIR = this.salarioBase * 0.15;
			else if (this.salarioBase < 5000)
					this.valorIR = this.salarioBase * 0.18;
				else this.valorIR = this.salarioBase * 0.27;
		
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + this.nome +
				", salarioBase=" + this.salarioBase +
				", valorIR= " + this.valorIR + "]";
	}


	public Double comporSalario(Double valor) {
		return this.salarioBase;
	}
		

}
