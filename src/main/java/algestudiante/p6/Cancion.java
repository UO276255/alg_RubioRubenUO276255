package algestudiante.p6;

public class Cancion {

	private String code;
	private int minutos;
	private int segundos;
	private int puntuacion;
	
	public Cancion(String code, int minutos, int segundos, int puntuacion) {
		
		this.code = code;
		this.minutos = minutos;
		this.segundos = segundos;
		this.puntuacion = puntuacion;
	}

	public String getCode() {
		return code;
	}

	public int getPuntuacion() {
		return puntuacion;
	}
	
	public int getTime() {
		return (minutos*60) + segundos;
	}
	
	
}
