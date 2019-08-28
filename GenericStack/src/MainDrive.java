
public class MainDrive {

	public static void main(String[] args) {
		
		Stack <Integer> s = new LinkedListStack<Integer>();
		
		s.push(2);
		s.push(4);
		s.push(6);
		s.push(34);
		s.push(11);
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
		
	}

}
