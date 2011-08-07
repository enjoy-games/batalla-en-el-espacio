package juego.elementos;

import java.awt.Color;
import java.awt.Graphics;

import plantillas.elementos.ObjetoMovil;
import plantillas.elementos.PuntoMovil;

public final class Disparo extends ObjetoMovil {
	Disparo(int x_pos, int y_pos, int ancho, int alto, int velocidad_y,
			Color color) {
		super.esquina_superior_izquierda = new PuntoMovil();
		super.esquina_superior_izquierda.x_pos = x_pos;
		super.esquina_superior_izquierda.y_pos = y_pos;
		// velocidad_x = 0
		super.esquina_superior_izquierda.velocidad_y = velocidad_y;
		super.ancho = ancho;
		super.alto = alto;
		super.color = color;
	}

	public void movimiento() {
		if (this.esquina_superior_izquierda.y_pos > 0) {
			this.esquina_superior_izquierda.y_pos -= this.esquina_superior_izquierda.velocidad_y;
		}
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(super.color);
		g.fillRect(super.esquina_superior_izquierda.x_pos,
				super.esquina_superior_izquierda.y_pos, super.ancho, super.alto);
	}
}
