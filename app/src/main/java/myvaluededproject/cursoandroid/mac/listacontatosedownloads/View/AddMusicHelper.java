package myvaluededproject.cursoandroid.mac.listacontatosedownloads.View;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.Model.Song;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.R;

class AddMusicHelper {
    private Song song;
    private EditText nameSong;
    private EditText urlSong;
    private ImageView imageSong;

    public AddMusicHelper(AddMusicActivity context) {
        nameSong = context.findViewById(R.id.addNameSong);
        urlSong = context.findViewById(R.id.addUrlSong);
        imageSong = context.findViewById(R.id.addImageSong);

        song = new Song();
    }

    public Song salvarSong() {
        song.setNome(nameSong.getText().toString());
        song.setUrlSong(urlSong.getText().toString());

        return song;
    }

    public ImageView getImageSong() {
        return imageSong;
    }

    public void carregaFoto(String caminhoFoto) {
        song.setFoto(caminhoFoto);

        Bitmap image = BitmapFactory.decodeFile(caminhoFoto);
        Bitmap imageMenor = Bitmap.createScaledBitmap(image, 64, 64, true);

        imageSong.setImageBitmap(imageMenor);
    }
}
