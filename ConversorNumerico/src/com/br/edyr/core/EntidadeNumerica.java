/**
 * @author Edyr Costa
 * @date 07/06/2016
 */
package com.br.edyr.core;

public abstract class EntidadeNumerica {
	private String numero;
	public String[] numerosBase;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String[] getNumerosBase() {
		return numerosBase;
	}

	public void setNumerosBase(String[] numerosBase) {
		this.numerosBase = numerosBase;
	}
}