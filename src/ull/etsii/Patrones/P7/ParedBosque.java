package ull.etsii.Patrones.P7;

import ull.etsii.Patrones.P1E2.Personaje;

public class ParedBosque implements IPared {

	@Override
	public void Entrar(Personaje P) {
		System.out.println("No se puede ir por aquí, hay muchos árboles.");
	}

	@Override
	public void describe() {
		System.out.println("Una especie de pared hecha de un montón de árboles");
	}

}
