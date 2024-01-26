package UPsay.decouverteAndroid.map;

import android.content.Context;

public class Map1 extends TileMap{
    private static final int[][] ids = {
            {TileMap.TOP,TileMap.LEFT, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP,TileMap.RIGHT, TileMap.TOP,TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.LEFT},
            {TileMap.LEFT,TileMap.BOTTOM, TileMap.CENTER, TileMap.CENTER, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM,TileMap.RIGHT, TileMap.BOTTOM,TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.LEFT},
            {TileMap.LEFT,TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM,TileMap.RIGHT, TileMap.BOTTOM,TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.LEFT},
            {TileMap.BOTTOM_LEFT,TileMap.LEFT, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, 10, 10, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM,TileMap.RIGHT, TileMap.BOTTOM,TileMap.LEFT}};

    public Map1(Context context) {
        super(context);
        setTileIds(ids);
    }

    @Override
    public int updateRoom() {
        return 0;
    }
}
