public class Tamagotchi {
	public static Tamagotchi instance;
	private String petName;
	private String currentLocation;
	private int hungerLevel;
	private int happinessLevel;
	private int trainingLevel;
	
	
	private Tamagotchi(String petName){
		this.petName = petName;
		this.hungerLevel = 100;
		this.happinessLevel = 100;
		this.trainingLevel = 0;
	}
	
	public String getPetName() {
		return petName;
	}
	
	public static Tamagotchi getInstance(String petName){							
		instance = new Tamagotchi(petName);
		return instance;
	}
	
	public String getCurrentLocation() {	
		return currentLocation;
	}
	
	public void setCurrentLocation(String location) {
		this.currentLocation = location;
	}
	
	public void increaseHunger(int value){	
		hungerLevel = Math.min(100, hungerLevel + value);	 
	}
	
	public void increaseHappiness(int value){
		happinessLevel = Math.min(100, happinessLevel + value);
	}
	
	public void increaseTraining(int value){
		trainingLevel = Math.min(100, trainingLevel + value);
	}
	
	public void decreaseHappiness(int value){
		happinessLevel = Math.max(0, happinessLevel - value);
	}
	
	public void decreaseHunger(int value){
		hungerLevel = Math.max(0, hungerLevel - value);
	}
	
	public void displayStatus() {	
		System.out.println("\n============================");
		System.out.println("Pet Name: " + petName);
		System.out.println("- Hunger Level: " + hungerLevel);
		System.out.println("- Happiness Level: " + happinessLevel);
		System.out.println("- Training Level: " + trainingLevel);
		System.out.println("============================");
	}
}

class DisplayStatus implements Action{	

	@Override
	public void execute(Tamagotchi tamagotchi) {
		tamagotchi.displayStatus();
	}	
}
