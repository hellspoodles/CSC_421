import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// because of a minimal description, and setting coins "aside" doesn't 
// specify setting them into stacks, this is a game of single stack nim
public class GameNim extends Game { 

	//useless, but Game expects a double, so, 
	int WinningScore = 10;
    int LosingScore = -10;
    int NeutralScore = 0;

	public GameNim() {
    	currentState = new StateNim();
    }


    public boolean isWinState(State state) {
        StateNim cstate = (StateNim) state;
        //player who did the last move
        int previous_player = (state.player==0 ? 1 : 0);  
      
        	if (cstate.coins <= 0) {
        		return true;
        	}
        	return false;
        }		 
    
    public boolean isStuckState(State state) {
    	return false; // simple game has no stuck states	
   }


    public Set<State> getSuccessors(State state) {
		if (isWinState(state))
			return null;
		
		Set<State> successors = new HashSet<State>();
        StateNim cstate = (StateNim) state;

        StateNim successor_state;
       	successor_state = new StateNim(cstate);
       	successor_state.player = (state.player == 0 ? 1 : 0);

//just terrible lol
  
     	if (cstate.coins > 3) {
          	successor_state.coins-=1;
          	successors.add(successor_state);

          	StateNim successor_state2;
       		successor_state2 = new StateNim(cstate);
       		successor_state2.coins -=2;
       		successors.add(successor_state2);

       		StateNim successor_state3;
       		successor_state3 = new StateNim(cstate);
       		successor_state3.coins -=3;
       		successors.add(successor_state3);
       		
       		return successors;
       	}
       	
       	if (cstate.coins == 3) {
       	//	successor_state.coins-=1;
       	//	successors.add(successor_state);
       		
       		StateNim successor_state2;
       		successor_state2 = new StateNim(cstate);
       		successor_state2.coins -=2;
       		successors.add(successor_state2);

       		return successors;
       	}

       	if (cstate.coins < 3) {
       			successor_state.coins-=1;
       			successors.add(successor_state);
       			return successors;
       	}

        return successors;
    }	

  	// again, meaningless. 
    public double eval(State state) {   
    	if(isWinState(state)) {
    		
    		int previous_player = (state.player==0 ? 1 : 0);
    	
	    	if (previous_player > 0) //computer wins
	            return WinningScore;
	    	else 
	            return LosingScore;
    	}

        return NeutralScore;
    }


	public static void main(String[] args) throws Exception {


	        Game game = new GameNim(); 
	        Search search = new Search(game);
	        int depth = 13; // assuming
	        
	        //needed to get human's move
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        
	        while (true) {
	        	
	        	StateNim nextState = null;
	        	
	            switch ( game.currentState.player ) {
	              case 1: //Human
	                  
	            	  //get human's move
	                  System.out.print("You can take 1, 2, or 3 coins: ");
	                  int pos = Integer.parseInt( in.readLine() );
	            	  
	                  if (pos > 3) {
	                  	System.out.println("Invalid selection, your move is now 3.");
	              		pos = 3;
	                  } else if (pos < 1) {
	                  	System.out.println("Invalid selection, your move is now 1.");
	                  	pos = 1;
	                  }

	                  nextState = new StateNim((StateNim)game.currentState);
	                  nextState.player = 1;
	        			

	                 // for (int i = nextState.coins-1; i >= nextState.coins-1 -pos; i--) {
	                 // 		nextState.mainStackBK[i] = "";
	                 // }

	                
	                  	nextState.coins -= pos;
	                 

	        //			for (int i = 0; i < pos; i++) {
	        //				nextState.mainStack.pop();
	        //			}
	        			

	                  System.out.println("Human: \n" + nextState);
	                  break;
	                  
	              case 0: //Computer
	            	  
	            	  nextState = (StateNim)search.bestSuccessorState(depth);
	            	  nextState.player = 0;
	            	  System.out.println("Computer: \n" + nextState);
	                  break;
	            }
	                        
	            game.currentState = nextState;
	            //change player
	            game.currentState.player = (game.currentState.player==0 ? 1 : 0);
	            
	            //Who wins?
	            if ( game.isWinState(game.currentState) ) {
	            
	            	if (game.currentState.player == 1) //i.e. last move was by the computer
	            		System.out.println("You Win!");
	            	else
	            		System.out.println("Computer Wins!");
	            	
	            	break;
	            }
	        }
	    }
	}

