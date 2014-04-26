package com.andrewsoutar.minecraft_latrunculi;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderLatrunculi extends RenderLiving {
	private static final ResourceLocation texture = new ResourceLocation("");

	public RenderLatrunculi(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity par1entity) {
		return texture;
	}
}