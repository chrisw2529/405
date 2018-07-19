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
      bubbleSort(rides);
      findLongestTime(rides);
      //printRides(rides);
      findRidePath(rides);
    }
    else{
      System.out.println("error:  no text file specified");
      System.exit(0);
    }
  }

  //finds the best path throught all of the rides
  public static void findRidePath(ArrayList<Ride> rides){
    //finds the maximum amount of time that you could spend on rides
    int max = -1;
    for (int i = 0; i < rides.size(); i++) {
      if(max < rides.get(i).getTotalTime()){
        max = rides.get(i).getTotalTime();
      }
    }
    int maxPrint = max;

    //saves optimal ride order in ArrayList
    ArrayList<String> rideOrder = new ArrayList<String>();
    for(int i = rides.size()-1; i >= 0; i--){
      if(rides.get(i).getTotalTime() == max){
        rideOrder.add(rides.get(i).getName());
        max -= rides.get(i).getRideTime();
      }
    }

    //print optimal ride order
    System.out.println("the best ride order is: ");
    for(int i = rideOrder.size() -1; i>=0; i--){
      System.out.println(rideOrder.get(i));
    }
    System.out.println("You will spend a total of " + maxPrint + " hours on rides");
  }






  //you know how bubble sort works
  public static ArrayList<Ride> bubbleSort(ArrayList<Ride> rides){
    for (int i = 0; i < rides.size()-1; i++){
      for (int j = i+1; j < rides.size(); j++){
        if (rides.get(i).getStart() > rides.get(j).getStart()){
          Ride temp = rides.get(i);
          rides.set(i, rides.get(j));
          rides.set(j, temp);
        }
      }
    }
    return rides;
  }
/*findLongestTime
* takes in an arrayList and findes the most amount of time that you could spend riding each ride plus the most optimal combination of rides before it
*
*/
  public static void findLongestTime(ArrayList<Ride> rides){
    for (int i = 0; i < rides.size()-1; i++){
      for (int j = i+1; j < rides.size(); j++){
        if(rides.get(i).getEnd() <= rides.get(j).getStart()){
          if(rides.get(i).getTotalTime() + rides.get(j).getRideTime() > rides.get(j).getTotalTime()){
            rides.get(j).setTotalTime(rides.get(i).getTotalTime() + rides.get(j).getRideTime());
          }
        }
      }
    }
  }

  /*printArray
  * helper function print the array (seq)
  *
  */
  private static void printRides( ArrayList<Ride> rides){
    for (int i = 0 ; i < rides.size();i++ ) {
      Ride ride = rides.get(i);
      System.out.println(ride.getName() + " " + ride.getStart() + ride.getEnd() + ride.getRideTime() + " total time :"+ride.getTotalTime());
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
    ArrayList<Ride> rides = new ArrayList<Ride>();
    if(input.hasNextLine()){
      String trimer = input.nextLine().trim().replaceAll(" +", " ");
      String[] line = trimer.split("\\s");
      //System.out.println(Arrays.toString(line));
      for(int i = 0; i < line.length; i++){
        int colen = line[i].indexOf(':');
        String name = line[i].substring(0, colen);
        int comma = line[i].indexOf(',');
        int start = Integer.parseInt(line[i].substring(colen+2, comma));
        int pren = line[i].indexOf(')');
        int end  = Integer.parseInt(line[i].substring(comma+1, pren));
        rides.add(new Ride(name, start, end));
      }
      return rides;
    }
    else{
      System.err.println("nothing in file: " + file);
      System.exit(1);
    }
    return null;
  }
}
