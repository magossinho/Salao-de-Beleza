package modelo;

public class ItensAtendimento {
	
	private Funcionario funcionario;
	private Servico servico;
	
	public ItensAtendimento() {
		super();
	}

	public ItensAtendimento(Funcionario funcionario, Servico servico) {
		super();
		this.funcionario = funcionario;
		this.servico = servico;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	@Override
	public String toString() {
		return "ItensAtendimento [funcionario=" + funcionario + ", servico=" + servico + "]";
	}

	
}
