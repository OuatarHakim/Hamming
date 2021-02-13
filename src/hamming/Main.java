package hamming;
import java.util.Scanner;

import javax.management.BadStringOperationException;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("Message a Transmette tapez  => 1  ");
		System.out.println("Message a Véfifier tapez => 0 ");
		System.out.print("Veuillez saisir votre choix  :");
		Scanner choix = new Scanner(System.in);
		int s = choix.nextInt();
		System.out.println();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Veuillez saisir un mot  :");
		String str = sc.nextLine();
		

        
        Hamming hamming = new Hamming(str,s);
        hamming.choiceWanted();
        hamming.showMsg();
	}

}
