package juego.elementos;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import juego.Juego;
import juego.motor_colisiones.MotorColisiones;
import plantillas.elementos.ObjetoMovil;
import plantillas.elementos.PuntoMovil;

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

	/**
	 * 
	 * Constructor
	 * 
	 */
	public Bicho(int x_pos, int y_pos, int ancho, int alto, int velocidad_x,
			int velocidad_y, Image[] imagen) {
		super.esquina_superior_izquierda = new PuntoMovil();
		super.esquina_superior_izquierda.x_pos = x_pos;
		super.esquina_superior_izquierda.y_pos = y_pos;
		super.esquina_superior_izquierda.velocidad_x = velocidad_x;
		super.esquina_superior_izquierda.velocidad_y = velocidad_y;
		super.ancho = ancho;
		super.alto = alto;
		this.imagen = imagen;
		this.imagen_actual = 0;
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
		g.drawImage(this.imagen[this.imagen_actual],
				super.esquina_superior_izquierda.x_pos,
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
		if (MotorColisiones.figura_con_figura(this, Juego.nave_jugador)) {
			this.destruir();
		} else {
			super.mover();
		}
	}

	public void disparar() {
		// TODO
	}

	public void destruir() {
		// TODO - Destruccion al colisionar con nave jugador o con proyectil.
	}

	@Deprecated
	@Override
	public void dibujar(Graphics g) {
	}
}
