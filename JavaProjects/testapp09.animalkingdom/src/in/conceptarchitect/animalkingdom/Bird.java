package in.conceptarchitect.animalkingdom;

public  abstract class Bird extends Animal {

//	@Override
//	public String getType() {
//		// TODO Auto-generated method stub
//		return "Bird";
//	}
	
	
	@Override
	public String reproduce() {
		// TODO Auto-generated method stub
		return getType()+" Lays Eggs";
	}

	@Override
	public String move() {
		// TODO Auto-generated method stub
		return fly();
	}
	
	public String fly() {
		return getType()+" Fly";
	}

}
