
import java.util.List;
import java.util.ArrayList;

import javax.management.BadStringOperationException;

public class Hamming {
     private static HammingWord code ;
     private static int[] array;
     private boolean erreur=false;
     public Hamming(String msg) throws BadStringOperationException {
    	
    	 code = new HammingWord(msg);
    	// addParityBits(addMessage());
    	 if(code.acceptMsg()) {
    		 addParityBits(addMessage());
    	 }else if(code.isHamming()) {
    		 verifier();
    	 }else {
    	 System.out.println("the number of bits in the message is incorrect or its not a hamming code");
    	 System.exit(1);
     }
    	 
     }
     public static int[] addMessage()  {
    	
    	 int boxParity;
    	 int j=code.getnbMsg()-1;
    	 int temp=0;
    	 //un tableau pour placer les bits de msg;
    	array = new int[code.getnbMsg()+ code.getNbParityBitsNeeded() +1];//on commence par 1 vue n=2^i  i commence par 1
    	 
    	 for(int i =1; i <=array.length;i++) {
 			
 			   //box of parity bits 
 		        boxParity =  (int) Math.pow(2, temp);
 			
 			   //check if we are in boxParity
 			    if(i%boxParity != 0) {
 			     	
 			    	array[i]=Integer.parseInt(Character.toString(code.getMsg().charAt(j)));
 	                j--;
 	                
 			   }else{
 				
 				    temp++;
 			   }
 			
 			
 		 }
    	 
    	 return array;
     }
     //OU exclusif //Retourne 1 si l'un des deux bits de même poids est à 1 (mais pas les deux)
     public static  int[] addParityBits(int[] message) {
    	 
    	  for(int i = 0 ; i < code.getNbParityBitsNeeded(); i++ ) {
    		  
    		  int smallStep = (int) Math.pow(2,i);
    		  int bigStep = smallStep *2;
    		  int start = smallStep;
    		  int checkPos = start;
    		  
    			
  			System.out.println("Calculating Parity bit for Position : "+smallStep);
  			System.out.print("Bits to be checked : ");
    		  while(true) {
    			  
    			  for(int k = start;  k<= start + smallStep -1 ; k++) {
    				    checkPos= k;
    					

    				    if(k > message.length -1) {
    				    	break;
    				    }else {
    				    	
    				    	message[smallStep] ^= message[checkPos];
    				    }
    				    System.out.print(checkPos+" ");
    			        }
    				    if(checkPos >message.length-1 ) {
    				    	break;
    				    }else {
    				    	
    				    	start += bigStep;
    				    }
    				     
    			  
    			  
    		  }
    		  System.out.println();	
    	  }
    	 return message;
     }
     
     //convert String to array
     private  int[] StringToArray() {
    	 array = new int[code.getnbMsg()+1];
    	 for(int i = 0 ; i < code.getnbMsg(); i++ ) {
		    	array[code.getnbMsg() -i]=Integer.parseInt(Character.toString(code.getMsg().charAt(i)));

    	 }
    	 return array;
     }
     public void verifier() {
    	 StringToArray();
    		StringBuilder c = new StringBuilder();

    	 for(int i = 0 ; i < code.getNbBitsParity(); i++ ) {
   		  
   		  int smallStep = (int) Math.pow(2,i);
   		  int bigStep = smallStep *2;
   		  int start = smallStep;
   		  int checkPos = start;
   		  int a =0;
 			System.out.println("Calculating Parity bit for Position : "+smallStep);
 			System.out.print("Bits to be checked : ");
   		  while(true) {
   			  
   			  for(int k = start;  k<= start + smallStep -1 ; k++) {
   				    checkPos= k;
   					

   				    if(k > array.length -1) {
   				    	break;
   				    }else {
   				    	a ^= array[checkPos];
   				    	
   				    }
   				    System.out.print(checkPos+" ");
   				    
   			        }
   			     
   			
   				    if(checkPos >array.length-1 ) {
   				    	break;
   				    }else {
   				    	
   				    	start += bigStep;
   				    }
   				     
   			  
   		  }
   		 if(a !=array[smallStep]) {
		    	 //System.out.println("error code hamming in position");
		    	erreur=true;
		       }
			 System.out.print("le a :"+ a);

   		 c.insert(i, a);
   		  System.out.println();	
   	  }
   		

    	 if(erreur==true) {
    			int decimal = Integer.parseInt(c.toString(), 2);
    			System.out.println("eereur a la position :" + decimal);
    		  }
    	 
     }
     public void showMsg() {
    	
      for(int i = array.length -1  ; i >0 ; i--) {
    	  System.out.print(array[i] + " ");
      }
     }
     

 	
 		

}
