public class StateMissionaryCannibal
{    
	int N;
    int[] puzzleArray;
    /*
    Of form: {cabbage, goat, wolf, boat, cabbage, goat, wolf}
    boat = 0  : boat is on the right side
    boat = 1  : boat is on the left side
    */
    //boop
    
    public StateMissionaryCannibal(int[] puzzleArray) { 
        this.puzzleArray = puzzleArray; 
    	N = puzzleArray.length;
    }
    
    //It has to be a copy of values not reference because we will 
    //create many states and don't want to overwrite the same array.
    public StateMissionaryCannibal(StateMissionaryCannibal state) {
    	N = state.N;
    	puzzleArray = new int[N];
    	
        for(int i=0; i<N; i++)
        	puzzleArray[i] = state.puzzleArray[i];
    }
    
    public boolean equals(Object o) {
        return java.util.Arrays.equals( puzzleArray, ((StateMissionaryCannibal) o).puzzleArray );
    }
    
    public int hashCode() {
        return java.util.Arrays.hashCode( puzzleArray );
    }    
    
    public String toString() {
    	return java.util.Arrays.toString( puzzleArray );
    }

    public boolean stateValid()
    {
        //check lhs
        if(puzzleArray[0] < puzzleArray[1])
            return false;
        if(puzzleArray[3] < puzzleArray[4])
            return false;
        return true;
    }
}