package ull.etsii.Patrones.P7;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

public class GameGUI extends BasicGame
{
	
	private TiledMap map = null;
	
	public GameGUI(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		map = new TiledMap("src/MapaMazmorra.tmx");
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		map.render(0,0);
	}

	public static void Ejecutar()
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new GameGUI("Mapa"));
			appgc.setDisplayMode(640, 480, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
