import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Simulation newSimulation = new Simulation();

        ArrayList<Item> loadedItemsP1 = newSimulation.loadItems
                ("Phase-1.txt");


        ArrayList<Item> loadedItemsP2 = newSimulation.loadItems
                ("Phase-2.txt");


        // Loading U1 rockets with items from Phase-1 and Phase-2
        ArrayList<Rocket> listOfU1 = newSimulation.loadU1(loadedItemsP1);
        listOfU1.addAll(newSimulation.loadU1(loadedItemsP2));


        System.out.println();


        // Loading U2 rockets with items from Phase-1 and Phase-2
        ArrayList<Rocket> listOfU2 = newSimulation.loadU2(loadedItemsP1);
        listOfU2.addAll(newSimulation.loadU2(loadedItemsP2));

        System.out.println("U1 rockets simulation");
        int budgetU1 = newSimulation.runSimulation(listOfU1);
        System.out.println();
        System.out.println("U2 rockets simulation");
        int budgetU2 = newSimulation.runSimulation(listOfU2);

        System.out.println();
        System.out.println("For rocket type U1 total budget is: " + budgetU1);
        System.out.println("For rocket type U2 total budget is: " + budgetU2);

    }


}
