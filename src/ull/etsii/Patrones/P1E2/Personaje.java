package ull.etsii.Patrones.P1E2;

import ull.etsii.Patrones.P7.IHabitacion;

public class Personaje{
	public IEstado estado;
	public int HP;
	public int SP;
	public int Attack;
	public int Defense;
	public int MagicalAttack;
	public int MagicalDefense;
	public IHabitacion Ubicacion;
	
	public Personaje(IEstado est, int vida, int mana, int ata, int def, int matk, int mdef, IHabitacion Hab){
		estado = est;
		HP = vida;
		SP = mana;
		Attack = ata;
		Defense = def;
		MagicalAttack = matk;
		MagicalDefense = mdef;
		Ubicacion = Hab;
	}
	
	public Personaje(IEstado est, int vida, int mana, int ata, int def,
			int matk, int mdef) {
		estado = est;
		HP = vida;
		SP = mana;
		Attack = ata;
		Defense = def;
		MagicalAttack = matk;
		MagicalDefense = mdef;
	}

	public IHabitacion getUbicacion(){
		return Ubicacion;
	}
	
	public void mover(IHabitacion H){
		Ubicacion = H;
	}
	
	public void cambiarUbicacion(IHabitacion H){
		Ubicacion = H;
	}
	
	public void attack(Personaje P){
		estado.attackCommand(P);
	}
	
	public void magic(Personaje P){
		estado.magicCommand(P);
	}
	
	public void defend(Personaje P){
		estado.defendCommand(P);
	}
	
	public void modifyHP(int cant){
		HP = HP+cant;
	}
	
	public void modifySP(int cant){
		SP = SP+cant;
	}
	
	public void modifyDefense(int cant){
		Defense = Defense + cant;
	}
	
	
}