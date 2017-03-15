import java.util.Stack;

public class FlattenLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l1=new LinkedList(1);
		l1.next=new LinkedList(2);
		l1.next.next=new LinkedList(8);
		l1.next.down=new LinkedList(3);
		l1.next.down.next=new LinkedList(4);
		l1.next.down.next.next=new LinkedList(7);
		l1.next.down.next.down=new LinkedList(5);
		l1.next.down.next.down.next=new LinkedList(6);
		flatten(l1);
	}
	
	public static void flatten(LinkedList head){
		LinkedList preHead=head;
		//preHead=head;
		Stack<LinkedList> st=new Stack<LinkedList>();
		LinkedList[] list;
		//int count=0;
		while(head.next!=null){
			if(head.down!=null){
				LinkedList n=head;
				st.push(n);
				//count++;
				head=head.down;
				System.out.println(head.val);
			}
			else{
				head=head.next;
			System.out.println(head.val);
		}
		}
		while(!st.isEmpty()){
			head.next=st.pop();
			while(head.next!=null)
				head=head.next;
			System.out.println(head.val);
		}
	}

}
