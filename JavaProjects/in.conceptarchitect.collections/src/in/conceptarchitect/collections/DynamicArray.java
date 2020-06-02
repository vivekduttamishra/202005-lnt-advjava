package in.conceptarchitect.collections;

import java.util.Arrays;
import java.util.Iterator;

public class DynamicArray<X> implements IndexedList<X>{

	
	private int growSize;
	private int _capacity;
	private int count;
	X [] values;

	public DynamicArray(int growSize) {
		// TODO Auto-generated constructor stub
		this.growSize=growSize;
		this._capacity=growSize;
		//java doesn't allow array of generic type
		//values=new X[growSize];
		
		//create an array of object and tyepcase
		values=(X[]) new Object[growSize];
	}

	@Override
	public void add(X value) {
		// TODO Auto-generated method stub
		ensureCapacity();
		values[count]=value;
		count++;
		
	}

	private void ensureCapacity() {
		if(count==capacity()) {
			_capacity+=growSize;
			X[] newValues=(X[]) new Object[_capacity];
			for(int i=0;i<count;i++)
				newValues[i]=values[i];
			
			values=newValues;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public Iterator<X> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	int NormalizeIndex(int pos) {
		if(pos<0)
			pos=size()+pos;
		if(pos>=size())
			throw new IndexOutOfBoundsException(pos);
		return pos;
	}
	
	@Override
	public X get(int pos) {
		// TODO Auto-generated method stub
		
		pos=NormalizeIndex(pos);
		return values[pos];
	}

	@Override
	public void set(int pos, X value) {
		// TODO Auto-generated method stub
		
	}

	public int capacity() {
		// TODO Auto-generated method stub
		return _capacity;
	}

}
