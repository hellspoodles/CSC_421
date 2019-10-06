import java.util.HashSet;
import java.util.Set;

public class ProblemJug extends Problem {


	boolean goal_test(Object state) {
		StateJug jState = (StateJug) state;
		for (int x: jState.jArray) {
			if (Integer.valueOf(x) != 1)
				return false;
		}
		return true;
	}


	Set<Object> getSuccessors(Object state) {
		Set<Object> set = new HashSet<Object>();

		StateJug j = (StateJug) state;
		StateJug jj; 

		int x = j.jArray[0]; //12
		int y = j.jArray[1]; //8 
		int z = j.jArray[2]; //3

		 // non-programmatic solution. sorry sylvia
		
		 //x=12, y=0, z=0 --fill a
		 //x=4, y=8, z=0 -- a>b
	         //x=4, y=5, z=3 -- b>c
	 	 //x=7, y=5, z=0 -- c>a
		 //x=7, y=0, z=0 (empty b)
		 //x=0, y=7, z=0 -- a>b
		 //x=0, y=4, z=3 -- b>c
		 //x=3, y=4, z=0 -- c>a
		 //x=3, y=1, z=3 -- (b>c)
		 

		return null;
		

	}


	double step_cost(Object fromState, Object toState) {return 1;}

	public double h(Object state) {
		return null;
	}

	public static void Main(String[] args) throws Exception {
	
		ProblemJug problem = new ProblemJug();
		int [] jArray = {12, 8, 3};

		problem.initialState = new StateJug(jArray);
		Search search = new Search(problem);


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

