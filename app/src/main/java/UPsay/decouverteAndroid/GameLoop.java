package UPsay.decouverteAndroid;

import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.view.SurfaceHolder;

public class GameLoop extends Thread{
    private double count;
    private static final double MAX_UPS = 30.0;
    private boolean isRunning = false;
    private SurfaceHolder surfaceHolder;
    private Mansion mansion;

    //Audio Player
    MediaPlayer mediaPlayer;
    public GameLoop(Mansion mansion, SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        this.mansion = mansion;
    }

    public void startLoop() {
        count = 0;
        isRunning = true;
        start();
        mediaPlayer = MediaPlayer.create(mansion.getContext(), R.raw.loop);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
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

            mansion.update();
            mansion.draw(canvas);

            surfaceHolder.unlockCanvasAndPost(canvas);
            updateCount++;
            elapsedTime = System.currentTimeMillis() - startTime;
            //Get the difference between theoric time per update and elapsed time
            sleepTime = (long)(updateCount *(1E+3/MAX_UPS)/*to convert UPS to update per milliseconds*/  - elapsedTime);
            //if this difference is positive, we have to wait a bit to not refresh to early
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
