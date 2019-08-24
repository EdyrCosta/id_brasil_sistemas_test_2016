/**
 * @author Edyr Costa
 * @date 07/06/2016
 */
package com.br.edyr.modelos;

import com.br.edyr.core.EntidadeNumerica;

public class NumeroIndoArabico extends EntidadeNumerica {

	private String[] bases = new String[] { "1", "4", "5", "9", "10", "40", "50", "90", "100", "400", "500", "900",
			"1000" };

	public NumeroIndoArabico() {
		// Seta os Números
		setNumerosBase(bases);
	}

	public NumeroIndoArabico(String numero) {
		// Seta os Números
		setNumero(numero);
		setNumerosBase(bases);
	}
}