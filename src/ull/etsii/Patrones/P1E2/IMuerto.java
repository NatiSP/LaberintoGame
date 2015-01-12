package ull.etsii.Patrones.P1E2;

public class IMuerto implements IEstado{
	String estadoPersonaje;
	
	public IMuerto(){
		estadoPersonaje = "Muerto";
	}
	
	public void attackCommand(Personaje P){
		//do nothing
	}
	
	public void defendCommand(Personaje P){
		//do nothing
	}
	
	public void magicCommand(Personaje P){
	
	}
	
	public String getStatus(){
		return "Muerto";
	}
}