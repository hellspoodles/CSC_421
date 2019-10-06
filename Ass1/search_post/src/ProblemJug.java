import java.util.HashSet;
import java.util.Set;

public class ProblemJug extends Problem {


	boolean goal_test(Object state) {
		StateJug jState = (StateJug) state;
		for(int i = 0; i < jState.jArray.length; i++)
		{
			if(jState.jArray[i] == 1)
				return true;
		}
		return false;
	}


	Set<Object> getSuccessors(Object state) {
		Set<Object> set = new HashSet<Object>();

		StateJug j = (StateJug) state;
		StateJug jj;//abrahms. or the A1 Abrhams Main Battle Tank. <3
		//[12,8,3]
		//fill each jug
		jj = new StateJug(j);
		jj.jArray[0] = 12;
		set.add(jj);
		jj = new StateJug(j);
		jj.jArray[1] = 8;
		set.add(jj);
		jj = new StateJug(j);
		jj.jArray[2] = 3;
		set.add(jj);
		//empty each jug
		jj = new StateJug(j);
		jj.jArray[0] = 0;
		set.add(jj);
		jj = new StateJug(j);
		jj.jArray[1] = 0;
		set.add(jj);
		jj = new StateJug(j);
		jj.jArray[2] = 0;
		set.add(jj);
		//pour each jug into each other.
		int buff,a,b,amax = 0;	//how much can be filled into the destination

		// 12 < 8
		jj = new StateJug(j); a = 0; b = 1; amax = 12;
		buff = amax - jj.jArray[a];
		if(buff <= jj.jArray[b]){jj.jArray[a] = amax; jj.jArray[b] -= buff;}
		else{jj.jArray[a] += jj.jArray[b]; jj.jArray[b] = 0;}
		set.add(jj);
		// 12 < 3
		jj = new StateJug(j); a = 0; b = 2; amax = 12;
		buff = amax - jj.jArray[a];
		if(buff <= jj.jArray[b]){jj.jArray[a] = amax; jj.jArray[b] -= buff;}
		else{jj.jArray[a] += jj.jArray[b]; jj.jArray[b] = 0;}
		set.add(jj);

		//8 < 12
		jj = new StateJug(j); a = 1; b = 0; amax = 8;
		buff = amax - jj.jArray[a];
		if(buff <= jj.jArray[b]){jj.jArray[a] = amax; jj.jArray[b] -= buff;}
		else{jj.jArray[a] += jj.jArray[b]; jj.jArray[b] = 0;}
		set.add(jj);

		//8 < 3
		jj = new StateJug(j); a = 1; b = 2; amax = 8;
		buff = amax - jj.jArray[a];
		if(buff <= jj.jArray[b]){jj.jArray[a] = amax; jj.jArray[b] -= buff;}
		else{jj.jArray[a] += jj.jArray[b]; jj.jArray[b] = 0;}
		set.add(jj);

		//3 < 12
		jj = new StateJug(j); a = 2; b = 0; amax = 3;
		buff = amax - jj.jArray[a];
		if(buff <= jj.jArray[b]){jj.jArray[a] = amax; jj.jArray[b] -= buff;}
		else{jj.jArray[a] += jj.jArray[b]; jj.jArray[b] = 0;}
		set.add(jj);

		//3 < 8
		jj = new StateJug(j); a = 2; b = 1; amax = 3;
		buff = amax - jj.jArray[a];
		if(buff <= jj.jArray[b]){jj.jArray[a] = amax; jj.jArray[b] -= buff;}
		else{jj.jArray[a] += jj.jArray[b]; jj.jArray[b] = 0;}
		set.add(jj);


		//System.out.println(j.toString() + " => " + set.toString());
		return set;
	}


	double step_cost(Object fromState, Object toState) {return 1;}

	public double h(Object state) {return 0;}

	public static void main(String[] args) throws Exception {
	
		ProblemJug problem = new ProblemJug();
		int [] jArray = {0, 0, 0};

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
		
		//System.out.println("\n\nIterativeDeepening----------------------");
		//System.out.println("IterativeDeepeningTreeSearch:\t" + search.IterativeDeepeningTreeSearch());
		System.out.println("IterativeDeepeningGraphSearch:\t" + search.IterativeDeepeningGraphSearch());	


	}
}

