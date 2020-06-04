package in.conceptarchitect.collections;

public class ListBuilderAction<E> implements Action<E,LinkedList<E>> {
	
	LinkedList<E> result=new LinkedList<E>();

	@Override
	public void execute(E value) {
		// TODO Auto-generated method stub
		result.add(value);
	}

	public LinkedList<E> getResult() {
		return result;
	}
	
	@Override
	public LinkedList<E> result() {
		// TODO Auto-generated method stub
		return result;
	}
	

	public void setResult(LinkedList<E> result) {
		this.result = result;
	}
	
	

}
