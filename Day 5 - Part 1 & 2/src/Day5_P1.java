import java.util.*;

public class Day5_P1 {
	public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        while(true){
        	String line = in.next();
        	if(line.equals("end"))
        		break;
        	int num = Integer.parseInt(line);
        	list.add(num);
        	System.out.println(num);
        }
        int jumps=0, index=0;
        while(true){
        	int toJump = list.get(index);
        	if(toJump<3)
        		list.set(index, toJump+1);
        	else
        		list.set(index, toJump-1);
        	index+=toJump;
        	jumps++;
        	if(index>=list.size()){
        		System.out.println(jumps);
        		break;
        	}
        }
        in.close();
    }

}
