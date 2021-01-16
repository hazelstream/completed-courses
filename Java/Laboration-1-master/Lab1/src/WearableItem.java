public abstract class WearableItem extends Item {

	public WearableItem(String name) {
		super(name);
	}

	public void putOn(Player player, Item item) {
		System.out.println("Du tar på dig " + item.getName() + ".");
		player.giveEquipment(item);
		player.removeItem(item);
	}

	public void doCommand(String com, Item item, Player player) {

		if (com.contains(" ")) {
			String parts[] = com.split(" ");
			String com1 = parts[0];
			String com2 = parts[1];	
			if (com1.toUpperCase().equals("BÄR") && com2.toUpperCase().equals(item.getName().toUpperCase())) {
				putOn(player, item);
			}
		}
	}
}
