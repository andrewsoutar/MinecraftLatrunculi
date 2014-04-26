package com.andrewsoutar.minecraft_latrunculi;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Latrunculi.modid, name = "Latrunculi Mod", version = Latrunculi.version)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Latrunculi {
	public static final String modid = "com.andrewsoutar.minecraft_latrunculi";
	public static final String version = "1.0";
	
	public static Block startSquare;
	public static Block boardSquareWhite;
	public static Block boardSquareBlack;
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		startSquare = new BlockStartSquare(512, Material.rock).setUnlocalizedName("startSquare");
		boardSquareWhite = new BlockBoardSquareWhite(513, Material.rock).setUnlocalizedName("boardSquareWhite");
		boardSquareBlack = new BlockBoardSquareBlack(514, Material.rock).setUnlocalizedName("boardSquareBlack");
		
		GameRegistry.registerBlock(startSquare, modid + startSquare.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(boardSquareWhite, modid + boardSquareWhite.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(boardSquareBlack, modid + boardSquareBlack.getUnlocalizedName().substring(5));
		
		EntityRegistry.registerModEntity(EntityWhiteLatrunculiPlayer.class, "White Latrunculi Player", 1, this, 80, 3, true);
		EntityRegistry.registerModEntity(EntityBlackLatrunculiPlayer.class, "Black Latrunculi Player", 2, this, 80, 3, true);
		EntityRegistry.registerModEntity(EntityWhiteLatrunculiDux.class, "White Latrunculi Dux", 3, this, 80, 3, true);
		EntityRegistry.registerModEntity(EntityBlackLatrunculiDux.class, "Black Latrunculi Dux", 3, this, 80, 3, true);
		
		RenderingRegistry.registerEntityRenderingHandler(EntityWhiteLatrunculiPlayer.class, new RenderWhiteLatrunculiPlayer(new WhiteLatrunculiPlayerModel(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackLatrunculiPlayer.class, new RenderBlackLatrunculiPlayer(new BlackLatrunculiPlayerModel(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityWhiteLatrunculiDux.class, new RenderWhiteLatrunculiDux(new WhiteLatrunculiDuxModel(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackLatrunculiDux.class, new RenderBlackLatrunculiDux(new BlackLatrunculiDuxModel(), 0.5F));
		
		LanguageRegistry.addName(startSquare, "Starting Latrunculi Block");
		LanguageRegistry.addName(boardSquareWhite, "White Latrunculi Board Square");
		LanguageRegistry.addName(boardSquareBlack, "Black Latrunculi Board Square");
	}

}