package UPsay.decouverteAndroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceView;

import androidx.core.content.ContextCompat;

import UPsay.decouverteAndroid.entities.Sprite;

public class Player {
    private static final double MAX_SPEED = 20;
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

    public Player(Context context, double _x, double _y) {
        currentState = PlayerState.STATIC;
        this.x = _x;
        this.y = _y;
        paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.player);
        paint.setColor(color);
    }

    public void draw(Canvas canvas)
    {
        sprite.draw(currentState);
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
            x = x+joystick.getRadiusRateX()*MAX_SPEED/joystick.getRadius();
        }else{
            if(valueY>0){
                currentState = PlayerState.UP;
            }else {
                currentState = PlayerState.DOWN;
            }
            y = y+joystick.getRadiusRateY()*MAX_SPEED/joystick.getRadius();
        }


    }

}
