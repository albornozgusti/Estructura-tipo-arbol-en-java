package Arbol;

import java.util.ArrayList;

public class ListaconArreglo extends Lista
{
	private int inicial;
	private ArrayList<Object> datos;
	
	public ListaconArreglo(){
		this.datos=new ArrayList();
		this.inicial=0;
	}

	@Override
	public Object elemento(int pos){ 
		return datos.get(pos);
	}

	@Override
	public void agregar(Object elem, int pos){
		datos.add(pos, elem);
		this.tamanio++;
	}

	@Override
	public void eliminar(int pos){
		datos.remove(pos);
		this.tamanio--;
	}

	@Override
	public boolean esvacia(){
		
		if (datos.isEmpty()==true)
            return true;		
        else
            return false;	
	}
	
	@Override
	public boolean incluye(Object elem) {	
		return (datos.contains(elem));
	}
}