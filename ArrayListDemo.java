import java.util.ArrayList;
import java.util.Arrays;
public class ArrayListDemo {
    public static void main(String[] args){
        /* 
        String[] fruits={"apple", "cherry", "grape", "lemon", "lime"};
        
        System.out.println("Favorite fruits:");
        System.out.println(Arrays.toString(fruits));

        fruits=Arrays.copyOf(fruits, 10);
        fruits[5]="kiwi";
        fruits[6]="oranges";
        fruits[7]="pear";
        fruits[8]="watermelon";

        System.out.println("Favorite fruits:");
        System.out.println(Arrays.toString(fruits));*/

        ArrayList<String> fruits=new ArrayList<>();

        fruits.add("apple");
        fruits.add("cherry");
        fruits.add("grape");
        fruits.add("lemon");
        fruits.add("lime");
        
        System.out.println("\nFavorite fruits:");
        System.out.println(fruits.toString());

        fruits.set(1, "papaya");

        System.out.println("Favorite fruits:");
        System.out.println(fruits.toString());
        System.out.println("\nTop Favorite:");

        String favorite;
        favorite=fruits.get(0);
        System.out.println(favorite);

        String runnerUp;
        runnerUp=fruits.get(1);

        System.out.println("\nTop Favorites:");
        System.out.println(runnerUp);

        System.out.println("Remove last place:");

        int lastIndex;
        lastIndex=fruits.size()-1;
        System.out.println("last index: "+lastIndex);
        fruits.remove(lastIndex);
        System.out.println(fruits.toString());



        //System.out.println("\nFavorite fruits:");
        //for (String elemtn: fruits){
            //System.out.println(element);
        //}
        

    }
}
