package juego.elementos;

import juego.Juego;

import plantillas.colisiones.MotorColisiones;
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
	Disparo(int x_pos, int y_pos, int ancho, int alto, int velocidad_y,
			EstadoObjetoMovil estado, Juego juego) {
		super.esquina_superior_izquierda = new PuntoMovil();
		super.esquina_superior_izquierda.x_pos = x_pos;
		super.esquina_superior_izquierda.y_pos = y_pos;
		// velocidad_x = 0
		super.esquina_superior_izquierda.velocidad_y = velocidad_y;
		super.ancho = ancho;
		super.alto = alto;
		super.estado = estado;
		this.puntero_juego = juego;
	}

	/**
	 * 
	 * Metodos
	 * 
	 */
	public void movimiento() {
		/*
		 * Movimiento del disparo comprobando colisiones con nave_jugador y
		 * bichos.
		 */
		int sentido = 0;

		if (super.estado == EstadoObjetoMovil.up
				&& this.esquina_superior_izquierda.y_pos > 0) {
			sentido = -1;
		} else if (super.estado == EstadoObjetoMovil.down
				&& this.esquina_superior_izquierda.y_pos < 400) {
			sentido = 1;
		}

		if (this.colision_nave_jugador()) {
			this.puntero_juego.nave_jugador.destruir();
			this.esquina_superior_izquierda.x_pos = -1 - this.alto;
		}

		int i;
		if ((i = this.colision_bicho()) > -1) {
			this.puntero_juego.bichos[i].destruir();
			this.esquina_superior_izquierda.x_pos = -1 - this.alto;
		}

		this.esquina_superior_izquierda.y_pos += this.esquina_superior_izquierda.velocidad_y
				* sentido;
	}

	private boolean colision_nave_jugador() {
		/*
		 * Comprueba si colisiona con la nave del jugador.
		 */
		boolean colision = false;

		if (MotorColisiones
				.figura_con_figura(
						this.esquina_superior_izquierda.x_pos,
						this.esquina_superior_izquierda.y_pos,
						this.ancho,
						this.alto,
						this.puntero_juego.nave_jugador.esquina_superior_izquierda.x_pos,
						this.puntero_juego.nave_jugador.esquina_superior_izquierda.y_pos,
						this.puntero_juego.nave_jugador.ancho,
						this.puntero_juego.nave_jugador.alto)) {
			colision = true;
		}

		return colision;
	}

	private int colision_bicho() {
		/*
		 * Comprueba si colisiona con un bicho y devuelve su indice.
		 */
		int colision = -1;

		for (int i = 0; i < this.puntero_juego.bichos.length; i++) {
			if (this.puntero_juego.bichos[i] != null
					&& MotorColisiones
							.figura_con_figura(
									this.esquina_superior_izquierda.x_pos,
									this.esquina_superior_izquierda.y_pos,
									this.ancho,
									this.alto,
									this.puntero_juego.bichos[i].esquina_superior_izquierda.x_pos,
									this.puntero_juego.bichos[i].esquina_superior_izquierda.y_pos,
									this.puntero_juego.bichos[i].ancho,
									this.puntero_juego.bichos[i].alto)) {
				colision = i;
			}
		}

		return colision;
	}
}
