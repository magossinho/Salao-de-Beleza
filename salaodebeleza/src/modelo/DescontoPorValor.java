package modelo;

import interfaces.PoliticaDesconto;

public class DescontoPorValor implements PoliticaDesconto {

	public Double gerarPercentualDeDesconto(Double valor) {
		
		Double percentual=0.0;
		
		if (valor < 500)
			percentual = 3.0;
		else 
			if (valor < 1000)
				percentual = 7.0;
			else percentual = 10.0;
		
		return percentual;
		
	}
	
	
}
