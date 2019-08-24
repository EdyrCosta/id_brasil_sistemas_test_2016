/**
 * @author Edyr Costa
 * @date 07/06/2016
 */
package com.br.edyr.main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;

import com.br.edyr.ui.pnlMain;

public class Principal {
	public static void main(String[] args) {
		// Prepara a Interface Gráfica
		pnlMain panel = new pnlMain();
		JFrame frame = new JFrame("Conversor Númerico by Edyr Costa");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(360, 530);

		// Centraliza na Tela
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((dim.width - frame.getWidth()) / 2, (dim.height - frame.getHeight()) / 2);

		// Inicializa o Ícone
		URL urlIcon = ClassLoader.getSystemResource("com/br/edyr/res/calc.png");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(urlIcon));

		// Adiciona a Interface
		frame.add(panel);
		// Exibe a Janela
		frame.setVisible(true);
	}
}