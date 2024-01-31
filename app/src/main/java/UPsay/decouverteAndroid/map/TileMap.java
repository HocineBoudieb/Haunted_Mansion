package UPsay.decouverteAndroid.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.service.quicksettings.Tile;
import android.util.Log;

public abstract class TileMap {

    //Id
    public int id;
    //Spawn point
    final double startX;
    final double startY;

    //Tiles i want to use
    public static int[] exitTiles = {10,21};
    public final static int TOP_RIGHT = 277;
    public final static int TOP_LEFT = 275;
    public final static int TOP = 276;
    public final static int BOTTOM_RIGHT = 321;
    public final static int BOTTOM_LEFT = 319;
    public final static int BOTTOM = 320;
    public final static int RIGHT = 299;
    public final static int LEFT = 297;
    public final static int CENTER = 298;
    public final static int CENTER_ = 298;

    public final static int[] boundTiles = {TOP,TOP_LEFT,TOP_RIGHT,LEFT,RIGHT,BOTTOM,BOTTOM_LEFT,BOTTOM_RIGHT};
    private int[][] tileIds;
    private TileSet tiles;
    public TileMap(Context context, double x, double y, int _id) {
        startX = x; startY = y; tiles = new TileSet(context);
        id = _id;
    }

    public void setTileIds(int[][] tileIds) {
        this.tileIds = tileIds;
    }

    public int getLength(){
        return tileIds.length;
    }


    public int getId(int i, int j) {
        if (i < 0 || i >= tileIds.length|| j < 0 || j >= tileIds[i].length) {
            //Log.e("TileMap", "Index out of bounds!");
            return 10; // Ou une autre valeur par défaut
        }
        return tileIds[i][j];
    }

    public Bitmap getBmp(int tileId) {
        return tiles.getTiles(tileId);
    }

    public abstract int updateRoom(int id);
}
