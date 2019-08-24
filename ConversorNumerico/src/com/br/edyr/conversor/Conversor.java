/**
 * @author Edyr Costa
 * @date 07/06/2016
 */
package com.br.edyr.conversor;

import com.br.edyr.modelos.NumeroIndoArabico;
import com.br.edyr.modelos.NumeroRomano;

public class Conversor {
	public NumeroRomano converterRomano(NumeroIndoArabico numIndoArabico) {
		// Inicializa os Objetos
		StringBuilder romanos = new StringBuilder();
		NumeroRomano numRomano = new NumeroRomano();

		// Verifica a integridade das bases
		int tamBaseAra = numIndoArabico.getNumerosBase().length;
		int tamBaseRom = numRomano.getNumerosBase().length;
		if (tamBaseAra != tamBaseRom) {
			// Dispara uma Exceção
			throw new IllegalArgumentException();
		}

		// Percorre as bases númericas
		for (int i = tamBaseRom - 1; i >= 0; i--) {
			// Números inteiros para facilitar o cálculo
			int numero = Integer.valueOf(numIndoArabico.getNumero());
			int numeroBase = Integer.valueOf(numIndoArabico.getNumerosBase()[i]);

			// Percorre quando o número for maior que a base
			while (numero >= numeroBase) {
				// Obtém o Número atual
				numero = Integer.valueOf(numIndoArabico.getNumero());
				// Subtrai o valor correspondente
				numero -= numeroBase;
				numIndoArabico.setNumero(String.valueOf(numero));
				// Compõe o Número Romano
				romanos.append(numRomano.getNumerosBase()[i]);
			}
		}

		// Atualiza com o Número
		numRomano.setNumero(romanos.toString());

		// Retorna os Dados
		return numRomano;
	}

	public NumeroIndoArabico converterIndoArabico(NumeroRomano numRomano) {
		// Inicializa os Objetos
		int indoarabicos = 0;
		NumeroIndoArabico numIndoArabico = new NumeroIndoArabico();

		// Verifica a integridade das bases
		int tamBaseAra = numIndoArabico.getNumerosBase().length;
		int tamBaseRom = numRomano.getNumerosBase().length;
		if (tamBaseAra != tamBaseRom) {
			// Dispara uma Exceção
			throw new IllegalArgumentException();
		}

		// Percorre os Caracteres
		String numero = numRomano.getNumero();
		for (int i = 0; i < numero.length(); i++) {
			// Obtém o caractere atual
			String caractere = String.valueOf(numero.charAt(i));
			int indice = numero.indexOf(caractere);
			// Verifica se é do grupo dos subtraendos
			// I, X, C
			if (caractere.equalsIgnoreCase("I")) {
				if (indice + 2 < numero.length()) {
					if (numero.substring(indice, (numero.indexOf(caractere) + 2)).equalsIgnoreCase("X")) {
						caractere += "X";
						i++;
					} else if (numero.substring(indice + 1, indice + 2).equalsIgnoreCase("V")) {
						caractere += "V";
						i++;
					}
				}
			} else if (caractere.equalsIgnoreCase("X")) {
				if (indice + 2 < numero.length()) {
					if (numero.substring(indice + 1, indice + 2).equalsIgnoreCase("L")) {
						caractere += "L";
						i++;
					} else if (numero.substring(indice + 1, indice + 2).equalsIgnoreCase("C")) {
						caractere += "C";
						i++;
					}
				}
			} else if (caractere.equalsIgnoreCase("C")) {
				if (indice + 2 < numero.length()) {
					if (numero.substring(indice + 1, indice + 2).equalsIgnoreCase("D")) {
						caractere += "D";
						i++;
					} else if (numero.substring(indice + 1, indice + 2).equalsIgnoreCase("M")) {
						caractere += "M";
						i++;
					}
				}
			}

			// Pesquisa o correspondente para o Indo-Arábico
			for (int k = 0; k < numRomano.getNumerosBase().length; k++) {
				String numeroBase = numRomano.getNumerosBase()[k];
				if (caractere.equalsIgnoreCase(numeroBase)) {
					// Faz a soma com o valor correspondente
					indoarabicos += Integer.valueOf(numIndoArabico.getNumerosBase()[k]);

					// Sai do laço
					break;
				}
			}
		}

		// Atualiza com o Número
		numIndoArabico.setNumero(String.valueOf(indoarabicos));

		// Retorna os Dados
		return numIndoArabico;
	}
}