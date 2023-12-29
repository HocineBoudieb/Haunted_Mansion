package UPsay.decouverteAndroid.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.service.quicksettings.Tile;

public class TileMap {
    private int[][] tileIds;
    private TileSet tiles;
    public TileMap(Context context,int[][] tileIds) {
        this.tileIds = tileIds;
        tiles = new TileSet(context);
    }
    public void draw(Canvas canvas){
        for (int i = 0; i < tileIds.length; i++) {
            for (int j = 0; j < tileIds[i].length; j++) {
                int tileId = tileIds[i][j];
                Bitmap tile = tiles.getTiles(tileId);

                // Dessiner la tile à la position (j * tileWidth, i * tileHeight) sur le canvas
                canvas.drawBitmap(tile, j * tile.getWidth(), i * tile.getHeight(), null);
            }
        }
    }


}
