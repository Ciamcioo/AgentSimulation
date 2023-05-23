import java.util.Random;

public class Map {

    private String[][] map;
    private int size = 20;

    public Map(){
    }

    public void map_initialization(double vaccineProbability){
        map = new String[size+2][size+2];
        int[] probability = new int[100];

        for(int i = 0; i < vaccineProbability*100; i++){
            probability[i] = 1;
        }

        for(int i = 1; i<=size; i++){
            for(int j = 1; j<=size; j++){
                int random = new Random().nextInt(probability.length);
                if(probability[random]==1){
                    map[i][j]="V";
                } else {
                    map[i][j]=" ";
                }
            }
        }
    }

    public void print_map(){
        for(int i = 1; i<=size; i++){
            System.out.print(" __");
        }
        System.out.println();
        for(int i = 1; i <=size; i++){
            System.out.print("|");
            for(int j = 1; j<=size; j++){
                System.out.print("  " + map[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
        for(int i = 1; i<=size; i++){
            System.out.print(" __");
        }
    }
    public static void main(String[] args){
        double vaccineProbability = 0.15;
        Map map = new Map();
        map.map_initialization(vaccineProbability);
        map.print_map();

    }

}
