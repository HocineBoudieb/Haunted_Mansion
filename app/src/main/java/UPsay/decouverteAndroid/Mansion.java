package UPsay.decouverteAndroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

public class Mansion extends SurfaceView implements SurfaceHolder.Callback {
    private final Player player;
    private GameLoop gameLoop;
    private Joystick joystick;

    //Manage touch and move player
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                player.setPos((double)event.getX(),(double)event.getY());
                return true;
            case MotionEvent.ACTION_MOVE:
                player.setPos((double)event.getX(),(double)event.getY());
                return true;
        }
        return super.onTouchEvent(event);
    }

    public Mansion(Context context) {
        super(context);
        //Get the holder
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        //Manage Game Loop
        gameLoop = new GameLoop(this, surfaceHolder);

        //Initialize the player instance
        player = new Player(getContext(),500,500);

        //Initialize the joystick instance
        joystick = new Joystick();
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        gameLoop.startLoop();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawTest(canvas);
        player.draw(canvas);
    }
    public void drawTest(Canvas canvas){
        String count = Double.toString(gameLoop.getCount());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(getContext(), R.color.white);
        paint.setColor(color);
        paint.setTextSize(100);
        canvas.drawText("UPDATES : "+count,100,100, paint);
    }

    public void update() {
        player.update();
    }
}
