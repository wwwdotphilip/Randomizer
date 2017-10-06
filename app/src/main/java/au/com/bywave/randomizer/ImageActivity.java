package au.com.bywave.randomizer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class ImageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        ImageView photo = (ImageView) findViewById(R.id.ivPhoto);
        new DownloadImageTask(photo).execute("https://image.prntscr.com/image/1b41Jpt-QFSOFGxfdLGesw.jpg");
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public DownloadImageTask(ImageView imageView) {
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String url = strings[0];
            Bitmap bitmap = null;
            try {
                InputStream in = new URL(url).openStream();
                bitmap = BitmapFactory.decodeStream(in);
            } catch (Exception e){

            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (bitmap != null){
                imageView.setImageBitmap(bitmap);
            }
        }
    }
}
