package UPsay.decouverteAndroid.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.Arrays;

import UPsay.decouverteAndroid.Joystick;
import UPsay.decouverteAndroid.MainActivity;
import UPsay.decouverteAndroid.Player;

public class MapManager {
    private TileMap currentMap;
    //Initialize Camera
    private double x;
    private double y;
    //camera speed
    public static final double MAX_SPEED = 20;

    public MapManager(Context context) {
        //initialize Map
        int[][] ids = new int[50][50];

        // Remplir les bords avec les valeurs spécifiées
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (i == 0 && j == 0) {
                    ids[i][j] = TileMap.TOP_LEFT;
                } else if (i == 0 && j == 50 - 1) {
                    ids[i][j] = TileMap.TOP_RIGHT;
                } else if (i == 0) {
                    ids[i][j] = TileMap.TOP;
                } else if (i == 50 - 1 && j == 0) {
                    ids[i][j] = TileMap.BOTTOM_LEFT;
                } else if (i == 50 - 1 && j == 50 - 1) {
                    ids[i][j] = TileMap.BOTTOM_RIGHT;
                } else if (i == 50 - 1) {
                    ids[i][j] = TileMap.BOTTOM;
                } else if (j == 0) {
                    ids[i][j] = TileMap.LEFT;
                } else if (j == 50 - 1) {
                    ids[i][j] = TileMap.RIGHT;
                } else {
                    ids[i][j] = TileMap.CENTER;
                }
            }
        }
        currentMap = new TileMap(context,ids);
        x = -96*currentMap.getLength()/2.0+MainActivity.PHONE_WIDTH/2.0;
        y = -96*currentMap.getLength()/2.0+MainActivity.PHONE_HEIGHT/2.0;
    }
    public void draw(Canvas canvas){
        for (int i = 0; i < currentMap.getLength(); i++) {
            for (int j = 0; j < currentMap.getLength(); j++) {
                int tileId = currentMap.getId(i,j);
                Bitmap tile = currentMap.getBmp(tileId);

                // Dessiner la tile à la position (j * tileWidth, i * tileHeight) sur le canvas
                canvas.drawBitmap(tile, j * tile.getWidth()+(float)x, i * tile.getHeight()+(float)y, null);
            }
        }
    }

    public void update(Joystick joystick) {
        double valueX = joystick.getRadiusRateX();
        double valueY = joystick.getRadiusRateY();
        if(!joystick.getPressed()){
            return;
        }
        if(Math.abs(valueX)> Math.abs(valueY)){
            double moveX = joystick.getRadiusRateX()*MAX_SPEED/joystick.getRadius();
            if(canMoveTo(getPxlToIdx(x+moveX*-1,MainActivity.PHONE_WIDTH),getPxlToIdx(y,MainActivity.PHONE_HEIGHT)))
                x=x+moveX*-1;
        }else{
            double moveY = joystick.getRadiusRateY()*MAX_SPEED/joystick.getRadius();
            if(canMoveTo(getPxlToIdx(x,MainActivity.PHONE_WIDTH),getPxlToIdx(y+moveY*-1,MainActivity.PHONE_HEIGHT)))
                y=y+moveY*-1;
        }
    }
    public boolean canMoveTo(double _x, double _y){
        if(_x>49 || _y>49 || _x<0 || _y<0)return false;
        return !isIn(TileMap.boundTiles, currentMap.getId((int) _y , (int) _x ));
    }
    private boolean isIn(int[] key,int value){
        for (int j : key) {
            if (j == value)
                return true;
        }
        return false;
    }
    private double getPxlToIdx(double pxl,double phoneDim){
        return (pxl-phoneDim/2.0)/-96;
    }
}
