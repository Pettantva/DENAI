package DecisionTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class importance {
	private String[][] newmatrix;
	String attribute;
	int rows;
	int cols;
	public importance(String attribute,String[][] newmatrix){
		this.attribute = attribute;
		this.newmatrix = newmatrix;
		this.cols = newmatrix[0].length;
		this.rows = newmatrix.length;
		//double gain = calcGain();
		//System.out.println(gain);
		
	}
	private String[] collect(){
		String[] col = getColumn(attributeNr());
		String[] decision = getColumn(newmatrix[0].length -1);
		
	    
		Map<String, Integer> seussCount = new HashMap<String,Integer>();
	    for(int i = 2; i < col.length ; i++){
	    	String combined = col[i] + " " + decision[i];
	       Integer count = seussCount.get(combined);
	       if (count ==  null) {
	           count = 0;
	       }
	       seussCount.put(combined, count + 1);
	    }
	    Set<String> set = seussCount.keySet();
	    String[] keyset = set.toArray(new String[set.size()]);
	    String[] collect = new String[keyset.length];
	    for(int j = 0; j < keyset.length ; j++){
	    	collect[j] = keyset[j]+ " " + seussCount.get(keyset[j]);
	    }
	    return collect;
		
	}
	private String[] getColumn(int nr){
		String[] column = new String[rows];
		for(int i = 0; i < rows ; i++){
			column[i] = newmatrix[i][nr]; // eventuellt tvärtom
		}
		return column;
	}
	private int attributeNr(){
		int attributeNr = 0;
		for(int i = 0; i < newmatrix[0].length ; i++){
			if(newmatrix[0][i].equals(attribute)){
				attributeNr = i;
			}
		}
		return attributeNr;
	}
	private String[][] beforeEval(){
		String[] collection = collect();
		//String file = "/Users/Dalle/Dropbox/Skola/4/AI - EDAF70/Ass2/text.txt";
		//int attribute = 8;
		//DataMatrix matrix = new DataMatrix(file);
		//String[][] newmatrix = matrix.get();
		
		String[] types = newmatrix[1][attributeNr()].split("\\s+");
		String[][] typeData = new String[3][types.length];
		//typeData[0][0] = types[0];
		//typeData[0][1] = types[1];
		for(int a = 0; a < types.length ; a ++){
			typeData[0][a] = types[a];
		}
		for(int i = 0; i < types.length ; i++){
			for(int j = 0; j < collection.length ; j++){
				String[] splitCollection = collection[j].split("\\s+");
				if(types[i].equals(splitCollection[0]) && splitCollection[1].equals("Yes")){
					if(typeData[1][i] != null){
						int value = Integer.parseInt(typeData[1][i]);
						int colValue = Integer.parseInt(splitCollection[2]);
						String sum = Integer.toString(value + colValue);
						typeData[1][i] = sum;
						typeData[2][i] = Integer.toString(colValue);
 					}
					else{
						int colValue = Integer.parseInt(splitCollection[2]);
						typeData[1][i] = Integer.toString(colValue);
						typeData[2][i] = Integer.toString(colValue);
					}
					
				}
				else if(types[i].equals(splitCollection[0]) && splitCollection[1].equals("No")){
					if(typeData[1][i] != null){
						int value = Integer.parseInt(typeData[1][i]);
						int colValue = Integer.parseInt(splitCollection[2]);
						String sum = Integer.toString(value + colValue);
						typeData[1][i] = sum;
						
 					}
					else{
						int colValue = Integer.parseInt(splitCollection[2]);
						
						typeData[1][i] = Integer.toString(colValue);
					}
				}
			}
		}
		for(int p = 0; p < typeData.length; p++){
			for(int c = 0; c < typeData[0].length; c++){
				//System.out.print(typeData[p][c] + " ");
			}
			//System.out.println();
		}
		return typeData;		
		
		
	}
	public double calcGain(){
		String[][] typeData = beforeEval();
		evalfunc eval = new evalfunc(typeData);
		double gain = eval.gain();
		return gain;
	}
}
