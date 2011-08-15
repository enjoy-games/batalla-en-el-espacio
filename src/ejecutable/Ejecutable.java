package ejecutable;

import java.awt.Graphics;
import java.awt.event.KeyListener;

import plantillas.graficos.DoubleBuffering;
import plantillas.menu.Menu;

import juego.Juego;
import juego.controles_de_usuario.Teclado;
import juego.graficos.MotorGrafico;
import juego.menu.BtnNuevo_click;
import juego.menu.BtnPausa_click;

/**
 * 
 * Clase Applet que se ejecuta en el navegador.
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
@SuppressWarnings("serial")
public final class Ejecutable extends DoubleBuffering {
	private MotorGrafico motor_grafico;
	private Juego juego;

	/**
	 * 
	 * Metodos
	 * 
	 */
	@Override
	public void init() {
		/*
		 * Se ejecuta al inicio de carga del applet.
		 */
		this.juego = new Juego();
		this.motor_grafico = new MotorGrafico(this, this.juego);
		Menu.agregar_menu(this);
		this.cargar_eventos();
	}

	@Override
	public void paint(Graphics g) {
		/*
		 * Metodo de la clase applet que permite dibujar en el.
		 */
		this.motor_grafico.ejecutar(g);
	}

	@Override
	public void bucle_juego() {
		/*
		 * Bucle de juego.
		 */
		this.juego.ejecutar();
	}

	private void cargar_eventos() {
		/*
		 * Aqui se agregan todos los eventos necesarios.
		 */
		KeyListener Teclado = new Teclado(this.juego);

		// Controles de usuario.
		this.addKeyListener(Teclado); // Eventos de teclado.
		Menu.btnNuevo.addKeyListener(Teclado);
		Menu.btnPausa.addKeyListener(Teclado);

		// Acciones de menu.
		Menu.btnNuevo.addMouseListener(new BtnNuevo_click(this.juego));
		Menu.btnPausa.addMouseListener(new BtnPausa_click(this.juego));
	}
}
