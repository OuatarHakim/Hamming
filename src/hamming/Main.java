package hamming;
import java.util.Scanner;

import javax.management.BadStringOperationException;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("Génération mot de hamming  tapez  => 1  ");
		System.out.println("Véfifier  mot de hamming tapez => 0 ");
		System.out.print("Veuillez saisir votre choix  :");
		Scanner choix = new Scanner(System.in);
		int choice = choix.nextInt();
		System.out.println();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Veuillez saisir un mot  :");
		String str = sc.nextLine();
		
		
        Hamming hamming = new Hamming(str,choice);
        hamming.choiceWanted();
        
		System.out.println();
		System.out.println("------------------------Le mot de Hamming: ------------------------------------------");
		System.out.println();

        hamming.showMsg();
	}

}
