package Game;

import java.awt.Graphics;

public abstract class GameObject {
	protected int x,y; //position of the object in the game
	protected GameObjectID id;
	protected int veloX, veloY; //velocity of the object to x and y direction
	
	public GameObject(int x, int y, GameObjectID id){
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void updateLogic();
	
	public abstract void updateGraphic(Graphics g);
	
	
	
}
