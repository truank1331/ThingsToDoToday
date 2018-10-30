package thingstodotoday;
import java.util.*;
class Activity {
    int code;
    String name;
    int minutes;
    Activity(int n,String str){
        code = n;
        String ss[] = str.split(":");
        name = ss[0];
        minutes = Integer.parseInt(ss[1]);
    }
    public String toString(){
        return name;
    }
}
class ActivityComparator implements Comparator<Activity>{
    public int compare(Activity a1,Activity a2){
        if(a1.minutes<a2.minutes){
            return -1;
        }
        else if(a1.minutes>a2.minutes)
            return 1;
        return 0;
    }
}
public class ThingsToDoToday {
    public static void main(String[] args) {
        PriorityQueue<Activity> myActivity = new PriorityQueue<>(new ActivityComparator());
        PriorityQueue<Activity> myActivity2 = new PriorityQueue<>(new ActivityComparator());
        Scanner in = new Scanner(System.in);
        Activity e = null;
        for(int i=0;i<10;i++){
            int n = in.nextInt();
            String str = in.nextLine();
            e = new Activity(n,str);
            myActivity.add(e);      
            myActivity2.add(e);
        }
        int ni = 0;
        int time = 0;
        for(int i=0;i<10;i++){
            if(time+myActivity2.peek().minutes<=480){
                time+=myActivity2.remove().minutes;
                ni++;             
            }
            else
                break;
        }
        System.out.println(ni+" "+time);
        for(int i=0;i<ni;i++)
            System.out.println(myActivity.peek()+" "+myActivity.remove().minutes);
    }
}
