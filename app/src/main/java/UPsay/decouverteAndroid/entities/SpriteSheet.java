package UPsay.decouverteAndroid.entities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import UPsay.decouverteAndroid.R;

public class SpriteSheet {
    private Bitmap bitmap;
    private Bitmap sprites[][] = new Bitmap[4][4];
    public SpriteSheet(Context context) {
        BitmapFactory.Options bmpOpt = new BitmapFactory.Options();
        bmpOpt.inScaled = false;
        this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.spritesheet, bmpOpt);
        for(int i = 0; i< sprites.length; i++){
            for(int j = 0; j< sprites[i].length; j++){
                Bitmap bmp = Bitmap.createBitmap(bitmap,16*j,16*i,16,16);
                sprites[i][j] = Bitmap.createScaledBitmap(bmp,bmp.getWidth()*6,bmp.getHeight()*6,false);
            }
        }
    }
    public Bitmap getKeySprite(int i, int j){
        return sprites[i][j];
    }
}
