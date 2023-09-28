import java.util.ArrayList;

public class Formulas {
	private int Suma (ArrayList<Integer> lista) {
		int suma=0;
		for (int i:lista) {
			suma=suma+i;
		}
		return suma;
	}
	public double Media(ArrayList<Integer> lista) {
		return Suma(lista)/lista.size();
	}
	public double Variacion(ArrayList<Integer> lista) {
		double calculo = 0;
		for (int i:lista) {
			calculo=calculo+Math.pow(i-Media(lista),2);
		}
		return calculo/lista.size();
	}
	public double Desviacion(ArrayList<Integer> lista) {
		return Math.sqrt(Variacion(lista));
	}
}
