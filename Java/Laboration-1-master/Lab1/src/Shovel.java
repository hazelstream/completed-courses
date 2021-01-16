public class Shovel extends Tool {

	public Shovel(String name) {
		super(name);
		setPrice(15);
		setWeight(3.5);
	}

	public void use(Player player, Item item) {

		System.out.println("Du börjar gräva efter gömda skatter."); 
		if (player.currentPos().getHiddenTreasure() != null) {
			player.getItems().add(player.currentPos().getHiddenTreasure()); 
			System.out.println("Du hittade " + player.currentPos().getHiddenTreasure().getName() +".");
			player.currentPos().emptyHiddenTreasure();
		} 
		else {
			System.out.println("Du hittade inget."); 
		} 
	} 

	public void doCommand(String com, Item item, Player player) {

		System.out.println("DoCommand i Shovel");
		if (com.toUpperCase().contains("GRÄV")) {
			use(player, item);
		}

	}

}


