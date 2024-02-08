package UPsay.decouverteAndroid.map;

import android.content.Context;
import android.media.MediaPlayer;
import android.service.quicksettings.Tile;

import UPsay.decouverteAndroid.MainActivity;
import UPsay.decouverteAndroid.R;

public class Map4 extends TileMap{
    private static final int[][] ids =
            {
                    {TileMap.TOP_LEFT,TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, 21, 21, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP, TileMap.TOP,TileMap.TOP, TileMap.TOP_RIGHT},
                    {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT},
                    {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT},
                    {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT},
                    {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT},
                    {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT},
                    {TileMap.LEFT,TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT},
                    {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT},
                    {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT},
                    {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT},
                    {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT},
                    {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT},
                    {TileMap.LEFT,TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT},
                    {TileMap.LEFT, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.CENTER, TileMap.RIGHT},
                    {TileMap.BOTTOM_LEFT,TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, 10, 10, TileMap.BOTTOM, TileMap.BOTTOM, TileMap.BOTTOM, 274, 274, TileMap.BOTTOM,TileMap.BOTTOM_RIGHT}
            };
    public Map4(Context context) {
        super(context, -96*ids.length/2.0+ MainActivity.PHONE_WIDTH/2.0, -96*ids[0].length/2.0+ MainActivity.PHONE_HEIGHT/2.0,3);
        setTileIds(ids);
    }

    @Override
    public int updateRoom(int id) {
        switch (id)
        {
            case 10:
                return 3;
            case 21:
                return 2;
            case 274:
                return 5;

        }
        return 3;
    }
}
