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

	boolean validState(Object state)
	{
		StateColonialRacism che = (StateColonialRacism) state;
		if(che.puzzleArray[0] < che.puzzleArray[1] && che.puzzleArray[0] > 0)
		{
			return false;
		}
		if(che.puzzleArray[3] < che.puzzleArray[4] && che.puzzleArray[3] > 0)
		{
			return false;
		}
		return true;
	}
  
    Set<Object> getSuccessors(Object state) {
    	
        Set<Object> set = new HashSet<Object>();
		StateColonialRacism s = (StateColonialRacism) state;

		StateColonialRacism ss; //successor state
		
		///Puzzle arry def
		///  0    1   2    3    4
		///[good,bad,boat,good,bad]
		//boat = 0  : boat is on the right side
		//boat = 1  : boat is on the left side
		///

		//cannot have more reavers on one side or else the browncoats get eaten
		if(s.puzzleArray[2] == 1)	//if boat is on left side...
		{
						//try sending one to each side.
			//reaver
			ss = new StateColonialRacism(s);
			if(s.puzzleArray[1] > 0)
			{
				ss.puzzleArray[1] = ss.puzzleArray[1] - 1;
				ss.puzzleArray[2] = 0;
				ss.puzzleArray[4] = ss.puzzleArray[4] + 1;
				if(validState(ss))
					set.add(ss);
			}

			//browncoat
			ss = new StateColonialRacism(s);
			if(s.puzzleArray[0] > 0)
			{
				ss.puzzleArray[0] = ss.puzzleArray[0] - 1;
				ss.puzzleArray[2] = 0;
				ss.puzzleArray[3] = ss.puzzleArray[3] + 1;
				if(validState(ss))
					set.add(ss);
			}
			//try sending two to each side
			// reaver browncoat
			ss = new StateColonialRacism(s);
			if(s.puzzleArray[0] > 0 && s.puzzleArray[1] > 0)
			{
				ss.puzzleArray[0] = ss.puzzleArray[0] - 1;
				ss.puzzleArray[1] = ss.puzzleArray[1] - 1;
				ss.puzzleArray[2] = 0;
				ss.puzzleArray[3] = ss.puzzleArray[3] + 1;
				ss.puzzleArray[4] = ss.puzzleArray[4] + 1;
				if(validState(ss))
					set.add(ss);
			}
			// reaver reaver
			ss = new StateColonialRacism(s);
			if(s.puzzleArray[1] > 1)
			{
				ss.puzzleArray[1] = ss.puzzleArray[1] - 2;
				ss.puzzleArray[2] = 0;
				ss.puzzleArray[4] = ss.puzzleArray[4] + 2;
				if(validState(ss))
					set.add(ss);
			}
			// browncoat browncoat
			ss = new StateColonialRacism(s);
			if(s.puzzleArray[0] > 1)
			{
				ss.puzzleArray[0] = ss.puzzleArray[0] - 2;
				ss.puzzleArray[2] = 0;
				ss.puzzleArray[3] = ss.puzzleArray[3] + 2;
				if(validState(ss))
					set.add(ss);
			}
		} else {//if boat is on right side...
			//try sending one to each side.
			//reaver
			ss = new StateColonialRacism(s);
			if(s.puzzleArray[4] >= 1)
			{
				ss.puzzleArray[4] = ss.puzzleArray[4] - 1;
				ss.puzzleArray[2] = 1;
				ss.puzzleArray[1] = ss.puzzleArray[1] + 1;
				if(validState(ss))
					set.add(ss);
			}

			//browncoat
			ss = new StateColonialRacism(s);
			if(s.puzzleArray[3] >= 1)
			{
				ss.puzzleArray[3] = ss.puzzleArray[3] - 1;
				ss.puzzleArray[2] = 1;
				ss.puzzleArray[0] = ss.puzzleArray[0] + 1;
				if(validState(ss))
					set.add(ss);
			}
			//try sending two to each side
			// reaver browncoat
			ss = new StateColonialRacism(s);
			if(s.puzzleArray[3] >= 1 && s.puzzleArray[4] >= 1)
			{
				ss.puzzleArray[3] = ss.puzzleArray[3] - 1;
				ss.puzzleArray[4] = ss.puzzleArray[4] - 1;
				ss.puzzleArray[2] = 1;
				ss.puzzleArray[0] = ss.puzzleArray[0] + 1;
				ss.puzzleArray[1] = ss.puzzleArray[1] + 1;
				if(validState(ss))
					set.add(ss);
			}
			// reaver reaver
			ss = new StateColonialRacism(s);
			if(s.puzzleArray[4] >= 2)
			{
				ss.puzzleArray[4] = ss.puzzleArray[4] - 2;
				ss.puzzleArray[2] = 1;
				ss.puzzleArray[1] = ss.puzzleArray[1] + 2;
				if(validState(ss))
					set.add(ss);
			}
			// browncoat browncoat
			ss = new StateColonialRacism(s);
			if(s.puzzleArray[3] >= 2)
			{
				ss.puzzleArray[3] = ss.puzzleArray[3] - 2;
				ss.puzzleArray[2] = 1;
				ss.puzzleArray[0] = ss.puzzleArray[0] + 2;
				if(validState(ss))
					set.add(ss);
			}
		}
		//System.out.println(set.toString());
        return set;
	}
	
	double step_cost(Object fromState, Object toState) { return 1; }

	public double h(Object state) { 
		StateColonialRacism s = (StateColonialRacism) state;
		return  6 - (s.puzzleArray[0] + s.puzzleArray[1]);
	}


	public static void main(String[] args) throws Exception {
		ProblemColonialRacism problem = new ProblemColonialRacism();
		int[] puzzleArray = {0,0,0,3,3};
		/*
		Of form: [good,bad,boat,good,bad]
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
