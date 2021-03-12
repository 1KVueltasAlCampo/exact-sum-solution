package ui;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.IOException;

	public class Main{
		public static void main(String args[]) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String numberOfBooksS= br.readLine();
      String output="";
      
        while(numberOfBooksS!=null) {
          int numberOfBooks = Integer.parseInt(numberOfBooksS); 
          String line = br.readLine();
			    String [] lineSplit = line.split(" ");
			    int[] books = new int[numberOfBooks];
			    for(int i=0;i<numberOfBooks;i++) {
  				  books[i]=Integer.parseInt(lineSplit[i]);
			    }
			    int priceSearched = Integer.parseInt(br.readLine());
			    Arrays.sort(books);
			    ArrayList<Integer> diferences = new ArrayList<Integer>();
			    for(int i=0;i<numberOfBooks;i++) {
			    	int answer = binarySearch(books,priceSearched-books[i]);
			    	if(answer != -1&&answer-i!=0) {
			    		diferences.add(Math.abs(books[answer]-books[i]));
			    	}
			    }
			  Collections.sort(diferences);
			  int value = (priceSearched-diferences.get(0))/2;
			  int firstValue = Math.abs(priceSearched-value);
			  
			      if(firstValue<value) {
				      output+=("Peter should buy books whose prices are "+firstValue+" and "+value+".\n"+"\n");
			      }
			      else {
				    output+=("Peter should buy books whose prices are "+value+" and "+firstValue+".\n"+"\n");
			     }
			      br.readLine();
			      numberOfBooksS=br.readLine();
		  }
			bw.write(output);
			br.close();
			bw.close();
      }
			
		public static int binarySearch(int[] books,int valueToSearch) {
			int pos = -1;
			int i = 0;
			int j = books.length-1;
			while(i<=j && pos<0) {
				int m = (i+j)/2;
				if(books[m]==valueToSearch) {
					pos=m;
				}
				else if(books[m]>valueToSearch){
					j=m-1;
				}
				else {
					i=m+1;
				}
			}
			return pos;
		}
	}
	
