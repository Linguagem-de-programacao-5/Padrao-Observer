import java.util.Observable;

public class StatusPedido extends Observable {
    private String status;
    private String dataAtualizacao;

    public StatusPedido(String status, String dataAtualizacao) {
        this.status = status;
        this.dataAtualizacao = dataAtualizacao;
    }

    public void atualizarStatus(){
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return   status + "\nData atualização: " + dataAtualizacao;
    }
}
