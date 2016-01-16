package Game;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {

	public Player(int x, int y, GameObjectID id) {
		super(x, y, id);
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
