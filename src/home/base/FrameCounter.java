package home.base;

/**
 * Created by VALV on 7/18/2017.
 */
public class FrameCounter {
    int count;
    int countMax;

    public FrameCounter(int countMax){
        this.countMax = countMax;
    }

    public void reset(){
        count = 0;
    }

    public boolean run(){
        if (count < countMax){
            count++;
            return false;
        }
        return true;
    }

}