import java.util.Observable;
        import java.util.Observer;

public class Seguidor implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Seguidor(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void ativarNotificacao(Perfil perfil) {
        perfil.addObserver(this);
    }

    public void update(Observable perfil, Object arg1) {
        this.ultimaNotificacao = this.nome + ", foi feita uma nova publicação no perfil " + perfil.toString() + "!" ;
    }
}
