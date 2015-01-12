package ull.etsii.Patrones.P7;

import ull.etsii.Patrones.P1E2.Personaje;

public class HabitacionBosque implements IHabitacion {

	int NumeroHabitacion;
	
	String archivoMapa;
	
	final LugarDelMapa Lados[] = new LugarDelMapa[NUMLADOS];
	
	public HabitacionBosque(int n, String archivo) {
		NumeroHabitacion = n;
		archivoMapa = archivo;
	}
	
	public String getArchivo(){
		return archivoMapa;
	}

	@Override
	public void Entrar(Personaje P) {
		P.mover(this);
	}

	@Override
	public void describe() {
		System.out.println("Una estancia boscosa, rodeada de árboles.");
	}

	@Override
	public int getNum() {
		return NumeroHabitacion;
	}

	@Override
	public void EstablecerLado(Direccion direccion, LugarDelMapa lugardelmapa) {
		switch (direccion){
		case ESTE:{
			Lados[2] = lugardelmapa;
		}
			break;
		case NORTE:{
			Lados[0] = lugardelmapa;
		}
			break;
		case OESTE:{
			Lados[3] = lugardelmapa;
		}
			break;
		case SUR:{
			Lados[1] = lugardelmapa;
		}
			break;
		default:
			break;
		}
	}

	@Override
	public LugarDelMapa[] getElements() {
		return Lados;
	}

}
