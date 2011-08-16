package juego.elementos;

import plantillas.elementos.ObjetoEstatico;
import plantillas.elementos.PuntoEstatico;

/**
 * 
 * Implementacion de un contador de vida para el juego.
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
public final class ContadorVida extends ObjetoEstatico {
	/**
	 * 
	 * Variables
	 * 
	 */
	public int contador_vida;

	/**
	 * 
	 * Constructor
	 * 
	 */
	public ContadorVida(int x_pos, int y_pos, int ancho, int alto) {
		super.esquina_superior_izquierda = new PuntoEstatico();
		super.esquina_superior_izquierda.x_pos = x_pos;
		super.esquina_superior_izquierda.y_pos = y_pos;
		super.ancho = ancho;
		super.alto = alto;
		this.contador_vida = 3;
	}
}
