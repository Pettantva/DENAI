package DecisionTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class main {

	public static void main(String[] args) {
		String file = "/Users/ludvigpettersson/Documents/text.txt";
		DataMatrix matrix = new DataMatrix(file);
		String[][] mat = matrix.get();
		DecisionTreeLearning P1AI = new DecisionTreeLearning(matrix.getExamples(mat), matrix.getAttributes(mat), null, mat);
		Tree tree = P1AI.DecisionTree();
		tree.print();
	}
}
