package DecisionTree;

import java.util.ArrayList;

public class Tree {
	private String name;
	private String value;
	private ArrayList<Tree> leafs;
	
	public Tree(String name, String value){
		this.name = name;
		this.value = value;
		this.leafs = new ArrayList<Tree>();
	}
	
	public void addChild(Tree child){
		leafs.add(child);
	}
	
	public void print(){
		System.out.println(this.name);
		for(int i = 0; i < leafs.size(); i++){
			leafs.get(i).print();
		}
	}
	
}
