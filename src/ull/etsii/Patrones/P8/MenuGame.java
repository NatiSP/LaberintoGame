package ull.etsii.Patrones.P8;
import org.newdawn.slick.Color;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
 
public class MenuGame extends BasicGameState{
	
	private StateBasedGame game; // stored for later use
	Music m;
 
    @Override
    public void init(GameContainer container, StateBasedGame game)
            throws SlickException {
        this.game = game;
		m = new Music("data/musica.ogg");
		m.loop();
    }
 
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException {
        g.setColor(Color.white);
        g.drawString("Juego del Laberinto", 50, 10);
     
        g.drawString("1. Laberinto Bosque", 50, 100);
        g.drawString("2. Laberinto Mazmorra", 50, 120);
        g.drawString("3. Quit", 50, 140);
    }
 
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException {
        // TODO Auto-generated method stub
 
    }
 
    @Override
    public int getID() {
        // TODO Auto-generated method stub
        return 0;
    }
    
    public void keyReleased(int key, char c) {
    	GameClient.prevState = this;
        switch(key) {
        case Input.KEY_1:
            game.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
            break;
        case Input.KEY_2:
        	game.enterState(2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
            break;
        case Input.KEY_3:
            System.exit(Input.KEY_3);
            break;
        default:
            break;
        }
    }
 
}
