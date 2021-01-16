public class Tool extends Item {

	public Tool(String name) {
		super(name);
	}

	public void use(Player player, Item item) {
		System.out.println("Du anvÃ¤nder " + item.getName());
	}

	public void doCommand(String com, Item item, Player player) {

		System.out.println("DoCommand i Tool");
		if (com.contains(" ")) {
			String parts[] = com.split(" ");
			String com1 = parts[0];
			String com2 = parts[1];
			if (com1.toUpperCase().equals("ANVÄND")) {
				if (com2.toUpperCase().equals(item.getName().toUpperCase())) {
					use(player, item);
				}
			}
		}
	}
}

