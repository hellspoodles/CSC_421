import java.util.HashSet;
import java.util.Set;

public class ProblemPancake extends Problem {
		
	boolean goal_test(Object state) {
		StatePancake pState = (StatePancake) state;
		for(int i = 0; i < pState.pArray.length; i++) {
				if(i != pState.pArray[i])
					return false;
		}
        return true;
	}

	int[] flipStack(int flipLocation, int[] pancakeStack)
	{
		int size = pancakeStack.length;
		//flip the first "flipLocation" values
		int[] newstack = new int[size];
		for(int i = 0; i < size; i++)
		{
			newstack[i] = pancakeStack[i];
		}
		for(int i = 0; i <= flipLocation; i++)
		{
			newstack[i] = pancakeStack[flipLocation - i];
		}
		return newstack;
	}

	Set<Object> getSuccessors(Object state) {
		Set<Object> set = new HashSet<Object>();

		StatePancake p = (StatePancake) state;
		StatePancake pp; // successor pancake 
	
		for(int i = 0; i < p.pArray.length; i++)
		{
			pp = new StatePancake(p);
			pp.pArray = flipStack(i, pp.pArray);
			set.add(pp);
		}
		return set;
	}

	double step_cost(Object fromState, Object toState) {return 1;}

	public double h(Object state) {
		int huristic = 0;
		StatePancake p = (StatePancake) state;
		for(int i = 1; i < p.pArray.length; i++)
		{
			if(p.pArray[i] > p.pArray[i-1])
			{
				huristic--;
			}
		}
		return huristic;
	}

	public static void main(String[] args) throws Exception {
		ProblemPancake problem = new ProblemPancake();
		int [] pArray = {1, 0, 3, 5, 2, 4};


		problem.initialState = new StatePancake(pArray);
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
