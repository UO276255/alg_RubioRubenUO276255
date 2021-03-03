package algestudiante.p01;

public class Main {

	public static void main(String[] args) {
		MatrizOperaciones mx = new MatrizOperaciones("files/matriz02.txt");
		mx.recorrerCamino(6,6);
		mx.escribir();
	}

}
