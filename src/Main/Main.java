package Main;

import java.util.ArrayList;
import java.util.Scanner;
import Arbol.ArbolGeneral;
import Arbol.Cola;
import Arbol.Lista;
import Arbol.ListaconArreglo;
import Arbol.NodoGeneral;
import Arbol.Recorredor;
import Menus.MenuAdministracion;


public class Main{
	
	static ArbolGeneral SuperArbolGeneral=new ArbolGeneral();
	static Crear nuevo=new Crear();

	public static void main(String[] args){

		SuperArbolGeneral.setdatoraiz("SERES VIVOS");
		//Lista Taxonomias=new ListaconArreglo();
		int opcion=0;
		
		while(opcion!=3){//menu principal
			try {
				Scanner teclado = new Scanner(System.in);	///

				System.out.println("------------------------------------------------------------");
				System.out.println("--------- SISTEMA DE NOMBRES DE DOMINIO TAXONOMICO ---------");
				System.out.println("------------------------------------------------------------");
				System.out.println("1) Administracion ");
				System.out.println("");
				System.out.println("2) Consultas ");
				System.out.println("");
				System.out.println("3) Salir");

				opcion= teclado.nextInt();

				while(opcion<0 || opcion>3){//caso invalido de opcion
					System.out.println("Ingrese una opcion VALIDA");
					opcion= teclado.nextInt();
				}

				switch(opcion){//caso valido de opcion ingresada

				case 1://administracion 
					Scanner teclado1 = new Scanner(System.in);	
					System.out.println("------------------------------------------------------------");
					System.out.println("---------          MENU DE ADMINISTRACION          ---------");
					System.out.println("------------------------------------------------------------");
					System.out.println("");
					System.out.println("1) Ingrese Dominio Taxonomico");
					System.out.println("");
					System.out.println("2) Eliminar Nombre de Especies");
					System.out.println("");
					System.out.println("3) Volver al menu principal");
					System.out.println("");

					int opcion3;
					opcion3= teclado1.nextInt();

					while(opcion3<0 || opcion3>4){//caso invalido de opcion administracion
						System.out.println("Ingrese una opcion VALIDA");
						opcion3= teclado1.nextInt();
					}

					switch(opcion3){

					case 1: //nueva entrada de dominio taxonomico
						//nuevo.CrearArbol(SuperArbolGeneral);
						nuevo.Ingresar_Arbol(SuperArbolGeneral);
						break;

					case 2: //eliminar especie taxonomica
						Scanner tecladoelminiar = new Scanner(System.in);	
						System.out.println("Que especie desea eliminar ?");
						String Aeliminar= tecladoelminiar.nextLine();
						SuperArbolGeneral.eliminar(SuperArbolGeneral, Aeliminar);
						System.out.println("LA ELIMINACION FUE EXITOSA");
						break;

					case 3: //vuelve al menu anterior
						break;
					}
					break;
				case 2: //consultas del menu principal
					int opcion1;
					Scanner teclado4 = new Scanner(System.in);	

					System.out.println("------------------------------------------------------------");
					System.out.println("-----------        MENU DE CONSULTAS            ------------");
					System.out.println("------------------------------------------------------------");
					System.out.println("1) TIPO DE REPRODUCCION Y METABOLISMO DE LA ESPECIE QUE INGRESO");
					System.out.println("");
					System.out.println("2) INGRESANDO DOMINIO MOSTRAR ESPECIES DEL MISMO");
					System.out.println("");
					System.out.println("3) MOSTRAR CATEGORIAS DEPENDIENDO PROFUNDIDAD");
					System.out.println("");
					System.out.println("4) IMPRIMIR ARBOL COMPLETO");
					System.out.println("");
					System.out.println("5) VOLVER AL MENU PRINCIPAL");

					opcion1= teclado4.nextInt();

					while(opcion1<0 || opcion1>5){//no sale de aqui hasta que se ingrese una opcion valida
						System.out.println("Ingrese una opcion VALIDA");
						opcion1= teclado4.nextInt();
					}

					switch(opcion1){
					case 1: //mostrar especie concreta
						Scanner teclado_4 = new Scanner(System.in);
						System.out.println("Ingrese la especie");
						String respuesta_4 = teclado_4.nextLine();
						SuperArbolGeneral.imprimir_reproduccion_metabolismo(SuperArbolGeneral, respuesta_4);
						break;

					case 2: 
						Scanner teclado45 = new Scanner(System.in);	
						System.out.println("Ingrese una CLASE DE TAXONOMIA para saber las especies relacionadas");
						String ingre_clase= teclado45.nextLine();
						SuperArbolGeneral.buscar_clase(SuperArbolGeneral, ingre_clase);
						break;

					case 3: //muestra categorias de la profundidad ingresada
						Scanner teclado84 = new Scanner(System.in);	
						System.out.println("Ingrese un nivel de profundidad");
						int ingresado = teclado84.nextInt();
						SuperArbolGeneral.Imprime_dependiendo_profundidad(SuperArbolGeneral, ingresado);
						break;

					case 4://imprime todo el arbol completo
						SuperArbolGeneral.imprimo_por_nivel(); 
						break;

					case 5://vuelve al menu principal
						break;
					}
					break;
					
				case 3 ://fin del programa, case principal
					System.out.println("FIN DE LA EJECUCION");
					break;
				}
			}
			catch(Exception e){
				System.out.println("ERROR. Ingrese un numero válido");
			}
		}
	}
}