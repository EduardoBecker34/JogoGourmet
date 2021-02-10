package br.com.gourmet;

import br.com.gourmet.controller.ControladorJogo;

public class Application {
	public static void main(String[] args) throws Exception {
		ControladorJogo controlador = new ControladorJogo();
		controlador.preparaInicioJogo();
	}
}