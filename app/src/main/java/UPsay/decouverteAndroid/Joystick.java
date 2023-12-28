package UPsay.decouverteAndroid;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Joystick {
    private  Paint outerCirclePaint;
    private  Paint innerCirclePaint;
    private  int outerCircleX;
    private  int outerCircleY;
    private  int innerCircleX;
    private  int innerCircleY;
    private  int innerCircleR;
    private  int outerCircleR;
    private int radiusRateX;
    private int radiusRateY;

    public Joystick(int centerX, int centerY, int _outerCircleR, int _innerCircleR) {
        //position of joystick
        this.outerCircleX = centerX;
        this.outerCircleY = centerY;
        this.innerCircleX = centerX;
        this.innerCircleY = centerY;
        this.outerCircleR = _outerCircleR;
        this.innerCircleR = _innerCircleR;

        //Display parameter of joystick
        this.outerCirclePaint = new Paint();
        outerCirclePaint.setColor(Color.DKGRAY);
        outerCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);

        this.innerCirclePaint = new Paint();
        innerCirclePaint.setColor(Color.GRAY);
        innerCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(outerCircleX,outerCircleY,outerCircleR,outerCirclePaint);
        canvas.drawCircle(innerCircleX,innerCircleY,innerCircleR,innerCirclePaint);
    }

    public void update() {
    }
    public void setPos(){

    }
    public void resetPos(){

    }
    public boolean isPressedOnPos(int x, int y){
        int distToJoystick = (int)Math.sqrt(Math.pow(outerCircleX-x,2)+Math.pow(outerCircleY-y,2));
        return distToJoystick < outerCircleR;
    }
}
