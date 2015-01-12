package ull.etsii.Patrones.P8;

import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
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
import org.newdawn.slick.tiled.TiledMap;

import ull.etsii.Patrones.P1E2.Enemigo;
import ull.etsii.Patrones.P1E2.Heroe;
import ull.etsii.Patrones.P1E2.INormal;
import ull.etsii.Patrones.P1E2.Personaje;
import ull.etsii.Patrones.P7.ILaberintoFactory;
import ull.etsii.Patrones.P7.Juego;
import ull.etsii.Patrones.P7.Laberinto;
import ull.etsii.Patrones.P7.LaberintoBosqueFactory;
import ull.etsii.Patrones.P7.LaberintoMazmorraFactory;

public class MazmorraGame extends BasicGameState{
	
	private StateBasedGame game; // stored for later use

	private TiledMap Map;
    private Animation sprite, up, down, left, right;
    private float x = 300f, y = 300f;

    /** The collision map indicating which tiles block movement - generated based on tile properties */
    private boolean[][] blocked;
    private boolean[][] exit;
    private int [][] salidas;
	private AppGameContainer container;
    private static final int SIZE = 33;
    
    public static final int gameState = 0;
    public static final int battleState = 1;
    public static int HabitacionMonstruo;
    public static int HabitacionSalida;
    
    public boolean Combate = false;
    
    static Laberinto L1;
	 static ILaberintoFactory JL;
	 
	 static Juego J;
	 
	 static Personaje H1;
	 static Personaje H2;
	 static Personaje M1;
	 
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		this.game = game;
		JL = new LaberintoMazmorraFactory();
		L1 = JL.crearLaberinto();
		HabitacionSalida = 3;
		HabitacionMonstruo = 2;
		
		J = new Juego();
		
	   	 //EjecutarJuego();
	  		H2 = new Heroe(new INormal(),20,10,4,4,4,4, L1.numeroDeHabitacion(1), 1);
	  		M1 = new Enemigo(new INormal(),60,25,10,10,10,10, L1.numeroDeHabitacion(HabitacionMonstruo));
	  		H1 = new Heroe(new INormal(),20,10,4,4,4,4, L1.numeroDeHabitacion(1), 1);
	        Image [] movementUp = {new Image("data/mika-4a.png"), new Image("data/mika-4b.png")};
	        Image [] movementDown = {new Image("data/mika-1a.png"), new Image("data/mika-1b.png")};
	        Image [] movementLeft = {new Image("data/mika-2a.png"), new Image("data/mika-2b.png")};
	        Image [] movementRight = {new Image("data/mika-3a.png"), new Image("data/mika-3b.png")};
	  		System.out.println(L1.numeroDeHabitacion(1).toString());
	        System.out.println(H1.getUbicacion().toString());
	        int [] duration = {300, 300};         Map = new TiledMap(H1.getUbicacion().getArchivo());

	         /*
	         * false variable means do not auto update the animation.
	         * By setting it to false animation will update only when
	         * the user presses a key.
	         */
	        up = new Animation(movementUp, duration, false);
	        down = new Animation(movementDown, duration, false);
	        left = new Animation(movementLeft, duration, false);
	        right = new Animation(movementRight, duration, false);

	        // Al iniciar el personaje mirará a la derecha
	        sprite = down;

	        // Mapas de colisiones y salidas basado en el tiled
	        blocked = new boolean[Map.getWidth()][Map.getHeight()];
	        exit = new boolean[Map.getWidth()][Map.getHeight()];
	        salidas = new int[Map.getWidth()][Map.getHeight()];
	        
	        //Se mira el mapa y se cargan los mapas de colisiones y salidas
	        crearLimites();
	}
	

    private boolean isBlocked(float x, float y)
    {
        int xBlock = (int)x / SIZE;
        int yBlock = (int)y / SIZE;
        return blocked[xBlock][yBlock];
    }
    
    private void movement(GameContainer container, int delta){
        Input input = container.getInput();
        boolean collision = false;
        if (input.isKeyDown(Input.KEY_UP))
        {
       	 {
       		 sprite = up;
       		 if (!isBlocked(x, y - delta * 0.1f))
       		 {
       			 collision = false;
       		 }
       		 for(int z = 0;z<SIZE;z++)
       		 {
       			 if (isBlocked(x + z, y - delta * 0.1f))
       			 {
       				 collision = true;
       				 z = SIZE;
       			 }
       		 }
       		 	if (!collision)
       		 	{
       		 		sprite.update(delta);
       		 		y -= delta * 0.1f;
       		 	}
       		 } 
        }
        else if (input.isKeyDown(Input.KEY_DOWN))
        {
       	 {
       		 sprite = down;
       		 if (!isBlocked(x, y + SIZE + delta * 0.1f))
       		 {
       			 collision = false;
       		 }
       		 for(int z = 0;z<SIZE;z++)
       		 {
       			 if (isBlocked(x + z, y + SIZE + delta * 0.1f))
       			 {
       				 collision = true;
       				 z = SIZE;
       			 }
       		 }
       		 	if (!collision)
       		 	{
       		 		sprite.update(delta);
       		 		y += delta * 0.1f;
       		 	}
       		 } 
        }
        else if (input.isKeyDown(Input.KEY_LEFT))
        {
       	 {
       		 sprite = left;
       		 if (!isBlocked(x-delta * 0.1f, y))
       		 {
       			 collision = false;
       		 }
       		 for(int z = 0;z<SIZE;z++)
       		 {
       			 if (isBlocked(x - delta * 0.1f, y + z))
       			 {
       				 collision = true;
       				 z = SIZE;
       			 }
       		 }
       		 	if (!collision)
       		 	{
       		 		sprite.update(delta);
       		 		x -= delta * 0.1f;
       		 	}
       		 } 
        }
        else if (input.isKeyDown(Input.KEY_RIGHT))
        {
       	 {
       		 sprite = right;
       		 if (!isBlocked(x + SIZE + delta * 0.1f, y))
       		 {
       			 collision = false;
       		 }
       		 for(int z = 0;z<SIZE;z++)
       		 {
       			 if (isBlocked(x + SIZE + delta * 0.1f, y + z))
       			 {
       				 collision = true;
       				 z = SIZE;
       			 }
       		 }
       		 	if (!collision)
       		 	{
       		 		sprite.update(delta);
       		 		x += delta * 0.1f;
       		 	}
       		 } 
        }
    }
    private boolean isInExit(float x, float y){
        int xBlock = (int)x / SIZE;
        int yBlock = (int)y / SIZE;
        return exit[xBlock][yBlock];
   	 
    }
    
    private void crearLimites(){
        for (int xAxis=0;xAxis<Map.getWidth(); xAxis++)
        {
             for (int yAxis=0;yAxis<Map.getHeight(); yAxis++)
             {
           	  blocked[xAxis][yAxis] = false;
           	  exit[xAxis][yAxis] = false;
                 int tileID = Map.getTileId(xAxis, yAxis, 2);
                 String value = Map.getTileProperty(tileID, "blocked", "false");
                 if ("true".equals(value))
                 {
                     blocked[xAxis][yAxis] = true;
                 }
                 value = Map.getTileProperty(tileID, "exit", "false");
                 if ("true".equals(value))
                 {
                     exit[xAxis][yAxis] = true;
                 }
                 value = Map.getTileProperty(tileID, "habitacion", "0");
                 salidas[xAxis][yAxis] = Integer.parseInt(value);
             }
         }
    }


	@Override
	public void render(GameContainer container, StateBasedGame SBG, Graphics g)
			throws SlickException {
        Map.render(0, 0);
        sprite.draw((int)x, (int)y);
        if(H1.Ubicacion.equals(L1.numeroDeHabitacion(HabitacionMonstruo)) && M1.HP > 0)
        	container.getGraphics().drawString("¡¡Combate!!", 200, 200);
        if(H1.Ubicacion.equals(L1.numeroDeHabitacion(HabitacionSalida))){
        	g.drawString("¡Felicidades,  has llegado al final del laberinto!", 100, 200);
        }
        if(H1.HP <= 0 && H2.HP <= 0){
        	g.drawString("GAME OVER", 200, 200);
        }
	}

	@Override
	public void update(GameContainer container, StateBasedGame SBG, int delta)
			throws SlickException {
   	 	//Realiza el movimiento del personaje
   	 	movement(container, delta);
   	 
   	 	//Comprobar si esta en la habitacion de un monstruo y si es asi, pelear (por consola)
   	 	if(H1.getUbicacion().equals(M1.getUbicacion()) && M1.HP > 0){
   	 		GameClient.prevState = this;
   	 		game.enterState(3, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
   	 		M1.HP = 0;
   	 	}
   	 
   	 	//Comprobar si esta en una puerta y si es así, cambiar el mapa
   	 
   	 	//Poner parametro de "mapa al que ir" en las salidas de cada mapa.
   	 	if(isInExit(x, y)){
   	 		System.out.println("Hay una salida aqui");
   	 		int habSalida;
            int xBlock = (int)x / SIZE;
            int yBlock = (int)y / SIZE;
   		 	habSalida = salidas[xBlock][yBlock];
   		 	x = 150;
   		 	y = 150;
   		 
   		 	//Cambiar la ubicación del personaje
   		 	H1.cambiarUbicacion(L1.numeroDeHabitacion(habSalida));
   		 
   		 	Map = new TiledMap(H1.getUbicacion().getArchivo());
   		 	crearLimites();
   	 	}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}
	
    public void keyReleased(int key, char c) {
        switch(key) {
        case Input.KEY_ESCAPE:
            game.enterState(0, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
            break;
        default:
            break;
        }
    }

}
