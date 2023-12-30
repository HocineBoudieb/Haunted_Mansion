package UPsay.decouverteAndroid.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.service.quicksettings.Tile;

public class TileMap {
    //Tiles i want to use
    public final static int TOP_RIGHT = 277;
    public final static int TOP_LEFT = 275;
    public final static int TOP = 276;
    public final static int BOTTOM_RIGHT = 321;
    public final static int BOTTOM_LEFT = 319;
    public final static int BOTTOM = 320;
    public final static int RIGHT = 299;
    public final static int LEFT = 297;
    public final static int CENTER = 298;
    public final static int[] boundTiles = {TOP,TOP_LEFT,TOP_RIGHT,LEFT,RIGHT,BOTTOM,BOTTOM_LEFT,BOTTOM_RIGHT};
    private int[][] tileIds;
    private TileSet tiles;
    public TileMap(Context context,int[][] tileIds) {
        this.tileIds = tileIds;
        tiles = new TileSet(context);
    }

    public int getLength(){
        return tileIds.length;
    }


    public int getId(int i, int j) {
        return tileIds[i][j];
    }

    public Bitmap getBmp(int tileId) {
        return tiles.getTiles(tileId);
    }
}
