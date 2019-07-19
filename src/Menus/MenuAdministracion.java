package Menus;

import java.util.Scanner;

import Arbol.ArbolGeneral;
import Main.DatoRaiz;
import Main.Metabolismo;
import Main.Reproduccion;

public class MenuAdministracion {
	
	private Metabolismo metabolismo;
	private Reproduccion reproduccion;
	public int opcion;
	public DatoRaiz dato=new DatoRaiz(metabolismo,reproduccion);
	
	public Metabolismo getMetabolismo(){
		return dato.getMetabolismo();
	}
	
	public Reproduccion getReproduccion(){
		return dato.getReproduccion();
	}
	
	public int getOpcion(){
		return opcion;
	}
	
	public void setMetabolismo(){
		Scanner teclado2 = new Scanner(System.in);	
		Metabolismo metabolismo=new Metabolismo();
		System.out.println("SELECCIONE TIPO DE METABOLISMO:");
		System.out.println("1) Anabolico ");
		System.out.println("2) Catabolico ");
		int opcion= teclado2.nextInt();
		
		while(opcion<0 || opcion>2){
			System.out.println("OPCION FUERA DE RANGO");
			System.out.println("INGRESE NUEVAMENTE LA OPCION: ");
			opcion= teclado2.nextInt();
		}
		
		if(opcion==1){
			metabolismo.setTipo_de_Metabolismo("ANABOLICO");
			dato.setMetabolismo(metabolismo);
			System.out.println("Usted ingreso [ANABOLICO]");
		}
		if(opcion==2){	
			metabolismo.setTipo_de_Metabolismo("Catabolico");
			dato.setMetabolismo(metabolismo);
			System.out.println("Usted ingreso [CATABOLICO]");
		}
	}
	
	public void setReproduccion(){
		Reproduccion reproduccion=new Reproduccion();
		Scanner teclado3 = new Scanner(System.in);	
		System.out.println("INGRESE TIPO DE REPRODUCCION:");
		System.out.println("1) Sexual ");
		System.out.println("2) Asexual ");
		int opcion1= teclado3.nextInt();
		
		while(opcion1<0 || opcion1>2){
			System.out.println("OPCION FUERA DE RANGO");
			System.out.println("INGRESE NUEVAMENTE LA OPCION: ");
			opcion= teclado3.nextInt();
		}
		if(opcion1==1){
			reproduccion.setTipo_de_reproduccion("Sexual");
			dato.setReproduccion(reproduccion);
			System.out.println("Usted ingreso Reproduccion [SEXUAL]");
		}
		
		if(opcion1==2){
			reproduccion.setTipo_de_reproduccion("Asexual");
			dato.setReproduccion(reproduccion);
			System.out.println("Usted ingreso Reproduccion [ASEXUAL]");
		}
	}
}