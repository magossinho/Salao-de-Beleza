package launcher;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Atendimento;
import modelo.Cabeleireiro;
import modelo.Cliente;
import modelo.DescontoPorDiaSemana;
import modelo.DescontoPorValor;
import modelo.Funcionario;
import modelo.ItensAtendimento;
import modelo.Manicure;
import modelo.Servico;
import utilitario.ValidaCpf;

public class Main {
	static List<Cliente> clientes = new ArrayList<Cliente>();
	static ArrayList<Atendimento> atendimentos = new ArrayList<Atendimento>();
	static ArrayList<Servico> servicos = new ArrayList<Servico>();
	static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	
	public static void main(String[] args) {
		int opcao; 
		String opcoesDoMenu = "1- Cadastrar Funcionario "
				+ "\n2- Mostrar Funcion�rios Cadastrados"
				+ "\n3- Cadastrar Cliente "
				+ "\n4- Mostrar Clientes Cadastrados"
				+ "\n5- Cadastrar Servi�o"
				+ "\n6- Mostrar Servi�os Cadastrados"
				+ "\n7- Cadastrar Atendimento"
				+ "\n8- Mostrar Atendimentos Cadastrados"
				+ "\n9- Mostrar Composi��o do Salario"
				+ "\n10- Encerrar Exeu��o"
				+ "\nQual a op��o desejada? ";
		do {
			
			opcao = Integer.parseInt(JOptionPane.showInputDialog(opcoesDoMenu));
			
			switch(opcao) {
			case 1:
				cadastrarFuncionario();
				break;
			case 2:
				mostrarFuncionario();
				break;
			case 3:
				cadastrarCliente();
				break;
			case 4:
				mostrarClientes();
				break;
			case 5:
				cadastrarServico();
				break;
			case 6:
				mostrarServico();
				break;
			case 7:
				cadastrarAtendimento();
				break;
			case 8:
				mostrarAtendimento();
				break;
			case 9:
				totalizarServicosPorFuncionario();
				break;
			case 10:
				System.out.println("Encerrando execu��o...");
				break;
		
			default:
				JOptionPane.showMessageDialog(null, "Op��o escolhida � inv�lida. Dever� escolher outra");
			} //fim switch
		} while (opcao != 10);
		

	}
	
	public static void cadastrarFuncionario() {
		int tipo = Integer.parseInt(JOptionPane.showInputDialog
				("1 para manicure; 2 para cabeleireiro"));
		if (tipo == 1) {
			Funcionario temp = new Manicure();
			temp.setNome(JOptionPane.showInputDialog(
					"Nome da(do) manicure: ")  );
			temp.setSalarioBase(Double.parseDouble(JOptionPane.showInputDialog(
					"Sal�rio base da(do) manicure: ")));

			((Manicure)temp).setProdutividade(Integer.parseInt(
					JOptionPane.showInputDialog(
					"Produtividade da(do) manicure: ")));
					
			funcionarios.add(temp);
			
			JOptionPane.showMessageDialog(null,  
					"Manicure cadastrada(o) com sucesso");
		}
		if (tipo == 2) {
			Funcionario temp = new Cabeleireiro();
			temp.setNome(JOptionPane.showInputDialog(
					"Nome da(do) cabeleireiro: ")  );
			temp.setSalarioBase(Double.parseDouble(JOptionPane.showInputDialog(
					"Sal�rio base da(do) cabeleireiro: ")));

			((Cabeleireiro)temp).setComissao(Double.parseDouble(
					JOptionPane.showInputDialog(
					"Comiss�o da(do) cabeleireiro: ")));
					
			funcionarios.add(temp);
			
			JOptionPane.showMessageDialog(null,  
					"Cabeleireiro cadastrada(o) com sucesso");
		}
	}
	
	public static void mostrarFuncionario() {
		for(Funcionario f: funcionarios) {
			JOptionPane.showMessageDialog(null, f.toString());
		}
		
		
	}
	public static void cadastrarServico() {
		Servico temp = new Servico();
		temp.setDescricao(JOptionPane.showInputDialog(
				"Descri��o do servi�o: ")  );
		
		temp.setValor(Double.parseDouble(JOptionPane.showInputDialog(
				"Valor do servi�o: ")));
		
		temp.setDuracao(Integer.parseInt(JOptionPane.showInputDialog(
				"Dura�ao do servi�o: ")));
		servicos.add(temp);
		
		JOptionPane.showMessageDialog(null,  
				"Servi�o cadastrado com sucesso");
		
	}
	
		
	public static void cadastrarAtendimento() {
		String tempCPF="";
		Atendimento temp;

		tempCPF=JOptionPane.showInputDialog("Digite o CPF do cliente: "); 
		Cliente clienteEncontrado = buscarClientePeloCPF(tempCPF);
		if (clienteEncontrado == null) {
			JOptionPane.showMessageDialog(null,"CPF inexistente");
		}
		else {
			temp = new Atendimento();
			temp.setCliente(clienteEncontrado);
			try {
//			SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c = Calendar.getInstance();
			temp.setData(c);	
			
			//cadastrar os servi�os que o cliente deseja realizar no sal�o de beleza
			String resposta="";
			Servico servico_buscado;
			Funcionario func_buscado;
			Double valorTotal = 0.0;
			do { //este do-while termina na linha 169 e serve para que o cliente tenha a possibilidade
				 //de escolher v�rios servi�os para o seu atendimento
				
				do { //este do-while termina na linha 152 e serve para repetir a digita��o da descri��o 
					 //do servi�o em caso de erro. 
					String aux = JOptionPane.showInputDialog("Qual o servi�o desejado?");
					servico_buscado = buscarServicoPorDescricao(aux);
					if (servico_buscado == null) {
						JOptionPane.showMessageDialog(null, "Servico n�o dispon�vel. Escolha outro. ");
					}
				} while (servico_buscado == null);

				do { //este do-while termina na linha 160 e serve para repetir a digita��o do nome 
					 //do funcion�rio em caso de erro
					String auxF = JOptionPane.showInputDialog("Digite o nome do funcionario: ");
					func_buscado = buscarFuncionarioPeloNome(auxF);
					if (func_buscado == null) {
						JOptionPane.showMessageDialog(null, "Funcion�rio n�o encontrado");
					}
				} while (func_buscado == null);
				
				ItensAtendimento auxItens = new ItensAtendimento(func_buscado, servico_buscado); //Aqui crio um objeto ItensAtendimento 
				                //j� inicializando com o ponteiro do servico e do funcionario que vai realizar esse servico
				
				temp.getItensDoAtendimento().add(auxItens); //Aqui o item do servi�o instanciado na linha acima � 
				                                            //colocado na lista dos servicos do atendimento que est� sendo cadastrado
				valorTotal = valorTotal + servico_buscado.getValor();
				resposta = JOptionPane.showInputDialog("Mais algum servi�o (Sim/N�o)? ");
			
			} while (resposta.equalsIgnoreCase("Sim"));// Aqui testo se o usu�rio quer colocar mais algum servi�o no 
			                                           //seu atendimento 
			
			temp.setValorTotal(valorTotal);
			
			//DEFINE A POLITICA DE DESCONTO
if (temp.getData().DAY_OF_WEEK >=1 && temp.getData().DAY_OF_WEEK <= 3) {
	temp.setTipoDesconto(new DescontoPorDiaSemana());
			}
else 
	temp.setTipoDesconto(new DescontoPorValor());

//MOSTRAR PERCENTUAL DE DESCONTO
Double x = temp.getTipoDesconto().gerarPercentualDeDesconto(valorTotal);
JOptionPane.showMessageDialog(null,  "Desconto = " + x);
			atendimentos.add(temp); //Gravo o atendimento completo na lista dos atendimentos do salao
			JOptionPane.showMessageDialog(null, "Cadastro do atendimento realizado com sucesso");
			}

			catch(Exception e) {
				
			}
		}
			
	}
	
	public static Funcionario buscarFuncionarioPeloNome(String nome) {
		Funcionario achouFuncionario;
			int j=0;
			while ((j < funcionarios.size()) && 
					(!nome.equals(funcionarios.get(j).getNome()))) {
				j++;
			}
			if (j == funcionarios.size()) {
				achouFuncionario = null;
			}
			else {
				achouFuncionario = funcionarios.get(j);
			}
			return achouFuncionario;
	}
	
	public static Servico buscarServicoPorDescricao(String desc) {
		Servico achouServico;
			int j=0;
			while ((j < servicos.size()) && 
					(!desc.equals(servicos.get(j).getDescricao()))) {
				j++;
			}
			if (j == servicos.size()) {
				achouServico = null;
			}
			else {
				achouServico = servicos.get(j);
			}
			return achouServico;
	}
	
	public static Cliente buscarClientePeloCPF(String cpf) {
		Cliente achouCliente;
			int j=0;
			while ((j < clientes.size()) && (!cpf.equals(clientes.get(j).getCpf()))) {
				j++;
			}
			if (j == clientes.size()) {
				achouCliente = null;
			}
			else {
				achouCliente = clientes.get(j);
			}
			return achouCliente;
	}
	
	
	public static void mostrarAtendimento() {
		for(Atendimento a: atendimentos) {
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String retorno="";
			retorno = formatter.format(a.getData().getTime());
			System.out.println(retorno);
			System.out.println("Nome do cliente atendido: " +
			   a.getCliente().getNome());
			System.out.println("CPF do cliente: " +
			   a.getCliente().getCpf());
			System.out.println("Endere�o do cliente: "+
			   a.getCliente().getEndereco());
			for (ItensAtendimento i: a.getItensDoAtendimento()) {
				System.out.println("Descri��o do servico: " + i.getServico().getDescricao());
				System.out.println("Valor do servi�o: " + i.getServico().getValor());
				System.out.println("Dura��o do servi�o: " + i.getServico().getDuracao());
				System.out.println("Realizado pelo funcion�rio: " + i.getFuncionario().getNome());				
				
			}
			System.out.println("Valor total = " + a.getValorTotal());
		}
		
		
	}
	
	public static void mostrarServico() {
		for(Servico s: servicos) {
			System.out.println("Descri��o do servi�o: " +
			   s.getDescricao());
			System.out.println("Valor do servi�o: " +
			   s.getValor());
			System.out.println("Dura�ao do servi�o: "+
			   s.getDuracao());
		}
		
		
	}
	
	public static void cadastrarCliente() {
		Cliente aux = new Cliente();
		aux.setNome(JOptionPane.showInputDialog("Digite o nome do cliente: "));
		aux.setEndereco(JOptionPane.showInputDialog("Digite o endere�o do cliente: "));
		boolean validacao = false;
		do {
			aux.setCpf(JOptionPane.showInputDialog("Digite o CPF do cliente: "));
			validacao = ValidaCpf.isCPF(aux.getCpf());
			if (!validacao) {
				JOptionPane.showMessageDialog(null, "CPF incorreto");
			}
		} while (!validacao);
		clientes.add(aux);
		JOptionPane.showMessageDialog(null,"Cadastro do Cliente realizado com sucesso");	
	}

	public static void mostrarClientes() {
		int i;
		for(i=0; i<clientes.size();i++) {
			System.out.println("\nNome: " + clientes.get(i).getNome());
			System.out.println("\nEndere�o: "+ clientes.get(i).getEndereco());
			System.out.println("\nCPF: " + clientes.get(i).getCpf()+"\n");
		}
	}
	
	
	public static void totalizarServicosPorFuncionario() {
		String nome = JOptionPane.showInputDialog
				("Nome do funcionario");
		Funcionario aux = buscarFuncionarioPeloNome(nome);
		if (aux == null) {
			System.out.println("Funcionario n�o existe.");
		}
		else {
			Double total = 0.0;
			for(Atendimento a: atendimentos) {
				for (ItensAtendimento i: a.getItensDoAtendimento()) {
					if(i.getFuncionario() == aux) {
						total = total + i.getServico().getValor();
					}
				}
			}
			System.out.println(
					"Valor total dos Servicos do Jo�o = " 
			+ total);
			System.out.println("Salario final: "+
			aux.comporSalario(total));
		}
		
	}
	

	
	
}
