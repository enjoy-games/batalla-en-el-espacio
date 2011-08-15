package juego.elementos;

import plantillas.colisiones.MotorColisiones;
import plantillas.elementos.ObjetoMovil;
import plantillas.elementos.PuntoMovil;
import plantillas.tipos_de_datos.EstadoObjetoMovil;

import juego.Juego;

/**
 * 
 * Implementacion de un enemigo del juego.
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
public final class Bicho extends ObjetoMovil {
	/**
	 * 
	 * Variables
	 * 
	 */
	public int indice_bicho;
	public int imagen_actual;
	public boolean destruido;
	public int segundos_destruido;
	private Juego puntero_juego;

	/**
	 * 
	 * Constructor
	 * 
	 */
	public Bicho(int indice, int x_pos, int y_pos, int ancho, int alto,
			int velocidad_x, int velocidad_y, Juego juego) {
		this.indice_bicho = indice;
		super.esquina_superior_izquierda = new PuntoMovil();
		super.esquina_superior_izquierda.x_pos = x_pos;
		super.esquina_superior_izquierda.y_pos = y_pos;
		super.esquina_superior_izquierda.velocidad_x = velocidad_x;
		super.esquina_superior_izquierda.velocidad_y = velocidad_y;
		super.ancho = ancho;
		super.alto = alto;
		this.imagen_actual = 0;
		this.destruido = false;
		this.puntero_juego = juego;
	}

	/**
	 * 
	 * Metodos
	 * 
	 */
	public void movimiento() {
		/*
		 * Efectua el movimiento del elemento.
		 */
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
			this.destruir();
		} else {
			super.mover();
		}
	}

	public void disparar() {
		if (this.puntero_juego.disparo_bichos[this.indice_bicho] != null
				&& this.puntero_juego.disparo_bichos[this.indice_bicho].esquina_superior_izquierda.y_pos <= 0) {
			this.puntero_juego.disparo_bichos[this.indice_bicho] = null;
		}

		if (this.puntero_juego.disparo_bichos[this.indice_bicho] == null) {
			this.puntero_juego.disparo_bichos[this.indice_bicho] = new Disparo(
					this.esquina_superior_izquierda.x_pos + this.ancho / 2,
					this.esquina_superior_izquierda.y_pos + 10 + 1, 3, 10, 10,
					EstadoObjetoMovil.down, this.puntero_juego);
		}
	}

	public void destruir() {
		this.destruido = true;
	}
}
