package com.accenture.granja.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

import com.accenture.granja.model.*;

public class GranjaUI {

	public void start() {
		// TODO Auto-generated method stub
		Granja granja = new Granja("6000000");
		//	LocalDate now = LocalDate.now();

		Scanner scanner = new Scanner(System.in);
		/*	
		System.out.println("Ingrese dinero que hay en la caja de la granja: ");
		BigDecimal dineroEnCaja = scanner.nextBigDecimal();
		granja.setDineroEnCaja(dineroEnCaja);

		*/


		granja.addTiposAnimales("HUEVOS", 21, 6000, 21, new BigDecimal(10), new BigDecimal(40));
		granja.addTiposAnimales("POLLITOS", 2000, 600, 1, new BigDecimal(200), new BigDecimal(400));
		//Ganado ganado= new Ganado((long)1, 2, LocalDate.now());
		//granja.addhuevo(1, 2, LocalDate.now());




		//granja.agregarAnimal(2,15,LocalDate.now());// agrega Pollo no funciona

		//granja.addPollito(new Pollito(2, 26, now));
		// granja.addPollito(new Pollito(2, 2005, now));// Lo ingreso Expirado
		// granja.addPollito(new Pollito(2, 5, now));

		// granja.addHuevo(new Huevo(1, 30, now));// Lo ingreso Expirado
		// granja.addHuevo(new Huevo(1, 10, now));
		// granja.addHuevo(new Huevo(1, 15, now));
		// granja.addHuevo(new Huevo(1, 40, now));
		// granja.addHuevo(new Huevo(1, 25, now));
		//

		//List<Huevo>huevos=((TiposAnimales)granja.tiposAnimales).huevos; no funciona
		//System.out.println(huevos);

		int opcion = 0;
		while (opcion != 8) {
			granja.ofrecerMenu();
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

				String animal= scanner.next();
				System.out.println("Ingrese cantidad de dias que se animal vive");
				int diasExpiracion = scanner.nextInt();
				System.out.println("Ingrese cantidad maxima que quiere tener en la granja");
				int cantidadMaxima = scanner.nextInt();
				System.out.println("Cada cuanto tiempo se reproduce");
				int tiempoDeReproduccion = scanner.nextInt();
				System.out.println("Cual va a ser su precio de compra");
				BigDecimal precioCompra= scanner.nextBigDecimal();
				System.out.println("Cual va a ser su precio de venta");
				BigDecimal precioVenta= scanner.nextBigDecimal();
				granja.addTiposAnimales(animal, diasExpiracion, cantidadMaxima, tiempoDeReproduccion, precioCompra, precioVenta);
				break;
			}
			}
		}
		{
			System.out.println("Gracias por visitar nuestra granja!!!");
			scanner.close();
		}

	}

}
