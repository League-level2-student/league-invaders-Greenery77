import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
	    Rocketship rs = new Rocketship(250, 700, 50, 50);
	    
	    
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
		

	g.setColor(Color.BLACK);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT); 
	rs.draw(g);
	
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
	    } else {
	        currentState++;
	    }
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


