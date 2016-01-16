
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {

	private GameObjectHandler handler;
	
	public Player(int x, int y, GameObjectID id, GameObjectHandler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	@Override
	public void updateLogic() {
		x += veloX;
		y += veloY;
		
		x = Main.constrain(x, 0, Main.WIDTH - 30 - 5);
		y = Main.constrain(y, 0, Main.HEIGHT - 30 -28);
		
		collisionAnalyse();
	}

	private void collisionAnalyse() {
		for(GameObject object : handler.getAllObjects()){
			if(!(object instanceof Player)){
				if(this.getBounds().intersects(object.getBounds()))
					handler.removeObject(object);
			}
		}
	}

	@Override
	public void updateGraphic(Graphics g) {
		//This is an example to make a representation to the object player
		g.setColor(Color.white);
		g.fillRect(x, y, 30, 30);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 30, 30);
	}
	
}
