package test;

import org.junit.Test;

import grafo.Coloreo;
import grafo.GrafoNDNP;

public class GrafoTest {

	@Test
	public void pruebaDeColoreoAleatorioSecuencialUno(){
		GrafoNDNP grafoUno = new GrafoNDNP(PATH_ARCHIVOS + "grafoUno.in");
		
		System.out.println("GRAFO 1 :");
		grafoUno.getColoreo().aleatorioSecuencial();
		grafoUno.getColoreo().printearColoreo();
	}
	
	@Test
	public void pruebaDeColoreoAleatorioSecuencialDos(){
		GrafoNDNP grafoDos = new GrafoNDNP(PATH_ARCHIVOS + "grafoDos.in");
		
		System.out.println("GRAFO 2 :");
		grafoDos.getColoreo().aleatorioSecuencial();
		grafoDos.getColoreo().printearColoreo();
	}
	
	@Test
	public void pruebaDeColoreoWelshPowell(){
		GrafoNDNP grafoTres = new GrafoNDNP(PATH_ARCHIVOS + "grafoTres.in");
		
		System.out.println("GRAFO 3 :");
		grafoTres.getColoreo().resolucionWelshPowell();
		grafoTres.getColoreo().printearColoreo();
	}
	
	@Test
	public void pruebaDeColoreoMatula(){
		GrafoNDNP grafoTres = new GrafoNDNP(PATH_ARCHIVOS + "grafoTres.in");
		
		System.out.println("GRAFO 4 :");
		grafoTres.getColoreo().resolucionMatula();
		grafoTres.getColoreo().printearColoreo();
	}
	
	private static final String PATH_ARCHIVOS = "PreparacionDePrueba/LoteDePrueba/IN/";
}
