class GnomeSort {
    
    // Array for sorted data
    int[] sortedData;
    
    // Keeps track of number of iterations
    int gnomeIterations = 0;
    
    public int[] sort(int[] data) {
        // Reset sortedData array
        sortedData = data;
        // Keeps track of the index of data
        int indexNum = 0;
        // Loops through the data array until all the data is sorted
        while (indexNum < sortedData.length) {
            // If this is the first data value, move to the next
            if (indexNum == 0) {
                indexNum++;
            }
            // If the 2 cards being compated are already sorted, move to the next
            if (sortedData[indexNum] >= sortedData[indexNum - 1]) {
                indexNum++;
            }
            // The 2 cards are not in correct order, so rearange and go back a card
            else {
                // Temporary value (for switching order of values)
                int temp;
                temp = sortedData[indexNum];
                // Switch the 2 data values
                sortedData[indexNum] = sortedData[indexNum - 1];
                sortedData[indexNum - 1] = temp;
                // Go back a data value
                indexNum--;
            }
            gnomeIterations++;
        }//while loop
        return sortedData;   
}
    
    public int getIteration() {
        return gnomeIterations;
    }
    
}//GnomeSort

