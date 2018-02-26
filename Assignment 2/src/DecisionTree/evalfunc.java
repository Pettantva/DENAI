package DecisionTree;

public class evalfunc {
	private String[][] typeData;
	private int size;
	private int nrAttributes;
	public evalfunc(String[][] typeData){
		size = 0;
		this.typeData = typeData;
		nrAttributes = typeData[0].length;
		for(int i = 0; i < nrAttributes; i++){
			if(typeData[1][i] == null){
				typeData[1][i] = "0";
			}
			size = size + Integer.parseInt(typeData[1][i]);
		}
		
		
	}
	private double bfunc(double q){
    	if(q == 0 || q == 1){
    		return 0;
    	}
    	else{
    		double first = log2(q);
    		double second = log2(1-q);
    		double a = -(q*first + (1-q)*second);
        	return a;
    	}
    	
    }
    private double log2(double n)
    {
        return (Math.log(n) / Math.log(2));
    }
    public double gain(){
    	double sum = 0;
    	double positiveSum = 0;
    	for(int i = 0; i < nrAttributes; i++){
    		if(typeData[1][i] == null){
    			typeData[1][i] = "0";
    		}
    		if(typeData[2][i] == null){
    			typeData[2][i] = "0";
    		}
    		double numerator = Integer.parseInt(typeData[1][i]);
    		double positive = Integer.parseInt(typeData[2][i]);
    		positiveSum = positiveSum + positive;
    		sum = sum + (numerator/size*bfunc(positive/numerator)); 
    	}
    	return bfunc(positiveSum/size)-sum;
    }
}
