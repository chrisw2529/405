/* Chris White
* 405 Proj3
* finds Longest amount of time that can be spent on rides
* takes in a .txt file
*
*/
import java.util.*;
public class Proj3{
  public static void main(String[] args) {
    if(args.length != 0){
      String arrayFile = args[0];
      ArrayList<Ride> rides = buildArray(arrayFile);
      //findSeq(sequence);
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
  private static ArrayList<Ride> buildArray(String file){
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
      System.out.println(Arrays.toString(line));
      for(int i = 0; i < line.length; i++){
        String name = ///here!!
      }
      return null;
    }
    else{
      System.err.println("nothing in file: " + file);
      System.exit(1);
    }
    return null;
  }
}