import java.util.Queue;

class Solution {
	static int k=0;

	static class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
		}
	}
	public static String Josephus(int m, int n) {
		String s="";
		Node head = new Node(0);
		Node prev = head;
		for (int i = 1; i < m; i++) {
			prev.next = new Node(i);
			prev = prev.next;
		}

		
		prev.next = head;

		
		Node ptr1 = head, ptr2 = head;

		while (ptr1.next != ptr1) {

			
			int count = 1;
			while (count != n) {
				ptr2 = ptr1;
				ptr1 = ptr1.next;
				count++;
			}
			ptr2.next = ptr1.next; 
			//System.out.println(ptr1.data);
			s=s+ ptr1.data+" ";	
			//System.out.println(s);
			ptr1 = ptr2.next; 
			
			
		} 
		s=s+ptr1.data;
	    //System.out.println(s);
		return s;
	}

	// public static void main(String[] args){
	// 	Solution a = new Solution();
	// 	String p= Solution.Josephus(7, 2);
	// }
}