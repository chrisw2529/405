/* Chris White
* 405 Proj3 ride helper class
*
*/
import java.util.*;
public class Ride{
  String name;
  int start;
  int end;

  Ride(String name, int start, int end){
    this.name = name;
    this.start = start;
    this.end = end;
  }

  public String getName(){
    return this.name;
  }
  public int getStart(){
    return this.start;
  }
  public int getEnd(){
    return this.end;
  }
}
