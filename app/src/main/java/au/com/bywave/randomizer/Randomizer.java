package au.com.bywave.randomizer;

import android.util.Log;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Randomizer {
    private int mMin = 0;
    private int mMax = 100;
    private RandomListener mRandomListener;
    private int rotation = 0;
    private Random random;
    public boolean isRandomizing = false;


    public Randomizer() {
        random = new Random();
    }

    public interface RandomListener {
        void onChange(int value);

        void onComplete(int value);
    }

    public void start() {
        Log.v("Randomizer", "Randomizing");
        isRandomizing = true;
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (rotation < 100) {
                    if (mRandomListener != null) {
                        mRandomListener.onChange(random.nextInt(mMax - mMin + 1) + mMin);
                    }
                    rotation++;
                } else {
                    if (mRandomListener != null) {
                        mRandomListener.onComplete(random.nextInt(mMax - mMin + 1) + mMin);
                    }
                    timer.cancel();
                    rotation = 0;
                    isRandomizing = false;
                }
            }
        }, 0, 50);
    }

    public void setMin(int value) {
        mMin = value;
    }

    public void setMax(int value) {
        mMax = value;
    }

    public void setOnRandomListener(RandomListener randomListener) {
        mRandomListener = randomListener;
    }
}
