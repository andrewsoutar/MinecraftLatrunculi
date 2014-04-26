package com.andrewsoutar.minecraft_latrunculi;

import net.minecraft.entity.Entity;

public class LatrunculiPiece {
	public Entity entity;
	
	public String color;

	public int x;
	public int z;

	public boolean is_dux;
	
	public LatrunculiPiece(Entity par1entity, int par2x, int par3z, String par4color, boolean par5is_dux) {
		entity = par1entity;
		x = par2x;
		z = par3z;
		color = par4color;
		is_dux = par5is_dux;
	}
	
	public void doTeleport() {
		entity.setPosition(((double) this.x) + ((double) 0.5), entity.posY, ((double) this.z) + ((double) 0.5));
	}
}
