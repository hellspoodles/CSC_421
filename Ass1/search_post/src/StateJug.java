public class StateJug {

    int N;
    int[] jArray;


    public StateJug (int[] jArray) { 
        this.jArray = jArray; 
    	N = jArray.length;
    }


    public StateJug(StateJug state) {
    	N = state.N;
    	jArray = new int[N];
    	
        for(int i=0; i<N; i++)
        	jArray[i] = state.jArray[i];
    }


    public boolean equals(Object o) {
        return java.util.Arrays.equals( jArray, ((StateJug) o).jArray );
    }
    
    public int hashCode() {
        return java.util.Arrays.hashCode( jArray );
    }    
    
    public String toString() {
    	return java.util.Arrays.toString( jArray );
    }


}


