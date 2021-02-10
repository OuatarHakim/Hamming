import javax.management.BadStringOperationException;

public class HammingWord {
	
        private String msg;//message to be transmit
        private int nbParityBits ; // number of number of parity bits needed
        private boolean isHamming ; //check if it's hamming code ;
        
        
        public HammingWord(String message) throws BadStringOperationException{
        	//check if its a binary message and its not null
        	if(!message.matches("[01]+") || message.length()<1)throw new BadStringOperationException("the message is not binary");

        	msg = message;
        	nbParityBits=0;
        	isHamming = false;
        }
        
        //get number of number of parity bits needed
        private int getNbParityBits() {
        	
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
        //get number of bit in the message 
        private int getnbMsg() {
        	int m = msg.length();
        	return m;
        }
        
       
        
        //check if its a hamming code 
        private boolean  getIsHamming() {
        	
        	if(msg.length() != Math.pow(2, nbParityBits)){
        		return isHamming=false;
        	}else {
        		return isHamming=true;
        	}
        }
        
}
