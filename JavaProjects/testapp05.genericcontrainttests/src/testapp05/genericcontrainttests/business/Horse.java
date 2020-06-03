package testapp05.genericcontrainttests.business;

public class Horse extends Animal {

	int speed;

	public Horse(String name, int age, int speed) {
		super(name, age);
		this.speed = speed;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Horse [name=" + name + ", age=" + age + ", speed=" + speed + "]";
	}
	
}
