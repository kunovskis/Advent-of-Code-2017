import java.util.*;

public class Day6_P1 {
	
	public static void main (String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> place = new ArrayList<Integer>();
        List<List<Integer>> listOfLists = new ArrayList<List<Integer>>(); 
        	String example = "5 1 10 0 1 7 13 14 3 12 8 10 7 12 0 6";
        	String line="0 2 7 0";
        	String[] nums = example.split("\\s+");
        	for(int i=0; i<nums.length; i++){
        		place.add(Integer.parseInt(nums[i]));
        		list.add(Integer.parseInt(nums[i]));
        	}
        	list.add(0);
        	int length = list.size();
        	ArrayList<Integer> arr = new ArrayList<Integer>();
        	for(int i: list){
        		arr.add(i);
        	}
        	listOfLists.add(arr);
        	int max, index, cycles=0, br=0;
        	while(true){
        		cycles++;
        		max=list.get(0);
        		index=0;
        		for(int i=1; i<length-1; i++){
        			if(max<list.get(i)){
        				max=list.get(i);
        				index=i;
        			}
        		}
        		list.set(index, 0);
        		list.set(length-1, cycles);
        		index++;
        		for(int i=0; i<max; i++){
        			if(index==length-1) index=0;
        			int el = list.get(index);
        			list.set(index, el+1);
        			index++;       			
        		}
        		for(int i=0; i<listOfLists.size(); i++){
        			arr = (ArrayList<Integer>) listOfLists.get(i);
        			/*System.out.println(arr.get(0));
            		System.out.println(arr.get(1));
            		System.out.println(arr.get(2));
            		System.out.println(arr.get(3));
            		System.out.println(arr.get(4));*/
        			if(compare(list, arr)){
        				br=1;
        				break;
        			}
        		}
        		if(br==1) break;
        		arr = new ArrayList<Integer>();
        		for(int i: list){
        			arr.add(i);
        		}
        		listOfLists.add(arr);
        	}
        	System.out.println(cycles);
    }
	
	public static boolean compare(List<Integer> arr1, ArrayList<Integer> arr2){
		int a = arr1.remove(arr1.size()-1);
		int b = arr2.remove(arr2.size()-1);
		if( arr1.equals(arr2)){
			System.out.println(a-b);
			return true;
		}
		else{
			arr1.add(a);
			arr2.add(b);
			return false;
		}
	}


}
