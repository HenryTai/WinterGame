
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable{

	public static final long serialVersionUID = 1L;
	
	//Size of the Window
	public static final int WIDTH = 450, HEIGHT = WIDTH * 12 / 9;
	
	private Thread thread;
	
	private boolean isRunning = false;
	
	private GameObjectHandler handler;
	
	public Main(){
		handler = new GameObjectHandler();
		
		this.addKeyListener(new Controller(handler));
		
		new Window(WIDTH, HEIGHT, "Skip the ball!", this);
		
		handler.addObject(new Player(WIDTH/2, HEIGHT - 100, GameObjectID.Player, handler));
		handler.addObject(new Enemy(WIDTH/2, 0, GameObjectID.Player));
	}
	
	//Starting the content of game inside the window
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		isRunning = true;
	}
	
	//Stop the content of the game inside the window
	public synchronized void stop(){
		try{
			thread.join();
			isRunning = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//Game loop that a lot people use it to maintain the animation of the game
	@Override
	public void run() {
		this.requestFocus();
		long lastLoopTime = System.nanoTime();
		final double targetFPS = 60.0;
		final double optimalTime = 1000000000 / targetFPS;
		double delta = 0;
		
		//used to track FPS, no effect to the functionality of game loop
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(isRunning){
			long now = System.nanoTime();
			delta += (now - lastLoopTime) / optimalTime;
			lastLoopTime = now;
			
			//update the content/logic of the game
			while(delta >= 1){
				updateGameLogic();
				delta--;
			}
			
			//draw everything of the game at that time
			if(isRunning)	updateGameGraphic();
			
			frames++;
			
			//Used to keep track with FPS, and display in console
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		
		stop();
		
	}
	
	public void updateGameLogic(){
		handler.updateGameObjectsLogic();
	}
	
	//draw everything function
	public void updateGameGraphic(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH,HEIGHT);
		
		handler.updateGameObjectsGraphic(g);
		
		g.dispose();
		bs.show();
	}
	
	//constrain a variable within a boundaries
	public static int constrain(int var, int min, int max){
		if(var < min) return var = min;
		else if(var > max) return var = max;
		else return var;
	}
	public static void main(String[] args) {
		new Main();
	}
	
}
