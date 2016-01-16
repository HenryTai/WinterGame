
import java.awt.Graphics;
import java.util.LinkedList;

public class GameObjectHandler {
	//an linked list to store all game objects
	private LinkedList<GameObject> gameObjects = new LinkedList<GameObject>();
	
	//update all game objects'logic
	public void updateGameObjectsLogic(){
		for(GameObject object : gameObjects){
			object.updateLogic();
		}
	}
	
	//update all game objects'graphic
	public void updateGameObjectsGraphic(Graphics g){
		for(GameObject object : gameObjects){
			object.updateGraphic(g);
		}
	}
	
	//add object to the game objects handler
	public void addObject(GameObject object){
		gameObjects.add(object);
	}
	
	//remove object from the game object handler
	public void removeObject(GameObject object){
		gameObjects.remove(object);
	}
	
	public LinkedList<GameObject> getAllObjects(){
		return this.gameObjects;
	}
}
