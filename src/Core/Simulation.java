package Core;
import Map.Map;

import static java.lang.Math.abs;

public class Simulation  {

    public static void main(String[] args) throws InterruptedException {
//        DataOfSimulation dataOfSimulation = new DataOfSimulation();
        DataOfSimulation dataOfSimulation = new DataOfSimulation(20, 40, 40, 10, 20, 40, 0.1, 5, 2, 0.1, 2 ,0.1);
        Map mapOfSimulation = new Map(dataOfSimulation);

        while (dataOfSimulation.getNumberOfIterations() > 0) {
            mapOfSimulation.packageInitialization();
            mapOfSimulation.agentControlMethod();
            mapOfSimulation.printMap();
            mapOfSimulation.packageDestruction();
            mapOfSimulation.settingValueOfMoveIterationToFalse();
            dataOfSimulation.setNumberOfIterations(dataOfSimulation.getNumberOfIterations() - 1);
            dataOfSimulation.updateData(mapOfSimulation);
            dataOfSimulation.displayData(mapOfSimulation);
            Thread.sleep(1000);
        }

        // TODO dopisać testy jednostkowe do klas, które ich nie mają. Przejżyjcie te testy i klasy, jeżli jakiaś nie ma testu to daje TODO że dopisać test do klasy i ja powoli
        //  je będe dopisywał

        // TODO dopisać lepsze niszczenie obiektu wtedy gdy obiekty jest pusty


    }
}
