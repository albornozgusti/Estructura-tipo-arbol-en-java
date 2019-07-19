package Arbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ArbolGeneral {
	
	private NodoGeneral raiz;
	int pos;
	
	public ArbolGeneral ()
	{
		raiz = new NodoGeneral ();
	}
	
	public NodoGeneral getRaiz ()
	{
		return raiz;
	}
	
	private void setRaiz (NodoGeneral raiz)
	{
		this.raiz= raiz;
	}
	
	public  Object getDatoRaiz()
	{
		return raiz.getDato();
	}
	
	public void setdatoraiz(Object s)
	{
		raiz.setDato(s);
	}
	
	public Lista getHijos()
	{
		return raiz.getHijos();
	}

	public void agregarHijo(ArbolGeneral hijo)
    {
		raiz.getHijos().agregar(hijo,raiz.getHijos().getTamanio());
	}

    /*public void eliminarHijo(Lista hijo)
    {
    	raiz.getListahijos().recorredor(hijo).eliminar();
    }*/
    
    public void eliminarHijo(ArbolGeneral hijo)
	{
		if (raiz.getHijos().incluye(hijo)) {
			for (int i = 0; i < raiz.getHijos().getTamanio(); i++) {
				if (raiz.getHijos().elemento(i).equals(hijo))
					raiz.getHijos().eliminar(i);
			}
		}
	}
     
    //MODULO 2
    public void imprimo_por_nivel(){
    	//recorrido por niveles, imprime el arbol completo, hace falta retocarlo para su correcta representacion
    	String nivel1="Reino:  \t";
    	String nivel2="Filo:   \t";
    	String nivel3="clase:  \t";
    	String nivel4="Orden:  \t";
    	String nivel5="Familia:\t";
    	String nivel6="Genero: \t";
    	String nivel7="especie:\t";
    	
    	Cola c = new Cola();
    	c.push(this);
    	c.push(null);
    	int nivel=0;
    	
    	while (!c.esvacia()){		
    			Object temp=  c.pop();   			
    			if(temp==null){
    				nivel++;
    				if(nivel<8)
    					c.push(null);
    			}
    			else {
   					switch (nivel) {
   						case 1:
    						nivel1+=((ArbolGeneral) temp).getDatoRaiz()+" ";
    						break;
    					case 2:
    						nivel2+=((ArbolGeneral) temp).getDatoRaiz().toString()+" ";
    						break;
    					case 3:
    						nivel3+=((ArbolGeneral) temp).getDatoRaiz().toString()+" ";
    						break;
    					case 4:
    						nivel4+=((ArbolGeneral) temp).getDatoRaiz().toString()+" ";
    						break;
    					case 5:
    						nivel5+=((ArbolGeneral) temp).getDatoRaiz().toString()+" ";
    						break;
    					case 6:
    						nivel6+=((ArbolGeneral) temp).getDatoRaiz().toString()+" ";
    						break;
    					case 7:
    						nivel7+=((ArbolGeneral) temp).getDatoRaiz().toString()+" ";
    						break;
    					}
    					
    					Lista hijos= ((ArbolGeneral) temp).getHijos();
    					Recorredor rec = hijos.recorredor(hijos);
    					
    					rec.comenzar();   					
    					while(rec.fin()){		
    						ArbolGeneral hijo=  (ArbolGeneral) rec.elemento();
    						c.push( hijo);
    						rec.proximo();
    					}
    				}
    			}
    	System.out.println( nivel1);
    	System.out.println( nivel2);
    	System.out.println( nivel3);
    	System.out.println( nivel4);
    	System.out.println( nivel5);
    	System.out.println( nivel6);
    	System.out.println( nivel7);
    		}

    //MODULO 1 ELIMINACION
    public boolean eliminar(ArbolGeneral a, String destino){
    	//recorrido recursivo que cuando retorna elimina a los hijos cuando avanza a sus ancestros	    	
    	NodoGeneral nodo = a.getRaiz();//dato a comparar
    	
    	if (nodo.getHijos().esvacia()) { //compara si esta vacia
    		if (nodo.getDato().equals(destino))
    			return true;	
    	}
    	else{
    		Lista hijos =nodo.getHijos();
    		Recorredor rec = hijos.recorredor(hijos);	
    		rec.comenzar();
    		while (rec.fin()){//BUCLE
    			ArbolGeneral hijo = (ArbolGeneral) rec.elemento();
    			boolean esta =eliminar(hijo,destino);//cuanto esta en verdadore entra al if
    			if (esta){//ESTE IF
    				a.eliminarHijo(hijo);
    				
    				if(a.getHijos().esvacia()){	
    					return true;
    				}
    				else{	
    					return false;
    				}
    			}
    			rec.proximo();
    		}
    	}
		return false;
    }
    
    //MODULO 2
    public void imprimir_reproduccion_metabolismo(ArbolGeneral destino, Object especie){
    	//recorrido recursivo para buscar una especie concreta
		NodoGeneral superArbol = destino.getRaiz();
		//CUANDO YA ENC0NTRO QUE ES IGUAL A LA QUE SE BUSCA.
		if (destino.getDatoRaiz().equals(especie)){
			//imprimir metabolismo y reproduccion
			System.out.println(destino.getRaiz().getMetabolismo().getTipo_de_Metabolismo());
			System.out.println(destino.getRaiz().getReproduccion().getTipo_de_reproduccion());
		}
		//ACA BUSCA
		else{
			Lista mishijos =superArbol.getHijos();			
			Recorredor rec= mishijos.recorredor(mishijos);
			rec.comenzar();
			while (rec.fin()){
				ArbolGeneral actual = (ArbolGeneral) rec.elemento();
				actual.imprimir_reproduccion_metabolismo(actual,especie);
				rec.proximo();	
			}
		}		 
    }
    
    //MODULO 2
    public void Imprime_dependiendo_profundidad(ArbolGeneral a,int profundidad){
    	//recorrido por niveles, imprime todas las categorias de una profundidad dada
    	int distancia=0;
    	Cola c = new Cola();
    	c.push(a);
    	c.push(null);
    	while (!c.esvacia()){		
    			Object e= c.pop();
    			if (e==null){
    				distancia++;
    				if (distancia <8 && distancia<profundidad){
    					c.push(null);
    				}
    			}
    			else {
    				if (distancia==profundidad){
    					System.out.println(((ArbolGeneral) e).getDatoRaiz());
    				}
    				else{
    					Lista hijos= ((ArbolGeneral) e).getHijos();
    					Recorredor rec = hijos.recorredor(hijos);	
    					rec.comenzar();   					
    					while(rec.fin()){		
    						ArbolGeneral hijo=  (ArbolGeneral) rec.elemento();
    						c.push( hijo);
    						rec.proximo();
    					}
    				}
    			}
    		}
    	}
    
    //MODULO 1 DE CREAR DEVUELVE UNA CLASE NUEVA SI NO EXISTE LO AGREGA A UNA EXISTENTE.
    public void buscar_clase(ArbolGeneral origen, String destinoo){	//recursivo
    	NodoGeneral nodo= origen.getRaiz();	
    	String com= (String) nodo.getDato();
    	if (destinoo.equals(com)){
    		imprimir_especies(origen);
    	}
    	else{
    		Lista hijos=nodo.getHijos();
    		Recorredor rec = hijos.recorredor(hijos);
    		rec.comenzar();
    		while (rec.fin()){
    			ArbolGeneral aux_2 = (ArbolGeneral) rec.elemento();
    			buscar_clase(aux_2,destinoo);
    			rec.proximo();
    		}
    	}
    }
    
    //MODULO 2 FUNCIONA  CON EL BUSCAR_CLASE
    public void imprimir_especies(ArbolGeneral a){
    	NodoGeneral nodo= a.getRaiz();
    	if (nodo.getHijos().getTamanio()==0){
    		System.out.println(nodo.getDato());
    	}
    	else{
    		Lista hijos=nodo.getHijos();
    		Recorredor rec = hijos.recorredor(hijos);
    		rec.comenzar();
    		while (rec.fin()){
    			ArbolGeneral aux_2 = (ArbolGeneral)  rec.elemento();
    			imprimir_especies(aux_2);
    			rec.proximo();
			}
    	}
    }
}