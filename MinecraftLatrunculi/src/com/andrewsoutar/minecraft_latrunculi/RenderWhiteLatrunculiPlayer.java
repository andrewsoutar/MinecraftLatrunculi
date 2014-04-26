package com.andrewsoutar.minecraft_latrunculi;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderWhiteLatrunculiPlayer extends RenderLatrunculi {
	private static final ResourceLocation texture = new ResourceLocation(Latrunculi.modid + ":textures/entity/white.png");
	
	public RenderWhiteLatrunculiPlayer(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity par1entity) {
		return texture;
	}
}