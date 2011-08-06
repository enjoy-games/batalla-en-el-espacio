package plantillas.menu;

import java.awt.Button;

import ejecutable.Ejecutable;

/**
 * 
 * Implementacion de una barra de menu para el applet.
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
public class Menu {
	/**
	 * 
	 * Variables
	 * 
	 */
	public static Button btnNuevo = new Button("Nuevo"), btnPausa = new Button(
			"Pausa");

	/**
	 * 
	 * Metodos
	 * 
	 */
	public static void agregar_menu(Ejecutable ejecutable) {
		int x = 5, y = 5, ancho = 70, alto = 23;

		btnNuevo.setLocation(x, y);
		btnNuevo.setSize(ancho, alto);
		x += ancho + y;
		btnPausa.setLocation(x, y);
		btnPausa.setSize(ancho, alto);
		x += ancho + y;

		ejecutable.setLayout(null);
		ejecutable.add(btnNuevo);
		ejecutable.add(btnPausa);
	}
}
