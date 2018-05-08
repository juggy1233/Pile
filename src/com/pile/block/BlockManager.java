package com.pile.block;

import com.pile.GameCamera;

import java.awt.*;
import java.util.ArrayList;

public class BlockManager {
	private GameCamera camera;
	private ArrayList<Block> blocks;
	public BlockManager(GameCamera camera) {
		this.camera = camera;
		this.blocks = new ArrayList<Block>();
	}

	public void update() {
		for (Block b:blocks) {
			b.update();
		}
	}

	public void render(Graphics g) {
		for (Block b:blocks) {
//			g.drawImage();
		}
	}
}
