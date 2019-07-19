package Arbol;

public class Cola {
	
 Lista datos;
 int pos=1;
 
 public Cola(){
	 datos=new ListaconArreglo();
 }
 
 public void push (Object a){
	datos.agregar(a, 0);
 }
 
public Object  pop (){		
	 Object aux =(Object) datos.elemento(datos.getTamanio()-1);
	 datos.eliminar(datos.getTamanio()-1);
	 return aux;
 }
 
public Object top(){
	 Object aux = (Object) datos.elemento(datos.getTamanio()-1);
	 return aux;
 }
 
public Boolean esvacia(){
	 if (datos.getTamanio()==0){
		 return true ;
	 }
	 else{
		 return false;
	 }
 }
}
