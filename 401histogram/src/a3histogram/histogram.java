package a3histogram;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class histogram {

		public static void main(String[] args) {
			// Set up scanner for input from console.
			
			Scanner scan = new Scanner(System.in);
			/* Use a List<Integer> object to hold the data values read as input. You'll need to find the minimum and maximum values 
			 * to determine the range the bins need to span and the bin boundaries.
			 * To read the input, use a Scanner object like in A1 and A2. After reading the first integer 
			 * indicating the number of bins, use a while loop with the hasNextInt() method to read the remaining input 
			 * into your list until hasnextInt() returns false. This will happen when you get to the word "end" at the end.
			 You are free to decide for yourself anything not specified otherwise in this writeup.
			 */
			
			List<Integer> list = new ArrayList<Integer>();
			
			int numBins = scan.nextInt(); // 7
		// adds values to the list 
			while (scan.hasNextInt()) {
				list.add(scan.nextInt());
			}
			Collections.sort(list); // sorts least to greatest
			
			// turns list into an array
			int [] array = new int[list.size()]; 
			
			for (int i=0; i< array.length; i++) {
				array[i] = list.get(i);
			}
			// min
			int min = list.get(0);
			// max
			int max = list.get(list.size() - 1);
		
			// average
			int fin = 0;
			for (int i=0; i < list.size(); i++) {
				fin += list.get(i);
			}
			double avg = (int) Math.round(fin / list.size());
			
			// range of bins
			// separated into int and double so when divide one from the other, it rounds the double and turns into an int
			int dif = max - min;
			double n = numBins;
			int range = (int) Math.round(dif/n); // (84-71) / 7 = 1.85  

			
			
		scan.close();
		System.out.println("Number of Bins: " + numBins);
		System.out.println("Minimum: " + min);
		System.out.println("Maximum: " + max);
		System.out.println("Average: " + avg);
		System.out.println();
		System.out.println("My Histogram: ");
		System.out.println();
		
		


//		holds boundaries that will depend on numBins and the range of each case
		int first = array[0];
		int [] boundaries = new int [numBins + 1];
		boundaries[0] = first;
		for (int i=1; i < boundaries.length; i++) {
			boundaries[i] = boundaries[i-1] + range;
		}
		// stars array
		int [] stars = new int[numBins];
		for (int i=0; i < array.length; i++) {
			for (int j=0; j < numBins; j++) {
				// this line means the end of the loop (because its almost to the end boundary)
				if (j == numBins - 1) { 
					stars[j]++;
					break;
				} else if (array[i] == boundaries[j]) { // if its first boundary
					stars[j]++;
					break; // break statements for last 3 help prevent stars from accumulating
				} else if (array[i] == boundaries[j+1]) { // if its end boundary
					stars[j+1]++; 
					// add to next
					break;
					// if array val is in between
				} else if (array[i] < boundaries[j] && array[i] <= boundaries[j+1]) { 
					stars[j]++;
					break;
				}
			}
		}
		

		// prints histogram
			for (int i=0; i< numBins; i++) {
				System.out.print(boundaries[i] + "-" + boundaries[i+1] + ":|"); 
					for (int j=0; j < stars[i]; j++) {
						System.out.print("*");
					}
					System.out.println(); // fixes line problem 
				}
			System.exit(0);
			}
		
	}

			
