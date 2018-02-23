package DecisionTree;
import java.util.*;

public class DecisionTreeLearning {
	private String[][] matrix; 
	private String[][] examples;
	private String[] attributes;
	private String[][] parentExamples;
	private Tree tree;
	private boolean examplesSameClass;
	private String classification;
	private int rows;
	private int cols;

	
	public DecisionTreeLearning(String[][] examples, String attributes[], String[][] parentExamples, String[][] matrix){
		this.examples = examples;
		this.matrix = matrix;
		this.rows = examples.length;
		this.cols = examples[0].length;
		this.attributes = attributes;
		this.parentExamples = parentExamples;
		setSameClass();
		this.tree = null;
	}
	
	public Tree DecisionTree(){
		boolean noex = true;
		boolean noat = true;
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				if(examples[i][j] != null){
					noex = false;
					break;
				}
			}
			if(!noex){
				break;
			}
		}
		for(int i = 0; i < attributes.length-1; i++){
			if(attributes[i] != null){
				noat = false;
				break;
			}
		}
		if(noex){
			Tree leaf = new Tree(PluralityValue(this.parentExamples));
			return leaf;
		}
		else if(examplesSameClass){
			Tree leaf = new Tree(classification);
			return leaf;
		}
		else if(noat){
			Tree leaf = new Tree(PluralityValue(this.examples));
			return leaf;
		}
		else{
			int gain = Integer.MIN_VALUE;
			int nbr = 0;
			for(int j = 0; j < rows-1; j++){
				int temp = 1;
				//int temp = Importance(attributes[j], examples);
				if (temp > gain){
					gain = temp;
					nbr = j;
				}
			}
			this.tree = new Tree(attributes[nbr]); //hur ska trädet representeras
			String[] values = getValues(nbr);
			String[][][] exs = new String[values.length][rows][cols];
			for(int v = 0; v < values.length; v++){
				for(int i = 0; i < rows; i++){
					for(int j = 0; j < cols; j++){
						if(j != nbr){
							exs[v][i][j] = examples[i][j];
						}
						else{
							if(examples[i][j] == values[v]){
								exs[v][i][j] = examples[i][j];
							}
							else{
								exs[v][i][j] = null;
							}
						}
					}
				}	
			}
			String[] newAtr = new String[attributes.length];
			//boolean jump = false;
			/*for(int i = 0; i < attributes.length; i++){
				if(i == nbr){
					jump = true;
				}
				else{
					if(jump){
						newAtr[i-1] = attributes[i];
					}
					else{
						newAtr[i] = attributes[i];
					}
				}
			}*/
			for(int i = 0; i < attributes.length; i++){
				if(nbr != i){
					newAtr[i] = attributes[i];
				}
				else{
					newAtr[i] = null;
				}
			}
			DecisionTreeLearning P1AI;
			for(int v = 0; v < values.length; v++){
				P1AI = new DecisionTreeLearning(exs[v], newAtr, this.examples, this.matrix);
				Tree subTree = P1AI.DecisionTree();
				this.tree.addChild(subTree);
			}
		}
		return this.tree;
	}
	
	private String[] getValues(int c){
		String[] values = new String[examples[0].length];
		ArrayList<String> vals= new ArrayList<String>();
		for(int r = 0; r < examples[0].length; r++){
			values[r] = examples[r][c];
		}
		if(values.length > 0){
			vals.add(values[0]);
		}
		boolean add = true;
		for(int i = 1; i < values.length; i++){
			for(int j = 0; j < vals.size(); j++){
				if(vals.get(j) != null && values[i] != null){
					if(values[i].equals(vals.get(j))){
						add = false;
						break;
					}
				}
			}
			if(add){
				vals.add(values[i]);
			}
			add = true;
		}
		String[] vale = new String[vals.size()];
		for(int i = 0; i < vals.size(); i ++){
			vale[i]=vals.get(i);
		}
		return vale;
	}
	
	private void setSameClass(){ 
		this.examplesSameClass = true;
		this.classification = examples[0][examples[0].length-1];
		for(int i = 0; i < examples.length - 1; i ++){
			if((i + 1) < examples.length){
				if(examples[i][examples[0].length-1] != examples[i+1][examples[0].length-1]){
					this.examplesSameClass = false;
					this.classification = null;
				}
			}
		}
	}
	
	private String PluralityValue(String[][] pE){
		for(int i = 0; i < pE.length; i++){
			for(int j = 0; j < pE.length; j++){
				
			}
		}
	}
		/*int[] nbr = new int[pE.length];
		String[] values = new String[pE.length];
		for(int r = 0; r < pE.length; r++){
			values[r] = pE[r][c];
		}
		for(int i = 0; i < values.length; i++){
			nbr[i] = 0;
			for(int j = 0; j < values.length; j++){
				if(values[i] == values[j]){
					nbr[i]++;
				}
			}
		}
		int max = 0;
		int maxplace = 0;
		for(int q = 0; q < nbr.length; q++){
			if(nbr[q] > max){
				max = nbr[q];
				maxplace = q;
			}
		}
		return values[maxplace];
	}
	
	private int Importance(String attri, String[][] ex){
		return 0;
	}*/
}
/*
int unique = 0;
boolean uni = true;
for(int i = 0; i < values.length; i++){
	for(int j = 0; j < values.length; j++){
		if((i != j) && values[i].equals(values[j])){
			uni = false;
			break;
		}
	}
	if(uni){
		unique++;
	}
}
String[] val = new String[unique];
boolean cont = true;
for(int i = 0; i < values.length; i++){
	for(int j = 0; j < unique; j++){
		if(val[j] != null){
			if(val[j] == values[i]){
				cont = false;
			}
		}
	}
	if(cont){
		for(int j = 0; j < unique; j++){
			if(val[j] == null){
				val[j] = values[i];
			}
		}
	}
}
return val;*/
