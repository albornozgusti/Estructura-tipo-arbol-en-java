package Arbol;

import Main.DatoRaiz;
import Main.Metabolismo;
import Main.Reproduccion;

public class NodoGeneral 
{
	private Object dato;
	private DatoRaiz datoraiz;
	private Lista listahijos;
	
	public NodoGeneral(){
		listahijos= new ListaconArreglo();	
	}
	
	public void setMetabolismoReproduccion(Metabolismo metabolismo, Reproduccion reproduccion){
		this.datoraiz=new DatoRaiz(metabolismo, reproduccion);
	}
	
	public Metabolismo getMetabolismo(){
		return datoraiz.getMetabolismo();
	}
	
	public Reproduccion getReproduccion(){
		return datoraiz.getReproduccion();
	}
	
	public void setMetabolismo(Metabolismo metabolismo){
		this.datoraiz.setMetabolismo(metabolismo);
	}
	
	public void setReproduccion(Reproduccion reproduccion){
		this.datoraiz.setReproduccion(reproduccion);
	}
	
	public Object getDato(){
		return dato;
	}
	
	public void setDato(Object dato){
		this.dato = dato;
	}
	
	public Lista getHijos(){
		return listahijos;
	}
	
	public void setHijos(Lista listahijos){
		this.listahijos =listahijos;
	}
	
	public Lista getListahijos(){
		return listahijos;
	}
}