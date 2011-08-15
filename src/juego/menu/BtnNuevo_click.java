package juego.menu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import juego.Juego;

/**
 * 
 * Acciones del boton btnNuevo del menu.
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
public class BtnNuevo_click implements MouseListener {
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
	public BtnNuevo_click(Juego juego) {
		this.puntero_juego = juego;
	}

	/**
	 * 
	 * Metodos
	 * 
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		/*
		 * Evento click.
		 */
		this.puntero_juego.comenzar_partida();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		/*
		 * Cuando el raton entra en la zona del boton.
		 */
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		/*
		 * Cuando el raton sale de la zona del boton.
		 */
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		/*
		 * Cuando se pulsa un boton del raton sobre el boton.
		 */
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		/*
		 * Cuando se suelta un boton del raton sobre el boton.
		 */
		// TODO Auto-generated method stub

	}
}
