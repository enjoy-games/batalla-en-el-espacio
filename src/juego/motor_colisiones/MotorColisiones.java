package juego.motor_colisiones;

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

	public static boolean figura_con_figura(int Ax, int Ay, int Aancho,
			int Aalto, int Bx, int By, int Bancho, int Balto) {
		/*
		 * Comprueba si dos elementos estan colisionando.
		 */
		boolean colision = false,

		o1_verticeA = false, o1_verticeB = false, o1_verticeC = false, o1_verticeD = false,

		o2_verticeA = false, o2_verticeB = false, o2_verticeC = false, o2_verticeD = false;

		// Busco si algun vertice está colisionando.
		o1_verticeA = MotorColisiones.punto_figura(Ax, Ay, Bx, By, Bancho,
				Balto);
		o1_verticeB = MotorColisiones.punto_figura(Ax + Aancho, Ay, Bx, By,
				Bancho, Balto);
		o1_verticeC = MotorColisiones.punto_figura(Ax + Aancho, Ay + Aalto, Bx,
				By, Bancho, Balto);
		o1_verticeD = MotorColisiones.punto_figura(Ax, Ay + Aalto, Bx, By,
				Bancho, Balto);

		o2_verticeA = MotorColisiones.punto_figura(Bx, By, Ax, Ay, Aancho,
				Aalto);
		o2_verticeB = MotorColisiones.punto_figura(Bx + Bancho, By, Ax, Ay,
				Aancho, Aalto);
		o2_verticeC = MotorColisiones.punto_figura(Bx + Bancho, By + Balto, Ax,
				Ay, Aancho, Aalto);
		o2_verticeD = MotorColisiones.punto_figura(Bx, By + Balto, Ax, Ay,
				Aancho, Aalto);

		if (o1_verticeA == true || o1_verticeB == true || o1_verticeC == true
				|| o1_verticeD == true || o2_verticeA == true
				|| o2_verticeB == true || o2_verticeC == true
				|| o2_verticeD == true) {
			// Si hay colision de los vertices de las figuras...
			colision = true;
		}

		return colision;
	}

	private static boolean punto_figura(int Ax, int Ay, int Bx, int By,
			int Bancho, int Balto) {
		/*
		 * Devuelve LadoColision si el punto esta colisionando con la figura.
		 */
		boolean colision = false;

		// Para evitar tangencias agrego un "borde" de 1 pixel a la figura.
		if (Ax >= Bx - 1) {
			// Si el punto esta a la derecha del vertice A...
			if (Ax <= Bx + By + 1) {
				// Si el punto esta a la izquierda del vertice B...
				if (Ay >= By - 1) {
					// Si el punto esta debajo del vertice A...
					if (Ay <= By + Balto + 1) {
						// Si el punto esta encima del vertice D...
						colision = true;
					}
				}
			}
		}

		return colision;
	}
}
