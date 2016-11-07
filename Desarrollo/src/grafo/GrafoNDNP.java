package grafo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GrafoNDNP {
	private Coloreo coloreo;
	private MatrizSimetrica matriz;
	private int cantidadDeNodos;
	private int cantidadDeAristas;
	private double porcentajeAdyacencia;
	private int gradoMaximo;
	private int gradoMinimo;
	
	public GrafoNDNP(String path) {
		Scanner entrada = null;
		
		try {
			entrada = new Scanner(new File(path));
			
			if(entrada.hasNextLine()) {
				this.cantidadDeNodos = entrada.nextInt();
				this.cantidadDeAristas = entrada.nextInt();
				
				matriz = new MatrizSimetrica(this.cantidadDeNodos);		//Crea la matriz Simetrica
				
				this.porcentajeAdyacencia = entrada.nextDouble();
				this.gradoMaximo = entrada.nextInt();
				this.gradoMinimo = entrada.nextInt();
				
				for(int i=0; i<this.cantidadDeAristas; i++) {
					int fila = entrada.nextInt();
					int columna = entrada.nextInt();
					matriz.setMatrizSimetrica(fila, columna);
				}
				
				this.coloreo = new Coloreo(this.matriz);
			}
			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}  finally {
			entrada.close();
		}
	}
	
	
	public GrafoNDNP(MatrizSimetrica matriz, int cantNodos, int cantAristas, double PorcAdyacencia) {
		this.matriz=matriz;
		this.cantidadDeNodos=cantNodos;
		this.cantidadDeAristas=cantAristas;
		this.porcentajeAdyacencia=PorcAdyacencia;
	}
	
	public MatrizSimetrica getMatrizSimetrica() {
		return this.matriz;
	}
	
	public Coloreo getColoreo() {
		return coloreo;
	}
	
	public void grabarSalidaGrafo(String pathOut) {
		PrintWriter salida = null;
		
		try {
			salida = new PrintWriter(new File(pathOut));
			
			salida.print(this.coloreo.getCantNodos() + " " + this.coloreo.getCantidadDeColores() + " ");
			salida.print(this.coloreo.getCantAristas() + " " + this.porcentajeAdyacencia + " ");
			salida.println(this.gradoMaximo + " " + this.gradoMinimo);
			
			for (int i = 0; i < coloreo.getCantNodos(); i++) {
				salida.println(coloreo.nodos.get(i).getNumero() + " " + coloreo.nodos.get(i).getColor());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			salida.close();
		}
	}
	
}
