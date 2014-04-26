package com.andrewsoutar.minecraft_latrunculi;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class LatrunculiMain {
	private boolean started=false;
	
	private int gameHeight;
	
	private int mob_x;
	private int mob_z;

	private int x_min = 0;
	private int x_max = 11;
	private int z_min = 0;
	private int z_max = 7;

	private int x_offset;
	private int z_offset;
	
	private LatrunculiPiece[][] board = new LatrunculiPiece[this.x_max-this.x_min+1][this.z_max-this.z_min+1];

	private boolean ready;

	private String turn;
	
	private int[] getBoardCoords (int x, int z) {
		int[] ret = new int[2];
		ret[0] = x - this.x_offset;
		ret[1] = z - this.z_offset;
		return ret;
	}
	
	private int[] getWorldCoords (int x, int z) {
		int[] ret = new int[2];
		ret[0] = x + this.x_offset;
		ret[1] = z + this.z_offset;
		return ret;
	}
	
	private boolean isOnBoard(int x, int y, int z) {
		return ((y == this.gameHeight) &&
				(x >= this.x_min) &&
				(x <= this.x_max) &&
				(z >= this.z_min) &&
				(z <= this.z_max));
	}

	private boolean checkMove(int x, int y, int z) {
		// Make sure we're ready to move
		if (!this.ready) {
			return false;
		}
		
		// Make sure they're on the board
		if (!isOnBoard(x, y, z))
			return false;
		
		// Now more complicated logic
		int lower, higher;
		
		if (x == this.mob_x) {
			if (z == this.mob_z) {
				// We're not going anywhere
				return false;
			} else if (z > this.mob_z) {
				higher = z;
				lower = this.mob_z+1;
			} else {
				higher = this.mob_z-1;
				lower = z+1;
			}
			
			// Check for pieces in the way
			for (int i = lower; i <= higher; i++) {
				if (board[x][i] != null) {
					System.out.println("Fail 1 at i=" + i);
					return false;
				}
			}
			
			// Check for latrunculi suicide
			if (!board[this.mob_x][this.mob_z].is_dux &&
					this.isOnBoard(x-1, y, z) &&
					this.isOnBoard(x+1, y, z) &&
					(board[x-1][z] != null) &&
					(board[x+1][z] != null) &&
					(board[x-1][z].color != this.turn) &&
					(board[x+1][z].color != this.turn)) {
				System.out.println("Fail 2");
				return false;
			}
			
		} else if (z == this.mob_z) {
			if (x > this.mob_x) {
				higher = x;
				lower = this.mob_x + 1;
			} else {
				higher = this.mob_x - 1;
				lower = x;
			}
			
			for (int i = lower; i <= higher; i++) {
				if (board[i][z] != null)
					return false;
			}
			
			if (!board[this.mob_x][this.mob_z].is_dux &&
					this.isOnBoard(x, y, z-1) &&
					this.isOnBoard(x, y, z-1) &&
					(board[x][z-1] != null) &&
					(board[x][z+1] != null) &&
					(board[x][z-1].color != this.turn) &&
					(board[x][z+1].color != this.turn))
				return false;
			
		} else {
			// Straight lines are the key to success in this game. You did not
			// make one. Fuck you.
			return false;
		}
		System.out.println("True!");
		return true;
	}
	
	private void capture(int x, int z) {
		if (!board[x][z].is_dux) {
			this.board[x][z].entity.isDead = true;
			this.board[x][z] = null;
		}
	}
	
	private void updateCaptures(String color, int x, int z) {
		if (this.isOnBoard(x-2, this.gameHeight, z)) {
			if ((this.board[x-2][z] != null) &&
					(this.board[x-1][z] != null) &&
					(this.board[x-2][z].color == color) &&
					(this.board[x-1][z].color != color))
				this.capture(x-1, z);
		}
		if (this.isOnBoard(x+2, this.gameHeight, z)) {
			if ((this.board[x+2][z] != null) &&
					(this.board[x+1][z] != null) &&
					(this.board[x+2][z].color == color) &&
					(this.board[x+1][z].color != color))
				this.capture(x+1, z);
		}
		if (this.isOnBoard(x, this.gameHeight, z-2)) {
			if ((this.board[x][z-2] != null) &&
					(this.board[x][z-1] != null) &&
					(this.board[x][z-2].color == color) &&
					(this.board[x][z-1].color != color))
				this.capture(x, z-1);
		}
		if (this.isOnBoard(x, this.gameHeight, z+2)) {
			if ((this.board[x][z+2] != null) &&
					(this.board[x][z+1] != null) &&
					(this.board[x][z+2].color == color) &&
					(this.board[x][z+1].color != color))
				this.capture(x, z+1);
		}
	}
	
	private void move(int x, int y, int z) {
		LatrunculiPiece piece = this.board[this.mob_x][this.mob_z];
		int[] adj = this.getWorldCoords(x, z);
		piece.x = adj[0];
		piece.z = adj[1];
		this.board[x][z] = piece;
		this.board[this.mob_x][this.mob_z] = null;
		piece.doTeleport();
		if (this.turn == "white")
			this.turn = "black";
		else
			this.turn = "white";
		this.ready = false;
		this.updateCaptures(piece.color, x, z);
	}

	public void startGame(World world, int x, int y, int z) {
		if (this.started)
			return;
		System.out.println("Running startGame");
		this.started = true;
		this.gameHeight = y;
		this.x_offset = (x+1)-this.x_min;
		this.z_offset = (z+1)-this.z_min;
		
		for (int i=this.x_min; i<=this.x_max; i++) {
			EntityWhiteLatrunculiPlayer player = new EntityWhiteLatrunculiPlayer(world);
			int[] adj = this.getWorldCoords(i, this.z_min);
			player.setPosition(((double) adj[0]) + ((double) 0.5), this.gameHeight+1, ((double) adj[1]) + ((double) 0.5));
			player.doRegister();
			world.spawnEntityInWorld(player);
		}
		
		for (int i=this.x_min; i<=this.x_max; i++) {
			EntityBlackLatrunculiPlayer player = new EntityBlackLatrunculiPlayer(world);
			int[] adj = this.getWorldCoords(i, this.z_max);
			player.setPosition(((double) adj[0]) + ((double) 0.5), this.gameHeight+1, ((double) adj[1]) + ((double) 0.5));
			player.setRotationYawHead((float) Math.PI);
			player.doRegister();
			world.spawnEntityInWorld(player);
		}
		
		{
			EntityWhiteLatrunculiDux dux = new EntityWhiteLatrunculiDux(world);
			int[] adj = this.getWorldCoords(this.x_min+5, this.z_min+1);
			dux.setPosition(((double) adj[0]) + ((double) 0.5), this.gameHeight+1, ((double) adj[1]) + ((double) 0.5));
			dux.doRegister();
			world.spawnEntityInWorld(dux);
		}
		
		{
			EntityBlackLatrunculiDux dux = new EntityBlackLatrunculiDux(world);
			int[] adj = this.getWorldCoords(this.x_max-5, this.z_max-1);
			dux.setPosition(((double) adj[0]) + ((double) 0.5), this.gameHeight+1, ((double) adj[1]) + ((double) 0.5));
			dux.doRegister();
			world.spawnEntityInWorld(dux);
		}
		
		this.turn = "white";
	}
	
	public LatrunculiPiece registerPiece(Entity entity, int x, int z, String color, boolean is_dux) {
		LatrunculiPiece piece = new LatrunculiPiece(entity, x, z, color, is_dux);
		int[] adj = this.getBoardCoords(x, z);
		board[adj[0]][adj[1]] = piece;
		return piece;
	}
	
	public void mobClicked(LatrunculiPiece piece) {
		if (piece.color == this.turn) {
			int[] adj = this.getBoardCoords(piece.x, piece.z);
			this.mob_x = adj[0];
			this.mob_z = adj[1];
			this.ready = true;
		}
	}

	public void tryMove(int un_x, int y, int un_z) {
		int[] boardCoords = this.getBoardCoords(un_x, un_z);
		int x = boardCoords[0];
		int z = boardCoords[1];
		
		System.out.println("Trying to move from " + this.mob_x + "," + this.mob_z + " to " + x + "," + z);
		if (this.checkMove(x, y, z)) {
			this.move(x, y, z);
		}
	}
	
}