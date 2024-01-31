package UPsay.decouverteAndroid.map;

import android.content.Context;

import UPsay.decouverteAndroid.MainActivity;

public class Map1 extends TileMap{
    private static final int[][] ids = {
            {TileMap.TOP,TileMap.LEFT, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP,TileMap.RIGHT, TileMap.TOP,TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.LEFT},
            {TileMap.LEFT,TileMap.BOTTOM, TileMap.CENTER, TileMap.CENTER, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.CENTER, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.LEFT},
            {TileMap.LEFT,TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.CENTER, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.LEFT},
            {TileMap.BOTTOM_LEFT,TileMap.LEFT, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, 10, 10, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM,TileMap.BOTTOM_LEFT}};

    public Map1(Context context) {
        super(context, -96*ids.length/2.0+ MainActivity.PHONE_WIDTH/2.0, ids[0].length,1);
        setTileIds(ids);
    }

    @Override
    public int updateRoom(int id) {
        return 2;
    }
}
