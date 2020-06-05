package in.conceptarchitect.animalkingdom;

public class Horse extends Mammal implements Rideable,Domestic{

	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return getType()+" is a grass eater";
	}
	
	public String ride() {
		return getType()+" is a great ride";
	}

	@Override
	public String move() {
		// TODO Auto-generated method stub
		return getType()+" moves on land";
	}

}
