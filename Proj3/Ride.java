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
  int rideTime;
  int totalTime;

  Ride(String name, int start, int end){
    this.name = name;
    this.start = start;
    this.end = end;
    this.rideTime = end - start;
    this.totalTime = end - start;
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
  public int getRideTime(){
    return this.rideTime;
  }
  public int getTotalTime(){
    return this.totalTime;
  }
  public void setTotalTime(int time){
    if(this.totalTime < time){
      this.totalTime  = time;
    }
  }
}
