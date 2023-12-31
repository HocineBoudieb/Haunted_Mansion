package UPsay.decouverteAndroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceView;

import androidx.core.content.ContextCompat;

import UPsay.decouverteAndroid.entities.Sprite;

public class Player {
    private PlayerState currentState;
    private double x;
    private double y;
    private Paint paint;
    private Sprite sprite;

    public enum PlayerState {
        STATIC,  // Le joueur ne bouge pas
        UP,      // Le joueur se déplace vers le haut
        DOWN,    // Le joueur se déplace vers le bas
        LEFT,    // Le joueur se déplace vers la gauche
        RIGHT    // Le joueur se déplace vers la droite
    }

    public Player(Context context) {
        currentState = PlayerState.STATIC;
        sprite = new Sprite(context);
        paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.player);
        paint.setColor(color);
        x = MainActivity.PHONE_WIDTH/2.0;
        y = MainActivity.PHONE_HEIGHT/2.0;
    }

    public void draw(Canvas canvas)
    {
        sprite.draw(canvas,currentState,x,y);
    }

    public void update(Joystick joystick){
        double valueX = joystick.getRadiusRateX();
        double valueY = joystick.getRadiusRateY();
        if(!joystick.getPressed()){
            currentState = PlayerState.STATIC;
            return;
        }
        if(Math.abs(valueX)> Math.abs(valueY)){
            if(valueX>0){
                currentState = PlayerState.RIGHT;
            }else {
                currentState = PlayerState.LEFT;
            }
        }else{
            if(valueY>0){
                currentState = PlayerState.UP;
            }else {
                currentState = PlayerState.DOWN;
            }
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
