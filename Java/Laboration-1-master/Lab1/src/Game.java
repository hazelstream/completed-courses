import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Game {

    private Player player;
    private ArrayList<Location> world = new ArrayList<>();
    private Scanner reader = new Scanner(System.in);

    public Game() {
        createWorld();
    }

    public void run(){
        System.out.println("Välkommen Månfarare!\nVad heter du? ");
        String name = reader.nextLine();
        String command;
        player = new Player(name, world);

        player.currentPos().describeYourself();
        doWhat();

        while (true) {
            command = reader.nextLine();
            doCommand(command, player);
            doWhat();

            //player.printEquipment();

        }


    }

    public void createWorld(){
        Location one = new SpaceStation("rymdstation");
        Location two = new LandingZone("landningszon");
        Location three = new Crater("krater");
        Location four = new Tunnel("tunnel");
        Location five = new Shipwreck("vrak");

        Collections.addAll(world, one, two, three, four, five);

        one.addPaths(two, null, null, null);
        two.addPaths(four, null, one, three);
        three.addPaths(null, two, null, null);
        four.addPaths(five, null, two, null);
        five.addPaths(null, null, four, null);
    }


    public void doCommand(String command, Player player) {
        if (command.toUpperCase().equals("HELP")) {
            System.out.println("H��r kommer n��gra tips p�� olika kommandon!\n"
            		+ "F��r att v��lja en riktning att f��rdas i anv��nder du v��deerstrecks som kommandon.\n"
            		+ "T. ex. 'norr' eller 's��der'. F��r att plocka upp f��rem��l anv��nder du kommandot 'ta'\n"
            		+ "f��ljt av f��rem��let. T. ex. 'ta spaden'. N��r du har en spade kan du gr��va med kommandot\n"
            		+ "'gr��v'. Andra redskap kan brukas med 'anv��nd' och utrustning tas p�� med 'b��r'.\n"
            		+ "T. ex. 'anv��nd facklan' eller 'b��r byxor'. F��r att se vilka f��rem��l du ��ger skriv in 'f��rem��l'.\n"
            		+ "Skriv in 'utrustning' f��r att se vad du har p�� dig. Se dig omkring d��r du ��r med 'titta'.\n"
            		+ "Denna hj��lpmeny tas alltid fram med kommandot 'help'. St��ng programmet med 'exit'.");
        } else if (command.toUpperCase().equals("EXIT")){
            System.out.println("Exiting program.");
            System.exit(0);
        }
        else {
            player.currentPos().doCommand(command, player);
        }
    }

    public void doWhat(){
        System.out.print("\nVad vill du göra? ");
    }
}
