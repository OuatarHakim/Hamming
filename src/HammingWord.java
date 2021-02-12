import javax.management.BadStringOperationException;

public class HammingWord {
	
        private String msg;//message to be transmit
        private int nbMsg; // numbre of bits in the message
        private int nbParityBits ; // number of number of parity bits needed
        private boolean isHamming ; //check if it's hamming code ;
        private boolean acceptMsg ; //check if we can transmet the message  exemple 4 11 26
        
        public HammingWord(String message) throws BadStringOperationException{
        	//check if its a binary message and its not null
        	if(!message.matches("[01]+") || message.length()<1)throw new BadStringOperationException("the message is not binary");

        	msg = message;
        	nbMsg= message.length();
        	nbParityBits=0;
        	isHamming = false;
        	acceptMsg= false;
        }
        
        //get number of number of parity bits needed
       public int getNbParityBitsNeeded() {
        	
            nbParityBits=0;
        	while(true)
    		{
        		
    			if(getnbMsg()+nbParityBits+1 <= Math.pow(2,nbParityBits))
    			{
    				break;
    			}
    			nbParityBits++;
    		
    		}
       
			return nbParityBits;
        }
       public int getNbBitsParity() {

           nbParityBits=0;
       	while(true)
   		{
       		
   			if(getnbMsg()<= Math.pow(2,nbParityBits)-1 || getnbMsg() <=3)
   			{
   				break;
   			}
   			nbParityBits++;
   		
   		}
      
			return nbParityBits;
       }
        //get number of bit in the message 
        public int getnbMsg() {
        	int m = msg.length();
        	return m;
        }
        
       
        //get the message
        public String getMsg() {
        	return msg;
        }
        //check if its a hamming code 
        public boolean  isHamming() {
        	
        	if(msg.length() != Math.pow(2,getNbBitsParity())-1){
        		return isHamming=false;
        	}else {
        		return isHamming=true;
        	}
        }
        
        public boolean acceptMsg() {
        	if(msg.length() !=( Math.pow(2, getNbParityBitsNeeded())-1)-getNbParityBitsNeeded()) {
        		return acceptMsg = false;
        	}else {
        		return acceptMsg = true;
        	}
        }
        
        
}

