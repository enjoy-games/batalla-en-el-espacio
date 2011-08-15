package juego.elementos;

import juego.Juego;

/**
 * 
 * Implementacion de la inteligencia artificial para los enemigos.
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
public final class InteligenciaArtificial {
	/**
	 * 
	 * Variables
	 * 
	 */
	private Juego puntero_juego;

	public InteligenciaArtificial(Juego juego) {
		this.puntero_juego = juego;
	}

	/**
	 * 
	 * Metodos
	 * 
	 */
	public void ejecutar() {
		this.disparar();
	}

	private void disparar() {
		for (int i = this.puntero_juego.bichos.length - 1; i >= 0; i--) {
			if (this.puntero_juego.bichos[i] != null
					&& this.puntero_juego.bichos[i].destruido == false) {
				if ((i > (this.puntero_juego.bichos.length - 1) - 10)
						|| ((i <= (this.puntero_juego.bichos.length - 1) - 10) && (this.puntero_juego.bichos[i + 10] == null))) {

					if (this.puntero_juego.nave_jugador.esquina_superior_izquierda.x_pos > (this.puntero_juego.bichos[i].esquina_superior_izquierda.x_pos - this.puntero_juego.bichos[i].ancho / 2)
							&& this.puntero_juego.nave_jugador.esquina_superior_izquierda.x_pos < (this.puntero_juego.bichos[i].esquina_superior_izquierda.x_pos + this.puntero_juego.bichos[i].ancho / 2)) {
						this.puntero_juego.bichos[i].disparar();
					}

				}
			}
		}
	}
}
