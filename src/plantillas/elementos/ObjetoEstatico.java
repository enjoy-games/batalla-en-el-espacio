package plantillas.elementos;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * Implementacion de un objeto del juego que no se mueve.
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
public abstract class ObjetoEstatico {
	/**
	 * 
	 * Variables
	 * 
	 */
	public PuntoEstatico esquina_superior_izquierda;
	public int ancho, alto;
	public Color color;

	/**
	 * 
	 * Metodos
	 * 
	 */
	public abstract void dibujar(Graphics g);
}
