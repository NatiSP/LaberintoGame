package ull.etsii.Patrones.P7;

public interface IHabitacion extends LugarDelMapa{

	public static int NUMLADOS = 4;
	public static String archivoMapa = null;
	
	public int getNum();
	
	public void EstablecerLado(Direccion direccion, LugarDelMapa lugardelmapa);
	
	LugarDelMapa[] getElements();

	public String getArchivo();
}
