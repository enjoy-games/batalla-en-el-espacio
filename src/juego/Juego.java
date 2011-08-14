package juego;

import juego.elementos.Bicho;
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
public class Juego {
	/**
	 * 
	 * Variables
	 * 
	 */
	public static EstadoPartida estado;
	public static NaveJugador nave_jugador;
	public static int numero_de_enemigos = 40;
	public static Bicho[] bichos = new Bicho[Juego.numero_de_enemigos];
	public static InteligenciaArtificial ia;

	// TODO

	/**
	 * 
	 * Metodos
	 * 
	 */
	public static void iniciar_elementos() {
		/*
		 * Instancia los objetos y establece sus propiedades.
		 */
		Juego.estado = EstadoPartida.menu_principal;

		// Elementos de juego.

		Juego.nave_jugador = new NaveJugador(200 - 20, 400 - 40, 40, 40, 8);

		// Enemigos
		int x = 0, y = 33, ancho = 40, alto = 40;
		for (int i = 0; i < numero_de_enemigos; i++) {
			Juego.bichos[i] = new Bicho(x, y, ancho, alto, 8, 8);

			if (x < 400 - ancho) {
				x += ancho;
			} else {
				x = 0;
				y += alto;
			}
		}

		Juego.ia = new InteligenciaArtificial();
		// TODO
	}

	public void ejecutar() {
		/*
		 * Bucle de juego.
		 */
		if (Juego.estado == EstadoPartida.jugando) {

			Juego.nave_jugador.movimiento();

			if (Juego.nave_jugador.disparo != null) {
				Juego.nave_jugador.disparo.movimiento();
			}

			for (int i = 0; i < Juego.bichos.length; i++) {
				if (Juego.bichos[i] != null) {
					if (Juego.bichos[i].destruido) {
						Juego.bichos[i].segundos_destruido++;

						if (Juego.bichos[i].segundos_destruido == 4) {
							Juego.bichos[i] = null;
						}
					} else {
						Juego.bichos[i].movimiento();
					}
				}
			}

			Juego.ia.ejecutar();
		}
	}

	public static void comenzar_partida() {
		/*
		 * Establece los datos necesarios para comenzar una partida.
		 */
		if (Juego.estado == EstadoPartida.menu_principal) {
			Juego.estado = EstadoPartida.jugando;
		}
	}

	public static void pausa(boolean pausar) {
		/*
		 * Pausa la partida o la reanuda.
		 */
		if (Juego.estado == EstadoPartida.jugando
				|| Juego.estado == EstadoPartida.pausa) {
			if (pausar) {
				Juego.estado = EstadoPartida.pausa;
			} else {
				Juego.estado = EstadoPartida.jugando;
			}
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
