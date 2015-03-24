import org.lwjgl.opengl.GL11;

public class Planet {
	public float x;
	public float y;
	public float radius;
	public double[] color = {Math.random(),Math.random(),Math.random()};
	public Planet(float x, float y, float size) {
		this.x = x;
		this.y = y;
		this.radius = size;
	}

	public void drawCircle() {
		GL11.glColor3d(color[0], color[1], color[2]);
		GL11.glBegin(GL11.GL_TRIANGLE_FAN);
		for (int i = 0; i < 360; i++) {
			float angle = (float) ((Math.PI * i) / 180);
			GL11.glVertex2d(Math.cos(angle) * radius+x, Math.sin(angle) * radius+y);
		}
		GL11.glEnd();
	}
}
