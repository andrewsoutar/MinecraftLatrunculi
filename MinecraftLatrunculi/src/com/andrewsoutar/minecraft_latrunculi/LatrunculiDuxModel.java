package com.andrewsoutar.minecraft_latrunculi;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class LatrunculiDuxModel extends ModelBase {
	public ModelRenderer ArmLeft;
	public ModelRenderer ArmRight;
	public ModelRenderer Body;
	public ModelRenderer EagleBody;
	public ModelRenderer EagleHead;
	public ModelRenderer EagleWings;
	public ModelRenderer Head;
	public ModelRenderer LegLeft;
	public ModelRenderer LegRight;

	public LatrunculiDuxModel() {
		ArmLeft = new ModelRenderer(this, 0, 0);
		ArmLeft.addBox(0F, 0F, 0F, 2, 8, 2);
		ArmLeft.setRotationPoint(-7F, 11F, 1F);
		ArmLeft.rotateAngleZ = 0.3490658503988659F;
	
		ArmRight = new ModelRenderer(this, 0, 0);
		ArmRight.addBox(0F, 0F, 0F, 2, 8, 2);
		ArmRight.setRotationPoint(5F, 11F, 1F);
		ArmRight.rotateAngleZ = 5.934119456780721F;
	
		Body = new ModelRenderer(this, 20, 18);
		Body.addBox(0F, 0F, 0F, 8, 10, 4);
		Body.setRotationPoint(-4F, 10F, 0F);
	
		EagleBody = new ModelRenderer(this, 14, 2);
		EagleBody.addBox(0F, 0F, 0F, 2, 4, 4);
		EagleBody.setRotationPoint(-1F, 2F, 0F);
	
		EagleHead = new ModelRenderer(this, 28, 2);
		EagleHead.addBox(0F, 0F, 0F, 2, 2, 2);
		EagleHead.setRotationPoint(-1F, 0F, 0F);
	
		EagleWings = new ModelRenderer(this, 34, 6);
		EagleWings.addBox(0F, 0F, 0F, 12, 0, 4);
		EagleWings.setRotationPoint(-6F, 2F, 0F);
	
		Head = new ModelRenderer(this, 24, 8);
		Head.addBox(0F, 0F, 0F, 4, 4, 4);
		Head.setRotationPoint(-2F, 6F, 0F);
	
		LegLeft = new ModelRenderer(this, 0, 18);
		LegLeft.addBox(0F, 0F, 0F, 4, 10, 4);
		LegLeft.setRotationPoint(-4F, 20F, 0F);
	
		LegRight = new ModelRenderer(this, 0, 18);
		LegRight.addBox(0F, 0F, 0F, 4, 10, 4);
		LegRight.setRotationPoint(0F, 20F, 0F);
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		ArmLeft.render(f5);
		ArmRight.render(f5);
		Body.render(f5);
		EagleBody.render(f5);
		EagleHead.render(f5);
		EagleWings.render(f5);
		Head.render(f5);
		LegLeft.render(f5);
		LegRight.render(f5);
	}

}