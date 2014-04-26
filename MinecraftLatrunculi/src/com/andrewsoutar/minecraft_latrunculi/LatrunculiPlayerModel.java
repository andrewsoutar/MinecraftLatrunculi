package com.andrewsoutar.minecraft_latrunculi;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class LatrunculiPlayerModel extends ModelBase {
	public ModelRenderer Body;
	public ModelRenderer Head;
	public ModelRenderer LeftArm;
	public ModelRenderer LeftLeg;
	public ModelRenderer RightArm;
	public ModelRenderer RightLeg;

	public LatrunculiPlayerModel() {
		Body = new ModelRenderer(this, 40, 18);
		Body.addBox(0F, 0F, 0F, 8, 10, 4);
		Body.setRotationPoint(-4F, 4F, 0F);
	
		Head = new ModelRenderer(this, 44, 8);
		Head.addBox(0F, 0F, 0F, 4, 4, 4);
		Head.setRotationPoint(-2F, 0F, 0F);
	
		LeftArm = new ModelRenderer(this, 0, 22);
		LeftArm.addBox(0F, 0F, 0F, 2, 8, 2);
		LeftArm.setRotationPoint(2F, 5F, 1F);
		LeftArm.rotateAngleZ = 0.3490658503988659F;
	
		LeftLeg = new ModelRenderer(this, 17, 20);
		LeftLeg.addBox(0F, 0F, 0F, 4, 8, 4);
		LeftLeg.setRotationPoint(0F, 14F, 0F);
	
		RightArm = new ModelRenderer(this, 0, 22);
		RightArm.addBox(0F, 0F, 0F, 2, 8, 2);
		RightArm.setRotationPoint(-4F, 5F, 1F);
		RightArm.rotateAngleZ = 5.934119456780721F;
	
		RightLeg = new ModelRenderer(this, 17, 20);
		RightLeg.addBox(0F, 0F, 0F, 4, 8, 4);
		RightLeg.setRotationPoint(-4F, 14F, 0F);
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Body.render(f5);
		Head.render(f5);
		LeftArm.render(f5);
		LeftLeg.render(f5);
		RightArm.render(f5);
		RightLeg.render(f5);
	}
	
	@Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity par7entity)
    {

    }
}