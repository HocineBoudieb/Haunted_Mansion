package UPsay.decouverteAndroid.map;

import android.content.Context;
import android.service.quicksettings.Tile;

import UPsay.decouverteAndroid.MainActivity;

public class Map2 extends TileMap{
    private static final int[][] ids = {
            {TileMap.TOP_LEFT,TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP,TileMap.RIGHT, TileMap.TOP,TileMap.TOP_RIGHT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.RIGHT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.LEFT},
            {TileMap.LEFT,TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.BOTTOM,TileMap.RIGHT, TileMap.BOTTOM,TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.LEFT},
            {TileMap.LEFT,TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER,TileMap.CENTER, TileMap.BOTTOM,TileMap.LEFT},
            {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT, TileMap.LEFT},
            {TileMap.BOTTOM_LEFT,TileMap.LEFT, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM,TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM,TileMap.RIGHT, TileMap.BOTTOM,TileMap.BOTTOM_RIGHT}};

    public Map2(Context context) {
        super(context, -96*ids.length/2.0+ MainActivity.PHONE_WIDTH/2.0, ids[0].length);
        setTileIds(ids);
    }

    @Override
    public int updateRoom() {
        return 1;
    }
}
