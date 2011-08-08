package juego.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import juego.Juego;
import plantillas.elementos.ObjetoMovil;
import plantillas.elementos.PuntoMovil;
import plantillas.tipos_de_datos.EstadoObjetoMovil;

/**
 * 
 * Implementacion de la nave del jugador.
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
public final class NaveJugador extends ObjetoMovil {
	/**
	 * 
	 * Variables
	 * 
	 */
	public Image imagen;
	public Disparo disparo;

	/**
	 * 
	 * Constructor
	 * 
	 */
	public NaveJugador(int x_pos, int y_pos, int ancho, int alto,
			int velocidad_x, Image imagen) {
		super.esquina_superior_izquierda = new PuntoMovil();
		super.esquina_superior_izquierda.x_pos = x_pos;
		super.esquina_superior_izquierda.y_pos = y_pos;
		super.esquina_superior_izquierda.velocidad_x = velocidad_x;
		// velocidad_y = 0
		super.ancho = ancho;
		super.alto = alto;
		this.imagen = imagen;
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
		g.drawImage(this.imagen, super.esquina_superior_izquierda.x_pos,
				super.esquina_superior_izquierda.y_pos, ejecutable);
	}

	public void movimiento() {
		/*
		 * Mueve el elemento comprobando las colisiones.
		 */
		// Guardo la velocidad real.
		int aux_velocidad_x = super.esquina_superior_izquierda.velocidad_x;
		int aux_velocidad_y = super.esquina_superior_izquierda.velocidad_y;
		int left = super.esquina_superior_izquierda.x_pos;
		int next_left = super.esquina_superior_izquierda.x_pos
				- super.esquina_superior_izquierda.velocidad_x;
		int right = super.esquina_superior_izquierda.x_pos + super.ancho;
		int next_right = super.esquina_superior_izquierda.x_pos + super.ancho
				+ super.esquina_superior_izquierda.velocidad_x;
		int next_velocidad_x = left - Juego.limite_izquierdo();
		int next_velocidad_y = Juego.limite_derecho() - right;

		if (super.estado == EstadoObjetoMovil.left) {
			// Si se mueve hacia la izquierda...

			if (next_left < Juego.limite_izquierdo()) {
				// Si colisiona con el limite izquierdo...

				// Frena.
				super.esquina_superior_izquierda.velocidad_x = next_velocidad_x;
			}
		} else if (super.estado == EstadoObjetoMovil.right) {
			// Si se mueve hacia la derecha...

			if (next_right > Juego.limite_derecho()) {
				// Si colisiona con el limite derecho...

				// Frena.
				super.esquina_superior_izquierda.velocidad_x = next_velocidad_y;
			}
		}

		// Se mueve a la velocidad indicada.
		super.mover();

		// Se restaura la velocidad real.
		super.esquina_superior_izquierda.velocidad_x = aux_velocidad_x;
		super.esquina_superior_izquierda.velocidad_y = aux_velocidad_y;
	}

	public void disparar() {
		if (this.disparo != null
				&& this.disparo.esquina_superior_izquierda.y_pos <= 0) {
			this.disparo = null;
		}

		if (this.disparo == null) {
			this.disparo = new Disparo(this.esquina_superior_izquierda.x_pos
					+ this.ancho / 2,
					this.esquina_superior_izquierda.y_pos - 10 - 1, 3, 10, 10,
					Color.white, EstadoObjetoMovil.up);
		}
	}

	public void destruir() {
		// TODO
	}

	@Deprecated
	@Override
	public void dibujar(Graphics g) {
	}
}
