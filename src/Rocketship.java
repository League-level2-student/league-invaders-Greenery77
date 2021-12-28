import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject{

	boolean left;
	boolean right;
	boolean up;
	boolean down;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
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
			if (needImage) {
			    loadImage ("rocket.png");
			}
	 }
	 
	 void draw(Graphics g) {
	     
	     if (gotImage) {
	    		g.drawImage(image, x, y, width, height, null);
	    	} else {
	    		g.setColor(Color.BLUE);
	    		g.fillRect(x, y, width, height);
	    	}
	     
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
	 public Projectile getProjectile() {
	        return new Projectile(x+width/2, y, 10, 10);
	} 
}
