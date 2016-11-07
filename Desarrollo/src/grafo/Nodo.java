package grafo;

public class Nodo implements Comparable<Nodo>{
	private int posicion;
	private int color;
	private int numero;
	private int grado;
	
	public Nodo() {
		this.posicion = 0;
		this.numero = 0;
		this.color = 0;
		this.grado = 0;
	}
	
	public Nodo(int posicion,int numero, int color, int grado) {
		this.posicion = posicion;
		this.numero = numero;
		this.color = color;
		this.grado = grado;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}
	
	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	@Override
	public int compareTo(Nodo o) {
		Integer gradoA = this.grado;
		Integer gradoB = o.grado;
		
		return gradoA.compareTo(gradoB);
	}
	
	
}
