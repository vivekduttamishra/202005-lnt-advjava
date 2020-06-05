package in.conceptarchitect.animalkingdom;

public class Camel extends Mammal implements Rideable,Domestic{

	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return getType()+" is a grass eater";
	}
	
	public String ride() {
		return getType()+" is a great desert ride";
	}

	@Override
	public String move() {
		// TODO Auto-generated method stub
		return getType()+" moves in desert";
	}

}
