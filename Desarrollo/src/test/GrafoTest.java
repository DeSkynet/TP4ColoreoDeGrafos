package test;

import org.junit.Test;

import grafo.Coloreo;
import grafo.Grafo;

public class GrafoTest {

	@Test
	public void pruebaDeColoreoAleatorioSecuencialUno(){
		Grafo grafoUno = new Grafo(PATH_ARCHIVOS + "grafoUno.in");
		Coloreo testUno;
		
		System.out.println("GRAFO 1 :");
		testUno = new Coloreo(grafoUno.getMatrizSimetrica());
		testUno.aleatorioSecuencial();
		testUno.printearColoreo();
	}
	
	@Test
	public void pruebaDeColoreoAleatorioSecuencialDos(){
		Grafo grafoDos = new Grafo(PATH_ARCHIVOS + "grafoDos.in");
		Coloreo testDos;
		
		System.out.println("GRAFO 2 :");
		testDos = new Coloreo(grafoDos.getMatrizSimetrica());
		testDos.aleatorioSecuencial();
		testDos.printearColoreo();
	}
	
	@Test
	public void pruebaDeColoreoWelshPowell(){
		Grafo grafoTres = new Grafo(PATH_ARCHIVOS + "grafoTres.in");
		Coloreo testTres;
		
		System.out.println("GRAFO 3 :");
		testTres = new Coloreo(grafoTres.getMatrizSimetrica());
		testTres.resolucionWelshPowell();
		testTres.printearColoreo();
	}
	
	@Test
	public void pruebaDeColoreoMatula(){
		Grafo grafoTres = new Grafo(PATH_ARCHIVOS + "grafoTres.in");
		Coloreo testTres;
		
		System.out.println("GRAFO 4 :");
		testTres = new Coloreo(grafoTres.getMatrizSimetrica());
		testTres.resolucionMatula();
		testTres.printearColoreo();
	}
	
	private static final String PATH_ARCHIVOS = "PreparacionDePrueba/LoteDePrueba/IN/";
}
