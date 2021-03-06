package DecisionTree;

import java.util.ArrayList;

public class Tree {
	private String name;
	private String value;
	private ArrayList<Tree> leafs;
	private String goal;
	
	public Tree(String name){
		this.name = name;
		//this.value = value;
		this.leafs = new ArrayList<Tree>();
		this.goal = "null";
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
	public void addGoal(String goal){
		this.goal = goal;
	}	
}
