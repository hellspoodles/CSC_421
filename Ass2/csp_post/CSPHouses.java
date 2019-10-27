import java.util.Arrays;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.HashSet;

public class CSPHouses extends CSP {

	static Set<Object> varCol = new HashSet<Object>(
			Arrays.asList(new String[] { "blue", "green", "ivory", "red", "yellow" }));
	static Set<Object> varDri = new HashSet<Object>(
			Arrays.asList(new String[] { "coffee", "milk", "orange-juice", "tea", "water" }));
	static Set<Object> varNat = new HashSet<Object>(
			Arrays.asList(new String[] { "englishman", "japanese", "norwegian", "spaniard", "ukrainian" }));
	static Set<Object> varPet = new HashSet<Object>(
			Arrays.asList(new String[] { "dog", "fox", "horse", "snails", "zebra" }));
	static Set<Object> varCig = new HashSet<Object>(
			Arrays.asList(new String[] { "chesterfield", "kools", "lucky-strike", "old-gold", "parliament" }));

	public boolean isGood(Object X, Object Y, Object x, Object y) {
		// Y is a variable
		// X is a variable
		// x is domain assignment of X
		// y is domain assignment of Y
		// checking to see if, X is x, and Y is y. Is it valid?
		// if X is not even mentioned in by the constraints, just return true
		// as nothing can be violated

		if (!C.containsKey(X)) {
			////System.out.println(" : True - 36");
			return true;
		}

		// uniqueness constraints
		// Of general form. If both X and Y are in this variable set, and X does not
		// equal Y,
		// return false if they are assigned to the same house.
		if (varCol.contains(X) && varCol.contains(Y) && !X.equals(Y) && x.equals(y)) {
			////System.out.println(" : False - 51");
			return false;
		}

		if (varCig.contains(X) && varCig.contains(Y) && !X.equals(Y) && x.equals(y)) {
			//System.out.println(" : False - 56");
			return false;
		}

		if (varPet.contains(X) && varPet.contains(Y) && !X.equals(Y) && x.equals(y)) {
			//System.out.println(" : False - 61");
			return false;
		}

		if (varNat.contains(X) && varNat.contains(Y) && !X.equals(Y) && x.equals(y)) {
			//System.out.println(" : False - 66");
			return false;
		}

		if (varDri.contains(X) && varDri.contains(Y) && !X.equals(Y) && x.equals(y)) {
			//System.out.println(" : False - 71");
			return false;
		}

		// Unary Constraints:
		// 8.Milk is drunk in the middle house.
		if (X.equals("milk") && !x.equals(3)) {
			//System.out.println(" : False - 78");
			return false;
		}
		// 9.The Norwegian lives in the first house on the left.
		if (X.equals("norwegian") && !x.equals(1)) {
			//System.out.println(" : False - 83");
			return false;
		}

		// Binary Constraints
		// 1.The Englishman lives in the red house. 
		if(X.equals("englishman") && Y.equals("red") && !x.equals(y))
			return false;
		// 2.The Spaniard owns a dog. 
		if(X.equals("spaniard") && Y.equals("dog") && !x.equals(y))
			return false;
		// 3.Coffee is drunk in the green house. 
		if(X.equals("coffee") && Y.equals("green") && !x.equals(y))
			return false;
		// 4.The Ukrainian drinks tea
		if(X.equals("ukrainian") && Y.equals("tea") && !x.equals(y))
			return false;
		// 6.The Old-Gold smoker owns snails.
		if(X.equals("old-gold") && Y.equals("snails") && !x.equals(y))
			return false;
		// 7.Kools are being smoked in the yellow house. 
		if(X.equals("kools") && Y.equals("yellow") && !x.equals(y))
			return false;
		// 12.The Lucky-Strike smoker drinks orange juice. 
		if(X.equals("lucky-strike") && Y.equals("orange-juice") && !x.equals(y))
			return false;
		// 13.The Japanese smokes Parliament. 
		if(X.equals("japanese") && Y.equals("parliament") && !x.equals(y))
			return false;


		// Location constraints:
		// 5.The green house is directly to the right of the ivory house.
		if (X.equals("green") && Y.equals("ivory") && !x.equals(Integer.parseInt(y.toString()) + 1)) {
			//System.out.println(" : False - 92");
			return false;
		}
		// 10.The Chesterfield smoker lives next to the fox owner.
		if (X.equals("chesterfield") && Y.equals("fox")
				&& !(x.equals(Integer.parseInt(y.toString()) + 1) || x.equals(Integer.parseInt(y.toString()) - 1))) {
			//System.out.println(" : False - 98");
			return false;
		}
		// 11.Kools are smoked in the house next to the house where the horse is kept.
		if (X.equals("kools") && Y.equals("horse")
				&& !(x.equals(Integer.parseInt(y.toString()) + 1) || x.equals(Integer.parseInt(y.toString()) - 1))) {
			//System.out.println(" : False - 104");
			return false;
		}
		// 14.The Norwegian lives next to the blue house.
		if (X.equals("norwegian") && Y.equals("blue")
				&& !(x.equals(Integer.parseInt(y.toString()) + 1) || x.equals(Integer.parseInt(y.toString()) - 1))) {
			//System.out.println(" : False - 110");
			return false;
		}



		// check to see if there is an arc between X and Y
		// if there isn't an arc, then no constraint, i.e. it is good
		if (!C.get(X).contains(Y)) {
			//System.out.println(" : True - 117");
			return true;
		}
		//System.out.println(" : True - 120");
		return true;
	}

	public static void main(String[] args) throws Exception {
		CSPHouses csp = new CSPHouses();

		// Establish Domain
		Integer[] domain = { 1, 2, 3, 4, 5 };

		for (Object X : varCol)
			csp.addDomain(X, domain);
		for (Object X : varDri)
			csp.addDomain(X, domain);
		for (Object X : varPet)
			csp.addDomain(X, domain);
		for (Object X : varNat)
			csp.addDomain(X, domain);
		for (Object X : varCig)
			csp.addDomain(X, domain);

		// Establish Constraints
		// Uniqueness constraints
		for (Object X : varCol)
			for (Object Y : varCol)
				csp.addBidirectionalArc(X, Y);
		for (Object X : varCig)
			for (Object Y : varCig)
				csp.addBidirectionalArc(X, Y);
		for (Object X : varPet)
			for (Object Y : varPet)
				csp.addBidirectionalArc(X, Y);
		for (Object X : varNat)
			for (Object Y : varNat)
				csp.addBidirectionalArc(X, Y);
		for (Object X : varDri)
			for (Object Y : varDri)
				csp.addBidirectionalArc(X, Y);

		Search search = new Search(csp);
		System.out.println(search.BacktrackingSearch());
	}
}