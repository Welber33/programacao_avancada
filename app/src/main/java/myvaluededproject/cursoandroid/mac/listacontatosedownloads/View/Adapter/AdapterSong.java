package myvaluededproject.cursoandroid.mac.listacontatosedownloads.View.Adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.Model.Song;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.R;

import java.util.List;

public class AdapterSong extends BaseAdapter {
    private List<Song> contatos;
    private Activity contexto;

    public AdapterSong(Activity contexto, List<Song> songs) {
        this.contatos = songs;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return this.contatos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.contatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.contatos.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Song song = contatos.get(position);

        LayoutInflater inflater = contexto.getLayoutInflater();
        View linha = inflater.inflate(R.layout.linha_song, null);

        ImageView imageSong = linha.findViewById(R.id.imageSong);
        TextView nameSong = linha.findViewById(R.id.nameSong);
        ImageButton checkStatus = linha.findViewById(R.id.checkStatus);

        nameSong.setText(song.getNome());

        if (song.getFoto() != null) {
            Bitmap image = BitmapFactory.decodeFile(song.getFoto());
            Bitmap imageMenor = Bitmap.createScaledBitmap(image, 64, 64, true);

            imageSong.setImageBitmap(imageMenor);
        }
        if (contexto.getExternalFilesDir(song.getMediaLocal()).exists()) {
            checkStatus.setImageResource(0);
            checkStatus.setBackgroundResource(0);
        }
        return linha;
    }
}
