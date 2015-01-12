package ull.etsii.Patrones.P1E2;

public class INormal implements IEstado{
	String estadoPersonaje;
	
	public INormal(){
		estadoPersonaje = "OK";
	}
	
	public void attackCommand(Personaje P){
		P.modifyHP(-10);
	}
	
	public void defendCommand(Personaje P){
		P.modifyHP(15);
	}
	
	public String getStatus(){
		return "OK";
	}

	public void magicCommand(Personaje P) {
		P.modifyHP(-15);
	}


}