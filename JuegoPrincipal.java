package juego;

import java.util.Scanner;

/**
 * @author Pablo Celorrio
 * @version 1.1 20/12/2022
 * Este programa ejecuta todos los métodos de la clase Juego.
 */

public class JuegoPrincipal {
	
	/**
	 * Método main
	 * @param args
	 */

	public static void main(String[] args) {
		
		/**
		 * Instacias a las clases Juego y Scanner
		 */

		Juego jue = new Juego();
		Scanner sc = new Scanner(System.in);
		
		/**
		 * Comentarios que describen el funcionamiento del juego
		 */
		
		System.out.println("Bienvenido, jugador. Espero que disfrutes del juego.");
		System.out.println(" ");
		System.out.println(">>>>>>>>>HISTORIA:<<<<<<<<");
		System.out.println(" ");
		System.out.println("Un rey malvado asola el continente en el que vives, eres un soldado entrenado en la lucha y la supervivencia. ");
		System.out.println("Tu objetivo es vencer al rey malvado y hacerte con su corona.");
		System.out.println(" ");
		System.out.println(">>>>>>>>>MODO DE JUEGO:<<<<<<<<<");
		System.out.println(" ");
		System.out.println("Al principio de cada turno se te dará una lista con las posibles opciones que puedes insertar por teclado.");
		System.out.println(" ");
		
		/**
		 * @param resultado variable que determina si se termina la partida y detiene el bucle
		 */
		
		String resultado = "null";
		
		/**
		 * Bucle que ejecuta los métodos de la clase Juego hasta que la partida termine
		 */
		
		while (resultado != "muerte" && resultado != "rey") {
			
			jue.accionDisp();
			String accion = sc.nextLine();
			resultado = jue.accion(accion);
			
		}
		
		/**
		 * Cierre de la clase Scanner y comentario final.
		 */
		
		sc.close();
		System.out.println("Gracias por jugar.");
	}

}
