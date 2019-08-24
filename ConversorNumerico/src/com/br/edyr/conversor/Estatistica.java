/**
 * @author Edyr Costa
 * @date 07/06/2016
 */
package com.br.edyr.conversor;

import com.br.edyr.modelos.NumeroIndoArabico;
import com.br.edyr.modelos.NumeroRomano;

public class Estatistica {
	public StringBuilder gerarEstatisticaRomanos(NumeroRomano numRomano)
	{
		// Inicializa os Objetos
		StringBuilder log = new StringBuilder();
		
		// Log
		log.append("Contagem de Algarismos");
		log.append("\n");
		
		// Percorre as bases
		for (int i = 0; i < numRomano.getNumerosBase().length; i++)
		{
			// Obtém os Números
			String numero = numRomano.getNumero();
			String numBase = (numRomano.getNumerosBase()[i].length() == 1) ? numRomano.getNumerosBase()[i] : "";
			if (!numBase.equals(""))
			{
				// Faz a contagem
				int count = numero.length() - numero.replace(numBase, "").length();
				// Monta o Log
				log.append("Algarismo " + numBase + " :\t" + count);
				log.append("\n");
			}
		}
		
		// Retorna os Dados
		return log;
	}
	
	public StringBuilder gerarEstatisticaIndoArabicos(NumeroIndoArabico numIndoArabico)
	{
		// Inicializa os Objetos
		StringBuilder log = new StringBuilder();
		
		// Log
		log.append("Contagem de Algarismos");
		log.append("\n");
		
		// Percorre as bases
		for (int i = 0; i < 10; i++)
		{
			// Obtém os Números
			String numero = numIndoArabico.getNumero();
			// Faz a contagem
			int count = numero.length() - numero.replace(String.valueOf(i), "").length();
			// Monta o Log
			log.append("Algarismo " + i + " :\t" + count);
			log.append("\n");
		}
		
		// Retorna os Dados
		return log;
	}
}