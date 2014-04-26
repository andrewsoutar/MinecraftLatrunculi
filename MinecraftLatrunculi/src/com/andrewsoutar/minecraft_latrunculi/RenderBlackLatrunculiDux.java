package com.andrewsoutar.minecraft_latrunculi;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderBlackLatrunculiDux extends RenderLatrunculi {
	private static final ResourceLocation texture = new ResourceLocation(Latrunculi.modid + ":textures/entity/blackdux.png");
	
	public RenderBlackLatrunculiDux(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity par1entity) {
		return texture;
	}
}