import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public interface Location {
	Location transferLocation(Tamagotchi tamagotchi);
	List<Action> makeAction();
}

enum Locations{
	Kitchen,
	Lobby,
	Playground,
	TrainingRoom;
}

class LocationFactory{
	public static Location createLocation(Locations locations) {
		switch(locations) {
			case Kitchen:
				return new Kitchen();
			case Lobby:
				return new Lobby();
			case Playground:
				return new Playground();
			case TrainingRoom:
				return new TrainingRoom();
			default:
				return null;
		}
	}
}

abstract class BaseLocation implements Location{	
	protected void showLocationOptions(String[] options) {		
		System.out.println("\nGo to: ");
		for (int i = 0; i < options.length; i++) {
			System.out.println(("- " + options[i]));
		}
	}
}

class Lobby extends BaseLocation {		
	
	public List<Action> makeAction() {	
		List<Action> actions = new ArrayList<>();
		actions.add(ActionFactory.createAction(Actions.Feed));
		actions.add(ActionFactory.createAction(Actions.Play));
		actions.add(ActionFactory.createAction(Actions.Train));
		actions.add(ActionFactory.createAction(Actions.DisplayStatus));
		return actions;
	}

	@Override
	public Location transferLocation(Tamagotchi tamagotchi) {
		showLocationOptions(new String[] {"Kitchen", "Playground", "Training Room"});
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Choice: ");
		String choice = scanner.nextLine().toLowerCase();
		
		switch (choice) {
			case "kitchen":
				tamagotchi.setCurrentLocation("Kitchen");
				return LocationFactory.createLocation(Locations.Kitchen);
			case "playground":
				tamagotchi.setCurrentLocation("Playground");
				return LocationFactory.createLocation(Locations.Playground);
			case "training room":
				tamagotchi.setCurrentLocation("Training Room");
				return LocationFactory.createLocation(Locations.TrainingRoom);
			default:
				System.out.println("Invalid choice. Staying in the Lobby.");
				return this;
		}
	}
}

class Kitchen extends BaseLocation{
	
	@Override
	public List<Action> makeAction() {
		List<Action> actions = new ArrayList<>();
		actions.add(ActionFactory.createAction(Actions.Feed));
		actions.add(ActionFactory.createAction(Actions.DisplayStatus));
		return actions;
	}

	@Override
	public Location transferLocation(Tamagotchi tamagotchi){
		showLocationOptions(new String[] {"Lobby", "Playground", "Training Room"});
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Choice: ");
		String choice = scanner.nextLine().toLowerCase();
		
		switch (choice) {
			case "lobby":
				tamagotchi.setCurrentLocation("Lobby");
				return LocationFactory.createLocation(Locations.Lobby);
			case "playground":
				tamagotchi.setCurrentLocation("Playground");
				return LocationFactory.createLocation(Locations.Playground);
			case "training room":
				tamagotchi.setCurrentLocation("Training Room");
				return LocationFactory.createLocation(Locations.TrainingRoom);
			default:
				System.out.println("Invalid choice. Staying in the Kitchen");
				return this;
		}
	}
}

class Playground extends BaseLocation{
	
	@Override
	public List<Action> makeAction() {
		List<Action> actions = new ArrayList<>();
		actions.add(ActionFactory.createAction(Actions.Play));
		actions.add(ActionFactory.createAction(Actions.DisplayStatus));
		return actions;
	}

	@Override
	public Location transferLocation(Tamagotchi tamagotchi){
		showLocationOptions(new String[] {"Lobby", "Kitchen", "Training Room"});
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Choice: ");
		String choice = scanner.nextLine().toLowerCase();
		
		switch (choice) {
			case "lobby":
				tamagotchi.setCurrentLocation("Lobby");
				return LocationFactory.createLocation(Locations.Lobby);
			case "kitchen":
				tamagotchi.setCurrentLocation("Kitchen");
				return LocationFactory.createLocation(Locations.Kitchen);
			case "training room":
				tamagotchi.setCurrentLocation("Training Room");
				return LocationFactory.createLocation(Locations.TrainingRoom);
			default:
				System.out.println("Invalid choice. Staying in the Playground.");
				return this;
		}
	}
}

class TrainingRoom extends BaseLocation{
	
	@Override
	public List<Action> makeAction() {
		List<Action> actions = new ArrayList<>();
		actions.add(ActionFactory.createAction(Actions.Train));
		actions.add(ActionFactory.createAction(Actions.DisplayStatus));
		return actions;
	}

	@Override
	public Location transferLocation(Tamagotchi tamagotchi) {
		showLocationOptions(new String[] {"Lobby", "Kitchen", "Playground"});

		Scanner scanner = new Scanner(System.in);
		System.out.print("Choice: ");
		String choice = scanner.nextLine().toLowerCase();
		
		switch (choice) {
			case "lobby":
				tamagotchi.setCurrentLocation("Lobby");
				return LocationFactory.createLocation(Locations.Lobby);
			case "kitchen":
				tamagotchi.setCurrentLocation("Kitchen");
				return LocationFactory.createLocation(Locations.Kitchen);
			case "playground":
				tamagotchi.setCurrentLocation("Playground");
				return LocationFactory.createLocation(Locations.Playground);
			default:
				System.out.println("Invalid choice. Staying in the Training Room.");
				return this;
		}
	}	
}