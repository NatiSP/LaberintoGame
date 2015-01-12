package ull.etsii.Patrones.P7;

import ull.etsii.Patrones.P1E2.Personaje;

public class ParedMazmorra implements IPared {

	@Override
	public void Entrar(Personaje P) {
		System.out.println("No se puede ir por aquí, hay una pared.");
	}

	@Override
	public void describe() {
		System.out.println("Una pared de piedra.");
	}

}
