
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
	
	private GameObjectHandler handler;
	
	public Controller(GameObjectHandler handler){
		this.handler = handler;
	}
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for(GameObject object : this.handler.getAllObjects()){
			
			if(object instanceof Player){
				if(key == KeyEvent.VK_UP) object.setVeloY(-5);
				if(key == KeyEvent.VK_DOWN) object.setVeloY(5);
				if(key == KeyEvent.VK_LEFT) object.setVeloX(-5);
				if(key == KeyEvent.VK_RIGHT) object.setVeloX(5);
			}
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for(GameObject object : this.handler.getAllObjects()){
			
			if(object instanceof Player){
				if(key == KeyEvent.VK_UP) object.setVeloY(0);
				if(key == KeyEvent.VK_DOWN) object.setVeloY(0);
				if(key == KeyEvent.VK_LEFT) object.setVeloX(0);
				if(key == KeyEvent.VK_RIGHT) object.setVeloX(0);
			}
		}
	}
}
