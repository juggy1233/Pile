package com.pile.block;

import com.pile.GameObject;
import com.pile.image.ImageType;
import com.pile.image.Resources;

import java.awt.image.BufferedImage;

public abstract class Block extends GameObject {
	public static int WIDTH = (int)(128 * Resources.SCALE);
	public static int HEIGHT = (int)(128 * Resources.SCALE);
	protected double x, y;
	protected ImageType image;
	protected boolean canCollide;

	public Block(double x, double y, ImageType image) {
		super(x, y);
		this.image = image;
	}
	public BufferedImage getImage() { return image.getImage(); }
	public abstract void update();
}
