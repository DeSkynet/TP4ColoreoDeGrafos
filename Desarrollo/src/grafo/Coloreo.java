package grafo;

import java.util.ArrayList;

public class Coloreo {
	private int cantNodos;
	private int cantAristas;
	ArrayList<Nodo> nodos;
	private MatrizSimetrica matrizSimetrica;
	private int cantidadDeColores;
	
	public Coloreo(MatrizSimetrica matrizSimetrica) {
		this.matrizSimetrica = matrizSimetrica;
		this.nodos = new ArrayList<Nodo>();
		this.cantNodos = matrizSimetrica.getPosiciones();
		this.cantAristas = matrizSimetrica.getCantAristas();
		
		 for (int i = 0; i < this.cantNodos; i++) {
			nodos.add(new Nodo(i, 0, 0));
		}
		 
		for (int i = 0; i < this.cantNodos; i++) {
			for (int j = i+1; j < this.cantNodos; j++) {
				if(matrizSimetrica.getMatrizSimetrica(i, j)==true) {
					nodos.get(i).setGrado(nodos.get(i).getGrado() +1);
					nodos.get(j).setGrado(nodos.get(j).getGrado() +1);
				}	
			}
		}
	}
	
	
	public void aleatorioSecuencial() {
		for (int i = 0; i < this.cantNodos; i++) {
			nodos.get(i).setColor(1);
			
			Boolean coincideColor = false;
			Boolean finWhile = false;
			
			while(!finWhile) {
				for (int j = 0; j < this.cantNodos; j++)
					if(nodos.get(i).getNumero()!= j && matrizSimetrica.getMatrizSimetrica(nodos.get(i).getNumero(), j) == true)
						if(nodos.get(i).getColor() == nodos.get(j).getColor())
							coincideColor = true;
					
					if(coincideColor) {
						nodos.get(i).setColor(nodos.get(i).getColor() + 1);
						coincideColor = false;
						finWhile = false;
					} else	
						finWhile = true;
					
					if(nodos.get(i).getColor() > this.cantidadDeColores)
						this.cantidadDeColores = nodos.get(i).getColor();
			}
		}
	}
	
	public void resolucionMatula() {
		for (int i = 0; i < this.cantNodos; i++) {
			for (int j = i+1; j < this.cantNodos; j++) {
				if(nodos.get(i).getGrado() > nodos.get(j).getGrado()) {
					Nodo auxiliar = nodos.get(i);
					nodos.set(i, nodos.get(j));
					nodos.set(j, auxiliar);
				} else {
					if(nodos.get(i).getGrado() == nodos.get(j).getGrado() && 
							nodos.get(i).getNumero() < nodos.get(j).getNumero()) {
						Nodo auxiliar = nodos.get(i);
						nodos.set(i, nodos.get(j));
						nodos.set(j, auxiliar);
					}
				}
			}
		}
		matula();
	}
	
	public void matula() {
		int i, color;
		
		for(i=0; i<cantNodos; i++) {
			color = 1;
			while(!sePuedeColorear(i, color))
				color++;
			
			nodos.get(i).setColor(color);
			if(color > this.cantidadDeColores)
				this.cantidadDeColores = color;
		}
	}
	
	private boolean sePuedeColorear(int n, int color) {
		int i=0; 
		if(nodos.get(n).getColor() != 0) //si el nodo fue coloreado 
			return false;
		//no puedo colorear
		while(i < cantNodos) {
			if(nodos.get(i).getColor() == color) {  //si el nodo a colorear es adyacente a un nodo ya pintado de ese
				if(esAdyacente(nodos.get(i), nodos.get(n)))  //color, no lo podré colorear
					return false;
			}
			i++;
		}
		return true;
	}
	
	private boolean esAdyacente(Nodo nodo1, Nodo nodo2) {
		return matrizSimetrica.getMatrizSimetrica(nodo1.getNumero(), nodo2.getNumero()) == true;
	}
	
	public void resolucionWelshPowell() {
		for (int i = 0; i < this.cantNodos; i++) {
			for (int j = i+1; j < this.cantNodos; j++) {
				if(nodos.get(i).getGrado() < nodos.get(j).getGrado()) {
					Nodo auxiliar = nodos.get(i);
					nodos.set(i, nodos.get(j));
					nodos.set(j, auxiliar);
				}
			}
		}
		welshPowell();
	}
	
	public void welshPowell() {
		for (int i = 0; i < this.cantNodos; i++) {
			nodos.get(i).setColor(1);
			
			Boolean coincideColor = false;
			Boolean finWhile = false;
			
			while(!finWhile) {
				for (int j = 0; j < this.cantNodos; j++)
					if(nodos.get(i).getNumero()!= j && matrizSimetrica.getMatrizSimetrica(nodos.get(i).getNumero(), j) == true)
						if(nodos.get(i).getColor() == nodos.get(j).getColor())
							coincideColor = true;
					
				if(coincideColor) {
					nodos.get(i).setColor(nodos.get(i).getColor() + 1);
					coincideColor = false;
					finWhile = false;
				} else	
					finWhile = true;
				
				if(nodos.get(i).getColor() > this.cantidadDeColores)
					this.cantidadDeColores = nodos.get(i).getColor();
			}
		}
	}
	
	public int getCantNodos() {
		return cantNodos;
	}


	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}


	public int getCantAristas() {
		return cantAristas;
	}


	public void setCantAristas(int cantAristas) {
		this.cantAristas = cantAristas;
	}


	public int getCantidadDeColores() {
		return cantidadDeColores;
	}


	public void setCantidadDeColores(int cantidadDeColores) {
		this.cantidadDeColores = cantidadDeColores;
	}

	public void printearColoreo() {
		for (int i = 0; i < this.cantNodos; i++) {
			System.out.print("Nodo:" + nodos.get(i).getNumero());
			System.out.print(" Grado:" + nodos.get(i).getGrado());
			System.out.println(" Color:" + nodos.get(i).getColor());
		}
	}
}
