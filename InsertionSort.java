class InsertionSort {
    
    // Array for sorted data
    int[] sortedData;
    // Keeps track of number of iterations
    int insertionIterations = 0;
    
    public int[] sort(int[] data) {
        // Reset sortedData array
        sortedData = data;
        // Loops through the data array
        for (int currentDataIndex = 1; currentDataIndex < sortedData.length; currentDataIndex++) {
            // Store current and previous data to compare
            int key = sortedData[currentDataIndex];
            int previousDataIndex = currentDataIndex - 1;

            // While the previous data is not the first data element, and the key is less than the current data
            while (previousDataIndex >= 0 && key < sortedData[previousDataIndex]) {
                // Switch order of data
                sortedData[previousDataIndex + 1] = sortedData[previousDataIndex];
                // Move back a data
                --previousDataIndex;
                // Count interations
                insertionIterations++;
            }
            // Update key 
            sortedData[previousDataIndex + 1] = key;
        }//for loop
        return sortedData;   
}
    
    public int getIteration() {
        return insertionIterations;
    }
    
}//InsertionSort

