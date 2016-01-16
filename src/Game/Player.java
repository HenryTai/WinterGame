package Game;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {

	public Player(int x, int y, GameObjectID id) {
		super(x, y, id);
		
		//Set changing velocity value
		veloX = 1;
		veloY = 1;
	}

	@Override
	public void updateLogic() {
		x += veloX;
		y += veloY;
	}

	@Override
	public void updateGraphic(Graphics g) {
		
		//This is an example to make a representation to the object player
		g.setColor(Color.white);
		g.fillRect(x, y, 30, 30);
	}
	
}
