package plantillas;

import juego.tipos_de_datos.EstadoPartida;

/**
 * 
 * Plantilla para facilitar las tareas basicas de un juego.
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
public abstract class PlantillaJuego {
	/**
	 * 
	 * Variables
	 * 
	 */
	public EstadoPartida estado;

	/**
	 * 
	 * Metodos
	 * 
	 */
	public abstract void ejecutar();

	public abstract void comenzar_partida();

	public final void pausa(boolean pausar) {
		/*
		 * Pausa la partida o la reanuda.
		 */
		if (this.estado == EstadoPartida.jugando
				|| this.estado == EstadoPartida.pausa) {
			if (pausar) {
				this.estado = EstadoPartida.pausa;
			} else {
				this.estado = EstadoPartida.jugando;
			}
		}
	}
}
