package juego.motor_colisiones;

import plantillas.elementos.ObjetoEstatico;

/**
 * 
 * Implementacion de un motor de colisiones.
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
public final class MotorColisiones {

	public static boolean figura_con_figura(ObjetoEstatico o1, ObjetoEstatico o2) {
		/*
		 * Comprueba si dos elementos estan colisionando.
		 */
		boolean colision = false,

		o1_verticeA, o1_verticeB, o1_verticeC, o1_verticeD,

		o2_verticeA, o2_verticeB, o2_verticeC, o2_verticeD;

		// Busco si algun vertice está colisionando.
		o1_verticeA = MotorColisiones.punto_figura(
				o1.esquina_superior_izquierda.x_pos,
				o1.esquina_superior_izquierda.y_pos, o2);
		o1_verticeB = MotorColisiones.punto_figura(
				o1.esquina_superior_izquierda.x_pos + o1.ancho,
				o1.esquina_superior_izquierda.y_pos, o2);
		o1_verticeC = MotorColisiones.punto_figura(
				o1.esquina_superior_izquierda.x_pos + o1.ancho,
				o1.esquina_superior_izquierda.y_pos + o1.alto, o2);
		o1_verticeD = MotorColisiones.punto_figura(
				o1.esquina_superior_izquierda.x_pos,
				o1.esquina_superior_izquierda.y_pos + o1.alto, o2);

		o2_verticeA = MotorColisiones.punto_figura(
				o2.esquina_superior_izquierda.x_pos,
				o2.esquina_superior_izquierda.y_pos, o1);
		o2_verticeB = MotorColisiones.punto_figura(
				o2.esquina_superior_izquierda.x_pos + o2.ancho,
				o2.esquina_superior_izquierda.y_pos, o1);
		o2_verticeC = MotorColisiones.punto_figura(
				o2.esquina_superior_izquierda.x_pos + o2.ancho,
				o2.esquina_superior_izquierda.y_pos + o2.alto, o1);
		o2_verticeD = MotorColisiones.punto_figura(
				o2.esquina_superior_izquierda.x_pos,
				o2.esquina_superior_izquierda.y_pos + o2.alto, o1);

		if (o1_verticeA == true || o1_verticeB == true || o1_verticeC == true
				|| o1_verticeD == true || o2_verticeA == true
				|| o2_verticeB == true || o2_verticeC == true
				|| o2_verticeD == true) { // Si hay colision de los vertices de
											// las figuras...
			colision = true;
		}

		return colision;
	}

	private static boolean punto_figura(int x, int y, ObjetoEstatico figura) {
		/*
		 * Devuelve LadoColision si el punto esta colisionando con la figura.
		 */
		boolean colision = false;

		// Para evitar tangencias agrego un "borde" de 1 pixel a la figura.
		if (x >= figura.esquina_superior_izquierda.x_pos - 1) { // Si el punto
																// esta a la
																// derecha del
																// vertice A...
			if (x <= figura.esquina_superior_izquierda.x_pos
					+ figura.esquina_superior_izquierda.y_pos + 1) { // Si el
																		// punto
																		// esta
																		// a la
																		// izquierda
																		// del
																		// vertice
																		// B...
				if (y >= figura.esquina_superior_izquierda.y_pos - 1) { // Si el
																		// punto
																		// esta
																		// debajo
																		// del
																		// vertice
																		// A...
					if (y <= figura.esquina_superior_izquierda.y_pos
							+ figura.alto + 1) { // Si el punto esta encima del
													// vertice D...
						colision = true;
					}
				}
			}
		}

		return colision;
	}
}
