package com.andrewsoutar.minecraft_latrunculi;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityBlackLatrunculiDux extends EntityCreature {

	private LatrunculiMain mainLatrunculi;
	private LatrunculiPiece piece;

	public EntityBlackLatrunculiDux(World par1World) {
		super(par1World);
		this.mainLatrunculi = (new LatrunculiSingleton()).getInstance();
		
	}
	
	@Override
	public boolean canBePushed() {
		return false;
	}
	
	@Override
	public boolean isMovementCeased() {
		return true;
	}
	
	@Override
	public boolean interact(EntityPlayer par1entityplayer) {
		this.mainLatrunculi.mobClicked(this.piece);
		return true;
	}
	
	public void doRegister() {
		this.piece = this.mainLatrunculi.registerPiece(this, (int) (this.posX-0.5), (int) (this.posZ-0.5), "black", true);
	}
}
