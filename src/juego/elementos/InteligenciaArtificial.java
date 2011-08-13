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
	 * Metodos
	 * 
	 */
	public void ejecutar() {
		this.disparar();
	}

	private void disparar() {
		for (int i = Juego.bichos.length - 1; i >= 0; i--) {
			if (Juego.bichos[i] != null && Juego.bichos[i].destruido == false) {
				if ((i > (Juego.bichos.length - 1) - 10)
						|| ((i <= (Juego.bichos.length - 1) - 10) && (Juego.bichos[i + 10] == null))) {

					if (Juego.nave_jugador.esquina_superior_izquierda.x_pos > (Juego.bichos[i].esquina_superior_izquierda.x_pos - Juego.bichos[i].ancho / 2)
							&& Juego.nave_jugador.esquina_superior_izquierda.x_pos < (Juego.bichos[i].esquina_superior_izquierda.x_pos + Juego.bichos[i].ancho / 2)) {
						Juego.bichos[i].disparar();
					}

				}
			}
		}
	}
}
