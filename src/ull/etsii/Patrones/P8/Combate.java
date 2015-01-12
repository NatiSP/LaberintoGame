package ull.etsii.Patrones.P8;

import java.util.Random;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import ull.etsii.Patrones.P1E2.Enemigo;
import ull.etsii.Patrones.P1E2.Heroe;
import ull.etsii.Patrones.P1E2.INormal;
import ull.etsii.Patrones.P1E2.Personaje;

public class Combate  extends BasicGameState{

	Random aleatorio = new Random();

	private StateBasedGame game; // stored for later use
	
	private Animation right;
	private Image Dragon;
	
	static Personaje H1;
	static Personaje H2;
	static Personaje M1;
	
	boolean Orden1, Orden2 = false;
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		this.game = game;
		
		H2 = new Heroe(new INormal(),20,10,4,4,4,4, null, 1);
  		M1 = new Enemigo(new INormal(),60,25,10,10,10,10, null);
  		H1 = new Heroe(new INormal(),20,10,4,4,4,4, null, 1);
  		Image [] movementRight = {new Image("data/mika-3a.png"), new Image("data/mika-3b.png")};
  		Dragon = new Image("data/Dragon.png");
  		
  		int [] duration = {400, 400};
  		right = new Animation(movementRight, duration, true);
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		g.setBackground(Color.darkGray);
		right.draw(100, 250);
		right.draw(100, 300);
		g.drawString("Heroe 1: " + H1.estado.getStatus(), 100, 360);
		g.drawString("HP: " + H1.HP, 100, 380);
		g.drawString("SP: " + H1.SP, 100, 400);
		g.drawString("Heroe 2: " + H2.estado.getStatus(), 220, 360);
		g.drawString("HP: " + H2.HP, 220, 380);
		g.drawString("SP: " + H2.SP, 220, 400);
		Dragon.draw(260, 150);
		g.drawString("Dragon: " + M1.estado.getStatus(), 340, 360);
		g.drawString("HP: " + M1.HP, 340, 380);
		g.drawString("SP: " + M1.SP, 340, 400);
		if(Orden1 == false){
			g.drawString("Turno del Heroe 1", 50, 50);
		}
		else{
			g.drawString("Turno del Heroe 2", 50, 50);
		}
		g.drawString("A: Ataque || M: Ataque mágico || D: Defender", 50, 80);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame arg1, int arg2)
			throws SlickException {
		Input in = gc.getInput();
		if(Orden1 == false){
			gc.getGraphics().drawString("Turno del Heroe 1", 50, 50);
			if(in.isKeyPressed(Input.KEY_A)){
				H1.attack(M1);
				Orden1 = true;
			}
			else if(in.isKeyPressed(Input.KEY_M)){
				H1.magic(M1);
				Orden1 = true;
			}
			else if(in.isKeyPressed(Input.KEY_D)){
				H1.defend(H1);
				Orden1 = true;
			}
			else{
			
			}
		}
		
		if(Orden1 == true){
			gc.getGraphics().drawString("Turno del Heroe 2", 50, 50);
			if(in.isKeyPressed(Input.KEY_A)){
				H2.attack(M1);
				DragonAttack();
				Orden1 = false;
			}
			else if(in.isKeyPressed(Input.KEY_M)){
				H2.magic(M1);
				DragonAttack();
				Orden1 = false;
			}
			else if(in.isKeyPressed(Input.KEY_D)){
				H2.defend(H2);
				DragonAttack();
				Orden1 = false;
			}
			else{
			
			}
		}
		if(M1.HP < 0){
			game.enterState(GameClient.prevState.getID(), new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}
	
	public void DragonAttack() {
		switch(aleatorio.nextInt(5))
		{
		case 0:{
			M1.attack(H1);
			System.out.println("¡El Dragón atacó al héroe 1!");
		}
			break;
		case 1:{
			((Enemigo) M1).attack(H2);
			System.out.println("¡El Dragón atacó al héroe 2!");
		}
			break;
		case 2:{
			((Enemigo) M1).magic(H1);
			System.out.println("¡El Dragón lanzó fuego al héroe 1!");
		}
			break;
		case 3:{
			((Enemigo) M1).magic(H2);
			System.out.println("¡El Dragón lanzó fuego al héroe 2!");
		}
			break;
		case 4:
			((Enemigo) M1).defend(M1);
			System.out.println("¡El Dragón se protegió y se curó!");
			break;
		}
    }

}
