package ull.etsii.Patrones.P8;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameClient extends StateBasedGame{

		static Music m;
		
		public static BasicGameState prevState = null;
	    /**
	     * @param args
	     */
	    public static void main(String[] args) {
    		try
    		{
    			AppGameContainer app = new AppGameContainer((org.newdawn.slick.Game) new GameClient("Laberinto Game"));
    			app.setForceExit(false);
    			app.setDisplayMode(640, 480, false);
    			app.setShowFPS(false);
    			app.start();
    			m = new Music("data/musica.ogg");
    			m.loop();
    		}
    		catch (SlickException e)
    		{
    			e.printStackTrace();
    		}
	    }
	 
	    public GameClient(String name) {
	        super(name);
	        // TODO Auto-generated constructor stub
	    }
	 
	    @Override
	    public void initStatesList(GameContainer container) throws SlickException {
	        addState(new MenuGame());
	        addState(new BosqueGame());
	        addState(new MazmorraGame());
	        addState(new Combate());
	    }

		public static int getID() {
			// TODO Auto-generated method stub
			return 0;
		}
	 
	}
