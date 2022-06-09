package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.size=0;
		this.head=new LLNode<E>(null);
		this.tail=new LLNode<E>(null);
		head.next=tail;
		tail.prev=head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element==null) 
			throw new NullPointerException("Null element can Not stored.");
		this.size++;
		LLNode<E> node=new LLNode<E>(element);
		node.prev=tail.prev;
		node.next=node.prev.next;
		node.prev.next=node;
		tail.prev=node;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		LLNode<E> t=head;
		if(head.next==tail)
			throw new IndexOutOfBoundsException("The list is empty.");
		else if(index<0)
			throw new IndexOutOfBoundsException("Out of Bound.");
		else if(index>=size)
			throw new IndexOutOfBoundsException("Out of Bound.");
		else 
			for(int i=0;i<=index;i++) 
				t=t.next;
		return t.data;
	}
	
	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(element==null) 
			throw new NullPointerException("Null element can Not stored.");
		else if(index<0)
			throw new IndexOutOfBoundsException("Out of Bound.");
		else if(index>size)
			throw new IndexOutOfBoundsException("Out of Bound.");
		else {
			LLNode<E> t=head;
			for(int i=0;i<=index;i++) 
				t=t.next;
			LLNode<E> node=new LLNode<E>(element);
			node.next=t.next;
			node.prev=node.next.prev;
			node.next.prev=node;
			t.next=node;
			this.size++;
		}
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(head.next==tail)
			throw new IndexOutOfBoundsException("The list is empty.");
		else if(index<0)
			throw new IndexOutOfBoundsException("Out of Bound.");
		else if(index>size)
			throw new IndexOutOfBoundsException("Out of Bound.");
		else {
			LLNode<E> t=head;
			for(int i=0;i<=index;i++) 
				t=t.next;
			t.prev.next=t.next;
			t.next.prev=t.prev;
			this.size--;
			return t.data;
		}
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		E temp;
		if(element==null) 
			throw new NullPointerException("Null element can Not stored.");
		else if(index<0)
			throw new IndexOutOfBoundsException("Out of Bound.");
		else if(index>size)
			throw new IndexOutOfBoundsException("Out of Bound.");
		else {
			LLNode<E> t=head;
			for(int i=0;i<=index;i++) 
				t=t.next;
			temp=t.data;
			t.data=element;
		return temp;
		}
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
