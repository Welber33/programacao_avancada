package myvaluededproject.cursoandroid.mac.listacontatosedownloads;
//made by John Welber
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterContato extends BaseAdapter{
    private List<Contato> contato;
    private Activity contexto;

    public AdapterContato(Activity contexto, List<Contato> contato) {
        this.contato = contato;
        this.contexto = contexto;
    }
    @Override
    public int getCount() {
        return this.contato.size();
    }

    @Override
    public Object getItem(int position) {
        return this.contato.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.contato.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contato contato1 = contato.get(position);

        LayoutInflater inflater = contexto.getLayoutInflater();
        View linha = inflater.inflate(R.layout.linha,null);

        TextView nome = linha.findViewById(R.id.nome_ID);
        TextView email = linha.findViewById(R.id.email_ID);
        ImageView imagem = linha.findViewById(R.id.imagem_contato_ID);

        nome.setText(contato1.getNome());
        email.setText(contato1.getEmail());
        //imagem url Download

        return linha;
    }
}
