package DecisionTree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataMatrix {
	String fileName;
	String line;
	ArrayList<ArrayList<String>> matrix;
	int count;
	int c;
	int r;
	
	public DataMatrix(String filename){
		this.fileName = filename;
		line = null;
		matrix = new ArrayList<ArrayList<String>>();
		count = 0;
	}
	public String[][] get(){
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	if(line.length() > 0){
            	if(( ! String.valueOf(line.charAt(0)).equals("%"))){
            		
            		if(String.valueOf(line.charAt(0)).equals("@")){
            			//String attribute = line.substring(1, 4);
            			if(String.valueOf(line.charAt(1)).equals("A")){
            				String[] attributeRow = line.split("\\s+");
            				matrix.add(new ArrayList<String>());
            				matrix.get(count).add(attributeRow[1]);
            				count++;
            			
            			}
            		}
            		else{
            			String[] dataRow = line.split(",");
            			for(int i = 0; i < dataRow.length; i++ ){
            				matrix.get(i).add(dataRow[i]);
            				
            			}
            			
            		}
            	}
            	}
            	
            }
            
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
        c = matrix.size();
        r = matrix.get(0).size();
        String[][] newMatrix = new String[r][c];
        for(int i = 0; i < matrix.size(); i ++){
        	for(int j = 0; j < matrix.get(0).size(); j++){
        		newMatrix[j][i] = matrix.get(i).get(j); 
        	}
        	
        }
        
        return newMatrix;

	}
	public int getCols(){
		return c;
		
	}
	public int getRows(){
		return r;
	}
	
}