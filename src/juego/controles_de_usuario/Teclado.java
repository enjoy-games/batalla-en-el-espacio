package juego.controles_de_usuario;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import plantillas.menu.Menu;
import plantillas.tipos_de_datos.EstadoObjetoMovil;

import juego.Juego;
import juego.tipos_de_datos.EstadoPartida;

/**
 * 
 * Controles del jugador con el teclado.
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
public final class Teclado implements KeyListener {
	/**
	 * 
	 * Metodos
	 * 
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		/*
		 * Evento de teclado al presionar una tecla.
		 */
		// Solo se permite el control si esta en la partida y no esta en pausa.
		if (Juego.estado == EstadoPartida.jugando) {
			// Si pulsa la tecla de flecha izquierda...
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				Juego.nave_jugador.estado = EstadoObjetoMovil.left;
				// Si pulsa la tecla de flecha derecha...
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				Juego.nave_jugador.estado = EstadoObjetoMovil.right;
			} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				// Si pulsa la tecla espacio...
				Juego.nave_jugador.disparar();
			} else { // Si ha pulsado otra tecla...
				Juego.nave_jugador.estado = EstadoObjetoMovil.parado;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		/*
		 * Evento de teclado al soltar una tecla.
		 */
		// Si la partida esta en curso...
		if (Juego.estado == EstadoPartida.jugando) {
			Juego.nave_jugador.estado = EstadoObjetoMovil.parado;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		/*
		 * Evento de teclado cuando el buffer de teclado ya se ha leido. Se
		 * ejecuta despues de KeyReleased.
		 */
		// TODO Auto-generated method stub

	}
}
