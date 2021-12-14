import javax.swing.JFrame;

public class LeagueInvaders {
	
	GamePanel GP;
	JFrame frame;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	
public LeagueInvaders() {
	
	this.frame = new JFrame();
	
	this.GP = new GamePanel();
	
}

void setup() {
	
	frame.add(GP);
	
	frame.show();
	
	frame.setSize(WIDTH, HEIGHT);
	
	frame.addKeyListener(GP);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}

	
	public static void main(String[] args) {
		
		LeagueInvaders LI = new LeagueInvaders();
		
		LI.setup();
		
	}
	
}
