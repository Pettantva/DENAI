package DecisionTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class main {

	public static void main(String[] args) {
<<<<<<< HEAD
=======
		//test();
		String file = "/Users/ludvigpettersson/Documents/text.txt";
		DataMatrix matrix = new DataMatrix(file);
		String[][] mat = matrix.get();
		DecisionTreeLearning P1AI = new DecisionTreeLearning(matrix.getExamples(mat), matrix.getAttributes(mat), null, mat);
		Tree tree = P1AI.DecisionTree();
		tree.print();
		int hej = 0;
>>>>>>> 241465681e08dc6d85b4479543db09000e8f3438
		
		
		
		
<<<<<<< HEAD
		
=======
		for(int i = 0; i < matrix.getNrRows(); i++){
			System.out.println("");
			for(int j = 0; j < matrix.getNrCols(); j++){
				System.out.print(mat[i][j] + "     ");
			}
		}
		
	}
	public static void test(){
		String file = "/Users/Dalle/Dropbox/Skola/4/AI - EDAF70/Ass2/text.txt";
		DataMatrix matrix = new DataMatrix(file);
		String[][] newmatrix = matrix.get();
		String[] col = matrix.getColumn(0);
		String[] decision = matrix.getColumn(matrix.getNrCols() - 1);
		Map<String, Integer> seussCount = new HashMap<String,Integer>();
	    for(int i = 1; i < col.length ; i++){
	    	String combined = col[i] + " " + decision[i];
	       Integer count = seussCount.get(combined);
	       if (count ==  null) {
	           count = 0;
	       }
	       seussCount.put(combined, count + 1);
	    }
	    Set<String> set = seussCount.keySet();
	    String[] keyset = set.toArray(new String[set.size()]);
	    for(int j = 0; j < keyset.length ; j++){
	    	System.out.println(keyset[j]+ " " + seussCount.get(keyset[j]));
	    }
>>>>>>> 241465681e08dc6d85b4479543db09000e8f3438
	}
	
	
}
