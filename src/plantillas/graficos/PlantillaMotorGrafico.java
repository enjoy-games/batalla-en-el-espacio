package plantillas.graficos;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

import plantillas.PlantillaJuego;

import juego.tipos_de_datos.EstadoPartida;

public abstract class PlantillaMotorGrafico {
	/**
	 * 
	 * Variables
	 * 
	 */
	protected Applet ejecutable;
	protected final String directorio_img = "juego/img/";
	protected PlantillaJuego puntero_juego;

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
		if (this.puntero_juego.estado == EstadoPartida.menu_principal) {
			this.mostrar_menu_principal(g);
		} else if (this.puntero_juego.estado == EstadoPartida.jugando) {
			this.mostrar_juego(g);
		} else if (this.puntero_juego.estado == EstadoPartida.pausa) {
			this.mostrar_pausa(g);
		} else if (this.puntero_juego.estado == EstadoPartida.clasificacion) {
			this.mostrar_clasificacion(g);
		}
	}

	protected abstract void mostrar_menu_principal(Graphics g);

	protected abstract void mostrar_juego(Graphics g);

	protected abstract void mostrar_pausa(Graphics g);

	protected abstract void mostrar_clasificacion(Graphics g);
}
