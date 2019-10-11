package osproject;

public class process implements Comparable<process>{
    String pid ;
    int arrival_time ;
    int service_time ;
    int wait_time ;
    int remain_time ;
    int start_time;
    int finish_time ;
    double tt ;
    boolean finish = false ;

    boolean turnOn = false ;
    boolean taken = false ;
    
    @Override
    public int compareTo(process o) {
        return this.arrival_time - o.arrival_time;
    }

}
