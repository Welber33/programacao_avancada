package myvaluededproject.cursoandroid.mac.listacontatosedownloads.Model;

//made by John Welber
public class Contato {
    private int id;
    private String nome;
    private String email;
    private String urlImagem;
    private String midiaLocal;

    public Contato(String nome, String email, String urlImagem, String midiaLocal) {
        this.nome = nome;
        this.email = email;
        this.urlImagem = urlImagem;
        this.midiaLocal = midiaLocal;
    }

    public Contato() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getMidiaLocal() {
        return midiaLocal;
    }

    public void setMidiaLocal(String midiaLocal) {
        this.midiaLocal = midiaLocal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
