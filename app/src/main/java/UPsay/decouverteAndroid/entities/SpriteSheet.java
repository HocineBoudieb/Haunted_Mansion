package UPsay.decouverteAndroid.entities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import UPsay.decouverteAndroid.R;

public class SpriteSheet {
    private Bitmap bitmap;

    public SpriteSheet(Context context) {
        BitmapFactory.Options bmpOpt = new BitmapFactory.Options();
        bmpOpt.inScaled = false;
        this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.spritesheet);
    }
    public Sprite getSprite(){
        return new Sprite(this,new Rect(0,0,64,64));
    }
}
