package grafo;

import java.util.Random;

public class GeneradorDeGrafos {
	int cantNodos;
	double porcAdyacencia;
	private boolean[] matrizEnVector;
	private int posiciones;
	
	public static GrafoNDNP generarAleatorioNYProbabilidad(int cantNodos,double probabilidad){	//Probabilidad ejemplo= 0,5
		Random arista = new Random();
		int cantAristas=0;
		MatrizSimetrica matriz=new MatrizSimetrica(cantNodos);
		Double aux = arista.nextDouble();
		for (int i = 0; i < cantNodos; i++) {
			for (int j = i+1; j < cantNodos; j++) {
				if(aux < probabilidad){
					matriz.setMatrizSimetrica(i, j);
					cantAristas++;
				}
				aux = arista.nextDouble();
			}
		}
		double porcentajeDeAdyacencia=(cantAristas *100/ matriz.getCantAristas());
		GrafoNDNP grafo=new GrafoNDNP(matriz,cantNodos,cantAristas,porcentajeDeAdyacencia);
		return grafo;
	}
	
//	public static Grafo generarAleatorioNYPorcAdyacencia(int cantNodos,double PorcentajeAdyacencia){
//		Random arista = new Random();
//		MatrizSimetrica matriz=new MatrizSimetrica(cantNodos);
//		int cantTotalAristas=matriz.getCantAristas();
//		Double aux = arista.nextDouble();
//		
//		for (int i = 0; i < cantNodos; i++) {
//			for (int j = i+1; j < cantNodos; j++) {
//				if(aux < ){
//					matriz.setMatrizSimetrica(i, j);
//					cantAristas++;
//				}
//				aux = arista.nextDouble();
//			}
//		}
//		
//		
//		Grafo grafo=new Grafo(matriz,cantNodos,cantAristas,porcentajeDeAdyacencia);
//		return grafo;
//	}
	
	
//	public static Grafo generarRegularNYGrado(int cantNodos, int grado) {
//		MatrizSimetrica matriz;
//		int cantidadAristas = 0;
//		double porcentajeDeAdyacencia;
//		
//		if(grado >= cantNodos) {
//			System.out.println("No se puede generar el grafo.");
//			return null;
//		}
//		
//		matriz = new MatrizSimetrica(cantNodos);
//		
//		if(cantNodos%2==0) {  // SITUACION: CANTNODOS ES PAR
//			if(grado%2==1) {
//				if(grado > 1) {
//					for (int i = 0; i < cantNodos; i++) {
//						matriz.setMatrizSimetrica(i, (i+1)%(cantNodos-1));
//					}
//				}
//				
//			}
//		}
//	}
	
	
	
	
}