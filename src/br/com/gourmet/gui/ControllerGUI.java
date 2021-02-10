package br.com.gourmet.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.com.gourmet.constants.Constantes;

public class ControllerGUI {

	private static Object[] options = { Constantes.OPCAOSIM, Constantes.OPCAONAO };

	public static JButton montaTelaAbertura() {

		// Cria Frame, Panel, botão e label
		JFrame frame = new JFrame(Constantes.NOMEJOGO);
		JPanel panel = new JPanel();
		JButton button = new JButton("Ok");
		JLabel label = new JLabel("Pense em um prato que gosta");

		// Seta layout do grid e ação default ao fechar frame
		panel.setLayout(new GridBagLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Especifica valores para alinhamentos
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;

		// Adiciona label e botão
		panel.add(label, gbc);
		gbc.insets = new Insets(15, 0, 0, 0);
		panel.add(button, gbc);

		// Monta painel no frame
		frame.getContentPane().add(panel);

		// Define tamanho, centraliza e exibe
		frame.setSize(Constantes.LARGURATELAINICIAL, Constantes.ALTURATELAINICIAL);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		return button;
	}

	public static int montaTelaConfirmaOpcao(String descricao) {
		return JOptionPane.showOptionDialog(null, "O prato que você pensou é " + descricao + "?", "Acertei?",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	}

	public static void mostraMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, Constantes.NOMEJOGO, JOptionPane.INFORMATION_MESSAGE);
	}

	public static String montaTelaInput(String mensagem) {
		return JOptionPane.showInputDialog(mensagem);
	}

}
