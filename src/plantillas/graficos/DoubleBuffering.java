package plantillas.graficos;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

/**
 * 
 * Implementacion de la tecnica double buffering para reducir el parpadeo de la
 * pantalla. Ademas, incluye la capacidad de ejecucion como hilo del applet.
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
public abstract class DoubleBuffering extends Applet implements Runnable {
	/**
	 * 
	 * Variables
	 * 
	 */
	// Doble buffering
	private Image dbImage;
	private Graphics dbg;

	// Hilo
	private volatile Thread thread;

	/**
	 * 
	 * Metodos
	 * 
	 */
	public final void start() {
		/*
		 * Inicio de ejecucion del hilo (Thread).
		 */
		thread = new Thread(this);
		thread.start();
	}

	public final void stop() {
		/*
		 * Fin de ejecucion del hilo (Thread).
		 */
		thread = null;
	}

	public final void run() {
		/*
		 * Ejecucion del hilo.
		 */
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

		Thread thisThread = Thread.currentThread();
		while (thread == thisThread) { // Bucle de ejecucion del hilo (Sera el
										// bucle de juego).
			this.juego();
			repaint();

			try {
				Thread.sleep(40);
			} catch (InterruptedException ex) {
				break;
			}

			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		}
	}

	public abstract void init(); // Inicio de ejecucion del applet.

	public abstract void paint(Graphics g); // Metodo de dibujar graficos del
											// applet.

	public final void update(Graphics g) {
		/*
		 * Metodo de actualizacion de la pantalla. Se sobrecarga para definir la
		 * tecnica doble buffering.
		 */
		if (this.dbImage == null) { // Si aun no se ha creado el buffer...
			// Se crea.
			this.dbImage = createImage(getSize().width, getSize().height);
			this.dbg = this.dbImage.getGraphics();
		}

		// Se dibuja en el buffer.
		this.dbg.setColor(getBackground());
		this.dbg.fillRect(0, 0, getSize().width, getSize().height);

		this.dbg.setColor(getForeground());
		this.paint(this.dbg);

		g.drawImage(this.dbImage, 0, 0, this);
	}

	public abstract void juego(); // Permite ejecutar instrucciones en el bucle
									// de juego al heredar de esta clase.
}
