package src;

public class Raycaster extends BitMap {
	private int[] map;
	private int mapHeight;
	private int mapWidth;
	private float scale;
	Camera cam = new Camera();

	public Raycaster(int width, int height, int mapWidth, int mapHeight) {
		super(width, height);
		this.mapHeight = mapHeight;
		this.mapWidth = mapWidth;
		map = new int[mapHeight * mapWidth];
		map[88] = 1;
		scale = height / 2;
	}

	public void update() {
		fill(-1);
		for (int x = 0; x < width; x++) {
			float scanX = ((float)x / width) * 2 - 1;
			float directionX = (float) (Math.cos(cam.angle));
			float directionY = (float) (Math.sin(cam.angle));
			float rayX = directionX + (float) (Math.sin(cam.angle)*scanX);
			float rayY = directionY - (float) (Math.cos(cam.angle)*scanX);
			castRay(cam.x, cam.y, rayX, rayY, x);
		}
	}

	private void castRay(float camX, float camY, float rayX, float rayY, int x) {
		/*
		 * boolean Xdirection = rayX < 0; boolean Ydirection = rayY < 0; float
		 * xPreStep = (float) (Math.ceil(camX) - camX); float yPreStep = (float)
		 * (Math.ceil(camY) - camY); float xStep = 1.0f / Math.abs(rayX); float
		 * yStep = 1.0f / Math.abs(rayY); if (Xdirection) { xPreStep--; } if
		 * (Ydirection) { yPreStep--; }
		 */
		float posX = camX;
		float posY = camY;
		float progress = 0;
		boolean draw = false;
		for (int i = 0; i < 1000; i++) {
			posX += rayX / 100;
			posY += rayY / 100;
			progress += 1.0f / 100;
			try {
				if (map[(int) posX + (int) posY * mapWidth] != 0) {
					draw = true;
					break;
				}
			} catch (Exception e) {
			}
		}
		if (draw) {
			int halfHeight = height / 2;
			int drawThickness = (int) (halfHeight / progress);
			drawVertLine(halfHeight - drawThickness, halfHeight + drawThickness, x);
		}
	}

	public void drawVertLine(int Ystart, int Yend, int x) {
		for (int y = Ystart; y < Yend; y++) {
			setRGB(0xff000000, x, y);
		}
	}

}
