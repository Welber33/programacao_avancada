package myvaluededproject.cursoandroid.mac.listacontatosedownloads.View;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.Model.Contato;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.R;

class AddContactsHelper {
    private Contato contato;
    private EditText nome;
    private EditText email;
    private ImageView foto;

    public AddContactsHelper(AddContactsActivity context) {
        nome = context.findViewById(R.id.nomeContato);
        email = context.findViewById(R.id.emailContato);
        foto = context.findViewById(R.id.fotoContato);

        contato = new Contato();
    }

    public Contato salvarContato() {
        contato.setNome(nome.getText().toString());
        contato.setEmail(email.getText().toString());

        return contato;
    }

    public void carregaContato(Contato contato) {
        this.contato = contato;
        nome.setText(contato.getNome());
        email.setText(contato.getEmail());

        if (contato.getMidiaLocal() != null) {
            carregaFoto(contato.getMidiaLocal());
        }
    }

    public ImageView getFoto() {
        return foto;
    }

    public void carregaFoto(String caminhoFoto) {
        contato.setMidiaLocal(caminhoFoto);

        Bitmap image = BitmapFactory.decodeFile(caminhoFoto);
        Bitmap imageMenor = Bitmap.createScaledBitmap(image, 64, 64, true);

        foto.setImageBitmap(imageMenor);
    }
}
