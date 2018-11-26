package myvaluededproject.cursoandroid.mac.listacontatosedownloads.View.Adapter;
//made by John Welber

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.Model.Contato;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.R;

import java.util.List;

public class AdapterContato extends BaseAdapter{
    private List<Contato> contatos;
    private Activity contexto;

    public AdapterContato(Activity contexto, List<Contato> contatos) {
        this.contatos = contatos;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        Contato contato = contatos.get(position);

        LayoutInflater inflater = contexto.getLayoutInflater();
        View linha = inflater.inflate(R.layout.linha_contacts, null);

        TextView nome = linha.findViewById(R.id.nome_ID);
        TextView email = linha.findViewById(R.id.email_ID);
        ImageView foto = linha.findViewById(R.id.imagem_contato_ID);

        nome.setText(contato.getNome());
        email.setText(contato.getEmail());
        //imagem url Download
        if (contato.getMidiaLocal() != null) {
            Bitmap image = BitmapFactory.decodeFile(contato.getMidiaLocal());
            Bitmap imageMenor = Bitmap.createScaledBitmap(image, 64, 64, true);

            foto.setImageBitmap(imageMenor);
        }

        return linha;
    }
}
