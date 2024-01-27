package UPsay.decouverteAndroid.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;

import java.util.Arrays;
import java.util.Map;

import UPsay.decouverteAndroid.Joystick;
import UPsay.decouverteAndroid.MainActivity;
import UPsay.decouverteAndroid.Player;

public class MapManager {
    //Initialize Maps
    private TileMap currentMap;
    private Map1 map1;
    private Map2 map2;
    //Initialize Camera
    private double x;
    private double y;
    //camera speed
    public static final double MAX_SPEED = 20;

    public MapManager(Context context) {
        //initialize Map
        map1 = new Map1(context);
        map2 = new Map2(context);
        currentMap = map1;
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
        int tileId =currentMap.getId((int)getPxlToIdx(y,MainActivity.PHONE_HEIGHT),(int)getPxlToIdx(x,MainActivity.PHONE_WIDTH));
        //Log.d("TILE","tile n "+tileId);
        if(tileId==10){
            changeToRoom(currentMap.updateRoom());
        }
    }

    private void changeToRoom(int i) {
        switch (i){
            case 1:
                currentMap = map1;
                break;
            case 2:
                currentMap = map2;
                break;
            default:
                currentMap = map1;
        }
        x = currentMap.startX;
        y = currentMap.startY;
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
