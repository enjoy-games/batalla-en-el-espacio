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
		Graficos.cargar_imagenes(this);
		Menu.agregar_menu(this);
		Juego.iniciar_elementos();
		this.cargar_eventos();
	}

	@Override
	public void paint(Graphics g) {
		/*
		 * Metodo de la clase applet que permite dibujar en el.
		 */
		Graficos.mostrar_fondo(g);

		if (Juego.estado == EstadoPartida.menu_principal) {
			Graficos.mostrar_menu_principal(g);
		} else if (Juego.estado == EstadoPartida.jugando) {
			Graficos.mostrar_juego(g, this);
		} else if (Juego.estado == EstadoPartida.pausa) {
			Graficos.mostrar_pausa(g);
		} else if (Juego.estado == EstadoPartida.clasificacion) {
			Graficos.mostrar_clasificacion(g);
		}
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

			for (int i = 0; i < Juego.bichos.length - 1; i++) {
				if (Juego.bichos[i] != null) {
					if (Juego.bichos[i].bicho_destruido) {
						Juego.bichos[i] = null;
					} else {
						Juego.bichos[i].movimiento();
					}
				}
			}
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
