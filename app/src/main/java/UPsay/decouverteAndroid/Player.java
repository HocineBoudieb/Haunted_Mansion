package UPsay.decouverteAndroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

public class Player {
    private double x;
    private double y;
    private Paint paint;

    public Player(Context context, double _x, double _y) {
        this.x = _x;
        this.y = _y;
        paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.player);
        paint.setColor(color);
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle((float)x,(float)y,30,paint);
    }

    public void update() {
    }

    public void setPos(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
