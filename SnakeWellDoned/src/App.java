import javax.swing.JPanel;
import graphics.Panel;
import graphics.Window;

public class App implements Runnable{

    public static Boolean engineOn;
    private static final String NAME = "Game";
    private static int ups = 0;
    private static int fps = 0;
    private static Window window;

    private static Thread thread;

    public static void main(String[] args) throws Exception {
        window = new Window(600, 600, NAME);
        JPanel panel = Panel.createPanel(10,10,20,20);

        window.addPanel(panel);
        App app = new App();
        app.startThread();
        
        
    }

    private synchronized void startThread(){
        engineOn = true;
        thread = new Thread(this, "Graphics");
        thread.start();
    }

    private synchronized void stopThread(){
        engineOn = false;
        try {
            thread.join();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void update(){
        ups++;
    }

    private static void display(){
        fps++;
    }

    public void run(){
        final int NS_PER_SECONDS = 1_000_000_000;
        final byte UPS = 60;
        final double NS_PER_UPDATE = NS_PER_SECONDS / UPS;
        long referenceTime = System.nanoTime();
        long fpsUpsCounterTime = System.nanoTime();
        double timeElapse;
        double delta = 0;
        while(engineOn){
            long startTime = System.nanoTime();
            timeElapse = startTime - referenceTime;
            referenceTime = startTime;
            delta += timeElapse / NS_PER_UPDATE;
    

            while(delta >= 1){
                update();
                delta--;
            }

            display();
            
            if (System.nanoTime() - fpsUpsCounterTime > NS_PER_SECONDS){
                window.setTittle(NAME + ", ups: " + Integer.toString(ups) + ", fps: " + Integer.toString(fps));
                fpsUpsCounterTime = System.nanoTime();
                fps = 0;
                ups = 0;
            }
        }
    }
}
