package com.pile.entity.player.inv;
import com.pile.image.Resources;

import com.pile.image.SingleImage;
import com.pile.image.ImageType;

import java.awt.image.BufferedImage;

public class Item {
	private int id, amount;
	private ImageType image;
	private int stack;

	public Item(int id) { this(id, 1); }

	public Item(int id, int amount) {
		this.id = id;
		this.amount = amount;
		double sc = 0.7;
		this.image = new SingleImage(Resources.scale(Resources.itemImages[id].getImage(), sc));
		this.stack = Resources.blockStack[id];
	}

	public BufferedImage getImage() { return image.getImage(); }
	public int getId() { return id; }
	public int getAmount() { return amount; }
	public void setAmount(int amount) { this.amount = amount; }
	public int subtractAmount(int amount) {
		this.amount -= amount;
		return this.amount;
	}

	public void add() { amount++; }
	public void decrease() { amount--; }
	public int getWidth(){ return image.getImage().getWidth();}
	public int getHeight(){ return image.getImage().getHeight();}

	public int getStackMax() { return stack; }

	@Override
	public String toString() {
		return "{" + id + "," + amount + "}";
	}
}
