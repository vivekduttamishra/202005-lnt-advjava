package in.conceptarchitect.animalkingdom;

public class Cow extends Mammal implements Domestic{

	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return getType()+" is a grass eater";
	}
	
	public String provideMilk() {
		return getType()+" provides milk";
	}

	@Override
	public String move() {
		// TODO Auto-generated method stub
		return getType()+" moves on land";
	}

}
