# Haunted Mansion

Welcome to Haunted Mansion, a thrilling Java Android game set in a mysterious mansion filled with puzzles and challenges. Explore multiple rooms, solve puzzles, and find your way out before it's too late!

## Gameplay Overview

- **2D Experience**: Immerse yourself in a 2D environment with intricate tilemaps, creating an eerie atmosphere within the haunted mansion.

- **Multiple Rooms**: Traverse through various rooms within the mansion, each presenting its own set of obstacles and secrets.

- **Dynamic Joystick**: Navigate your character using a dynamic joystick for fluid and intuitive movement controls.

- **Room Transitions**: Move seamlessly between rooms by walking through doors, unlocking new areas to explore.

- **Obstacle Challenges**: Encounter obstacles blocking your path. Use your problem-solving skills to overcome these challenges and progress further.

- **Exit Discovery**: Discover the exit hidden within the mansion to successfully escape. Beware of getting trapped, as it could result in failure!

- **Animated Hero**: Watch your character come to life with animated movements, enhancing the immersion of your journey through the mansion.

## How to Play

1. **Setup**: Clone or download the project files to your local machine and open the project in Android Studio.

2. **Build and Run**: Build the project in Android Studio and run it on an Android emulator or a physical device.

3. **Navigation**: Control your character's movements using the dynamic joystick. Explore different rooms by entering doors.

4. **Solve Puzzles**: Encounter puzzles and obstacles throughout the mansion. Use your skills to solve them and advance further.

5. **Find the Exit**: Locate the exit to successfully escape the haunted mansion. Avoid getting blocked, as it could result in failure.

6. **Enjoy**: Immerse yourself in the haunting atmosphere of the mansion and enjoy the adventure!

## Game Loop Implementation

```java
package UPsay.decouverteAndroid;

import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.view.SurfaceHolder;

public class GameLoop extends Thread {
    private double count;
    private static final double MAX_UPS = 30.0;
    private boolean isRunning = false;
    private SurfaceHolder surfaceHolder;
    private Mansion mansion;

    // Audio Player
    MediaPlayer mediaPlayer;

    public GameLoop(Mansion mansion, SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        this.mansion = mansion;
    }

    public void startLoop() {
        count = 0;
        isRunning = true;
        start();
        mediaPlayer = MediaPlayer.create(mansion.getContext(), R.raw.loop);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    @Override
    public void run() {
        super.run();

        // Count variable
        int updateCount = 0;
        long startTime;
        long elapsedTime;
        long sleepTime;

        startTime = System.currentTimeMillis();

        Canvas canvas;
        // Game Loop
        while (isRunning) {
            if (mansion.getGameState() == Mansion.GameState.GAME_OVER) isRunning = false;
            count += 1.0 / 30.0;
            canvas = surfaceHolder.lockCanvas();

            mansion.update();
            mansion.draw(canvas);

            surfaceHolder.unlockCanvasAndPost(canvas);
            updateCount++;
            elapsedTime = System.currentTimeMillis() - startTime;
            // Get the difference between theoretical time per update and elapsed time
            sleepTime = (long) (updateCount * (1E+3 / MAX_UPS)/* to convert UPS to updates per millisecond */ - elapsedTime);
            // If this difference is positive, we have to wait a bit to not refresh too early
            if (sleepTime > 0) {
                try {
                    sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        mediaPlayer.stop();
        mansion.gameOver();
        count = 0;
    }

    public void stopLoop() {
        interrupt();
    }

    public double getCount() {
        return count;
    }
}
