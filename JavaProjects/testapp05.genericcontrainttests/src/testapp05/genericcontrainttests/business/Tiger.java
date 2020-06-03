package testapp05.genericcontrainttests.business;

public class Tiger extends Animal {

	int huntingStrength;

	public Tiger(String name, int age, int huntingStrength) {
		super(name, age);
		this.huntingStrength = huntingStrength;
	}

	public int getHuntingStrength() {
		return huntingStrength;
	}

	public void setHuntingStrength(int huntingStrength) {
		this.huntingStrength = huntingStrength;
	}

	@Override
	public String toString() {
		return "Tiger [name=" + name + ", age=" + age + ", huntingStrength=" + huntingStrength + "]";
	}
	
	

}
