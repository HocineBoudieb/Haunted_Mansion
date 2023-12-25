package UPsay.decouverteAndroid;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameLoop extends Thread{
    private double count;
    private static final double MAX_UPS = 30.0;
    private boolean isRunning = false;
    private SurfaceHolder surfaceHolder;
    private Mansion mansion;
    public GameLoop(Mansion mansion, SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        this.mansion = mansion;
    }

    public void startLoop() {
        count = 0;
        isRunning = true;
        start();
    }

    @Override
    public void run() {
        super.run();

        //count variable
        int updateCount = 0;
        long startTime;
        long elapsedTime;
        long sleepTime;

        startTime = System.currentTimeMillis();

        Canvas canvas;
        //Game Loop
        while(isRunning){
            count += 1.0/30.0;
            canvas = surfaceHolder.lockCanvas();
            synchronized (surfaceHolder){
                mansion.update();
                mansion.draw(canvas);
            }
            surfaceHolder.unlockCanvasAndPost(canvas);
            updateCount++;
            elapsedTime = System.currentTimeMillis() - startTime;
            sleepTime = (long)(updateCount *(1E+3/MAX_UPS) - elapsedTime);
            if(sleepTime>0){
                try {
                    sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public double getCount() {
        return count;
    }
}
