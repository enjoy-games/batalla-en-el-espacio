package plantillas.graficos;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

import juego.Juego;
import juego.tipos_de_datos.EstadoPartida;

public abstract class MotorGrafico {
	/**
	 * 
	 * Variables
	 * 
	 */
	protected Applet ejecutable;
	protected final String directorio_img = "juego/img/";

	/**
	 * 
	 * Metodos
	 * 
	 */
	protected abstract void cargar_imagenes();

	protected Image abrir_fichero_imagen(String nombre) {
		return this.ejecutable.getImage(this.ejecutable.getCodeBase(),
				this.directorio_img + nombre);
	}

	public void ejecutar(Graphics g) {
		if (Juego.estado == EstadoPartida.menu_principal) {
			this.mostrar_menu_principal(g);
		} else if (Juego.estado == EstadoPartida.jugando) {
			this.mostrar_juego(g);
		} else if (Juego.estado == EstadoPartida.pausa) {
			this.mostrar_pausa(g);
		} else if (Juego.estado == EstadoPartida.clasificacion) {
			this.mostrar_clasificacion(g);
		}
	}

	protected abstract void mostrar_menu_principal(Graphics g);

	protected abstract void mostrar_juego(Graphics g);

	protected abstract void mostrar_pausa(Graphics g);

	protected abstract void mostrar_clasificacion(Graphics g);
}
