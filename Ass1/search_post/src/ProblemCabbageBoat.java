import java.util.HashSet;
import java.util.Set;

public class ProblemCabbageBoat extends Problem {
    
	boolean goal_test(Object state) {
		int[] acceptState = {1,1,1,1,0,0,0};
		boolean equalsReturn = true;
		StateCabbageBoat puzzleState = (StateCabbageBoat) state;
        for(int i = 0; i < acceptState.length; i++)
        {
            if(acceptState[i] != puzzleState.puzzleArray[i])
                equalsReturn = false;
        }
        return equalsReturn;
	}
  
    Set<Object> getSuccessors(Object state) {
    	
        Set<Object> set = new HashSet<Object>();
		StateCabbageBoat s = (StateCabbageBoat) state;

		StateCabbageBoat ss; //successor state

		if(s.puzzleArray[3] == 0)
		{
			//boat is on right hand side
			//assume input state is valid

			ss = new StateCabbageBoat(s);
			//try cabbage
			//test to see if goat and wolf are on current side
			if(s.puzzleArray[4] == 1 && (s.puzzleArray[5] != 1 || s.puzzleArray[6] != 1))
			{
				ss.puzzleArray[4] = 0;
				ss.puzzleArray[0] = 1;
				ss.puzzleArray[3] = 1;
				set.add(ss);
			}

			ss = new StateCabbageBoat(s);	//btw, coming from c, doing this in java feels gross.
			//try goat
			//No test, goat is always able to be chucked around if there
			if(s.puzzleArray[5] == 1)
			{
				ss.puzzleArray[5] = 0;
				ss.puzzleArray[1] = 1;
				ss.puzzleArray[3] = 1;
				set.add(ss);
			}

			ss = new StateCabbageBoat(s);
			//try wolf
			//test to see if goat and cabbage are on current side
			if(s.puzzleArray[6] == 1 && (s.puzzleArray[4] != 1 || s.puzzleArray[5] != 1))
			{
				ss.puzzleArray[6] = 0;
				ss.puzzleArray[2] = 1;
				ss.puzzleArray[3] = 1;
				set.add(ss);
			}

			ss = new StateCabbageBoat(s);
			//try nothing
			//test to see if wolf and goat are on same side or goat and cabbage are on same side.
			if((s.puzzleArray[4] != 1 || s.puzzleArray[5] != 1) && (s.puzzleArray[5] != 1 || s.puzzleArray[6] != 1))
			{
				ss.puzzleArray[3] = 1;
				set.add(ss);
			}
		} else {
			//boat is on left hand side
			//assume input state is valid

			ss = new StateCabbageBoat(s);
			//try cabbage
			//test to see if goat and wolf are on current side
			if(s.puzzleArray[0] == 1 && (s.puzzleArray[1] != 1 || s.puzzleArray[2] != 1))
			{
				ss.puzzleArray[0] = 0;
				ss.puzzleArray[4] = 1;
				ss.puzzleArray[3] = 0;
				set.add(ss);
			}

			ss = new StateCabbageBoat(s);	//btw, coming from c, doing this in java feels gross.
			//try goat
			//No test, goat is always able to be chucked around if there
			if(s.puzzleArray[1] == 1)
			{
				ss.puzzleArray[1] = 0;
				ss.puzzleArray[5] = 1;
				ss.puzzleArray[3] = 0;
				set.add(ss);
			}

			ss = new StateCabbageBoat(s);
			//try wolf
			//test to see if goat and cabbage are on current side
			if(s.puzzleArray[2] == 1 && (s.puzzleArray[0] != 1 || s.puzzleArray[1] != 1))
			{
				ss.puzzleArray[6] = 1;
				ss.puzzleArray[2] = 0;
				ss.puzzleArray[3] = 0;
				set.add(ss);
			}

			ss = new StateCabbageBoat(s);
			//try nothing
			//test to see if wolf and goat are on same side or goat and cabbage are on same side.
			if((s.puzzleArray[0] == 0 || s.puzzleArray[1] == 0) && (s.puzzleArray[1] != 1 || s.puzzleArray[2] != 1))
			{
				ss.puzzleArray[3] = 0;
				set.add(ss);
			}
		}
        return set;
    }
	
	double step_cost(Object fromState, Object toState) { return 1; }

	public double h(Object state) { return 0; }


	public static void main(String[] args) throws Exception {
		ProblemCabbageBoat problem = new ProblemCabbageBoat();
		int[] puzzleArray = {0,0,0,0,1,1,1};
		/*
		Of form: {cabbage, goat, wolf, boat, cabbage, goat, wolf}
		boat = 0  : boat is on the right side
		boat = 1  : boat is on the left side
		*/
		problem.initialState = new StateCabbageBoat(puzzleArray); 
		
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
