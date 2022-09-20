
import java.util.Random;
import java.io.File;
import processing.core.PImage;
public class WalkingSim {
    private static Random randGen;
    private static int bgColor;
    private static PImage[] frames;
    private static Walker[] walkers;
    public static void setup(){
        randGen=new Random();
        bgColor=randGen.nextInt();
        walkers=new Walker[8];
        int numWalkers=randGen.nextInt(1, 9);
        for (int i=0; i<numWalkers; i++){
            Random rando=new Random();
            walkers[i]=new Walker(rando.nextInt(0, Utility.width()), rando.nextInt(0, Utility.height()));
        }
        frames=new PImage[Walker.NUM_FRAMES];
        for (int i=0; i<frames.length; i++){
            frames[i]=Utility.loadImage("images" + File.separator + "walk-"+i+".png");
        }
        
    }
    public static void draw(){
        Utility.background(bgColor);
        for (int i=0; i<walkers.length; i++){
            if (walkers[i]!=null){
                Utility.image(frames[0], walkers[i].getPositionX(), walkers[i].getPositionY());
            }
        }
    }
    public static void main(String[] args){
        Utility.runApplication();
    }
    public static boolean isMouseOver(Walker walker){
        if(Utility.mouseX()>=walker.getPositionX()-frames[0].width/2 && Utility.mouseX()<=walker.getPositionX()+frames[0].width/2
        && Utility.mouseY()>=walker.getPositionY()-frames[0].height/2 && Utility.mouseY()<=walker.getPositionY()+frames[0].height/2){
            return true;
        }
        return false;
    }
    public static void mousePressed(){
        for (int i=0; i<walkers.length; i++){
            if (isMouseOver(walkers[i])){
                walkers[i].setWalking(true);
                System.out.println("nigger");
            }
        }
    }

}
