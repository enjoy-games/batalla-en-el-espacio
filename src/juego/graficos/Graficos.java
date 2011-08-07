package juego.graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import juego.Juego;

import ejecutable.Ejecutable;

/**
 * 
 * Implementacion del motor grafico del juego.
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
public class Graficos {
	/**
	 * 
	 * Variables
	 * 
	 */
	private static final String directorio_img = "juego/img/";
	public static Image nave_jugador;
	public static Image[] bicho1 = new Image[2], bicho2 = new Image[2];

	/**
	 * 
	 * Metodos
	 * 
	 */
	public static void cargar_imagenes(Ejecutable ejecutable) {
		/*
		 * Cargan en memoria las imagenes necesarias.
		 */
		Graficos.nave_jugador = ejecutable.getImage(ejecutable.getCodeBase(),
				Graficos.directorio_img + "nave_jugador.gif");
		Graficos.bicho1[0] = ejecutable.getImage(ejecutable.getCodeBase(),
				Graficos.directorio_img + "bicho1a.gif");
		Graficos.bicho1[1] = ejecutable.getImage(ejecutable.getCodeBase(),
				Graficos.directorio_img + "bicho1b.gif");
		Graficos.bicho2[0] = ejecutable.getImage(ejecutable.getCodeBase(),
				Graficos.directorio_img + "bicho2a.gif");
		Graficos.bicho2[1] = ejecutable.getImage(ejecutable.getCodeBase(),
				Graficos.directorio_img + "bicho2b.gif");
	}

	public static void mostrar_fondo(Graphics g) {
		/*
		 * Dibuja el fondo.
		 */
		g.setColor(Color.black);
		g.fillRect(0, 33, 400, 400);
	}

	public static void mostrar_menu_principal(Graphics g) {
		/*
		 * Dibuja la pantalla del menu principal.
		 */
		g.setColor(Color.white);
		g.drawString("Pulsa el boton nuevo para comenzar la partida.", 100, 100);
	}

	public static void mostrar_juego(Graphics g, ImageObserver ejecutable) {
		/*
		 * Dibuja los elementos del juego.
		 */
		Juego.nave_jugador.dibujar(g, ejecutable);
		// TODO - Juego.elemento.dibujar(g);
	}

	public static void mostrar_pausa(Graphics g) {
		/*
		 * Dibuja la pantalla de pausa.
		 */
		g.setColor(Color.white);
		g.drawString("Juego en pausa. Pulse el boton reanudar.", 100, 100);
	}

	public static void mostrar_clasificacion(Graphics g) {
		/*
		 * Dibuja la pantalla de clasificacion.
		 */
		// TODO
	}
}
