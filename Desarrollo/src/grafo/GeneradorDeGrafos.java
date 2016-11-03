package grafo;

import java.util.Random;

public class GeneradorDeGrafos {
	int cantNodos;
	double porcAdyacencia;
	private boolean[] matrizEnVector;
	private int posiciones;
	
	public static Grafo generarAleatorioNYProbabilidad(int cantNodos,double probabilidad){	//Probabilidad ejemplo= 0,5
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
		Grafo grafo=new Grafo(matriz,cantNodos,cantAristas,porcentajeDeAdyacencia);
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
	
	
	
	
	
	
	
}