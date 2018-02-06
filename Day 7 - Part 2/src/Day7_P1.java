import java.io.*;
import java.util.*;

public class Day7_P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		List<Node> nodes = new ArrayList<Node>();
		List<String> start = new ArrayList<String>();
		List<String> list = new ArrayList<String>();
		List<String[]> rows = new ArrayList<String[]>();
		while(true){
			String s = in.nextLine();
			if(s.equals("end"))
				break;
			s = s.replaceAll(",", "");
			s = s.replaceAll("\\(", "");
			s = s.replaceAll("\\)", "");
			String[] line = s.split(" ");
			rows.add(line);
			nodes.add(new Node(line[0], Integer.parseInt(line[1])));
			if(line.length>2 && line[2].equals("->")){
				start.add(line[0]);
				for(int i=3; i<line.length; i++){
					list.add(line[i]);
				}
			}
		}
		Node begin = null;
		for(String a : start){
			if(!list.contains(a)){
				for(Node n: nodes){
					if(n.name.equals(a)){
						begin = new Node(a, n.value);
						break;
					}
				}
			}
		}
		
		
		setChildren(rows, nodes, begin);
		
		//begin.print(0);
		
		for(int i=0; i<1000; i++){
			getLevels(begin);
		}
		
		begin.print(0);
	
		check(begin);
	}
	
	static void setChildren(List<String[]> rows, List<Node> nodes, Node begin){
		for(int i=0; i<rows.size(); i++){
			String[] r = rows.get(i);
			if(r[0].equals(begin.name)){
				for(int j=3; j<r.length; j++){
					for(Node n:nodes){
						if(n.name.equals(r[j])){
							begin.addNode(n);
						}
					}
				}
			}
		}
		for(Node n : begin.children){
			setChildren(rows, nodes, n);
		}
	}
	
	static void getLevels(Node begin){
		boolean child = true;
		if(begin.children.isEmpty()){
			if(begin.parent!=null){
				if(!begin.added){
					begin.parent.levelValue += begin.levelValue;
					begin.added=true;
				}
			}
		}
		else{
			for(Node n : begin.children){
				if(!n.added){
					child=false;
					break;
				}
			}
			if(child){
				if(begin.parent!=null && !begin.added){
					begin.parent.levelValue += begin.levelValue;
					begin.added=true;
				}
			}else{
				for(Node n : begin.children){
					if(!n.added)
						getLevels(n);
				}
			}
		}
	}
	
	static void check(Node begin){
		if(!begin.children.isEmpty()){
			compare(begin.children);
		}
		for(Node n : begin.children){
			check(n);
		}
	}
	
	static void compare(List<Node> nodes){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(Node n : nodes){
			if(map.containsKey(n.levelValue)){
				map.put(n.levelValue, map.get(n.levelValue)+1);
			}
			else{
				map.put(n.levelValue, 1);
			}
		}
		int toChange=0, rez=0;
		for(int key : map.keySet()){
			if(map.get(key)==1){
				System.out.println(key);
				toChange = key;
			}
			else{
				rez=key;
			}
		}
	}
}


class Node{
	
	public String name;
	public int value;
	public Node parent;
	public List<Node> children;
	public int maxLevel;
	public int levelValue;
	boolean added;
	
	public Node(String _name, int _value){
		name=_name;
		value=_value;
		levelValue = _value;
		maxLevel=0;
		children=new ArrayList<Node>();
		added=false;
	}
	
	public void addNode(Node n){
		n.parent=this;
		children.add(n);
	}
	
	public void print(int level){
		if(level!=0)
			System.out.println("LEVEL "+level+" "+ name + " " + levelValue + " PARENT:" + parent.name);
		else
			System.out.println("LEVEL "+level+" "+ name + " " + levelValue + " ROOT");
		for(Node c : children){
			c.print(level+1);
		}
	}
}
