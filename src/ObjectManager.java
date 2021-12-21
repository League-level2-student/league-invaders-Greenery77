import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	Rocketship rocket;
	ArrayList <Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList <Alien> aliens = new ArrayList<Alien>();
	Random ran = new Random();
	
public ObjectManager(Rocketship rocket) {
		
		this.rocket = rocket;
				
	}

	void addProjectile(Projectile p) {
		
		projectiles.add(p);
		
	}
	
	void addAlien() {
		
		aliens.add(new Alien(ran.nextInt(LeagueInvaders.WIDTH),0,50,50));
		
	}
	
	public void update() {
		
		for (int i = 0; i < aliens.size(); i++) {
			
			 aliens.get(i).update();
			
			 if (aliens.get(i).y > LeagueInvaders.HEIGHT){
				 
				 aliens.get(i).isActive = false;
				 
			 }
			 
		}
		
		for (int i = 0; i < projectiles.size(); i++) {
			
			 projectiles.get(i).update();
			
			 if (projectiles.get(i).y > LeagueInvaders.HEIGHT){
				 
				 projectiles.get(i).isActive = false;
				 
			 }
			 
		}
		
	}
	
	void draw(Graphics g) {
		
		rocket.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			
			 aliens.get(i).draw(g);
			 
		}
		for (int i = 0; i < projectiles.size(); i++) {
			
			 projectiles.get(i).draw(g);
			 
		}
	}
	
	void purgeObjects() {
		
		for (int i = aliens.size()-1; i >= 0; i--) {
			
			if (!aliens.get(i).isActive) {
			
				aliens.remove(i);
				
			}
		}
		for (int i = projectiles.size()-1; i >= 0; i--) {
			
			if (!projectiles.get(i).isActive) {
			
				projectiles.remove(i);
				
			}
		}
		}
		
	}
	

