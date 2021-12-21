
public class LinkedStack<Item> implements Iterable<Item>
{
 private Node first = null;
 private class Node
 {
 Item item;
 Node next;
 }
 
 public boolean isEmpty()
 { return first == null; }
 
 public void push(Item item)
 {
 Node oldfirst = first;
 first = new Node();
 first.item = item;
 first.next = oldfirst;
 }
 
 public Item pop()
 {
 Item item = first.item;
 first = first.next;
 return item;
 }
 
 public Iterator<Item> iterator() 
{ return new ListIterator(); }
 private class ListIterator implements Iterator<Item>
 {
 private Node current = first;
 public boolean hasNext() { return current != null; }
 public void remove() { /* not supported */ } 
 public Item next()
 {
 Item item = current.item;
 current = current.next; 
 return item;
 }
 }
 
 
 
}

public class ArrayStack<Item> implements Iterable<Item>
{
 private Item[] s;
 private int N = 0;
 
 public ArrayStack()
 { s =(Item[]) new Object[1]; } 
 
 public boolean isEmpty()
 { return N == 0; }
 
 public Iterator<Item> iterator()
 { return new ReverseArrayIterator(); }
 private class ReverseArrayIterator implements Iterator<Item>
 {
 private int i = N;
 public boolean hasNext() { return i > 0; }
 public void remove() { /* not supported */ }
 public Item next() { return s[--i]; }
 }
 
 
 
 /*
 public void push(String item)
 { s[N++] = item; }
 */
 
  public void push(String item)
 {
 if (N == s.length) resize(2 * s.length);
 s[N++] = item;
 }
 private void resize(int capacity)
 {
 Item[] copy =(Item[]) new Object[capacity];
 for (int i = 0; i < N; i++)
 copy[i] = s[i];
 s = copy;
 }
 
 /*
public String pop()
{ return s[--N]; }

public String pop()
{
 String item = s[--N];
 s[N] = null;
 return item;
}
*/
public String pop()
 {
 String item = s[--N];
 s[N] = null;
 if (N > 0 && N == s.length/4) resize(s.length/2);
 return item;
 } 
}




public class StackOfStrings
{
	StackOfStrings()
	{
	
		
	}
	
	void push()
	{
		
		
	}
	
	String Pop()
	{
		
		
	}
	
	boolean isEmpty()
	{
		
		
	}
	
	int size()
	{
		
		
	}
	
}