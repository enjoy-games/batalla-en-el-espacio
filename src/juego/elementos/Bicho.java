package juego.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import juego.Juego;
import juego.motor_colisiones.MotorColisiones;
import plantillas.elementos.ObjetoMovil;
import plantillas.elementos.PuntoMovil;
import plantillas.tipos_de_datos.EstadoObjetoMovil;

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
	public Image[] imagen;
	public int imagen_actual;
	public Image imagen_destruido;
	public boolean destruido;
	public Disparo disparo;
	public int segundos_destruido;

	/**
	 * 
	 * Constructor
	 * 
	 */
	public Bicho(int x_pos, int y_pos, int ancho, int alto, int velocidad_x,
			int velocidad_y, Image[] imagen, Image imagen_destruido) {
		super.esquina_superior_izquierda = new PuntoMovil();
		super.esquina_superior_izquierda.x_pos = x_pos;
		super.esquina_superior_izquierda.y_pos = y_pos;
		super.esquina_superior_izquierda.velocidad_x = velocidad_x;
		super.esquina_superior_izquierda.velocidad_y = velocidad_y;
		super.ancho = ancho;
		super.alto = alto;
		this.imagen = imagen;
		this.imagen_actual = 0;
		this.imagen_destruido = imagen_destruido;
		this.destruido = false;
	}

	/**
	 * 
	 * Metodos
	 * 
	 */
	public void dibujar(Graphics g, ImageObserver ejecutable) {
		/*
		 * Dibuja el elemento segun sus propiedades.
		 */
		Image imagen;

		if (this.destruido) {
			imagen = this.imagen_destruido;
		} else {
			imagen = this.imagen[this.imagen_actual];
		}

		g.drawImage(imagen, super.esquina_superior_izquierda.x_pos,
				super.esquina_superior_izquierda.y_pos, ejecutable);

		if (this.imagen_actual < this.imagen.length - 1) {
			this.imagen_actual += 1;
		} else {
			this.imagen_actual = 0;
		}
	}

	public void movimiento() {
		/*
		 * Efectua el movimiento del elemento.
		 */
		if (MotorColisiones.figura_con_figura(
				this.esquina_superior_izquierda.x_pos,
				this.esquina_superior_izquierda.y_pos, this.ancho, this.alto,
				Juego.nave_jugador.esquina_superior_izquierda.x_pos,
				Juego.nave_jugador.esquina_superior_izquierda.y_pos,
				Juego.nave_jugador.ancho, Juego.nave_jugador.alto)) {
			this.destruir();
		} else {
			super.mover();
		}
	}

	public void disparar() {
		if (this.disparo != null
				&& this.disparo.esquina_superior_izquierda.y_pos <= 0) {
			this.disparo = null;
		}

		if (this.disparo == null) {
			this.disparo = new Disparo(this.esquina_superior_izquierda.x_pos
					+ this.ancho / 2,
					this.esquina_superior_izquierda.y_pos + 10 + 1, 3, 10, 10,
					Color.white, EstadoObjetoMovil.down);
		}
	}

	public void destruir() {
		this.destruido = true;
	}

	@Deprecated
	@Override
	public void dibujar(Graphics g) {
	}
}
