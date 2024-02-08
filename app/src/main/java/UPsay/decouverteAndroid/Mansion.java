package UPsay.decouverteAndroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.lang.reflect.Array;
import java.util.Arrays;

import UPsay.decouverteAndroid.map.MapManager;
import UPsay.decouverteAndroid.map.TileMap;

public class Mansion extends SurfaceView implements SurfaceHolder.Callback {
    private final Player player;
    private GameLoop gameLoop;
    private Joystick joystick;
    private MapManager mapManager;
    private Bitmap restartButton;
    private Bitmap winScreen;

    // different states in enum
    public enum GameState {
        PLAYING,
        GAME_OVER
    }

    // Champ pour stocker l'état actuel du jeu
    private GameState gameState;
    public void gameOver() {
        gameLoop.stopLoop();
        Canvas canvas = getHolder().lockCanvas();
        canvas.drawBitmap(winScreen,0,0,null);
        canvas.drawBitmap(restartButton, 1800, 100, null);
        getHolder().unlockCanvasAndPost(canvas);

    }
    public GameState getGameState() {
        return gameState;
    }
    public void setGameState(GameState state) {
        gameState = state;
    }

    //Manage touch and move player
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(joystick.isPressedOnPos((double)event.getX(),(double)event.getY())){
                    joystick.setPressed(true);
                }else{
                    if(((double)event.getX()<700) && ((double)event.getY()>500)) {
                        joystick.changePos((double)event.getX(),(double)event.getY());
                        joystick.setPressed(true);
                    }
                    else{
                        if(((double)event.getX()>1700) && ((double)event.getY()<300)){
                            if(getGameState()==GameState.GAME_OVER){setGameState(GameState.PLAYING);gameLoop = new GameLoop(this,getHolder());gameLoop.startLoop();}
                            restart();
                        }
                    }
                }
                return true;
            case MotionEvent.ACTION_MOVE:
                if(joystick.getPressed()){
                    joystick.setPos((double)event.getX(),(double)event.getY());
                }
                return true;
            case MotionEvent.ACTION_UP:
                joystick.setPressed(false);
                joystick.resetPos();
                return true;
        }
        return super.onTouchEvent(event);
    }

    private void restart() {
        mapManager.restart();
    }

    public Mansion(Context context) {
        super(context);
        //Get the holder
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        //Manage Game Loop
        gameLoop = new GameLoop(this, surfaceHolder);

        //Initialize the player instance
        player = new Player(getContext());

        //Initialize the joystick instance
        joystick = new Joystick(350,750,70,40);

        //Use a Map Manager
        mapManager = new MapManager(getContext(),this);

        //Initialize restart Button
        BitmapFactory.Options bmpOpt = new BitmapFactory.Options();
        bmpOpt.inScaled = false;
        restartButton = BitmapFactory.decodeResource(context.getResources(), R.drawable.restart, bmpOpt);
        restartButton = Bitmap.createScaledBitmap(restartButton,restartButton.getWidth()*1,restartButton.getHeight()*1,false);

        //Create win screen

        winScreen = BitmapFactory.decodeResource(context.getResources(), R.drawable.win, bmpOpt);
        winScreen = Bitmap.createScaledBitmap(winScreen,MainActivity.PHONE_WIDTH,MainActivity.PHONE_HEIGHT,false);
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
        //drawTest(canvas);
        mapManager.draw(canvas);
        joystick.draw(canvas);
        player.draw(canvas);
        canvas.drawBitmap(restartButton, 1800, 100, null);
    }

    public void drawTest(Canvas canvas){
        String count = Double.toString(gameLoop.getCount());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(getContext(), R.color.white);
        paint.setColor(color);
        paint.setTextSize(100);
        canvas.drawText("HEY HEY",100,100, paint);
    }

    public void update() {
        joystick.update();
        player.update(joystick);
        mapManager.update(joystick);
    }
}
