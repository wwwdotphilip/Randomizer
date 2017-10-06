package au.com.bywave.randomizer;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import static au.com.bywave.randomizer.R.raw.randomize;

public class MainActivity extends AppCompatActivity {
    private Randomizer mRandomizer;
    private TextView result;
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.tvResult);

        mRandomizer = new Randomizer();

        mRandomizer.setOnRandomListener(new Randomizer.RandomListener() {
            @Override
            public void onChange(int value) {
                final String parsedVal = value + "";
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        result.setText(parsedVal);
                    }
                });
            }

            @Override
            public void onComplete(int value) {
                final String parsedVal = value + "";
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        result.setText(parsedVal);
                        mMediaPlayer.stop();
                        mMediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.bell);
                        mMediaPlayer.start();
                        result.setClickable(true);
                    }
                });
            }
        });

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mRandomizer.isRandomizing) {
                    randomize();
                }
            }
        });

        result.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (!mRandomizer.isRandomizing) {
                    setRange();
                }
                return false;
            }
        });
    }

    public void randomize() {
        mRandomizer.start();
        mMediaPlayer = MediaPlayer.create(MainActivity.this, randomize);
        mMediaPlayer.start();
    }

    public void setRange() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Set Range");

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setGravity(Gravity.CENTER);

        final EditText start = new EditText(this);
        start.setInputType(InputType.TYPE_CLASS_NUMBER);
        start.setHint("Start");
        layout.addView(start);

        LinearLayout.LayoutParams startParams = (LinearLayout.LayoutParams) start.getLayoutParams();
        startParams.setMargins(10, 10, 10, 10);
        start.setLayoutParams(startParams);

        final EditText end = new EditText(this);
        end.setInputType(InputType.TYPE_CLASS_NUMBER);
        end.setHint("End");
        layout.addView(end);

        LinearLayout.LayoutParams endParams = (LinearLayout.LayoutParams) start.getLayoutParams();
        endParams.setMargins(10, 10, 10, 10);
        end.setLayoutParams(endParams);

        builder.setView(layout);

        builder.setPositiveButton("Set", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mRandomizer.setMin(Integer.parseInt(start.getText().toString()));
                mRandomizer.setMax(Integer.parseInt(end.getText().toString()));
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }
}
