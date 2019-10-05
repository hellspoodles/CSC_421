import java.util.HashSet;
import java.util.Set;

public class ProblemPancake extends Problem {

	static int size;
	static void dumb(int x) {
		size = x;
	}
		
	boolean goal_test(Object state) {
		boolean equalsReturn = true;
		StatePancake pState = (StatePancake) state;
       		for(int i = 0; i < size; i++) {
            		if(i != pState.pArray[i])
                		equalsReturn = false;
        	}
        	return equalsReturn;
	}

	Set<Object> getSuccessors(Object state) {
		Set<Object> set = new HashSet<Object>();

		StatePancake p = (StatePancake) state;
		StatePancake pp; // successor pancake 
	
		//todo 	

		return set;
	}

	double step_cost(Object fromState, Object toState) {return 1;}

	public double h(Object state) {return 0;}

	public static void main(String[] args) throws Exception {
		ProblemPancake problem = new ProblemPancake();
		int [] pArray = {1, 0, 3, 5, 2, 4};
		int size = pArray.length;
		dumb(size);


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
