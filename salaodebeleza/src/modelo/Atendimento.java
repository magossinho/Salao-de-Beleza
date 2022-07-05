package modelo;

import java.util.ArrayList;
import java.util.Calendar;

import interfaces.PoliticaDesconto;

public class Atendimento {
	
	private Cliente cliente;
	private Calendar data; 
	private ArrayList<ItensAtendimento> itensDoAtendimento;
	private Double valorTotal;
	private PoliticaDesconto tipoDesconto;
	
	public Atendimento() {
		super();
		itensDoAtendimento = new ArrayList<ItensAtendimento>();
	}

	public Atendimento(Cliente cliente, Calendar data) {
		super();
		this.cliente = cliente;
		this.data = data;
		itensDoAtendimento = new ArrayList<ItensAtendimento>();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public ArrayList<ItensAtendimento> getItensDoAtendimento() {
		return itensDoAtendimento;
	}

	public void setItensDoAtendimento(ArrayList<ItensAtendimento> itensDoAtendimento) {
		this.itensDoAtendimento = itensDoAtendimento;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public PoliticaDesconto getTipoDesconto() {
		return tipoDesconto;
	}

	public void setTipoDesconto(PoliticaDesconto tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}

}
