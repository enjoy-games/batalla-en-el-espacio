package juego.menu;

import java.awt.Button;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import juego.Juego;
import juego.tipos_de_datos.EstadoPartida;

/**
 * 
 * Acciones del boton btnPausa del menu.
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
public final class BtnPausa_click implements MouseListener {
	/**
	 * 
	 * Variables
	 * 
	 */
	private Juego puntero_juego;

	/**
	 * 
	 * Constructor
	 * 
	 */
	public BtnPausa_click(Juego juego) {
		this.puntero_juego = juego;
	}

	/**
	 * 
	 * Metodos
	 * 
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		/*
		 * Evento click
		 */
		if (this.puntero_juego.estado == EstadoPartida.jugando) {
			this.puntero_juego.pausa(true);
			((Button) e.getSource()).setLabel("Reanudar");
		} else if (this.puntero_juego.estado == EstadoPartida.pausa) {
			this.puntero_juego.pausa(false);
			((Button) e.getSource()).setLabel("Pausa");
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		/*
		 * El raton entra en la zona del boton.
		 */
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		/*
		 * El raton sale de la zona del boton.
		 */
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		/*
		 * Se pulsa un boton del raton sobre el boton.
		 */
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		/*
		 * Se suelta un boton del raton sobre el boton.
		 */
		// TODO Auto-generated method stub

	}
}
