package ull.etsii.Patrones.P1E2;

import org.newdawn.slick.Graphics;

import ull.etsii.Patrones.P7.IHabitacion;

public class Heroe extends Personaje{
	//public IEstado estado;
	public int nivel;
	//public IClase clase;
	
	public Heroe(IEstado est, int vida, int mana, int ata, int def, int matk, int mdef, IHabitacion Hab, int niv/*, IClase cla*/){
		super(est, vida, mana, ata, def, matk, mdef, Hab);
		//clase = cla;
		nivel = niv;
	}
	
	public Heroe(IEstado est, int vida, int mana, int ata, int def, int matk, int mdef,
			int niv) {
		super(est, vida, mana, ata, def, matk, mdef);
		//clase = cla;
		nivel = niv;
	}

	public void setStatus(IEstado newStatus){
		estado = newStatus;
	}
	
	public void mostrar(){
		String Status = estado.getStatus();
		System.out.println("Heroe - Nivel: " + nivel);
		System.out.println("Estado: " + Status);
		System.out.println("HP: " + HP);
		System.out.println("SP: " + SP);
	}

	public void mostrar(Graphics g) {
		String Status = estado.getStatus();
		g.drawString("Heroe - Nivel: " + nivel, 100,120);
		g.drawString("Estado: " + Status, 100,140);
		g.drawString("HP: " + HP, 100,160);
		g.drawString("SP: " + SP, 100,180);
	}
}
