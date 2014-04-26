package com.andrewsoutar.minecraft_latrunculi;

public class LatrunculiSingleton {
	private static LatrunculiMain instance = null;

	public LatrunculiMain getInstance() {
		if (instance == null)
			instance = new LatrunculiMain();
		return instance;
	}

}
