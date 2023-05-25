package Core;


import Map.Map;

public class Simulation {
    public static void main(String[] args) {
        double vaccineProbability = 0.15;
        Map map = new Map(20);
//        map.map_initialization(vaccineProbability);
        map.print_map();

    }
}
