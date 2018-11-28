package myvaluededproject.cursoandroid.mac.listacontatosedownloads.View;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.R;

public class PlayerVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_video);
        String extra = getIntent().getStringExtra("video");
        VideoView video = findViewById(R.id.videoView);

        video.setVideoURI(Uri.parse(extra));
        video.start();

        MediaController controller = new MediaController(this);
        controller.setMediaPlayer(video);
        controller.show(10);

        video.setMediaController(controller);
    }
}
