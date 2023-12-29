package UPsay.decouverteAndroid.entities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import UPsay.decouverteAndroid.Player;

public class Sprite {
    private double count;
    private Bitmap bmp;
    private SpriteSheet playerSpriteSheet;
    public Sprite(Context context) {
        count = 0;
        playerSpriteSheet = new SpriteSheet(context);
    }

    public void draw(Canvas canvas, Player.PlayerState state, double x, double y) {
        int i;
        int j = 1;
        count +=0.25;
        i = (int)count%4;
        switch (state){
            case UP:
                j = 0;
                break;
            case DOWN:
                j = 1;
                break;
            case LEFT:
                j = 2;
                break;
            case RIGHT:
                j = 3;
                break;
            case STATIC:
                i = 2;
                break;
        }
        Bitmap bmp = playerSpriteSheet.getKeySprite(i,j);
        canvas.drawBitmap(bmp,(float) x,(float) y,null);
    }
}
