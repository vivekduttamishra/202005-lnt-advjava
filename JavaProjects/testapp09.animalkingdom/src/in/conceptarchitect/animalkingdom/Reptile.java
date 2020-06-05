package in.conceptarchitect.animalkingdom;

public abstract class Reptile extends Animal implements Hunter{

//	@Override
//	public String getType() {
//		// TODO Auto-generated method stub
//		return "Reptile";
//	}
	
	
	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return getType()+" is aflesh eater :"+hunt();
	}

	public abstract String hunt();

	@Override
	public String reproduce() {
		// TODO Auto-generated method stub
		return getType()+" lays eggs";
	}

	@Override
	public String move() {
		// TODO Auto-generated method stub
		return getType()+" Crawls";
	}

}
