import java.util.Observable;
import java.util.Observer;

public class Pedido implements Observer {
    private int codigo;
    private String produto;
    private String statusPedido;

    public Pedido(int codigo ,String produto) {
        this.codigo = codigo;
        this.produto = produto;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void adicionarStatus(StatusPedido statusPedido) {
        statusPedido.addObserver(this);
    }

    @Override
    public void update(Observable statusPedido, Object arg1) {
        this.statusPedido = "O pedido " + this.codigo +" está na etapa de "+ statusPedido.toString();
    }
}