package plantillas.graficos;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

import plantillas.PlantillaJuego;

import juego.tipos_de_datos.EstadoPartida;

/**
 * 
 * Plantilla para facilitar las tareas basicas de un motor grafico.
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
public abstract class PlantillaMotorGrafico {
	/**
	 * 
	 * Variables
	 * 
	 */
	protected Applet ejecutable;
	protected final String directorio_img = "juego/img/";
	protected PlantillaJuego puntero_juego;

	/**
	 * 
	 * Metodos
	 * 
	 */
	protected abstract void cargar_imagenes();

	protected Image abrir_fichero_imagen(String nombre) {
		return this.ejecutable.getImage(this.ejecutable.getCodeBase(),
				this.directorio_img + nombre);
	}

	public void ejecutar(Graphics g) {
		if (this.puntero_juego.estado == EstadoPartida.menu_principal) {
			this.mostrar_menu_principal(g);
		} else if (this.puntero_juego.estado == EstadoPartida.jugando) {
			this.mostrar_juego(g);
		} else if (this.puntero_juego.estado == EstadoPartida.pausa) {
			this.mostrar_pausa(g);
		} else if (this.puntero_juego.estado == EstadoPartida.clasificacion) {
			this.mostrar_clasificacion(g);
		}
	}

	protected abstract void mostrar_menu_principal(Graphics g);

	protected abstract void mostrar_juego(Graphics g);

	protected abstract void mostrar_pausa(Graphics g);

	protected abstract void mostrar_clasificacion(Graphics g);
}
