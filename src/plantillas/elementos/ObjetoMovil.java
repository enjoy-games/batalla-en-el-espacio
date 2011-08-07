package plantillas.elementos;

import plantillas.tipos_de_datos.EstadoObjetoMovil;

/**
 * 
 * Implementacion de un objeto del juego que se mueve.
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
public abstract class ObjetoMovil extends ObjetoEstatico {
	/**
	 * 
	 * Variables
	 * 
	 */
	public PuntoMovil esquina_superior_izquierda;
	public EstadoObjetoMovil estado;

	/**
	 * 
	 * Metodos
	 * 
	 */
	protected final void mover() {
		/*
		 * Efectua el movimiento del objeto.
		 */
		int sentido_x = 0, sentido_y = 0;

		if (this.estado == EstadoObjetoMovil.left
				|| this.estado == EstadoObjetoMovil.upleft
				|| this.estado == EstadoObjetoMovil.downleft) {
			// Si se mueve hacia la izquierda...
			sentido_x = -1;
		} else if (this.estado == EstadoObjetoMovil.right
				|| this.estado == EstadoObjetoMovil.upright
				|| this.estado == EstadoObjetoMovil.downright) {
			// Si se mueve hacia la derecha...
			sentido_x = 1;
		} else {
			// Si no se mueve horizontalmente...
			sentido_x = 0;
		}

		if (this.estado == EstadoObjetoMovil.up
				|| this.estado == EstadoObjetoMovil.upleft
				|| this.estado == EstadoObjetoMovil.upright) {
			// Si se mueve hacia arriba...
			sentido_y = -1;
		} else if (this.estado == EstadoObjetoMovil.down
				|| this.estado == EstadoObjetoMovil.downleft
				|| this.estado == EstadoObjetoMovil.downright) {
			// Si se mueve hacia abajo...
			sentido_y = 1;
		} else {
			// Si no se mueve verticalmente...
			sentido_y = 0;
		}

		if (this.estado == EstadoObjetoMovil.parado) {
			// Si no se mueve...
			sentido_x = 0;
			sentido_y = 0;
		}

		// Cambio la posicion del objeto segun su velocidad.
		this.esquina_superior_izquierda.x_pos += this.esquina_superior_izquierda.velocidad_x
				* sentido_x;
		this.esquina_superior_izquierda.y_pos += this.esquina_superior_izquierda.velocidad_y
				* sentido_y;
	}
}
