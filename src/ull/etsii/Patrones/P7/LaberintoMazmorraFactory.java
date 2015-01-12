package ull.etsii.Patrones.P7;

public class LaberintoMazmorraFactory implements ILaberintoFactory {

	@Override
	public Laberinto fabricarLaberinto(){
		return new Laberinto();
	}
	
	@Override
	public IPared crearPared() {
		return new ParedMazmorra();
	}

	@Override
	public IPuerta crearPuerta(IHabitacion h1, IHabitacion h2) {
		return new PuertaMazmorra(h1, h2);
	}
	
	@Override
	public Laberinto crearLaberinto(){
		Laberinto L = fabricarLaberinto();
		IHabitacion h1 = crearHabitacion(1, "data/MapaMazmorra1.tmx");
		IHabitacion h2 = crearHabitacion(2, "data/MapaMazmorra2.tmx");
		IHabitacion h3 = crearHabitacion(3, "data/MapaMazmorra3.tmx");
		L.anadirHabitacion(h1);
		L.anadirHabitacion(h2);
		L.anadirHabitacion(h3);
		IPuerta P1 = crearPuerta(h1,h2);
		IPuerta P2 = crearPuerta(h2,h3);
		
		h1.EstablecerLado(Direccion.NORTE, crearPared());
		h1.EstablecerLado(Direccion.ESTE, P1);
		h1.EstablecerLado(Direccion.SUR, crearPared());
		h1.EstablecerLado(Direccion.OESTE, crearPared());
		
		h2.EstablecerLado(Direccion.NORTE, P2);
		h2.EstablecerLado(Direccion.SUR, crearPared());
		h2.EstablecerLado(Direccion.ESTE, crearPared());
		h2.EstablecerLado(Direccion.OESTE, P1);
		
		h3.EstablecerLado(Direccion.NORTE, crearPared());
		h3.EstablecerLado(Direccion.SUR, P2);
		h3.EstablecerLado(Direccion.ESTE, crearPared());
		h3.EstablecerLado(Direccion.OESTE, crearPared());
		
		return L;
	}

	@Override
	public IHabitacion crearHabitacion(int n, String a) {
		return new HabitacionMazmorra(n,a);
	}

}
