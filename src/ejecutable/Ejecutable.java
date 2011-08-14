package ejecutable;

import java.awt.Graphics;
import java.awt.event.KeyListener;

import plantillas.graficos.DoubleBuffering;
import plantillas.menu.Menu;

import juego.Juego;
import juego.controles_de_usuario.Teclado;
import juego.graficos.Graficos;
import juego.menu.BtnNuevo_click;
import juego.menu.BtnPausa_click;
import juego.tipos_de_datos.EstadoPartida;

/**
 * 
 * Clase Applet que se ejecuta en el navegador.
 * 
 * Copyright (C) 2011 Sergio Lindo
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>
 * 
 */
@SuppressWarnings("serial")
public final class Ejecutable extends DoubleBuffering {
	private Graficos motor_grafico;

	/**
	 * 
	 * Metodos
	 * 
	 */
	@Override
	public void init() {
		/*
		 * Se ejecuta al inicio de carga del applet.
		 */
		this.motor_grafico = new Graficos(this);
		Menu.agregar_menu(this);
		Juego.iniciar_elementos();
		this.cargar_eventos();
	}

	@Override
	public void paint(Graphics g) {
		/*
		 * Metodo de la clase applet que permite dibujar en el.
		 */
		this.motor_grafico.ejecutar(g);
	}

	@Override
	public void juego() {
		/*
		 * Bucle de juego.
		 */
		if (Juego.estado == EstadoPartida.jugando) {

			Juego.nave_jugador.movimiento();

			if (Juego.nave_jugador.disparo != null) {
				Juego.nave_jugador.disparo.movimiento();
			}

			for (int i = 0; i < Juego.bichos.length; i++) {
				if (Juego.bichos[i] != null) {
					if (Juego.bichos[i].destruido) {
						Juego.bichos[i].segundos_destruido++;

						if (Juego.bichos[i].segundos_destruido == 4) {
							Juego.bichos[i] = null;
						}
					} else {
						Juego.bichos[i].movimiento();
					}
				}
			}

			Juego.ia.ejecutar();
		}
	}

	private void cargar_eventos() {
		/*
		 * Aqui se agregan todos los eventos necesarios.
		 */
		KeyListener Teclado = new Teclado();

		// Controles de usuario.
		this.addKeyListener(Teclado); // Eventos de teclado.
		Menu.btnNuevo.addKeyListener(Teclado);
		Menu.btnPausa.addKeyListener(Teclado);

		// Acciones de menu.
		Menu.btnNuevo.addMouseListener(new BtnNuevo_click());
		Menu.btnPausa.addMouseListener(new BtnPausa_click());
	}
}
