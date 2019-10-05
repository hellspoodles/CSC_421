public class StatePancake {
	
int N;
int[] pArray;


public StatePancake (int[] pArray) { 
        this.pArray = pArray; 
    	N = pArray.length;
    }


public StatePancake(StatePancake state) {
    	N = state.N;
    	pArray = new int[N];
    	
        for(int i=0; i<N; i++)
        	pArray[i] = state.pArray[i];
    }


    public boolean equals(Object o) {
        return java.util.Arrays.equals( pArray, ((StatePancake) o).pArray );
    }
    
    public int hashCode() {
        return java.util.Arrays.hashCode( pArray );
    }    
    
    public String toString() {
    	return java.util.Arrays.toString( pArray );
    }


}
