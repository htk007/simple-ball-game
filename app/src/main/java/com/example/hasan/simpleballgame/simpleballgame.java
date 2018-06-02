package com.example.hasan.simpleballgame;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class simpleballgame extends Activity {
    private GestureDetector gestureDetector;
    private BallGameView ballgameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ballgameView = (BallGameView) findViewById(R.id.BallGameView);

        gestureDetector = new GestureDetector(this, gestureListener);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

    }

    // when the app is pushed to the background, pause it
    @Override
    public void onPause() {
        super.onPause(); // call the super method
        ballgameView.stopGame(); // terminates the game
    } // end method onPause

    // release resources
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ballgameView.releaseResources();
    } // end method onDestroy


    // called when the user touches the screen in this Activity
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // get int representing the type of action which caused this event
        int action = event.getAction();
        // the user user touched the screen or dragged along the screen
        if (action == MotionEvent.ACTION_DOWN ||
                action == MotionEvent.ACTION_MOVE) {
            ballgameView.alignCannon(event);
            // align the cannon
        } // end if

// call the GestureDetector's onTouchEvent method
return gestureDetector.onTouchEvent(event);
    }

    // listens for touch events sent to the GestureDetector
     SimpleOnGestureListener gestureListener = new SimpleOnGestureListener()
    {
    // called when the user double taps the screen
     @Override
        public boolean onDoubleTap(MotionEvent e)
        {
            ballgameView.fireCannonball(e); // fire the cannonball
             return true; // the event was handled
        } // end method onDoubleTap
         }; // end gestureListener



}///end class simpleballgame
