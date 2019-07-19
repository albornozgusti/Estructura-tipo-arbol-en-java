package Main;

import java.util.Scanner;

import Arbol.ArbolGeneral;
import Menus.MenuAdministracion;

public class Crear {
	
	Scanner teclado11 = new Scanner(System.in);
	
	public ArbolGeneral Ingresar_Arbol(ArbolGeneral SuperArbolGeneral){			
		MenuAdministracion adm=new MenuAdministracion();
		//Arbol vacio
		Scanner teclado = new Scanner(System.in);
		boolean iniciar = false;
		boolean ingresar = true;
		System.out.println("Ingrese 3 para volver o 4 para cancelar");
		while(ingresar && !iniciar) {
			//ingreso reino
			boolean reino1 = false;
			System.out.println("Ingrese el reino");
			String reino = teclado.nextLine();

			if(reino.equals("3")|| reino.equals("4")){//cancela y elimina el arbol que se crea
				ingresar = false;
				SuperArbolGeneral.eliminar(SuperArbolGeneral, reino);
			}
			//while del filo
			while (ingresar && !reino1){//si reino se mantiene en falso
				ArbolGeneral Reino=Recorridos.siExiste(reino, SuperArbolGeneral);
				//ingreso filo
				boolean filo1 = false;
				System.out.println("Ingrese el filo");
				String filo = teclado.nextLine();

				if(filo.equals("3")){//cancela la creacion del filo y elimina el reino ingresado, y lo vuelve a pedir
					filo1 = true;
					reino1 = true;
					SuperArbolGeneral.eliminarHijo(Reino);
				}
				if(filo.equals("4")){//elimina todo lo creado hasta este punto, cancelando la entrada
					ingresar = false;
					SuperArbolGeneral.eliminar(SuperArbolGeneral, reino);
				}
				//while de la clase
				while(ingresar && !filo1){//analiza si sigue con la creacion
					ArbolGeneral Filo=Recorridos.siExiste(filo, Reino);
					//ingreso clase
					boolean clase1 = false;
					System.out.println("Ingrese la clase");
					String clase = teclado.nextLine();
					
					if(clase.equals("3")){//cancela la clase y elimina el filo que se ingreso, volviendolo a pedir
						filo1 = true;
						clase1 = true;
						Reino.eliminarHijo(Filo);
					}
					if(clase.equals("4")){
						ingresar = false;
						SuperArbolGeneral.eliminar(SuperArbolGeneral, filo);
					}
					//while de la orden
					while(ingresar && !clase1){
						ArbolGeneral Clase=Recorridos.siExiste(clase, Filo);
						//ingreso Orden
						boolean orden1 = false;
						System.out.println("Ingrese el Orden");
						String orden = teclado.nextLine();
						if(orden.equals("3")){//cancela el orden, elimina y vuelve a pedir la clase
							orden1 = true;
							clase1 = true;
							Filo.eliminarHijo(Clase);
						}
						if(orden.equals("4")){
							ingresar = false;
							SuperArbolGeneral.eliminar(SuperArbolGeneral, clase);
						}
						//while de la familia
						while(ingresar && !orden1){
							ArbolGeneral Orden=Recorridos.siExiste(orden, Clase);
							//ingreso Familia
							boolean familia1 = false;
							System.out.println("Ingrese la familia");
							String familia = teclado.nextLine();
							if(familia.equals("3")){//cancela la familia y elimina el Orden volviendolo a pedir
								orden1 = true;
								familia1 = true;
								Clase.eliminarHijo(Orden);
							}
							if(familia.equals("4")){
								ingresar = false;
								SuperArbolGeneral.eliminar(SuperArbolGeneral, orden);
							}
							//while del genero
							while(ingresar && !familia1){
								ArbolGeneral Familia=Recorridos.siExiste(familia, Orden);
								//ingreso genero
								boolean genero1 = false;
								System.out.println("Ingrese el Genero");
								String genero = teclado.nextLine();

								if(genero.equals("3")){//cancela el genero, elimina y vuelve a pedir el la familia
									familia1 = true;
									genero1 = true;
									Orden.eliminarHijo(Familia);
								}
								if(genero.equals("4")){
									ingresar = false;
									SuperArbolGeneral.eliminar(SuperArbolGeneral, familia);
								}
								//while de la especie
								while(ingresar && !genero1){
									ArbolGeneral Genero=Recorridos.siExiste(genero, Familia);
									//ingreso Especie
									boolean especie1 = false;
									System.out.println("Ingrese el Especie");
									String especie = teclado.nextLine();
									if(especie.equals("3")){//cancela la especie, elimina el genero y lo vuelve a pedir
										genero1 = true;
										especie1 = true;
										Familia.eliminarHijo(Genero);
									}
									if(especie.equals("4")){
										ingresar = false;
										SuperArbolGeneral.eliminar(SuperArbolGeneral, especie);
									}
									//while final
									while(ingresar && !especie1){
										ArbolGeneral Especie=Recorridos.siExiste(especie, Genero);
										adm.setMetabolismo();   //MENU PARA SETEAR METABOLISMO
										adm.setReproduccion();  //MENU PARA SETEAR REPRODUCCION
										Especie.setdatoraiz(especie);//SETEA EL NOMBRE DEL A ESPECIE
										Especie.getRaiz().setMetabolismoReproduccion(adm.getMetabolismo(), adm.getReproduccion());
										System.out.println(Especie.getRaiz().getMetabolismo().getTipo_de_Metabolismo());
										System.out.println(Especie.getRaiz().getReproduccion().getTipo_de_reproduccion());
										System.out.println("DOMINIO TAXONOMICO INGRESADO FUE : "+reino+"."+filo+"."+clase+"."+orden+"."+familia+"."+genero+"."+especie);
										String dom=reino+"."+filo+"."+clase+"."+orden+"."+familia+"."+genero+"."+especie;	
										ingresar = false;
									}
								}
							}
						}
					}
				}
			}
		}
		return SuperArbolGeneral;//retorna el mismo arbol que entro pero con la nueva "rama"
	}
	
	public ArbolGeneral CrearArbol(ArbolGeneral SuperArbolGeneral){
		
		MenuAdministracion adm=new MenuAdministracion();
		adm.setMetabolismo();   //MENU PARA SETEAR METABOLISMO
		adm.setReproduccion();  //MENU PARA SETEAR REPRODUCCION
		System.out.println("Ingrese REINO ");//INGRESO REINO
		String reino= teclado11.nextLine();
		ArbolGeneral Reino=Recorridos.siExiste(reino, SuperArbolGeneral);

		System.out.println("Ingrese FILO ");//
		String filo= teclado11.nextLine();
		ArbolGeneral  Filo=Recorridos.siExiste(filo, Reino);

		System.out.println("Ingrese CLASE");//
		String clase= teclado11.nextLine();
		ArbolGeneral Clase=Recorridos.siExiste(clase, Filo);

		System.out.println("Ingrese ORDEN");//
		String orden= teclado11.nextLine();
		ArbolGeneral Orden=Recorridos.siExiste(orden, Clase);

		System.out.println("Ingrese FAMILIA");//
		String familia= teclado11.nextLine();
		ArbolGeneral Familia=Recorridos.siExiste(familia,Orden);

		System.out.println("Ingrese GENERO");//
		String genero= teclado11.nextLine();
		ArbolGeneral Genero=Recorridos.siExiste(genero, Familia);

		System.out.println("Ingrese ESPECIE");//
		String especie= teclado11.nextLine();
		ArbolGeneral Especie=Recorridos.siExiste(especie, Genero);

		Especie.setdatoraiz(especie);				
		Especie.getRaiz().setMetabolismoReproduccion(adm.getMetabolismo(), adm.getReproduccion());
		
		System.out.println(Especie.getRaiz().getMetabolismo().getTipo_de_Metabolismo());
		
		System.out.println(Especie.getRaiz().getReproduccion().getTipo_de_reproduccion());

		System.out.println("DOMINIO TAXONOMICO INGRESADO FUE : "+reino+"."+filo+"."+clase+"."+orden+"."+familia+"."+genero+"."+especie);

		String dom=reino+"."+filo+"."+clase+"."+orden+"."+familia+"."+genero+"."+especie;			
		return SuperArbolGeneral;
	}
}