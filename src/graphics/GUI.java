package graphics;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class GUI {
	private int blockSize;
	private int width;
	private int height;
	private int FPS;

	public GUI(int blockSize, int width, int height, int FPS) {
		this.blockSize = blockSize;
		this.width = width;
		this.height = height;
		this.FPS = FPS;
		initialize();
	}

	private void initialize() {
		try {
			Display.setDisplayMode(new DisplayMode(width * blockSize, height
					* blockSize));
			Display.setTitle("Simulation");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, width * blockSize, height * blockSize, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}

	public void update() {
		Display.update();
		Display.sync(FPS);
	}

	public void clear() {
		glClear(GL_COLOR_BUFFER_BIT);
	}

	public boolean isCloseRequested() {
		return Display.isCloseRequested();
	}
	
	public void drawSquare(int x, int y, Color color) {
		drawSquare(x, y, color.getRed(), color.getGreen(), color.getBlue(), 1f);
	}

	public void drawSquare(int x, int y, float red, float green, float blue,
			float alpha) {
		int xPixel = x * blockSize;
		int yPixel = y * blockSize;
		int xPixel2 = xPixel + blockSize;
		int yPixel2 = yPixel + blockSize;
		glBindTexture(GL_TEXTURE_2D, 0);
		glColor4f(red, green, blue, alpha);
		glBegin(GL_TRIANGLES);
		glVertex2i(xPixel, yPixel);
		glVertex2i(xPixel2, yPixel);
		glVertex2i(xPixel2, yPixel2);
		glVertex2i(xPixel, yPixel2);
		glEnd();
//		glColor4f(red, green, blue, alpha);
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
