import java.util.*;

public class StateNim extends State {

	public int coins = 13;
	//public int[] moves = {1,2,3};

	//public String mainStackBK[] = new String [13];
	//public Stack mainStack = new Stack();

	
	//init
	public StateNim() {
//		for (int i = 0; i < 13; i++) {
//			mainStackBK[i] = "o";
	//		mainStack.push("o");	
//		}

				
		player = 1;

	}

	public StateNim(StateNim state) {
	//	for (int i = 12; i >=0; i--) 
	//		this.mainStackBK[i] = state.mainStackBK[i];	
	//	this.mainStack = state.mainStack;
		
		this.coins = state.coins;
		player = state.player;
	}

	public String toString() {	
		String ret = "";
		for (int i = 0; i < coins; i++) {
			//ret+= "mainStackBK[i]" + "\n";
			ret+= "o" + "\n";
		}
		System.out.println(coins);
		return ret;
	}
}