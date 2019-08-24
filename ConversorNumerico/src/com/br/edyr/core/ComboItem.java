/**
 * @author Edyr Costa
 * @date 07/06/2016
 */
package com.br.edyr.core;

/**
 * Classe Simples de Dados do tipo Chave/Valor para o JComboBox
 */
public class ComboItem {
	private String key;
	private String value;

	public ComboItem(String key, String value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return key;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
}