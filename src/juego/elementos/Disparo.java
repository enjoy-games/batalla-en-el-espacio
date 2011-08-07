package juego.elementos;

import java.awt.Color;
import java.awt.Graphics;

import plantillas.elementos.ObjetoMovil;
import plantillas.elementos.PuntoMovil;
import plantillas.tipos_de_datos.EstadoObjetoMovil;

/**
 * 
 * Implementacion de disparo.
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
public final class Disparo extends ObjetoMovil {
	Disparo(int x_pos, int y_pos, int ancho, int alto, int velocidad_y,
			Color color, EstadoObjetoMovil estado) {
		super.esquina_superior_izquierda = new PuntoMovil();
		super.esquina_superior_izquierda.x_pos = x_pos;
		super.esquina_superior_izquierda.y_pos = y_pos;
		// velocidad_x = 0
		super.esquina_superior_izquierda.velocidad_y = velocidad_y;
		super.ancho = ancho;
		super.alto = alto;
		super.color = color;
		super.estado = estado;
	}

	public void movimiento() {
		int sentido = 0;

		if (super.estado == EstadoObjetoMovil.up
				&& this.esquina_superior_izquierda.y_pos > 0) {
			sentido = -1;
		} else if (super.estado == EstadoObjetoMovil.down
				&& this.esquina_superior_izquierda.y_pos < 400) {
			sentido = 1;
		}

		this.esquina_superior_izquierda.y_pos += this.esquina_superior_izquierda.velocidad_y
				* sentido;
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(super.color);
		g.fillRect(super.esquina_superior_izquierda.x_pos,
				super.esquina_superior_izquierda.y_pos, super.ancho, super.alto);
	}
}
