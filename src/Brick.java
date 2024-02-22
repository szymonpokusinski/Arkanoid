import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Brick extends Rectangle2D.Float {
    private Brick c1;
    public static List<Brick> bricks = new LinkedList<>();
    public static List<Integer> list ;
    public Brick(float x, float y){
        super(x, y, 75, 30);
        //tworzenieListy();
    }
    public void tworzenieListy() {
        List<Integer> zeroOneList = oneZeroList(15);
        int x = 0;
        int y = 0;
        for (int i=0 ; i <= 4; i++){
            if (zeroOneList.get(i) == 1) {
                bricks.add(new Brick(x, 0));

            } else{
                bricks.add(null);
            }
            x += 80;
        }
        x = 0;
        for (int i = 5; i <= 9; i++){
            if (zeroOneList.get(i) == 1){
                bricks.add(new Brick(x, 35));
            } else {
                bricks.add(null);
            }
            x += 80;
        }
        x = 0;
        for (int i = 10; i <= 14; i++){
            if (zeroOneList.get(i) == 1){
                bricks.add(new Brick(x, 70));
            } else {
                bricks.add(null);
            }
            x += 80;
        }


    }
    public List<Integer> oneZeroList(int size){
        List<Integer> list1 = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++){
            int randomInt = random.nextInt(2);
            list1.add(randomInt);
        }
        return list1;
    }
}
