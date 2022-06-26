import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Perfil extends Observable{
    private String nome;
    private String bio;
    private List<Seguidor> segudires = new ArrayList();
    private List<Seguidor> seguindo = new ArrayList();
    private List<String> publicacoes = new ArrayList();

    public Perfil(String nome) {
        this.nome = nome;
    }

    public void postar() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return nome;
    }
}
