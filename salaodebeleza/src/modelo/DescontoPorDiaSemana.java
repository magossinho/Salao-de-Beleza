package modelo;

import interfaces.PoliticaDesconto;

public class DescontoPorDiaSemana implements PoliticaDesconto {
	
	public Double gerarPercentualDeDesconto(Double valor) {
		
		Double percentual=0.0;
		
		if (valor < 500)
			percentual = 5.0;
		else 
			if (valor < 1000)
				percentual = 10.0;
			else percentual = 15.0;
		
		return percentual;
		
	}
}
