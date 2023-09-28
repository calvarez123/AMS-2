import java.util.*;

public class Calculos {

	public static void main(String[] args) {
		Formulas form=new Formulas();
		ArrayList<Integer> peso=new ArrayList<Integer>();
		ArrayList<Integer> altura=new ArrayList<Integer>();
		Scanner ls=new Scanner(System.in);
		while(true) {
		System.out.println("Calculadora");
		System.out.print("1) Introducir datos\n2) Ver media\n3) Ver variacion\n4) Ver desviacion\n5) Salir\nOpcion: ");
		int opcion=ls.nextInt();
		switch(opcion) {
		case 1:
			int seguir=0;
			do {
				System.out.print("Introduce el peso en kg: ");
				int kg=ls.nextInt();
				System.out.print("Introduce la altura en cm: ");
				int cm=ls.nextInt();
				peso.add(kg);
				altura.add(cm);
				System.out.println("Se han añadido los datos correctamente");
				System.out.print("Quieres seguir añadiendo datos? (0 es si, cualquier otro numero no) ");
				seguir=ls.nextInt();
			}while(seguir==0);
			break;
		case 2:
			if (peso.isEmpty() || altura.isEmpty()) {
				System.out.println("La lista esta vacia introduce datos previamente");
			}
			else {
				System.out.println("La media del peso es: "+form.Media(peso));
				System.out.println("La media de la altura es: "+form.Media(altura));
			}
			break;
		case 3:
			if (peso.isEmpty() || altura.isEmpty()) {
				System.out.println("La lista esta vacia introduce datos previamente");
			}
			else {
				System.out.println("La variacion del peso es: "+form.Variacion(peso));
				System.out.println("La variacion de la altura es: "+form.Variacion(altura));
			}
			break;
		case 4:
			if (peso.isEmpty() || altura.isEmpty()) {
				System.out.println("La lista esta vacia introduce datos previamente");
			}
			else {
				System.out.println("La desviacion del peso es: "+form.Desviacion(peso));
				System.out.println("La desviacion de la altura es: "+form.Desviacion(altura));
			}
			break;
		case 5:
			System.out.println("Has salido con exito");
			System.exit(0);
		}
		}
		
	}

}
