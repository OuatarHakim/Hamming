import javax.management.BadStringOperationException;

public class Hamming {
     private static HammingWord code ;
     private static int[] tab;
     public Hamming(String msg) throws BadStringOperationException {
    	 code = new HammingWord(msg);
    	 addParityBits(addMessage());
    	 
     }
     public static int[] addMessage()  {
    	
    	 int boxParity;
    	 int j=code.getnbMsg()-1;
    	 int temp=0;
    	 //un tableau pour placer les bits de msg;
    	tab = new int[code.getnbMsg()+ code.getNbParityBits() +1];//on commence par 1 vue n=2^i  i commence par 1
    	 
    	 for(int i =1; i <=tab.length;i++) {
 			
 			   //box of parity bits 
 		        boxParity =  (int) Math.pow(2, temp);
 			
 			   //check if we are in boxParity
 			    if(i%boxParity != 0) {
 			     	
 			    	tab[i]=Integer.parseInt(Character.toString(code.getMsg().charAt(j)));
 	                j--;
 	                
 			   }else{
 				
 				    temp++;
 			   }
 			
 			
 		 }
    	 
    	 return tab;
     }
     //OU exclusif //Retourne 1 si l'un des deux bits de même poids est à 1 (mais pas les deux)
     public static  int[] addParityBits(int[] message) {
    	 
    	  for(int i = 0 ; i < code.getNbParityBits(); i++ ) {
    		  
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
     public void showMsg() {
    	
      for(int i = tab.length -1  ; i >0 ; i--) {
    	  System.out.print(tab[i]);
      }
     }
     

 	public static void main(String[] args) throws BadStringOperationException {
 /*	int[] tab = addMessage("10110111010");
 	for(int i=tab.length-1 ; i>0 ;i--) {
 		System.out.print(tab[i]);
 	}
       
     addParityBits(tab);   
     
     for(int i=tab.length-1 ; i>0 ;i--) {
  		System.out.print(tab[i]);
  	}*/
 		Hamming tab = new Hamming("10110111010");
 		tab.showMsg();
 	}
 		

}
