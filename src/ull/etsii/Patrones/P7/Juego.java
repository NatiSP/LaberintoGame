package ull.etsii.Patrones.P7;

import java.util.Random;
import java.util.Scanner;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import ull.etsii.Patrones.P1E2.*;
import ull.etsii.Patrones.P8.*;

public class Juego{
	

	public void EjecutarCombate(Personaje P1, Personaje P2, Personaje P3){
		
		System.out.println("¡Hay un dragon en la habitacion!");
		Combate(P1,P2,P3);
	}
	
	public static void Combate(Personaje P1, Personaje P2, Personaje P3){
		boolean salir = false;
		Scanner accion = new Scanner(System.in);
		Random aleatorio = new Random();
		
		while (!salir){
			((Heroe) P1).mostrar();
			System.out.println("----------------------------");
			((Heroe) P2).mostrar();
			System.out.println("#############################");
			((Enemigo) P3).mostrar();
			System.out.println("#############################");
			System.out.println("##Elige la accion a realizar para el heroe 1##");
			System.out.println("##A: Atacar | M: Ataque magico | D: Defender y recuperar vida##");
			switch(accion.nextLine()){
			case "A":
				P1.attack(P3);
				break;
			case "M":
				P1.magic(P3);
				break;
			case "D":
				P1.defend(P1);
				break;
				
			}
			//do action
			System.out.println("##Elige la accion a realizar para el heroe 2##");
			System.out.println("##A: Atacar | M: Ataque magico | D: Defender y recuperar vida##");
			switch(accion.nextLine()){
			case "A":
				P2.attack(P3);
				break;
			case "M":
				P2.magic(P3);
				break;
			case "D":
				P2.defend(P2);
				break;
				
			}
			switch(aleatorio.nextInt(5))
			{
			case 0:{
				((Enemigo) P3).attack(P1);
				System.out.println("¡El Dragón atacó al héroe 1!");
			}
				break;
			case 1:{
				((Enemigo) P3).attack(P2);
				System.out.println("¡El Dragón atacó al héroe 2!");
			}
				break;
			case 2:{
				((Enemigo) P3).magic(P2);
				System.out.println("¡El Dragón lanzó fuego al héroe 1!");
			}
				break;
			case 3:{
				((Enemigo) P3).magic(P2);
				System.out.println("¡El Dragón lanzó fuego al héroe 2!");
			}
				break;
			case 4:
				((Enemigo) P3).defend(P3);
				System.out.println("¡El Dragón se protegió y se curó!");
				break;
			}
			//do action
			//do things
			if(P1.HP > 0 && P1.estado.getStatus().equalsIgnoreCase("Muerto"))
				((Heroe) P1).setStatus(new INormal());
			if(P2.HP > 0 && P2.estado.getStatus().equalsIgnoreCase("Muerto"))
				((Heroe) P2).setStatus(new INormal());
			if(P1.HP < 1 && P1.estado.getStatus().equalsIgnoreCase("OK"))
				((Heroe) P1).setStatus(new IMuerto());
			if(P2.HP < 1 && P2.estado.getStatus().equalsIgnoreCase("OK"))
				((Heroe) P2).setStatus(new IMuerto());
			if(P3.HP < 1)
				((Enemigo) P3).setStatus(new IMuerto());
			if((P1.estado.getStatus().equalsIgnoreCase("Muerto") && P2.estado.getStatus().equalsIgnoreCase("Muerto"))
					|| P3.estado.getStatus().equalsIgnoreCase("Muerto")){
				((Heroe) P1).mostrar();
				System.out.println("-----------------------------");
				((Heroe) P2).mostrar();
				System.out.println("#############################");
				((Enemigo) P3).mostrar();
				System.out.println("Se acabó la batalla.");
				salir = true;
			}
		}
	}
	
	public static void Combate(Personaje P1, Personaje P3){
		boolean salir = false;
		Scanner accion = new Scanner(System.in);
		Random aleatorio = new Random();
		
		while (!salir){
			((Heroe) P1).mostrar();
			System.out.println("#############################");
			((Enemigo) P3).mostrar();
			System.out.println("#############################");
			System.out.println("##Elige la accion a realizar para el heroe 1##");
			System.out.println("##A: Atacar | M: Ataque magico | D: Defender y recuperar vida##");
			switch(accion.nextLine()){
			case "A":
				P1.attack(P3);
				break;
			case "M":
				P1.magic(P3);
				break;
			case "D":
				P1.defend(P1);
				break;
				
			}
			
			switch(aleatorio.nextInt(3))
			{
			case 0:{
				((Enemigo) P3).attack(P1);
				System.out.println("¡El Dragón atacó al héroe 1!");
			}
				break;
			case 1:{
				((Enemigo) P3).magic(P1);
				System.out.println("¡El Dragón lanzó fuego al héroe 1!");
			}
				break;
			case 2:
				((Enemigo) P3).defend(P3);
				System.out.println("¡El Dragón se protegió y se curó!");
				break;
			}
			//do action
			//do things
			if(P1.HP > 0 && P1.estado.getStatus().equalsIgnoreCase("Muerto"))
				((Heroe) P1).setStatus(new INormal());
			if(P1.HP < 1 && P1.estado.getStatus().equalsIgnoreCase("OK"))
				((Heroe) P1).setStatus(new IMuerto());
			if(P3.HP < 1)
				((Enemigo) P3).setStatus(new IMuerto());
			if((P1.estado.getStatus().equalsIgnoreCase("Muerto"))
					|| P3.estado.getStatus().equalsIgnoreCase("Muerto")){
				((Heroe) P1).mostrar();
				System.out.println("#############################");
				((Enemigo) P3).mostrar();
				System.out.println("Se acabó la batalla.");
				salir = true;
			}
		}
	}
}