package ull.etsii.Patrones.P1E2;

public interface IEstado{
	
	void attackCommand(Personaje P);
	
	void magicCommand(Personaje P);
	
	void defendCommand(Personaje P);
	
	String getStatus();
}