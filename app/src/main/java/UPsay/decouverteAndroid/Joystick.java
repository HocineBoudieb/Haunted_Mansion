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
    private double radiusRateX;
    private double radiusRateY;
    private boolean pressed;
    private int primaryCenterX;
    private int primaryCenterY;


    public Joystick(int centerX, int centerY, int _outerCircleR, int _innerCircleR) {
        //position of joystick
        primaryCenterX = centerX;
        primaryCenterY = centerY;
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
        if(pressed) {
            canvas.drawCircle(outerCircleX,outerCircleY,outerCircleR,outerCirclePaint);
            canvas.drawCircle(innerCircleX,innerCircleY,innerCircleR,innerCirclePaint);
        }
    }

    public void update() {
        innerCircleX = (int) (outerCircleX+radiusRateX);
        innerCircleY = (int) (outerCircleY+radiusRateY);
    }
    public void setPos(double x, double y){
        double dX = x - outerCircleX;
        double dY = y - outerCircleY;
        double dist = Math.sqrt(Math.pow(dX,2)+Math.pow(dY,2));

        if(dist < outerCircleR){
            radiusRateX = dX;
            radiusRateY = dY;
        }else {
            radiusRateX = (dX/dist)*outerCircleR;
            radiusRateY = (dY/dist)*outerCircleR;
        }
    }
    public void resetPos(){
        radiusRateX = 0.0;
        radiusRateY = 0.0;
        innerCircleX = primaryCenterX;
        innerCircleY = primaryCenterY;
        outerCircleX = primaryCenterX;
        outerCircleY = primaryCenterY;

    }
    public boolean isPressedOnPos(double x, double y){
        int distToJoystick = (int)Math.sqrt(Math.pow(outerCircleX-x,2)+Math.pow(outerCircleY-y,2));
        return distToJoystick < outerCircleR;
    }

    public void setPressed(boolean b) {
        pressed = b;
    }

    public boolean getPressed() {
        return pressed;
    }

    public void changePos(double x, double y) {
        innerCircleX = (int)x;
        innerCircleY = (int)y;
        outerCircleX = (int)x;
        outerCircleY = (int)y;
    }

    public double getRadiusRateX() {
        return radiusRateX;
    }
    public double getRadiusRateY() {
        return radiusRateY;
    }

    public double getRadius() {
        return outerCircleR;
    }
}
