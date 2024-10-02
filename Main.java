import java.io.*;
import java.util.*;

class Main {

    // The purpose of this class is to output the sorted data into a file called
    // output.txt
    public static void printData(int sortedData[]) {
        try {
            // Creates new file for lines that start with repeated word
            FileWriter myWriter = new FileWriter("output.txt");
            for (int i = 0; i < sortedData.length; i++) {
                myWriter.write(sortedData[i] + "\n");
            }
            myWriter.close();
        }

        // This exception will be thrown if the file cannot be found
        catch (FileNotFoundException e) {
            System.out.println("File does not exist or could not be found.");
            System.err.println("FileNotFoundException; " + e.getMessage());
        }

        // This exception will be thrown if the file is being used somewhere else
        catch (IOException e) {
            System.out.println("A error has occured.");
            System.err.println("IOExcpetion; " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        // scanner for customer's item selection
        Scanner userInput = new Scanner(System.in);
        // A file for the data (reference 1)
        File textFile = new File("Population.txt");
        // Reads streams of characters in the file
        FileReader input;
        // Bufferes files for efficiency, especially for larger files
        BufferedReader readFile;
        // Stores a given line of text from the file
        String lineOfText;
        // Array that stores all the population data
        int[] data;
        data = new int[1000];
        // Array for sorted data
        int[] sortedData;
        // Boolean for exiting code
        boolean exit = false;
        // Start and stop time for timer
        long finalTime;
        long startTime;

        // Prompt for all supported sorting algorithms
        System.out.println(
                "\nThis program will sort the population of the top 1000 most populated geographical areas in Canada in ascending order.");
        System.out.println("\nSupported Sorting Algorithms:");
        System.out.println("1. Gnome\n2. Strand\n3. Insertion\n4. TreeSort\n5. TimSort\n6. Pigeonhole Sort");
        System.out.println("If you would like to exit the program, enter 0.");

        while (exit == false) {
            System.out.print("\nEnter the number of the sorting method desired:    ");
            int sortChoice = userInput.nextInt();
            if (sortChoice == 0) {
                System.out.print("\nThank you for using this program!    ");
                break;
            }
            try {
                input = new FileReader(textFile);
                readFile = new BufferedReader(input);
                // Keeps track of the line number
                int lineNumber = 0;
                // Goes line by line through file and stores each line as a new data element
                while ((lineOfText = readFile.readLine()) != null) {
                    int populationData = Integer.parseInt(lineOfText);
                    data[lineNumber] = populationData;
                    lineNumber++;
                } // while

                // Closes scanners
                readFile.close();
                input.close();
            } // try

            // This exception will be thrown if the file cannot be found
            catch (FileNotFoundException e) {
                System.out.println("File does not exist or could not be found.");
                System.err.println("FileNotFoundException; " + e.getMessage());
            }
            // This exception will be thrown if the file is being used somewhere else
            catch (IOException e) {
                System.out.println("A error has occured.");
                System.err.println("IOExcpetion; " + e.getMessage());
            }

            // Switch case decision for which sorting algorithm to use
            switch (sortChoice) {
                // Gnome sort (reference 2)
                case 1:
                    // Start timer for sort (reference 3)
                    startTime = System.currentTimeMillis();
                    GnomeSort myGnomeSort = new GnomeSort();
                    sortedData = myGnomeSort.sort(data);
                    // End timer for sort
                    finalTime = System.currentTimeMillis();
                    // Output the sorted data into the output.txt file
                    printData(sortedData);
                    // Print the difference in time before and after sort
                    System.out.println("Time taken: " + (finalTime - startTime) + "ms");
                    // Print the number of iterations
                    System.out.println("Number of iterations: " + myGnomeSort.getIteration());
                    // Refers user to output.txt
                    System.out.println("Check the 'output.txt' file for sorted data.");
                    break;

                // Strand sort (reference 8)
                case 2:
                    startTime = System.currentTimeMillis();
                    StrandSort myStrandSort = new StrandSort();
                    sortedData = myStrandSort.sort(data);
                    finalTime = System.currentTimeMillis();
                    printData(sortedData);
                    System.out.println("Time taken: " + (finalTime - startTime) + "ms");
                    System.out.println("Number of iterations: " + myStrandSort.getIteration());
                    System.out.println("Check the 'output.txt' file for sorted data.");
                    break;

                // Insertion sort (reference 4)
                case 3:
                    startTime = System.currentTimeMillis();
                    InsertionSort myInsertionSort = new InsertionSort();
                    sortedData = myInsertionSort.sort(data);
                    finalTime = System.currentTimeMillis();
                    printData(sortedData);
                    System.out.println("Time taken: " + (finalTime - startTime) + "ms");
                    System.out.println("Number of iterations: " + myInsertionSort.getIteration());
                    System.out.println("Check the 'output.txt' file for sorted data.");
                    break;

                // Tree (reference 5)
                case 4:
                    startTime = System.currentTimeMillis();
                    TreeSort myTreeSort = new TreeSort();
                    myTreeSort.treeins(data);
                    myTreeSort.inorderRec(myTreeSort.root);
                    finalTime = System.currentTimeMillis();
                    printData(myTreeSort.getSortedData());
                    System.out.println("Time taken: " + (finalTime - startTime) + "ms");
                    System.out.println("Number of iterations: " + myTreeSort.getIteration());
                    System.out.println("Check the 'output.txt' file for sorted data.");
                    break;

                // TimSort (reference 6)
                case 5:
                    sortedData = data;
                    startTime = System.currentTimeMillis();
                    TimSort myTimSort = new TimSort();
                    myTimSort.timSort(sortedData, data.length);
                    finalTime = System.currentTimeMillis();
                    printData(sortedData);
                    System.out.println("Time taken: " + (finalTime - startTime) + "ms");
                    System.out.println("Number of iterations: " + myTimSort.getIteration());
                    System.out.println("Check the 'output.txt' file for sorted data.");
                    break;

                // Pigeonhole Sort (reference 7)
                case 6:
                    sortedData = data;
                    startTime = System.currentTimeMillis();
                    PigeonholeSort myPigeonholeSort = new PigeonholeSort();
                    myPigeonholeSort.pigeonhole_sort(sortedData, data.length);
                    finalTime = System.currentTimeMillis();
                    printData(sortedData);
                    System.out.println("Time taken: " + (finalTime - startTime) + "ms");
                    System.out.println("Number of iterations: " + myPigeonholeSort.getIteration());
                    System.out.println("Check the 'output.txt' file for sorted data.");
                    break;

                default:
                    System.out.println("\nPlease enter an option number from 1-6.");
                    break;

            }// switch

        } // while

    }// main
}// Main