import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	
	 final int MENU = 0;
	    final int GAME = 1;
	    final int END = 2;
	    int currentState = MENU;
	    Font titleFont;
	    Font subFont1;
	    Font subFont2;
	    Timer frameDraw;
	    Timer alienSpawn;
	    Rocketship rs = new Rocketship(250, 700, 50, 50);
	    ObjectManager om = new ObjectManager(rs);
	    public static BufferedImage image;
	    public static boolean needImage = true;
	    public static boolean gotImage = false;	
	    
	public void startGame() {
		  
		alienSpawn = new Timer(1000, om);
	    alienSpawn.start(); 
		  
	  }
	    
	@Override
	public void paintComponent(Graphics g){

		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
		
	}
	
	void updateMenuState() { 
		
		
	}
	
	void updateGameState() {
		
		rs.update();
		om.update();
		
	}
	
	void updateEndState()  { 
		
		
	}
	
	void drawMenuState(Graphics g) { 
		
	g.setColor(Color.BLUE);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
			
	g.setFont(titleFont);
	g.setColor(Color.YELLOW);
	g.drawString("LEAGUE INVADERS",20, 100);
	g.setFont(subFont1);
	g.drawString("ENTER to start", 20, 300);
	g.drawString("SPACE for instructions", 20, 400);
	
	
	}
	void drawGameState(Graphics g) { 
		
		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		
	om.draw(g);
	
	}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	
	void drawEndState(Graphics g)  { 
		
	g.setColor(Color.RED);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT); 
	
	g.setFont(titleFont);
	g.setColor(Color.YELLOW);
	g.drawString("GAME OVER", 100, 100);
	g.setFont(subFont1);
	g.drawString("You killed enemies", 20, 300);
	g.drawString("ENTER to restart", 20, 400);
	}
	
public GamePanel() {
	
	  this.titleFont = new Font("Arial", Font.PLAIN, 48);
	  this.subFont1 = new Font("Arial", Font.PLAIN, 25);
	  this.subFont2 = new Font("Arial", Font.PLAIN, 25);
	  frameDraw = new Timer(1000/60, this);
	  frameDraw.start();
	  if (needImage) {
		    loadImage ("space.png");
		}
}

@Override
public void actionPerformed(ActionEvent arg0) {
	
	if(currentState == MENU){
	    updateMenuState();
	}else if(currentState == GAME){
	    updateGameState();
	}else if(currentState == END){
	    updateEndState();
	}
	
	repaint();
	
}

@Override
public void keyPressed(KeyEvent e) {
	if (e.getKeyCode()==KeyEvent.VK_ENTER) {
	    if (currentState == END) {
	        currentState = MENU;
	    }
	    else{
	        currentState++;
	        if (currentState == GAME) {
	        	
		    	startGame();
		    	
		    }
	        if (currentState == END) {

		    	alienSpawn.stop();
		    	
		    }
	    }
	   
	}
	if (e.getKeyCode()==KeyEvent.VK_SPACE) {
		
		om.addProjectile(rs.getProjectile());
		
	}
	if (currentState == GAME && e.getKeyCode()==KeyEvent.VK_UP ) {
	    rs.up=true;
	}
	if (currentState == GAME && e.getKeyCode()==KeyEvent.VK_DOWN) {
	    rs.down=true;
	}
	if (currentState == GAME && e.getKeyCode()==KeyEvent.VK_LEFT) {
	    rs.left=true;
	}
	if (currentState == GAME && e.getKeyCode()==KeyEvent.VK_RIGHT) {
	    rs.right=true;
	}
}

@Override
public void keyReleased(KeyEvent e) {
	
	if (currentState == GAME && e.getKeyCode()==KeyEvent.VK_UP ) {
	    rs.up=false;
	}
	if (currentState == GAME && e.getKeyCode()==KeyEvent.VK_DOWN) {
	    rs.down=false;
	}
	if (currentState == GAME && e.getKeyCode()==KeyEvent.VK_LEFT) {
	    rs.left=false;
	}
	if (currentState == GAME && e.getKeyCode()==KeyEvent.VK_RIGHT) {
	    rs.right=false;
	}
	
}

@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

}


