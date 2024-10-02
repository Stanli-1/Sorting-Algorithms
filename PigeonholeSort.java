import java.lang.*;
import java.util.*;

class PigeonholeSort {
    
    // Array for sorted data
    int[] sortedData;
    
    // Keeps track of number of iterations
    int pigeonholeIterations = 0;
    
	public void pigeonhole_sort(int arr[],
									int n)
	{
		int min = arr[0];
		int max = arr[0];
		int range, i, j, index;

		for (int a = 0; a < n; a++) {
			if (arr[a] > max)
				max = arr[a];
			if (arr[a] < min)
				min = arr[a];
            pigeonholeIterations++;
		}

		range = max - min + 1;
		int[] phole = new int[range];
		Arrays.fill(phole, 0);

		for (i = 0; i < n; i++) {
            phole[arr[i] - min]++;
            pigeonholeIterations++;
        }

		index = 0;

		for (j = 0; j < range; j++) {
            pigeonholeIterations++;
            while (phole[j]-- > 0) {
                arr[index++] = j + min;                
            }
        }
	}
    
    public int getIteration() {
        return pigeonholeIterations;
    }
}

// Code contributed by Mohit Gupta_OMG <(0_o)>