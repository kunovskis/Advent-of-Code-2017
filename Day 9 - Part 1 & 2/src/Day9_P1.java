import java.util.*;

public class Day9_P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String line;
		boolean garbage = false, ignore = false;
		long sum=0, level=0, non=0;;
		while(true){
			line = in.nextLine();
			if(line.equals("end"))
				break;
			for(char c : line.toCharArray()){
				if(ignore){
					ignore=false;
				}
				else if(c=='!' && !ignore){
					ignore = true;
				}
				else if(c == '{' && !garbage){
					level++;
					sum+=level;
				}
				else if(c == '}' && !garbage){
					level--;
				}
				else if(c == '<' && !garbage){
					garbage=true;
				}
				else if(c == '>' && garbage){
					garbage=false;
				}
				else if(garbage){
					non++;
				}
			}
		}
		System.out.println(sum);
		System.out.println(non);
	}

}
