package com.accenture.granja.ui;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

import com.accenture.granja.beans.*;


public class GranjaUI {

	public void start() {
		// TODO Auto-generated method stub
		Granja granja = new Granja();
		LocalDate now = LocalDate.now();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingrese dinero que hay en la caja de la granja: ");
		BigDecimal dineroEnCaja = scanner.nextBigDecimal();
		granja.setDineroEnCaja(dineroEnCaja);

		System.out.println("Cantidad maxima de pollitos que puede tener: ");
		int cantMaxPollitos = scanner.nextInt();
		System.out.println("Indique Precio de compra de Pollitos: ");
		BigDecimal precioCompraP = scanner.nextBigDecimal();
		System.out.println("Indique Precio de Venta de Pollitos: ");
		BigDecimal precioVentaP = scanner.nextBigDecimal();
		System.out.println(granja);

		granja.addTiposAnimales(new TiposAnimales(1, "pollito", 2000, cantMaxPollitos, precioCompraP, precioVentaP));

		System.out.println(granja);

		System.out.println("Cantidad maxima de huevos que puede tener: ");
		int cantMaxHuevos = scanner.nextInt();
		System.out.println("Indique Precio de compra de Huevos: ");
		BigDecimal precioCompraH = scanner.nextBigDecimal();
		System.out.println("Indique Precio de Venta de Huevos: ");
		BigDecimal precioVentaH = scanner.nextBigDecimal();


		granja.addTiposAnimales(new TiposAnimales(2, "huevo", 21, cantMaxHuevos, precioCompraH, precioVentaH));

		// granja.addPollito(new Pollito(1, 15, now));
		granja.addPollito(new Pollito(2, 26, now));
		 granja.addPollito(new Pollito(3, 2005, now));// Lo ingreso Expirado
		// granja.addPollito(new Pollito(4, 5, now));

		 granja.addHuevo(new Huevo(1, 30, now));// Lo ingreso Expirado
		// granja.addHuevo(new Huevo(2, 10, now));
		// granja.addHuevo(new Huevo(3, 15, now));
		// granja.addHuevo(new Huevo(4, 40, now));
		// granja.addHuevo(new Huevo(5, 25, now));
		//

		System.out.println(granja);

		int opcion = 0;
		while (opcion != 7) {
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
				int cant = scanner.nextInt();
				granja.comprarHuevos(cant);
				break;
			}

			case 3: 
			{
				System.out.println("Cuantos huevos quiere vender? ");
				int cant = scanner.nextInt();
				granja.venderHuevos(cant);
				break;
			}

			case 4: 
			{
				System.out.println("Cuantos pollitos quiere comprar? ");
				int cant = scanner.nextInt();
				//granja.comprarPollitos(cant);
				break;
			}
			case 5: 
			{
				System.out.println("Cuantos pollitos quiere Vender?");
				int cant = scanner.nextInt();
				granja.venderPollitos(cant);
				break;
			}
			case 6: {
				System.out.println("Actualizar Granja");
				granja.actualizar();
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
