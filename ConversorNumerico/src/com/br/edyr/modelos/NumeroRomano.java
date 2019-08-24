/**
 * @author Edyr Costa
 * @date 07/06/2016
 */
package com.br.edyr.modelos;

import com.br.edyr.core.EntidadeNumerica;

public class NumeroRomano extends EntidadeNumerica {
	private String[] bases = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };

	public NumeroRomano() {
		// Seta o Número
		setNumerosBase(bases);
	}

	public NumeroRomano(String numero) {
		// Seta o Número
		setNumero(numero);
		setNumerosBase(bases);
	}
}