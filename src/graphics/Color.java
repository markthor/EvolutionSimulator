package graphics;

public class Color {
	public static final Color BURLY_WOOD = new Color(0.87058823529f, 0.71875f, 0.52734375f);
	
	private float red;
	private float green;
	private float blue;
	
	public Color(float red, float green, float blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public float getRed() {
		return red;
	}

	public float getGreen() {
		return green;
	}

	public float getBlue() {
		return blue;
	}
}
