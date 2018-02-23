package DecisionTree;

public class evalfunc {
	public evalfunc(){
		
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
}
