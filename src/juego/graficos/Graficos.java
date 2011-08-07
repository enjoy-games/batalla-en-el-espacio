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
	public static int duplicacion = 8;
	public static Image[] bicho1 = new Image[duplicacion],
			bicho2 = new Image[duplicacion];

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

		// Enemigos
		Image imagen1a = ejecutable.getImage(ejecutable.getCodeBase(),
				Graficos.directorio_img + "bicho1a.gif");
		Image imagen1b = ejecutable.getImage(ejecutable.getCodeBase(),
				Graficos.directorio_img + "bicho1b.gif");
		Image imagen2a = ejecutable.getImage(ejecutable.getCodeBase(),
				Graficos.directorio_img + "bicho2a.gif");
		Image imagen2b = ejecutable.getImage(ejecutable.getCodeBase(),
				Graficos.directorio_img + "bicho2b.gif");
		Image aux_imagen1, aux_imagen2;
		for (int i = 0; i < Graficos.duplicacion; i++) {
			// Se aumenta el numero de sprites por segundo.
			if (i < Graficos.duplicacion / 2) {
				// La primera mitad se carga con el spriteA.
				aux_imagen1 = imagen1a;
				aux_imagen2 = imagen2a;
			} else {
				// La segunda mitad se carga con el spriteB.
				aux_imagen1 = imagen1b;
				aux_imagen2 = imagen2b;
			}

			Graficos.bicho1[i] = aux_imagen1;
			Graficos.bicho2[i] = aux_imagen2;
		}
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
		g.drawString("Pulsa el boton 'Nuevo' para comenzar la partida.", 100,
				100);
	}

	public static void mostrar_juego(Graphics g, ImageObserver ejecutable) {
		/*
		 * Dibuja los elementos del juego.
		 */
		Juego.nave_jugador.dibujar(g, ejecutable);

		if (Juego.nave_jugador.disparo != null) {
			Juego.nave_jugador.disparo.dibujar(g);
		}

		for (int i = 0; i < Juego.bichos.length; i++) {
			Juego.bichos[i].dibujar(g, ejecutable);
		}
		// TODO - Juego.elemento.dibujar(g);
	}

	public static void mostrar_pausa(Graphics g) {
		/*
		 * Dibuja la pantalla de pausa.
		 */
		g.setColor(Color.white);
		g.drawString("Juego en pausa. Pulse el boton 'Reanudar'.", 100, 100);
	}

	public static void mostrar_clasificacion(Graphics g) {
		/*
		 * Dibuja la pantalla de clasificacion.
		 */
		// TODO
	}
}
