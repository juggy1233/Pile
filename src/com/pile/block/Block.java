package com.pile.block;

import com.pile.GameObject;
import com.pile.image.ImageType;
import com.pile.image.Resources;

import java.awt.image.BufferedImage;

public class Block extends GameObject {
	public static final int WIDTH = (int)(128 * Resources.SCALE);
	public static final int HEIGHT = (int)(128 * Resources.SCALE);

	public static final int STAGES = 9;

	protected int id;
	protected ImageType image;
	protected boolean canCollide;
	protected double destroyDelayMax, resetDelay, destroyDelay, destroyAmount;

	public Block(double x, double y, int id) { this(x, y, true, id); }

	public Block(double x, double y, boolean canCollide, int id) {
		super(x, y);
		this.id = id;
		this.image = Resources.blocks[id];
		this.canCollide = true;
		updateHitBox();
		destroyDelayMax = Resources.blockSpeeds[id];
		destroyDelay = destroyAmount = 0;
	}

	public BufferedImage getImage() { return image.getImage(); }
	public int getId() { return id; }
	public boolean canCollide() { return canCollide; }

	@Override
	public void updateHitBox() {
		hitBox.setRect(x, y, WIDTH, HEIGHT);
	}

	@Override
	public void update() {
		if (resetDelay < 3) {
			resetDelay++;
		} else {
			reset();
		}
		updateHitBox();
	}

	public void destroy(double amount) {
		resetDelay = 0;
		destroyDelay += amount;
		while (destroyDelay >= destroyDelayMax) {
			destroyDelay -= destroyDelayMax;
			destroyAmount++;
		}
	}
	public boolean destroyed() { return destroyAmount >= STAGES+1; }
	public double getDestroyAmount() { return destroyAmount; }
	public void reset() { destroyAmount = destroyDelay = 0; }
	public int getGridX() { return (int)(x / WIDTH); }
	public int getGridY() { return (int)(y / HEIGHT); }
}
