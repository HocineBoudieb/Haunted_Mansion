package UPsay.decouverteAndroid.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import UPsay.decouverteAndroid.R;

public class TileSet {
    private static final int HEIGHT = 16;
    private static final int WIDTH = 22;
    private Bitmap bitmap;
    private Bitmap tiles[];

    public TileSet(Context context) {
        tiles = new Bitmap[HEIGHT*WIDTH];
        BitmapFactory.Options bmpOpt = new BitmapFactory.Options();
        bmpOpt.inScaled = false;
        this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.tileset, bmpOpt);
        for(int i = 0; i< HEIGHT; i++){
            for(int j = 0; j< WIDTH; j++){
                int idx = i*WIDTH + j;
                Bitmap bmp = Bitmap.createBitmap(bitmap,16*j,16*i,16,16);
                tiles[idx] = Bitmap.createScaledBitmap(bmp,bmp.getWidth()*6,bmp.getHeight()*6,false);
            }
        }
    }
    public Bitmap getTiles(int idx){
        return tiles[idx];
    }
}
