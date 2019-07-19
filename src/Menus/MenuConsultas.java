package Menus;

import java.util.Scanner;

public class MenuConsultas {

	private static int opcion;
	
	public int getOpcion(){
		return opcion;
	}
	
	public static void Consola(){
		Scanner teclado4 = new Scanner(System.in);		
		System.out.println("------------------------------------------------------------");
		System.out.println("-----------        MENU DE CONSULTAS            ------------");
		System.out.println("------------------------------------------------------------");
		System.out.println("1) Administracion ");
		System.out.println("");
		
		opcion= teclado4.nextInt();
		
		switch(opcion){
			case 1: 
				break;
			case 2: 
				break;
			case 3: 
				break;
		}
	}
}
