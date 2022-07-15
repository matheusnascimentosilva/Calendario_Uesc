package BancoDeDados;

import java.io.IOException;

public class Testa_Banco {

	public static void main(String[] args) throws IOException {
		String path = "src\\BancoDeDados\\BancoEventos.Cal";
		@SuppressWarnings("unused")
		Manipula_Arquivos novo = new Manipula_Arquivos(); 
        //Manipula_Arquivos.Escrita(path);
        Manipula_Arquivos.Leitura(path);
        //Manipula_Arquivos.GravaNoArray(path);
        Manipula_Arquivos.ImprimeArray();

	}

}
