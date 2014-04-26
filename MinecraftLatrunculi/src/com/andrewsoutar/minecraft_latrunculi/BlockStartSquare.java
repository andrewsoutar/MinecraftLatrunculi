package com.andrewsoutar.minecraft_latrunculi;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockStartSquare extends Block {

	private LatrunculiMain latrunculiMain;

	public BlockStartSquare(int par1, Material par2Material) {
		super(par1, par2Material);
		this.latrunculiMain = (new LatrunculiSingleton()).getInstance();
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon(Latrunculi.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
	
	public boolean onBlockActivated (World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		latrunculiMain.startGame(par1World, x, y, z);
		return true;
	}

}
