import java.util.*;

public class StateNim extends State {

	public int coins = 13;

	public StateNim() {

		player = 0;

	}

	public StateNim(StateNim state) {
		
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