package codes;

import java.util.ArrayList;

public class Meses {
	
	private static final ArrayList<String> meses;
	static {
		meses = new ArrayList<String>(12);
		meses.add("Janeiro");
		meses.add("Fevereiro");
		meses.add("Março");
		meses.add("Abril");
		meses.add("maio");
		meses.add("Junho");
		meses.add("Julho");
		meses.add("Agosto");
		meses.add("Setembro");
		meses.add("Outubro");
		meses.add("Novembro");
		meses.add("Dzembro");
		
	}
	public void ListaMeses() {
		int indice;
		for(indice = 1;indice<meses.size();indice++) {
			System.out.printf("%d %s",indice,meses.get(indice));
		}
	}
	public String getMes(int indice) {
		String pega = meses.get(indice);
		return pega;
	}
	

}
