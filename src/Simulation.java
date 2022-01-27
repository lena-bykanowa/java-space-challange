import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public Simulation() {

    }

    ArrayList<Item> loadItems(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner newScanner = new Scanner(file);

        ArrayList<Item> listOfItems = new ArrayList<Item>();
        while (newScanner.hasNextLine()) {

            String line = newScanner.nextLine();
            //building tools=2000
            String[] data = line.split("=");
            //{"building tools", "2000"}
            //0, 1
            Item item = new Item(data[0], Integer.valueOf(data[1]));
            listOfItems.add(item);
        }

        return listOfItems;

    }

    ArrayList<Rocket> loadU1(ArrayList<Item> listOfItems) {

        ArrayList<Rocket> listOfU1 = new ArrayList<Rocket>();

        U1 u1Rocket = new U1();

        for (Item item : listOfItems) {
            if (!u1Rocket.canCarry(item)) {
                listOfU1.add(u1Rocket);
                //System.out.println("creating new u1 rocket");
                u1Rocket = new U1();

            }
            u1Rocket.carry(item);
            //System.out.println("loading item " + item.name);
            if (listOfItems.indexOf(item) == (listOfItems.size() - 1)) {
                listOfU1.add(u1Rocket);
            }

        }
        return listOfU1;
    }

    ArrayList<Rocket> loadU2(ArrayList<Item> listOfItems) {

        ArrayList<Rocket> listOfU2 = new ArrayList<Rocket>();

        U2 u2Rocket = new U2();

        for (Item item : listOfItems) {
            if (!u2Rocket.canCarry(item)) {
                listOfU2.add(u2Rocket);
                //System.out.println("creating new u2 rocket");
                u2Rocket = new U2();

            }
            u2Rocket.carry(item);
            //System.out.println("loading item " + item.name);
            if (listOfItems.indexOf(item) == (listOfItems.size() - 1)) {
                listOfU2.add(u2Rocket);
            }

        }
        return listOfU2;
    }

    int runSimulation (ArrayList<Rocket> listOfRockets) {
        int budget = 0;
        int numberOfTries= 0;
        for (Rocket rocket : listOfRockets) {
            numberOfTries += 1;
            budget += rocket.cost;

            while(!rocket.launch() || !rocket.land()) {
                numberOfTries += 1;
                budget += rocket.cost;
            }

        }

        System.out.println("Number of rockets sent: " + numberOfTries);
        System.out.println("Total budget: " + budget);
        return budget;

    }

}
