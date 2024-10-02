import java.util.*;

class StrandSort {
    
    // Array for sorted data
    int[] sortedData = new int[1000];
    
    // Keeps track of number of iterations
    int strandIterations = 0;
    
    public int[] sort(int[] data) {
        // Create output arraylist
        ArrayList <Integer> output = new ArrayList();
        // Creates 2 temperary array 
        ArrayList <Integer> temp = new ArrayList();
        ArrayList <Integer> tempTwo = new ArrayList();
    
        // Convert original data into arraylist
        ArrayList <Integer> inputArray = new ArrayList();
        for (int i = 0; i < data.length; i++) {
            inputArray.add(data[i]);
        }
    
        while (!inputArray.isEmpty()) {
            
            tempTwo.addAll(output);
            output.clear();
            
            // Move first data into temperary array
            temp.add(inputArray.get(0));
            inputArray.remove(0);
            // Keeps track of index of temp array
            int tempIndex = 0;
            
            // Compare original data with most recent temp array data
            for (int i = 0; i < inputArray.size(); i++) {
                // If the most recent temp value is less than current value in original data, add it to the temp array
                if (temp.get(tempIndex) <= inputArray.get(i)) {
                    temp.add(inputArray.get(i));
                    inputArray.remove(i);
                    i--;
                    tempIndex++;
                }
                strandIterations++;
            }//for
            
            // As long as the two temperary arraylists are not empty, compare the first elements of each
            while (temp.isEmpty() == false && tempTwo.isEmpty() == false) {
                // If tempTwo is less, add it to the output and delete it
                if (tempTwo.get(0) <= temp.get(0)) {
                    output.add(tempTwo.get(0));
                    tempTwo.remove(0);
                }
                // Otherwise (temp is large), add it to the output and delete it
                if (temp.get(0) <= tempTwo.get(0)) {
                    output.add(temp.get(0));
                    temp.remove(0);
                }
                strandIterations++;
            }// while
        
            // If temp is empty, add the rest of tempTwo to output as they are all larger and already sorted
            if (temp.isEmpty()) {
                output.addAll(tempTwo);
                tempTwo.clear();
            }
        
            // Same code as above but for tempTwo
            if (tempTwo.isEmpty()) {
                output.addAll(temp);
                temp.clear();
            }
            
        }// while loop

        for (int i = 0; i < output.size(); i++) {
            sortedData[i] = output.get(i);
        }
        return sortedData;
    }
    public int getIteration() {
        return strandIterations;
    }
}