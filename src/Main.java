import java.util.Scanner;

import javax.management.BadStringOperationException;

public class Main {

	public static void main(String[] args) throws BadStringOperationException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir un mot :");
		String str = sc.nextLine();
        Hamming hamming = new Hamming(str);
        hamming.showMsg();
	}

}
