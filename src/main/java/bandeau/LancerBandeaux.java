package bandeau;

import java.util.LinkedList;
import java.util.List;

public class LancerBandeaux extends Thread{

    private List<ScenarioElement> myElements = new LinkedList<>();
    private Bandeau b;

    public LancerBandeaux(Bandeau bandeau, List<ScenarioElement> myElements ){
        this.b = bandeau;
        this.myElements = myElements;
    }

    public  void run() {
        synchronized(b){
        for (ScenarioElement element : myElements) {
            for (int repeats = 0; repeats < element.repeats; repeats++) {
                element.effect.playOn(b);
            }
        }
    }}
}
