/**
 * @author Edyr Costa
 * @date 07/06/2016
 */
package com.br.edyr.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.br.edyr.conversor.Conversor;
import com.br.edyr.conversor.Estatistica;
import com.br.edyr.core.ComboItem;
import com.br.edyr.modelos.NumeroIndoArabico;
import com.br.edyr.modelos.NumeroRomano;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class pnlMain extends JPanel {
	private static final long serialVersionUID = -2534459927558597227L;
	private JTextField txfNumero1;
	private JTextField txfResultado;
	private JComboBox<ComboItem> cmbSistemaNumerico1;
	private JComboBox<ComboItem> cmbSistemaNumerico2;
	private DefaultListModel<String> modelo;

	private final String regexNumRomanos = "^[Mm]{0,3}([CMcm]|[CDcd]|[Dd]?[Cc]{0,3})([Xx][Cc]|[XLxl]|[Ll]?[Xx]{0,3})([IXix]|[IViv]|[Vv]?[Ii]{0,3})$";
	private final String regexNumIndoArabicos = "^[0-9]+$";

	/**
	 * Cria o Painel da Aplicação
	 */
	public pnlMain() {
		// Configura o Layout
		setLayout(null);
		setSize(360, 500);

		// Itens do ComboBox
		ComboItem cbiIndoArab = new ComboItem("Sistema Indo-Arábico", "0");
		ComboItem cbiRomano = new ComboItem("Sistema Romano", "1");

		// Label de Título
		JLabel lblControleDeTempo = new JLabel("CONVERSOR NUMÉRICO");
		lblControleDeTempo.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		lblControleDeTempo.setFont(new Font("Arial", Font.BOLD, 18));
		lblControleDeTempo.setBounds(0, 11, 360, 24);
		add(lblControleDeTempo);

		// Label de Introdução
		JLabel lblBemvindo = new JLabel(
				"<html>Bem-Vindo ao Conversor Numérico by Edyr Costa! Aqui você pode converter números indo-arábicos em romanos e vice-versa. Basta preencher os campos abaixo.</html>");
		lblBemvindo.setBounds(28, 46, 293, 62);
		add(lblBemvindo);

		// Label Texto
		JLabel lblDe = new JLabel("De:");
		lblDe.setForeground(new Color(20, 20, 200));
		lblDe.setBounds(38, 130, 46, 14);
		add(lblDe);

		// ComboBox de seleção do Sistema Numérico
		cmbSistemaNumerico1 = new JComboBox<ComboItem>();
		cmbSistemaNumerico1.addItem(cbiIndoArab);
		cmbSistemaNumerico1.addItem(cbiRomano);
		cmbSistemaNumerico1.setBounds(33, 155, 146, 20);
		add(cmbSistemaNumerico1);

		// TextField do Número a ser Convertido
		txfNumero1 = new JTextField();
		txfNumero1.setBounds(33, 180, 146, 20);
		add(txfNumero1);
		// txfNumero1.setColumns(10);

		// Label Texto
		JLabel lblPara = new JLabel("Para:");
		lblPara.setForeground(new Color(20, 20, 200));
		lblPara.setBounds(38, 224, 46, 14);
		add(lblPara);

		// ComboBox de seleção do Sistema Numérico
		cmbSistemaNumerico2 = new JComboBox<ComboItem>();
		cmbSistemaNumerico2.addItem(cbiIndoArab);
		cmbSistemaNumerico2.addItem(cbiRomano);
		cmbSistemaNumerico2.setBounds(33, 248, 146, 20);
		add(cmbSistemaNumerico2);

		// TextField com o Número Convertido
		txfResultado = new JTextField();
		txfResultado.setColumns(10);
		txfResultado.setEditable(false);
		txfResultado.setBounds(33, 273, 146, 20);
		add(txfResultado);

		// Label de Estatísticas
		JLabel lblEstatisticas = new JLabel("ESTATÍSTICAS");
		lblEstatisticas.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblEstatisticas.setBounds(28, 316, 146, 14);
		add(lblEstatisticas);

		// Botão de Conversão
		JButton btnConverter = new JButton("Converter");
		btnConverter.setBounds(215, 155, 106, 47);
		btnConverter.addActionListener(btnConverter_Action());
		add(btnConverter);

		// Lista de Estatísticas
		modelo = new DefaultListModel<>();
		JList<String> list = new JList<>(modelo);
		list.setBounds(28, 341, 293, 150);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		add(list);
	}

	private ActionListener btnConverter_Action() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Obtém os Sistemas Númericos
				if (((ComboItem) cmbSistemaNumerico1.getSelectedItem()).getValue() == "0") {
					// Faz a Validação
					String textoNumero = txfNumero1.getText();
					Pattern padrao = Pattern.compile(regexNumIndoArabicos);
					Matcher verificador = padrao.matcher(textoNumero);
					if (!verificador.matches()) {
						// Avisa ao Usuário
						JOptionPane.showMessageDialog(null, "Insira um número maior que 0 e menor que 3999.", "Erro",
								JOptionPane.ERROR_MESSAGE);
						// Foco
						txfNumero1.requestFocus();

						// Encerra a Execução
						return;
					} else if (Integer.valueOf(textoNumero) < 1 || Integer.valueOf(textoNumero) > 3999) {
						// Avisa ao Usuário
						JOptionPane.showMessageDialog(null, "Insira um número maior que 0 e menor que 3999.",
								"Limitação", JOptionPane.WARNING_MESSAGE);
						// Foco
						txfNumero1.requestFocus();

						// Encerra a Execução
						return;
					}

					if (((ComboItem) cmbSistemaNumerico2.getSelectedItem()).getValue() == "0") {
						// Copia o mesmo número
						txfResultado.setText(textoNumero);

						// Limpa
						modelo.clear();
					} else {
						// Prepara os Dados
						NumeroIndoArabico numIndoArabico = new NumeroIndoArabico();
						numIndoArabico.setNumero(textoNumero);

						// Faz a Conversão
						Conversor conv = new Conversor();
						NumeroRomano numRomano = conv.converterRomano(numIndoArabico);

						// Exibe o Resultado
						txfResultado.setText(numRomano.getNumero());

						// Gera as Estatísticas
						modelo.clear();
						Estatistica est = new Estatistica();
						String[] log = est.gerarEstatisticaRomanos(numRomano).toString().split("\n");
						for (int i = 0; i < log.length; i++) {
							modelo.addElement(log[i]);
						}
					}
				} else {
					// Faz a Validação
					String textoNumero = txfNumero1.getText();
					Pattern padrao = Pattern.compile(regexNumRomanos);
					Matcher verificador = padrao.matcher(textoNumero);
					if (!verificador.matches() || textoNumero.equals("")) {
						// Avisa ao Usuário
						JOptionPane.showMessageDialog(null, "Insira um número romano válido.", "Atenção",
								JOptionPane.ERROR_MESSAGE);
						// Foco
						txfNumero1.requestFocus();

						// Encerra a execução
						return;
					}

					if (((ComboItem) cmbSistemaNumerico2.getSelectedItem()).getValue() == "1") {
						// Copia o mesmo número
						txfResultado.setText(txfNumero1.getText());

						// Limpa
						modelo.clear();
					} else {
						// // Prepara os Dados
						NumeroRomano numero = new NumeroRomano();
						numero.setNumero(txfNumero1.getText());

						// Faz a Conversão
						Conversor conv = new Conversor();
						NumeroIndoArabico numIndoArabico = conv.converterIndoArabico(numero);

						// Exibe o Resultado
						txfResultado.setText(numIndoArabico.getNumero());

						// Gera as Estatísticas
						modelo.clear();
						Estatistica est = new Estatistica();
						String[] log = est.gerarEstatisticaIndoArabicos(numIndoArabico).toString().split("\n");
						for (int i = 0; i < log.length; i++) {
							modelo.addElement(log[i]);
						}
					}
				}
			}
		};
	}
}