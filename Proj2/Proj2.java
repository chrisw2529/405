/* Chris White
* 405 Proj2
* finds Longest Increasing subsequence from a arrray
* takes in a .txt file
*
*/
import java.util.*;
public class Proj2{
  public static void main(String[] args) {
    if(args.length != 0){
      String arrayFile = args[0];
      int[] sequence = buildArray(arrayFile);
      findSeq(sequence);
    }
    else{
      System.out.println("error:  no text file specified");
      System.exit(0);
    }
  }
/*findSeq
* takes in an array and finds longest increacing subsequence
* prints the length of the sequnce and the actual sequence
*
*/
  private static void findSeq(int[] seq){
    int[] longest = new int[seq.length];
    for (int i = 0; i<seq.length ; i++) {
      longest[i] = 1;
    }

    for (int i = 1; i<seq.length ; i++) {
      for (int j = 0; j< i ; j++) {
        if(seq[i] > seq[j] && longest[i] <= longest[j]){
          longest[i] = longest[j] + 1;
        }
      }
    }
    int length = longest[0];
    for(int i=1;i<longest.length;i++){
      if(longest[i] > length){
	       length = longest[i];
	    }
    }

    int next = 1;
    ArrayList<Integer> toPrint = new ArrayList<Integer>();
    for (int i = 0; i<longest.length; i++ ){
      if(next == longest[i]){
        toPrint.add(seq[i]);
        next++;
        if(next - 1 == length){
          break;
        }
      }
      else if(longest[i] == next - 1 ){
        toPrint.remove(toPrint.size() -1 );
        toPrint.add(seq[i]);
      }

    }
    System.out.println("the longest increasing sub-sequence is of length " +  length);

    for (int i = 0; i < toPrint.size()  ; i++) {
      System.out.print(toPrint.get(i) + " ");
    }
    System.out.println();
  }

  /*printArray
  * helper function print the array (seq)
  *
  */
  private static void printArray(int[] seq){
    for (int i = 0 ; i < seq.length;i++ ) {
      System.out.print(seq[i] + " ");
    }
    System.out.println();


  }

  /* buildArray
  * takes in a text file then, builds an array from the file and returns it
  * (ignores all extra white space)
  */
  private static int[] buildArray(String file){
    java.util.Scanner input = null;

    try {
        input = new java.util.Scanner(new java.io.File(file));

    } catch( java.io.FileNotFoundException e ) {
        System.err.println("Error: Unable to open file " + file);
        System.exit(1);
    }

    if(input.hasNextLine()){
      String trimer = input.nextLine().trim().replaceAll(" +", " ");
      String[] line = trimer.split("\\s");
      int[] ret = new int[line.length];
      for(int i = 0; i < line.length; i++){
         ret[i] =  Integer.parseInt(line[i]);
      }
      return ret;
    }
    else{
      System.err.println("nothing in file: " + file);
      System.exit(1);
    }
    return null;
  }
}
