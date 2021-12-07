import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	
	 final int MENU = 0;
	    final int GAME = 1;
	    final int END = 2;
	    int currentState = MENU;
	    Font titleFont;
	    Font subFont1;
	    Font subFont2;
	    
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
		
	g.setColor(Color.RED);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT); 
	
	}
	
	void drawEndState(Graphics g)  { 
		
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT); 
	
	g.setFont(titleFont);
	g.setColor(Color.YELLOW);
	g.drawString("text", 0, 0);
	
	}
	
public GamePanel() {
	
	  this.titleFont = new Font("Arial", Font.PLAIN, 48);
	  this.subFont1 = new Font("Arial", Font.PLAIN, 25);
	  this.subFont2 = new Font("Arial", Font.PLAIN, 25);
}

}


