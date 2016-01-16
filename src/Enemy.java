import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy extends GameObject{

	public Enemy(int x, int y, GameObjectID id) {
		super(x, y, id);
		veloY = 5;
	}

	@Override
	public void updateLogic() {
		if(y < 0 || y > Main.HEIGHT - 15 - 28) veloY *= -1;
		
		y += veloY;
	}

	@Override
	public void updateGraphic(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 15, 15);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 15, 15);
	}

}
