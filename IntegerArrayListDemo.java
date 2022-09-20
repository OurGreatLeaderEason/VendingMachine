import java.util.ArrayList;
import java.util.Scanner;

public class IntegerArrayListDemo {
    public static void main(String[] args){
        //ArrayList<Integer> scores=new ArrayList<>();
        Scanner kbReader=new Scanner(System.in);
        int size;
        System.out.println("Enter desired size of Array List: ");
        size=kbReader.nextInt();
        System.out.printf("Reading %d scores into array list...\n", size);
        ArrayList<Integer> scores=new ArrayList<>();
        
        System.out.printf("Enter %d scores, 1 per line", size);
        for (int count=1; count<=size; count=count+1){
            System.out.printf("Enter score %d ", count);
            int score;
            score=kbReader.nextInt();
            scores.add(score);

        }

        int totalScores=0;
        System.out.println("scores on the assignment:");
        //for (int score: scores){
            //System.out.println(score);
        //}

        for (int i=0; i<scores.size(); i++){
            System.out.println(scores.get(i));
        }
        

     
        
    }
}
