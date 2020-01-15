package BancoDeDados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Manipula_Arquivos {
	
	private static Scanner input;
	static ArrayList<String> teste;

	public static ArrayList<String>  GravaNoArray(String linha) throws IOException {
		ArrayList<String> eventos = new ArrayList<String>();
		linha = "C:\\Users\\Matheus\\eclipse-workspace\\Projeto LPIII\\src\\BancoDeDados\\BancoEventos.Cal";
		Manipula_Arquivos.Leitura(linha.toString());
		teste = eventos;
		return teste;
	}
	public static void ImprimeArray() {
		int index;
		for(index = 0;index<teste.size();index++) {
			System.out.println("Informações:"+teste.get(index));
		}
		
	}
	
	public static void Leitura(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        int index = 0;
        while (true) {
            if (linha != null) {
                Manipula_Arquivos.GravaNoArray(path).add(index, linha);
                index++;
 
            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
    }
	
	public static void Escrita(String path) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        String linha = "";
        input = new Scanner(System.in);
        System.out.println("Escreva algo: ");
        linha = input.nextLine();
        buffWrite.append(linha + "\n");
        buffWrite.close();
    }
	

}
