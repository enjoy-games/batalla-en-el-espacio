package juego.graficos;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import plantillas.elementos.ObjetoMovil;
import juego.Juego;
import juego.elementos.Bicho;

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
public class MotorGrafico extends plantillas.graficos.MotorGrafico {
	/**
	 * 
	 * Variables
	 * 
	 */
	private Image imagen_nave_jugador;
	private final int duplicacion = 8;
	private Image[] imagen_bicho1 = new Image[duplicacion];
	private Image[] imagen_bicho2 = new Image[duplicacion];
	private Image imagen_explosion;

	/**
	 * 
	 * Constructor
	 * 
	 */
	public MotorGrafico(Applet ejecutable) {
		super.ejecutable = ejecutable;
		this.cargar_imagenes();
	}

	/**
	 * 
	 * Metodos
	 * 
	 */
	@Override
	protected void cargar_imagenes() {
		/*
		 * Cargan en memoria las imagenes necesarias.
		 */
		this.imagen_nave_jugador = this
				.abrir_fichero_imagen("nave_jugador.gif");

		// Enemigos
		Image imagen1a = this.abrir_fichero_imagen("bicho1a.gif");
		Image imagen1b = this.abrir_fichero_imagen("bicho1b.gif");
		Image imagen2a = this.abrir_fichero_imagen("bicho2a.gif");
		Image imagen2b = this.abrir_fichero_imagen("bicho2b.gif");
		Image aux_imagen1, aux_imagen2;

		for (int i = 0; i < this.duplicacion; i++) {
			// Se aumenta el numero de sprites por segundo.
			if (i < this.duplicacion / 2) {
				// La primera mitad se carga con el spriteA.
				aux_imagen1 = imagen1a;
				aux_imagen2 = imagen2a;
			} else {
				// La segunda mitad se carga con el spriteB.
				aux_imagen1 = imagen1b;
				aux_imagen2 = imagen2b;
			}

			this.imagen_bicho1[i] = aux_imagen1;
			this.imagen_bicho2[i] = aux_imagen2;
		}

		this.imagen_explosion = this.abrir_fichero_imagen("explosion.gif");
	}

	private void mostrar_fondo(Graphics g) {
		/*
		 * Dibuja el fondo.
		 */
		g.setColor(Color.black);
		g.fillRect(0, 33, 400, 400);
	}

	@Override
	protected void mostrar_menu_principal(Graphics g) {
		/*
		 * Dibuja la pantalla del menu principal.
		 */
		this.mostrar_fondo(g);
		g.setColor(Color.white);
		g.drawString("Pulsa el boton 'Nuevo' para comenzar la partida.", 100,
				100);
	}

	@Override
	protected void mostrar_juego(Graphics g) {
		/*
		 * Dibuja los elementos del juego.
		 */
		this.mostrar_fondo(g);
		this.dibujar_nave_jugador(g);

		if (Juego.nave_jugador.disparo != null) {
			this.dibujar_disparo(g, Juego.nave_jugador.disparo);
		}

		for (int i = 0; i < Juego.bichos.length; i++) {
			if (Juego.bichos[i] != null) {
				this.dibujar_bicho(g, Juego.bichos[i]);
			}
		}
		// TODO - Juego.elemento.dibujar(g);
	}

	private void dibujar_nave_jugador(Graphics g) {
		/*
		 * Dibuja el elemento segun sus propiedades.
		 */
		g.drawImage(this.imagen_nave_jugador,
				Juego.nave_jugador.esquina_superior_izquierda.x_pos,
				Juego.nave_jugador.esquina_superior_izquierda.y_pos,
				super.ejecutable);
	}

	private void dibujar_disparo(Graphics g, ObjetoMovil disparo) {
		/*
		 * Dibuja el elemento segun sus propiedades.
		 */
		g.setColor(Color.white);
		g.fillRect(disparo.esquina_superior_izquierda.x_pos,
				disparo.esquina_superior_izquierda.y_pos, disparo.ancho,
				disparo.alto);
	}

	private void dibujar_bicho(Graphics g, ObjetoMovil bicho) {
		/*
		 * Dibuja el elemento segun sus propiedades.
		 */
		Image imagen;

		if (((Bicho) bicho).destruido) {
			imagen = this.imagen_explosion;
		} else {
			imagen = this.imagen_bicho1[((Bicho) bicho).imagen_actual];
		}

		g.drawImage(imagen, bicho.esquina_superior_izquierda.x_pos,
				bicho.esquina_superior_izquierda.y_pos, super.ejecutable);

		if (((Bicho) bicho).imagen_actual < this.imagen_bicho1.length - 1) {
			((Bicho) bicho).imagen_actual += 1;
		} else {
			((Bicho) bicho).imagen_actual = 0;
		}
	}

	private void dibujar_contador(Graphics g) {
		/*
		 * Dibuja el contador, segun sus propiedades.
		 */
		// TODO - Contador de vida con marco y rayas (Tipo Shinobi).
		g.setColor(Color.white);
		g.drawString("Vida", 0, 0);
	}

	@Override
	protected void mostrar_pausa(Graphics g) {
		/*
		 * Dibuja la pantalla de pausa.
		 */
		g.setColor(Color.white);
		g.drawString("Juego en pausa. Pulse el boton 'Reanudar'.", 100, 100);
	}

	@Override
	protected void mostrar_clasificacion(Graphics g) {
		/*
		 * Dibuja la pantalla de clasificacion.
		 */
		// TODO
	}
}
