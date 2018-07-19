/* Chris White
* 405 Proj3 ride helper class
*
*/
//import java.util.*;


import java.lang.Integer;


public class Ride{
  String name;
  int start;
  int end;
  int time;

  Ride(String name, int start, int end){
    this.name = name;
    this.start = start;
    this.end = end;
    this.time = end - start;
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
  public int getTime(){
    return this.time;
  }
  public void setTime(int time){
    if(this.time < time){
      this.time = time;
    }
  }
}
