import java.util.HashSet;
import java.util.Set;

public class ProblemColonialRacism extends Problem {
    
	boolean goal_test(Object state) {
		int[] acceptState = {3,3,1,0,0};
		boolean equalsReturn = true;
		StateColonialRacism puzzleState = (StateColonialRacism) state;
        for(int i = 0; i < acceptState.length; i++)
        {
            if(acceptState[i] != puzzleState.puzzleArray[i])
                equalsReturn = false;
        }
        return equalsReturn;
	}
  
    Set<Object> getSuccessors(Object state) {
    	
        Set<Object> set = new HashSet<Object>();
		StateColonialRacism s = (StateColonialRacism) state;

		StateColonialRacism ss; //successor state
		

		//cannot have more reavers on one side or else the browncoats get eaten
		if(s.puzzleArray[2] == 1)
		{
			//try sending one to each side.
			//reaver
			ss = new StateColonialRacism(s);
			//browncoat
			//try sending two to each side
		} else {

		}


        return set;
	}
	
	double step_cost(Object fromState, Object toState) { return 1; }

	public double h(Object state) { return 0; }


	public static void main(String[] args) throws Exception {
		ProblemColonialRacism problem = new ProblemColonialRacism();
		int[] puzzleArray = {0,0,0,1,3,3};
		/*
		Of form: {cabbage, goat, wolf, boat, cabbage, goat, wolf}
		boat = 0  : boat is on the right side
		boat = 1  : boat is on the left side
		*/
		problem.initialState = new StateColonialRacism(puzzleArray); 
		
		Search search  = new Search(problem);
		
		System.out.println("TreeSearch------------------------");
		//System.out.println("BreadthFirstTreeSearch:\t\t" + search.BreadthFirstTreeSearch());
		//System.out.println("UniformCostTreeSearch:\t\t" + search.UniformCostTreeSearch());
		//System.out.println("DepthFirstTreeSearch:\t\t" + search.DepthFirstTreeSearch());
		//System.out.println("GreedyBestFirstTreeSearch:\t" + search.GreedyBestFirstTreeSearch());
		//System.out.println("AstarTreeSearch:\t\t" + search.AstarTreeSearch());
		
		System.out.println("\n\nGraphSearch----------------------");
		System.out.println("BreadthFirstGraphSearch:\t" + search.BreadthFirstGraphSearch());
		System.out.println("UniformCostGraphSearch:\t\t" + search.UniformCostGraphSearch());
		System.out.println("DepthFirstGraphSearch:\t\t" + search.DepthFirstGraphSearch());
		System.out.println("GreedyBestGraphSearch:\t\t" + search.GreedyBestFirstGraphSearch());
		System.out.println("AstarGraphSearch:\t\t" + search.AstarGraphSearch());
		
		System.out.println("\n\nIterativeDeepening----------------------");
		//System.out.println("IterativeDeepeningTreeSearch:\t" + search.IterativeDeepeningTreeSearch());
		System.out.println("IterativeDeepeningGraphSearch:\t" + search.IterativeDeepeningGraphSearch());
	}
	
}
