package entry;

import graphics.GUI;

import java.util.Random;

public class Runner {
	public static void main(String[] args) {
		GUI gui = new GUI(10, 128, 96, 30);	
		Random rng = new Random();
		int x = Math.abs(rng.nextInt()%gui.getWidth());
		int y = Math.abs(rng.nextInt()%gui.getHeight());
		float r = Math.abs(rng.nextFloat());
		float g = Math.abs(rng.nextFloat());
		float b = Math.abs(rng.nextFloat());
		float a = 1;
		while (!gui.isCloseRequested()) {
			gui.clear();
			gui.drawSquare(x, y, r, g, b, a);
			gui.drawSquare(4, 10, 1f, 1f, 1f, 1f);
			gui.update();
		}
	}
}
