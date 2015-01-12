package ull.etsii.Patrones.P1E2;

import org.newdawn.slick.Graphics;

import ull.etsii.Patrones.P7.IHabitacion;

public class Enemigo extends Personaje{
	//public IEstado estado;
	//public IClase clase;
	
	public Enemigo(IEstado est, int vida, int mana, int ata, int def, int matk, int mdef, IHabitacion Hab/*, IClase cla*/){
		super(est, vida, mana, ata, def, matk, mdef, Hab);

		//clase = cla;
	}
	
	public Enemigo(IEstado est, int vida, int mana, int ata, int def, int matk, int mdef/*, IClase cla*/){
		super(est, vida, mana, ata, def, matk, mdef);
	}

	public void setStatus(IEstado newStatus){
		estado = newStatus;
	}
	
	public void mostrar(){
		System.out.println("Enemigo");
		//System.out.print("Estado: ");
		//System.out.println(estado.getStatus());
		System.out.println("HP: " + HP);
		System.out.println("SP: " + SP);
	}

	public void mostrar(Graphics g) {
		String Status = estado.getStatus();
		g.drawString("Dragon", 200,120);
		g.drawString("Estado: " + Status, 200,140);
		g.drawString("HP: " + HP, 200,160);
		g.drawString("SP: " + SP, 200,180);
	}
	

}