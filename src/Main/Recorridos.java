package Main;

import Arbol.ArbolGeneral;
import Arbol.Cola;
import Arbol.Lista;
import Arbol.ListaconArreglo;
import Arbol.NodoGeneral;
import Arbol.Recorredor;

public class Recorridos {
	
	
	 public static ArbolGeneral siExiste(String tipo,ArbolGeneral arbol){
		 //recursivo
		 ArbolGeneral retornable=null;// OOOOOO
		 boolean flag = true;	

	    	if (arbol.getHijos().getTamanio()>0){	    		
	    		Recorredor reco=new Recorredor(arbol.getHijos());
	    		reco.comenzar();
	    		while (reco.fin()){			
	    			ArbolGeneral actual = (ArbolGeneral) reco.elemento();
	    			//CASO DONDE SE FIJA SI EXISTE 
	    			if (actual.getDatoRaiz().equals(tipo)){
	    				flag=false;
	    				return actual; //va a ser utilizado...
	    			}
	    			reco.proximo();
	    		}
	    	}
	    	
	    	if(flag==true){
	    		retornable=new ArbolGeneral();
	    		retornable.setdatoraiz(tipo);
	    		arbol.agregarHijo(retornable);
	    		return retornable;	
	    	}
	    	return retornable;
	    }
}