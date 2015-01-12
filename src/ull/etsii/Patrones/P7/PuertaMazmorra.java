package ull.etsii.Patrones.P7;

import ull.etsii.Patrones.P1E2.Personaje;

public class PuertaMazmorra implements IPuerta {

	public IHabitacion Hab1 = null;
	public IHabitacion Hab2 = null;
	boolean estaAbierta = true;
	
	PuertaMazmorra(IHabitacion H1, IHabitacion H2){
		Hab1 = H1;
		Hab2 = H2;
	}
	
	@Override
	public void Entrar(Personaje P) {
		if(estaAbierta){
			P.mover(otroLadoDe(P.getUbicacion()));
		}
		else
			System.out.println("La puerta está cerrada.");
	}

	@Override
	public void describe() {
		System.out.println("Una puerta.");
	}

	@Override
	public IHabitacion otroLadoDe(IHabitacion habitacion) {
		if(habitacion == Hab1){
			return Hab2;
		}
		else
			return Hab1;
	}

}
