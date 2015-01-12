package ull.etsii.Patrones.P7;

public class LaberintoBosqueFactory implements ILaberintoFactory {

	@Override
	public IPared crearPared() {
		return new ParedBosque();
	}

	@Override
	public IPuerta crearPuerta(IHabitacion h1, IHabitacion h2) {
		return new CaminoBosque(h1, h2);
	}

	@Override
	public IHabitacion crearHabitacion(int n, String a) {
		return new HabitacionBosque(n, a);
	}

	@Override
	public Laberinto fabricarLaberinto(){
		return new Laberinto();
	}
	
	@Override
	public Laberinto crearLaberinto(){
		Laberinto L = fabricarLaberinto();
		IHabitacion h1 = crearHabitacion(1, "data/MapaBosque1.tmx");
		IHabitacion h2 = crearHabitacion(2, "data/MapaBosque2.tmx");
		IHabitacion h3 = crearHabitacion(3, "data/MapaBosque3.tmx");
		IHabitacion h4 = crearHabitacion(4, "data/MapaBosque4.tmx");
		IHabitacion h5 = crearHabitacion(5, "data/MapaBosque5.tmx");
		L.anadirHabitacion(h1);
		L.anadirHabitacion(h2);
		L.anadirHabitacion(h3);
		L.anadirHabitacion(h4);
		L.anadirHabitacion(h5);
		IPuerta P1 = crearPuerta(h1,h2);
		IPuerta P2 = crearPuerta(h2,h3);
		IPuerta C1 = crearPuerta(h1,h4);
		IPuerta P3 = crearPuerta(h4,h5);
		
		h1.EstablecerLado(Direccion.NORTE, P1);
		h1.EstablecerLado(Direccion.ESTE, C1);
		h1.EstablecerLado(Direccion.SUR, crearPared());
		h1.EstablecerLado(Direccion.OESTE, crearPared());
		
		h2.EstablecerLado(Direccion.NORTE, crearPared());
		h2.EstablecerLado(Direccion.SUR, P1);
		h2.EstablecerLado(Direccion.ESTE, crearPared());
		h2.EstablecerLado(Direccion.OESTE, P2);
		
		h3.EstablecerLado(Direccion.NORTE, crearPared());
		h3.EstablecerLado(Direccion.SUR, crearPared());
		h3.EstablecerLado(Direccion.ESTE, P2);
		h3.EstablecerLado(Direccion.OESTE, crearPared());
		
		h4.EstablecerLado(Direccion.NORTE, crearPared());
		h4.EstablecerLado(Direccion.SUR, crearPared());
		h4.EstablecerLado(Direccion.ESTE, P3);
		h4.EstablecerLado(Direccion.OESTE, C1);
		
		h5.EstablecerLado(Direccion.NORTE, crearPared());
		h5.EstablecerLado(Direccion.SUR, crearPared());
		h5.EstablecerLado(Direccion.ESTE, crearPared());
		h5.EstablecerLado(Direccion.OESTE, P3);
		
		return L;
	}

}
