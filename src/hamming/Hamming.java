/**
 * @author hakim ouatar
 */

package hamming;
public class Hamming {
	
     private  HammingWord code ; //binary code (to be transmitted or to check)
     private  int[] array;       // 
     private boolean erreur=false;  // check if 
     private int choice;
     
     public Hamming(String msg, int choix) throws Exception {
    	
    	 code = new HammingWord(msg);
    	 choice=choix;
         array=null;
        
     }
     
     /**
      * function to be used when we transmit un message 
      * @return array of bits in the good position 
      */
     public  int[] addMessage()  {
    	
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
   
     /**
      * function add parity bits in the message to be transmitted
      * @param message
      * @return array of bits (hamming message)
      */
     public   int[] addParityBits(int[] message) {
    	 
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
    				    	 //OU exclusif //Retourne 1 si l'un des deux bits de même poids est à 1 (mais pas les deux)
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
     
     /**
      * function convert string to array 
      * @return array 
      */
     private  int[] StringToArray() {
    	 array = new int[code.getnbMsg()+1];
    	 for(int i = 0 ; i < code.getnbMsg(); i++ ) {
		    	array[code.getnbMsg() -i]=Integer.parseInt(Character.toString(code.getMsg().charAt(i)));

    	 }
    	 return array;
     }
     
     /**
      * function check if the code is a hamming code
      */
     public void checkHammingCode() {
    	    
    	    
    	    StringToArray();
    		StringBuilder c = new StringBuilder();
    		
    	 for(int i = 0 ; i < code.getNbBitsParity(); i++ ) {
   		  
	   		     int smallStep = (int) Math.pow(2,i);
	   		     int bigStep = smallStep *2;
	   		     int start = smallStep;
	   		     int checkPos = start;
	   		     int a =0;
	 		     System.out.println("check parity bit for position : "+smallStep);
	 			 System.out.print("Bits to be checked : ");
	   		 
 			while(true) {
 				
   			    for(int k = start;  k<= start + smallStep -1 ; k++) {
   			    	
   				      checkPos= k;
   					  if(k > array.length -1) {
   				    	   break;
   				      }else {
   				       //OU exclusif //Retourne 1 si l'un des deux bits de même poids est à 1 (mais pas les deux)
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
   		       //check if a not equals to the parity bit
   		    if(a !=0) {
   			 erreur=true;
   		     }
	      System.out.print("    C"+i+ ": "+a);
          c.insert(i, a);
   		  System.out.println();	
   	      }
   		
         // if there is a error, calculating a position of error on decimal 
    	 if(erreur==true) {
    			 int position = Integer.parseInt(c.toString(), 2);
    			 System.out.println("Erreur a la position :" + position);
    	     
         }else {
      			System.out.println("le code n'a pas d'erreur");
      		    }
     }
     
     
     /**
      * show hamming code
      */
     public void showMsg() {
    	
      for(int i = array.length -1  ; i >0 ; i--) {
    	  System.out.print(array[i] + " ");
      }
     }
     
   
    
    /**
     * check your choice 
     */
 	public void choiceWanted()	throws Exception{
 		if(choice == 1 ) {
 			 if(!code.acceptMsg()) throw new Exception("the number of bits in the message is incorrect !");
 				System.out.println();
 	    		System.out.println("-------------------Génération de mot de hamming----------------------- ");
 	    		System.out.println();
 	    		 addParityBits(addMessage());
 	    	 
 		}else if(choice == 0) {
 			if(!code.isHamming()) throw new Exception("its not a hamming code !");
 				System.out.println();
 	    		System.out.println("-------------------Vérification de mot de hamming----------------------- ");
 	    		System.out.println();
 				 checkHammingCode();
	    	
 		}else {
 			throw new Exception("votre choix est invalide !");
 		}
 	}

}
