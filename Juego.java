package juego;

/**
 * @author Pablo Celorrio
 * @version 1.1 20/12/2022
 * Este programa consiste en un juego basado en acciones, según las decisiones que se tomen la historia avanzará, llegando a un resultado.
 */

import java.util.Random;

public class Juego {
	
	/**
	 * Aqui se declaran las variables necesarias para el funcionamiento del juego
	 * @param int numTurnos variable contador que almacena el turno en el que se encuentra
	 * @param String accion almacena una cadena de caracteres con la acción que el usuario introduce
	 * @param double dinero almacena el dinero que se recoge a través de la partida
	 * @param String result almacena una cadena de caracteres con el resultado de la partida
	 * @param int norte,sur,este,oeste variables contador que almacenan el número de veces que se ha usado cada acción
	 * @param int castillo variable que almacena un 0 o un 1, dependiendo si se entró al castillo o no
	 * @param String[] invent array de cadenas de caracteres que almacena los objetos que se consiguen durante el juego
	 */
	
	private int numTurnos;
	private String accion;
	private double dinero;
	private String result;
	private int norte;
	private int sur;
	private int este;
	private int oeste;
	private int queda;
	private int castillo;
	private String[] invent = new String[5];
	
	/**
	 * Constructor por defecto
	 */

	public Juego() {
		
		super();
	
	}
	
	/**
	 * Setters y getters
	 */
	
	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

	public String[] getInvent() {
		return invent;
	}

	public void setInvent(String[] invent) {
		this.invent = invent;
	}

	public int getNumTurnos() {

		return numTurnos;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * evalúa el número de veces que se ha usado cada acción, y dependiendo de la situación,
	 * envía por pantalla cada opción que se puede usar, además de pedir al usuario que introduzca la acción.
	 */
	
	public void accionDisp() {
		
		numTurnos ++;
		
		System.out.println(">>>>>>>>>ACCIONES DISPONIBLES:<<<<<<<<");
		System.out.println("");
		System.out.println("Turno: " + getNumTurnos());
		System.out.println(" ");
		
		if (castillo != 1) {
	
			if (norte < 3) {
		
				System.out.println("Norte");
		
			}
			if (sur < 3) {
			
				System.out.println("Sur");
		
			}
			if (este < 3) {
			
				System.out.println("Este");
		
			}
			if (oeste < 3) {
			
				System.out.println("Oeste");
				
			}
			if (queda < 3) {
			
				System.out.println("Quedarse");
		
			}
			
		}
		else {
			
			System.out.println("Pelea");
			System.out.println("Soborno");
			
		}
		
		System.out.println("Suicidio");
		System.out.println(" ");
		System.out.println("Escriba su acción: ");
		
	}
	
	/**
	 * toma el valor de la variable accion y dependiendo de la cadena de caracteres que contenga, 
	 * ejecutará los métodos que correspondan, además de imprimir por pantalla la decisión que ha tomado el usuario
	 * @param accion variable que almacena la acción que hace el usuario
	 * @return result retorna el valor de la variable result para indicarle a la clase principal cuando termina la partida
	 */

	public String accion(String accion) {
		
		if (norte > 3 || sur > 3 || este > 3 || oeste > 3 || queda > 3) {
			
			System.out.println("El tiempo se te acaba y mueres sin lograr nada. Has perdido.");
			setResult("muerte");
			return result;
			
		}
		
		switch (accion) {
		
		case "norte":
			
			System.out.println("Vas hacia el norte.");
			suceso();
			norte ++;
			return result;
			
		case "sur":
			
			System.out.println("Vas hacia el sur.");
			suceso();
			sur ++;
			return result;
			
		case "este":
			
			System.out.println("Vas hacia el este.");
			suceso();
			este ++;
			return result;
			
		case "oeste":
			
			System.out.println("Vas hacia el oeste.");
			suceso();
			oeste ++;
			return result;
			
		case "quedarse":
			
			System.out.println("Se hace la noche mientras esperas que algo suceda.");
			sucesoQueda(getNumTurnos());
			queda ++;
			return result;
			
		case "suicidio":
			
			if (castillo != 1) {
				System.out.println("Usas tu propio cuchillo para darte muerte. Sientes calor al principio, y luego frío. Caes al suelo y pierdes ");
				System.out.println("la consciencia. Has muerto.");
				setResult("muerte");
				return result;
			}
			else {
				
				System.out.println("Usas tu propio cuchillo para darte muerte. Sin embargo, no sientes nada, ni siquiera notas la ");
				System.out.println("herida, pero puedes ver como el rey malvado sangra, desmayándose frente a ti. Su corona cae a ");
				System.out.println("tus pies, siéndote conocida. En ese momento, al ver tu reflejo en el oro, te das cuenta de que ");
				System.out.println("siempre fuiste el rey malvado. Reclamas su corona, para volverte lo que una vez fue. Has ganado. Obtuviste el final malo.");
				setResult("rey");
				return result;
				
			}
			
		case "soborno":
			
			System.out.println("Rey malvado: Me ofreces dinero a cambio de tu vida ? No tomaré menos de 1000 de dinero.");
			
			if(dinero >= 1000) {
				
				System.out.println("Le ofreces el dinero al rey malvado para que perdone tu vida.");
				System.out.println("Rey malvado: Está bien. Perdonaré tu vida.");
				System.out.println("Vives el resto de tus días en el palacio del rey malvado, como tesorero y contable, aparte de ");
				System.out.println("recaudador de impuestos. Has ganado. Final contable");
				setResult("rey");
				return result;
				
			}
			else {
				
				System.out.println("Le ofreces el poco dinero que tienes al rey malvado para que perdone tu vida, aunque no es la cantidad requerida.");
				System.out.println("Rey malvado: Está bien. Perdonaré tu vida. Pero a cambio te convertirás en mi mano derecha.");
				System.out.println("Vives el resto de tus días en el palacio del rey malvado, trabajando como su jefe de guerra y su mano derecha. ");
				System.out.println("Tus días de asesinar inocentes no han hecho más que empezar. Has ganado. Final matanza");
				setResult("rey");
				return result;
				
			}
			
		case "pelea":
			
			if (invent[0] != "Espada del héroe" && invent[1] != "Escudo del héroe") {
				
				System.out.println("El rey malvado tiene demasiada fuerza comparado contigo, asi que mueres en batalla. Has muerto");
				setResult("muerte");
				return result;
				
			}
			else {
				
				System.out.println("Con el poder de tu espada y escudo, te bates en duelo con el rey, resultando ganador tras un arduo combate.");
				System.out.println("Tomas su corona y te sientas en su trono, convirtiéndote en un rey bondadoso. Has ganado.");
				setResult("rey");
				return result;
				
			}
			
		default:
			
			System.out.println("La orden que has dado no está en tus opciones o difiere en algún caracter de la orden que deseas.");
			return result;
		
		}
		
	}
	
	/**
	 * crea un suceso aleatorio de entre las posibles opciones reflejadas en este.
	 */
	
	public void suceso () {
		
		Random rd = new Random();
		
		int dado = rd.nextInt(1,50);
		
		switch (dado) {
		
		case 1:
			
			System.out.println("Unos vandidos te asaltan y roban todas tus pertenencias. Sientes calor al principio,");
			System.out.println("y luego frío. Caes al suelo y pierdes la consciencia. Has muerto.");
			setResult("muerte");
			break;
			
		case 2,3,4,5,6,7,8,9,10: 
			
			System.out.println("Llegas a una fortaleza en ruinas");
		
			if (dado > 4 && dado < 6) {
				
				cofre();
				
			}
			break;
			
		case 11,12,13,14,15,16,17,18,19,20:
			
			System.out.println("Llegas a una casa abandonada.");
		
			if (dado > 14 && dado < 16) {
			
				cofre();
			
			}
			break;
		
		case 21,22,23,24,25,26,27,28,29,30:
			
			System.out.println("Llegas a un desierto.");
		
			if (dado == 21) {
				
				System.out.println("Por el camino te comiste las provisiones que te quedaban, y te acabas el agua ");
				System.out.println("en busca de calmar tu estómago. Caminas sin rumbo hacia la nada, hasta que te ");
				System.out.println("desmayas por el calor. Has muerto.");
				setResult("muerte");
				
			}
			
			if (dado > 24 && dado < 26) {
				
				cofre();
				
			}
			break;
		
		case 31,32,33,34,35,36,37,38,39,40:
			
			System.out.println("Llegas a una selva con un río en el centro.");
		
			if (dado > 34 && dado < 36) {
			
				cofre();
			
			}
			break;
		
		case 41,42,43,44,45,46,47,48,49,50:
			
			System.out.println("Llegas al castillo del rey malvado.");

			if (dado == 50) {
			
				System.out.println("Al entrar en la sala del trono, te encuentras con el rey malvado tirado en el ");
				System.out.println("suelo, muerto. Reclamas su corona y te conviertes en un rey bondadoso. Has ganado.");
				setResult("rey");

			}
			
			sucesoCastillo();
			
			
			break;
			
		}
		
	}
	
	/**
	 * determina lo que sucede si se usa el comando "quedarse"
	 * @param numTurnos se usa para contemplar la opción de que el número de turnos sea par
	 */
	
	public void sucesoQueda(int numTurnos) {
		
		if (numTurnos % 2 == 0) {
			
			System.out.println("La noche cae y puedes continuar tu camino.");
			
		}
		else {
			
			System.out.println("La noche cae y las bestias te atacan mientras duermes. Has muerto.");
			setResult("muerte");
			
		}
		
	}
	
	/**
	 * si en el método suceso se da la opción de cofre, el método dará como resultado el objeto que recibe el usuario
	 */
	
	public void cofre() {
		
		System.out.println("Encontraste un cofre !!");
		
		Random rd = new Random();
		
		int dado = rd.nextInt(1,10);
		
		switch(dado) {
		
		case 1,2:
			
			System.out.println("El cofre en verdad es un mímico, que te muerde la cabeza y te come vivo. Has muerto");
			setResult("muerte");
		
		case 5,4,3:
			
			System.out.println("Encontraste la Espada del Héroe y una Llave misteriosa en el cofre");
			
			invent[0] = "Espada del héroe";
			invent[4] = "Llave Misteriosa";
		
		case 6:
			
			System.out.println("Encontraste la Espada del Héroe y el Escudo del Héroe en el cofre");
			
			invent[1] = "Escudo del héroe";
			invent[0] = "Espada del héroe";
		
		case 7:
			
			System.out.println("Encontraste una Tela Misteriosa y una Piedra Preciosa en el cofre");
		
			invent[2] = "Tela misteriosa";
			invent[3] = "Piedra preciosa";
		
		case 8:
			
			System.out.println("Encontraste 1000 de dinero en el cofre");
			
			dinero += 1000;
		
		case 9: 
			
			System.out.println("Encontraste 100 de dinero en el cofre");
			
			dinero += 100;
		
		case 10:
			
			System.out.println("Encontraste una Llave misteriosa en el cofre");
			
			invent[4] = "Llave Misteriosa";
		
		}
		
	}
	
	/**
	 * en este método se reflejan las distintas posibilidades que se dan al llegar al castillo del rey malvado.
	 * 
	 */
	
	public void sucesoCastillo() {
		
		if(invent[4] == "Llave Misteriosa") {
			
			System.out.println("Consigues entrar al castillo con la extraña llave que encontraste, ");
			System.out.println("y llegas a la sala del trono. Al llegar, el rey malvado está frente a ti.");
			castillo = 1;
			
		}
		else {
			
			System.out.println("La cerradura es complicada y no se puede abrir con facilidad. ");
			System.out.println("Parece que necesitarás una llave.");
			
		}
	}

}
