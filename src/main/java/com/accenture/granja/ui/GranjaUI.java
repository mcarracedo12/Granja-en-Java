package com.accenture.granja.ui;


import org.springframework.beans.factory.annotation.Autowired;


import com.accenture.granja.model.*;
import com.accenture.granja.services.GeneralService;


public class GranjaUI {
	@Autowired
	private GeneralService service = new GeneralService();
	
	
	Granja granja = null;
	
	public void start() {
		
	//	List<TiposAnimales> lista = service.actualizarPreciosVenta(1.20);
	//	for(TiposAnimales l : lista) {
	//		System.out.println(l);
	//	}
		
		//this.service = service;
		//Granja g = null;
		/*try {
			granja = service.buscarGranja((long)1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(granja !=null) {
		System.out.println(granja.toString());
		}
		else {
			System.out.println("No se encontro granja con id 1 ");
		}
		*/
	}
}
		/*Granja granja = new Granja();
		*/
	//	Scanner scanner = new Scanner(System.in);
/*
		int opcion = 0;
		while (opcion != 8) {
			ofrecerMenu();
			opcion = scanner.nextInt();
			switch (opcion) {
			case 1: 
			{
				granja.mostrarEstado();
				break;
			}

			case 2:
			{
				System.out.println("Cuantos huevos quiere comprar? ");
				//int cant = scanner.nextInt();
				//Prolemas con esto
				//((TiposAnimales) granja.tiposAnimales).agregahuevo(cant);

				break;
			}

			case 3: 
			{
				System.out.println("Cuantos huevos quiere vender? ");
				//int cant = scanner.nextInt();
				//	granja.venderHuevos(cant);
				break;
			}

			case 4: 
			{
				System.out.println("Cuantos pollitos quiere comprar? ");
				int cant = scanner.nextInt();
				granja.comprarPollitos(cant);
				break;
			}
			case 5: 
			{
				System.out.println("Cuantos pollitos quiere Vender?");
				//int cant = scanner.nextInt();
				//granja.venderPollitos(cant);
				break;
			}
			case 6: {
				System.out.println("Actualizar Granja");
				

				granja.actualizar();
				break;

			}
			case 7: {

				System.out.println("Ingrese nombre de tipo de animal\n");

				String animalName= scanner.next();
				System.out.println("Ingrese cantidad de dias que se animal vive");
				int diasExpiracion = scanner.nextInt();
				System.out.println("Ingrese cantidad maxima que quiere tener en la granja");
				int cantidadMaxima = scanner.nextInt();
				System.out.println("Cada cuanto tiempo se reproduce");
				int tiempoDeReproduccion = scanner.nextInt();
				System.out.println("Cual va a ser su precio de compra");
				float precioCompra= scanner.nextFloat();
				//				double precioCompra= scanner.nextBigDecimal();
				System.out.println("Cual va a ser su precio de venta");
				float precioVenta= scanner.nextFloat();
				//				BigDecimal precioVenta= scanner.nextBigDecimal();
				//TiposAnimales tipo = new TiposAnimales(animalName, diasExpiracion, cantidadMaxima, tiempoDeReproduccion, precioCompra, precioVenta);
				granja.addTiposAnimales(animalName, diasExpiracion, cantidadMaxima, tiempoDeReproduccion, precioCompra, precioVenta);
				break;
			}
			}
		}
		{
			System.out.println("Gracias por visitar nuestra granja!!!");
			scanner.close();
		}

	}

	private void ofrecerMenu() {

		System.out.println("\n\tIngrese una opcion del menu: ");
		System.out.println("1. Mostrar estado de la granja");
		System.out.println("2. Comprar huevos");
		System.out.println("3. Vender huevos");
		System.out.println("4. Comprar pollitos");
		System.out.println("5. Vender pollitos");
		System.out.println("6. Actualizar granja");
		System.out.println("7. Dar de alta tipos de animales");
		System.out.println("8. Salir \n");

*/
//	}

//}
