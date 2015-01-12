package ull.etsii.Patrones.P7;

public interface ILaberintoFactory {
	Laberinto crearLaberinto();
	
	IPared crearPared();

	IPuerta crearPuerta(IHabitacion h1, IHabitacion h2);

	Laberinto fabricarLaberinto();

	IHabitacion crearHabitacion(int n, String a);
}
