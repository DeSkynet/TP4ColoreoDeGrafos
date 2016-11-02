package grafo;

import java.io.File;
import java.util.Scanner;

public class Grafo {
	private MatrizSimetrica matriz;
	private int cantidadDeNodos;
	private int cantidadDeAristas;
	private double porcentajeAdyacencia;
	private int gradoMaximo;
	private int gradoMinimo;
	
	public Grafo(String path) {
		Scanner entrada = null;
		
		try {
			entrada = new Scanner(new File(path));
			
			if(entrada.hasNextLine()) {
				this.cantidadDeNodos = entrada.nextInt();
				this.cantidadDeAristas = entrada.nextInt();
				
				matriz = new MatrizSimetrica(this.cantidadDeNodos);
				
				this.porcentajeAdyacencia = entrada.nextDouble();
				this.gradoMaximo = entrada.nextInt();
				this.gradoMinimo = entrada.nextInt();
				
				for(int i=0; i<this.cantidadDeAristas; i++) {
					int fila = entrada.nextInt();
					int columna = entrada.nextInt();
					matriz.setMatrizSimetrica(fila, columna);
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}  finally {
			entrada.close();
		}
	}
}
