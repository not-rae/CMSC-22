public interface Action {	
	void execute(Tamagotchi tamagotchi);
}

enum Actions{																// enumeration w/ items feed, play, train na gagamitin ng factory later
	Feed,
	Play,
	Train,
	DisplayStatus;
}

class ActionFactory{
	public static Action createAction(Actions actions) {
		switch(actions) {
			case Feed:
				return new Feed();
			case Play:
				return new Play();
			case Train:
				return new Train();
			case DisplayStatus:
				return new DisplayStatus();
			default:
				return null;
		}
	}
}

class Feed implements Action{	
	public void execute(Tamagotchi tamagotchi) {
		System.out.println("\n[ Feeding " + tamagotchi.getPetName() + " ]");
		
		String currentLocation = tamagotchi.getCurrentLocation();
		
		if ("Lobby".equals(currentLocation)){
			tamagotchi.decreaseHunger(15);
			tamagotchi.increaseHappiness(15);
		}else if ("Kitchen".equals(currentLocation)) {
			tamagotchi.decreaseHunger(30);
			tamagotchi.increaseHappiness(5);
		}
	}
}

class Play implements Action{

	@Override
	public void execute(Tamagotchi tamagotchi) {
		System.out.println("\n[ Playing with " + tamagotchi.getPetName() + " ]");	
		
		String currentLocation = tamagotchi.getCurrentLocation();
		
		if ("Playground".equals(currentLocation)) {
			tamagotchi.increaseHappiness(5);
			tamagotchi.increaseHunger(10);
		}else {
			tamagotchi.increaseHappiness(10);
			tamagotchi.increaseHunger(20);
		}
	}
}


class Train implements Action{

	@Override
	public void execute(Tamagotchi tamagotchi) {
		System.out.println("\n[ Training " + tamagotchi.getPetName() + " ]");
		
		String currentLocation = tamagotchi.getCurrentLocation();
		
		if ("Lobby".equals(currentLocation)) {
			tamagotchi.increaseTraining(10);
            tamagotchi.decreaseHappiness(15);
            tamagotchi.increaseHunger(30);
        } else if ("Training Room".equals(currentLocation)) {
            tamagotchi.increaseTraining(20);
            tamagotchi.decreaseHappiness(5);
            tamagotchi.increaseHunger(15);
        }
	}
}


