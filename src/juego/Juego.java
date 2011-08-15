package juego;

import juego.elementos.Bicho;
import juego.elementos.Disparo;
import juego.elementos.InteligenciaArtificial;
import juego.elementos.NaveJugador;
import juego.tipos_de_datos.EstadoPartida;

/**
 * 
 * Implementa los elementos y reglas del juego.
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
public class Juego extends plantillas.PlantillaJuego {
	/**
	 * 
	 * Variables
	 * 
	 */
	public int numero_de_enemigos = 40;
	public NaveJugador nave_jugador;
	public Disparo disparo_jugador;
	public Bicho[] bichos = new Bicho[this.numero_de_enemigos];
	public Disparo[] disparo_bichos = new Disparo[this.numero_de_enemigos];
	public InteligenciaArtificial ia;

	/**
	 * 
	 * Constructor
	 * 
	 */
	public Juego() {
		/*
		 * Instancia los objetos y establece sus propiedades.
		 */
		super.estado = EstadoPartida.menu_principal;

		// Elementos de juego.

		this.nave_jugador = new NaveJugador(200 - 20, 400 - 40, 40, 40, 8, this);

		// Enemigos
		int x = 0, y = 33, ancho = 40, alto = 40;
		for (int i = 0; i < numero_de_enemigos; i++) {
			this.bichos[i] = new Bicho(i, x, y, ancho, alto, 8, 8, this);

			if (x < 400 - ancho) {
				x += ancho;
			} else {
				x = 0;
				y += alto;
			}
		}

		this.ia = new InteligenciaArtificial(this);
	}

	/**
	 * 
	 * Metodos
	 * 
	 */
	@Override
	public void ejecutar() {
		/*
		 * Bucle de juego.
		 */
		if (super.estado == EstadoPartida.jugando) {

			this.nave_jugador.movimiento();

			if (this.disparo_jugador != null) {
				this.disparo_jugador.movimiento();
			}

			for (int i = 0; i < this.bichos.length; i++) {
				if (this.bichos[i] != null) {
					if (this.bichos[i].destruido) {
						this.bichos[i].segundos_destruido++;

						if (this.bichos[i].segundos_destruido == 4) {
							this.bichos[i] = null;
						}
					} else {
						this.bichos[i].movimiento();
					}
				}
			}

			this.ia.ejecutar();
		}
	}

	/**
	 * 
	 * Limites del tablero de juego.
	 * 
	 */
	public static int limite_izquierdo() {
		return 0;
	}

	public static int limite_derecho() {
		return 400;
	}

	public static int limite_superior() {
		return 0;
	}

	public static int limite_inferior() {
		return 400;
	}
}
