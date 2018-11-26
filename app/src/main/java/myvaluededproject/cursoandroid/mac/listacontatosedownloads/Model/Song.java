package myvaluededproject.cursoandroid.mac.listacontatosedownloads.Model;

public class Song {
    private int id;
    private String nome;
    private String foto;
    private String mediaLocal;
    private String urlSong;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getMediaLocal() {
        return mediaLocal;
    }

    public void setMediaLocal(String mediaLocal) {
        this.mediaLocal = mediaLocal;
    }

    public String getUrlSong() {
        return urlSong;
    }

    public void setUrlSong(String urlSong) {
        this.urlSong = urlSong;
    }
}
