import java.util.Scanner;
import java.util.List;

public class Main{
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to Tamagotchi Game !!!");
		System.out.print("Enter a name for your pet: ");
		String petName = scanner.nextLine();
		
		Tamagotchi tamagotchi = Tamagotchi.getInstance(petName);
		
		Location currentLocation = LocationFactory.createLocation(Locations.Lobby);
		tamagotchi.setCurrentLocation("Lobby");
		
		while(true) {
			System.out.println("\n" + "Current Location: " + currentLocation.getClass().getSimpleName());
			System.out.println("What do you want to do?");
			
			List<Action> actions = currentLocation.makeAction();
			
			for (Action action: actions) {
				System.out.println("- " + action.getClass().getSimpleName());	
			}
			
			System.out.println("- Transfer Location");
			System.out.println("- Exit");
			
			System.out.print("Choice: ");
			String choice = scanner.nextLine().toLowerCase();
	
			if ("transfer location".equals(choice)) {
				currentLocation = currentLocation.transferLocation(tamagotchi);
			}else if ("exit".equals(choice)) {
				System.out.println("\nGood bye!");
				System.exit(0);
			}else {
				boolean actionFound = false;
			    for (int i = 0; i < actions.size(); i++) {
			        if (choice.equalsIgnoreCase(actions.get(i).getClass().getSimpleName())) {
			            actions.get(i).execute(tamagotchi);
			            actionFound = true;
			            break;
			        }
			    }if (!actionFound) {
			        System.out.println("Invalid choice. Please try again.");
			    }
			}
		}
	}
}