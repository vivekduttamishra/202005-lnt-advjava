package in.conceptarchitect.animalkingdom;

public class Cat extends Mammal implements Hunter{

	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return getType()+" is a flesh eater:"+hunt();
	}
	
	public String hunt() {
		return getType()+" hunts its prey";
	}

	@Override
	public String move() {
		// TODO Auto-generated method stub
		return getType()+" moves on land";
	}

}
