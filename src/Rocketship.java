import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{

	boolean left;
	boolean right;
	boolean up;
	boolean down;
	
	public void update() {
		if (right) {

			right();

		}
		if (left) {

			left();

		}
		if (down) {

			down();

		}
		if (up) {

			up();

		}

	}
	
	 public Rocketship(int x, int y, int width, int height){
		 
			super(x,y,width,height);
			speed = 8;
			
	 }
	 
	 void draw(Graphics g) {
		 
	     g.setColor(Color.BLUE);
	     g.fillRect(x, y, width, height);
		 
	 }
	 public void right() {
		 if (x< LeagueInvaders.WIDTH - 60) {
	        x+=speed;
	    }
	 }
	 public void left() {
		 if (x > 0)
	        x-=speed;
	    }
	 public void down() {
		if (y < LeagueInvaders.HEIGHT - 90) {
	        y+=speed;
	    }
	 }
	 public void up() {
		 if  (y > 0){
		    y-=speed;
	    }
	 }
}
