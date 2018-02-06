import java.util.*;

public class Day8_P1 {
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line;
		int maxHeld=0;
		Map<String, Integer> map = new HashMap<String,Integer>();
		while(true){
			line=in.nextLine();
			if(line.equals("end"))
				break;
			String[] row = line.split(" ");
			if(!map.containsKey(row[0])){
				map.put(row[0], 0);
			}
			if(!map.containsKey(row[4]))
				map.put(row[4], 0);
			int val = map.get(row[4]);
			int check = Integer.parseInt(row[6]);
			boolean change = false;
			switch(row[5]){
			case ">":{
				if(val > check){
					change=true;
				}
				break;
				}
			case "<":{
				if(val < check){
					change=true;
				}
				break;
				}
			case "==":{
				if(val == check){
					change=true;
				}
				break;
				}
			case "!=":{
				if(val != check){
					change=true;
				}
				break;
				}
			case ">=":{
				if(val >= check){
					change=true;
				}
				break;
				}
			case "<=":{
				if(val <= check){
					change=true;
				}
				break;
				}
			}
			if(change){
				val = map.get(row[0]);
				int ud = Integer.parseInt(row[2]);
				if(row[1].equals("inc")){
					val+=ud;
				}
				else{
					val-=ud;
				}
				if(maxHeld<val){
					maxHeld=val;
				}
				map.put(row[0], val);
			}
			System.out.println(row[0]+" "+map.get(row[0]));
			
		}
		
		int max=0, v=0;
		
		for(String k : map.keySet()){
			if(v==0){
				v=1;
				max=map.get(k);
			}else{
				if(max<map.get(k))
					max=map.get(k);
			}
		}
		System.out.println(max);
		
		System.out.println(maxHeld);
		
	}
}
