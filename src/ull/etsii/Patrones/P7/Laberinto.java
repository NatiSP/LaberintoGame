package ull.etsii.Patrones.P7;

import java.util.ArrayList;

public class Laberinto {
	ArrayList<IHabitacion> habitaciones = new ArrayList<IHabitacion>();
	
	public final void anadirHabitacion(IHabitacion habitacion){
		habitaciones.add(habitacion);
	}
	public final IHabitacion numeroDeHabitacion(int numero){
		for(int i = 0; i < habitaciones.size(); i++){
			if(habitaciones.get(i).getNum() == numero){
				//System.out.println("Habitacion " + i);
				return habitaciones.get(i);
			}
		}
		return null;
	}
	
}
