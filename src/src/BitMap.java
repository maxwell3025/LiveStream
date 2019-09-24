package src;

import java.awt.image.BufferedImage;
import java.util.Arrays;

public class BitMap {
	int width, height;
	int[] raster;
	public BitMap(int width, int height) {
		this.width = width;
		this.height = height;
		raster = new int[width*height];
	}
	public void copyToImage(BufferedImage image){
		image.setRGB(0, 0, width, height, raster, 0, width);
	}
	public void fill(int color){
		Arrays.fill(raster, color);
	}
	public void setRGB(int color, int x,int y){
		raster[x+y*width]=color;
	}

}
