package br.com.gourmet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.gourmet.constants.Constantes;
import br.com.gourmet.data.model.Jogo;
import br.com.gourmet.data.model.Nodo;
import br.com.gourmet.gui.ControllerGUI;

public class ControladorJogo {

	public void preparaInicioJogo() {
		// Monta tela de abertura
		JButton botaoInicio = ControllerGUI.montaTelaAbertura();

		// Adiciona listener para iniciar o jogo
		botaoInicio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					iniciaJogo();
				} catch (Exception e) {
					System.exit(0);
				}
			}
		});
	}

	public void iniciaJogo() throws Exception {
		Jogo jogo = new Jogo();

		while (!jogo.isEncerrado()) {
			controlePerguntaRespostaUsuario(jogo);
		}
	}

	private void controlePerguntaRespostaUsuario(Jogo jogo) throws Exception {
		int resultadoEscolha = ControllerGUI.montaTelaConfirmaOpcao(jogo.getNodoAtual().getDescricao());
		if (resultadoEscolha == Constantes.RESULTINPUTSIM) {
			controleRespostaSim(jogo);
		} else if (resultadoEscolha == Constantes.RESULTINPUTNAO) {
			controleRespostaNao(jogo);
		} else {
			throw new Exception("Não foi possível determinar a resposta escolhida.");
		}
	}

	private void controleRespostaSim(Jogo jogo) {
		if (jogo.getNodoAtual().getNodoFilhoRespostaSim() == null) {
			// Era último nodo, mensagem de acerto
			ControllerGUI.mostraMensagem("Acertei de novo!");
			jogo.setEncerramento(true);
		} else {
			// Avançar para próximo nodo
			jogo.setNodoAnterior(jogo.getNodoAtual());
			jogo.setNodoAtual(jogo.getNodoAtual().getNodoFilhoRespostaSim());
		}
	}

	private void controleRespostaNao(Jogo jogo) {
		if (jogo.getNodoAtual().getNodoFilhoRespostaNao() == null) {
			// Era último nodo, indicar nova opção para ser inserida
			Nodo novoNodoPratoDigitado = getNovoNodoPrato();
			Nodo novoNodoCaracteristicaDigitada = getNovoNodoCaracteristica(novoNodoPratoDigitado, jogo.getNodoAtual());

			atualizaNodoAnterior(novoNodoCaracteristicaDigitada, jogo);
			jogo.setEncerramento(true);
		} else {
			// Avançar para próximo nodo
			jogo.setNodoAnterior(jogo.getNodoAtual());
			jogo.setNodoAtual(jogo.getNodoAtual().getNodoFilhoRespostaNao());
		}
	}

	private Nodo getNovoNodoPrato() {
		String novoPrato = ControllerGUI.montaTelaInput("Qual o prato que você pensou?");
		Nodo novoNodoPratoDigitado = new Nodo(novoPrato, null, null);
		return novoNodoPratoDigitado;
	}

	private Nodo getNovoNodoCaracteristica(Nodo novoNodoPratoDigitado, Nodo nodoAtual) {
		String novaCaracteristica = ControllerGUI.montaTelaInput(
				novoNodoPratoDigitado.getDescricao() + " é ______ mas " + nodoAtual.getDescricao() + " não.");
		Nodo novoNodoCaracteristicaDigitada = new Nodo(novaCaracteristica, novoNodoPratoDigitado, nodoAtual);
		return novoNodoCaracteristicaDigitada;
	}

	private void atualizaNodoAnterior(Nodo novoNodoCaracteristicaDigitada, Jogo jogo) {
		if (jogo.getNodoAnterior().getNodoFilhoRespostaSim().equals(jogo.getNodoAtual())) {
			jogo.getNodoAnterior().setNodoFilhoRespostaSim(novoNodoCaracteristicaDigitada);
		} else if (jogo.getNodoAnterior().getNodoFilhoRespostaNao().equals(jogo.getNodoAtual())) {
			jogo.getNodoAnterior().setNodoFilhoRespostaNao(novoNodoCaracteristicaDigitada);
		}
	}

}
