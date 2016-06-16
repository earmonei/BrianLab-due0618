package edu.dtcc.earmonei;
/* "Product" */
class Car {
	private int year = 0;
	private String make = "";
	private String model = "";
	private String color = "";
//	private int numdoors = 0;
	private int mpg = 0;
	private double cost = 0.0;

	public void setYear(int year) {
		this.year = year;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setColor(String color) {
		this.color = color;
	}

//	public void setNumdoors(int numdoors) {
//		this.numdoors = numdoors;
//	}

	public void setMpg(int mpg) {
		this.mpg = mpg;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getYear() {
		return year;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public int getMpg() {
		return mpg;
	}

	public double getCost() {
		return cost;
	}

}

/* "Abstract Builder" */
//abstract class CarBuilder {
	abstract class CarBuilder extends Car{
	protected Car car;

	public Car getCar() {
		return car;
	}

	public void createNewCar() {
		car = new Car();
	}

	public abstract void selectYear();

	public abstract void selectMake();

	public abstract void selectModel();
	
	public abstract void selectColor();
	
//	public abstract void selectnumDoors();
	
	public abstract void selectMpg();
	
	public abstract void selectCost();
}

/* "ConcreteBuilder" */
class TwoDoorCarBuilder extends CarBuilder {
	public void selectYear() {
		car.setYear(2016);
//		car.setNumdoors(2);
	}

	public void selectMake() {
		car.setMake("Nissan");
	}

	public void selectModel() {
		car.setModel("350z");
	}
	
	public void selectColor() {
		car.setColor("Red");
	}
	public void selectMpg() {
		car.setMpg(15);
	}
	public void selectCost() {
		car.setCost(40000);
	}
}



/* "ConcreteBuilder" */
class FourDoorCarBuilder extends CarBuilder {
	public void selectYear() {
		car.setYear(2016);
//		car.setNumdoors(2);
	}

	public void selectMake() {
		car.setMake("Nissan");
	}

	public void selectModel() {
		car.setModel("Altima");
	}
	
	public void selectColor() {
		car.setColor("Black");
	}
	public void selectMpg() {
		car.setMpg(25);
	}
	public void selectCost() {
		car.setCost(25000);
	}
}

/* "Director" */
class Dealer {
	private CarBuilder carBuilder;

	public void setCarBuilder(CarBuilder cb) {
		carBuilder = cb;
	}

	public Car getCar() {
		return carBuilder.getCar();
	}

	public void constructCar() {
		carBuilder.createNewCar();
		carBuilder.selectYear();
		carBuilder.selectMake();
		carBuilder.selectModel();
		carBuilder.selectColor();
		carBuilder.selectMpg();
		carBuilder.selectCost();
	}
}

/* A customer ordering a pizza. */
class BuilderExample {
	public static void main(String[] args) {
		Dealer dealer = new Dealer();
		CarBuilder twoDoorCarBuilder = new TwoDoorCarBuilder();
		CarBuilder fourDoorCarBuilder = new FourDoorCarBuilder();

		dealer.setCarBuilder(twoDoorCarBuilder);
		
		dealer.constructCar();

		
		System.out.println("Two-door model:");
		System.out.println("Year: " + twoDoorCarBuilder.car.getYear());
		System.out.println("Make: " + twoDoorCarBuilder.car.getMake());
		System.out.println("Model: " + twoDoorCarBuilder.car.getModel());
		System.out.println("Color: " + twoDoorCarBuilder.car.getColor());
		System.out.println("MPG: " + twoDoorCarBuilder.car.getMpg());
		System.out.println("Cost: " + twoDoorCarBuilder.car.getCost());
		System.out.println();
		
		dealer.setCarBuilder(fourDoorCarBuilder);
		dealer.constructCar();

		
		System.out.println("Four-door model:");
		System.out.println("Year: " + fourDoorCarBuilder.car.getYear());
		System.out.println("Make: " + fourDoorCarBuilder.car.getMake());
		System.out.println("Model: " + fourDoorCarBuilder.car.getModel());
		System.out.println("Color: " + fourDoorCarBuilder.car.getColor());
		System.out.println("MPG: " + fourDoorCarBuilder.car.getMpg());
		System.out.println("Cost: " + fourDoorCarBuilder.car.getCost());
	}
}