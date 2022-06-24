import org.junit.jupiter.api.Test;

import java.io.PipedOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void deveNotificarPedidoEmSeparacao(){
        Pedido pedido = new Pedido(1,"tênis");
        StatusPedido statusPedido = new StatusPedido("Em separação", "23/06/2022 às 17:30");
        pedido.adicionarStatus(statusPedido);
        statusPedido.atualizarStatus();
       assertEquals("O pedido 1 está na etapa de Em separação\n" +
               "Data atualização: 23/06/2022 às 17:30", pedido.getStatusPedido());
    }

    @Test
    void deveNotificarPedidoEnviado(){
        Pedido pedido = new Pedido(1,"tênis");
        StatusPedido statusPedido = new StatusPedido("Em separação", "23/06/2022 às 17:30");
        pedido.adicionarStatus(statusPedido);
        StatusPedido statusPedido1 = new StatusPedido("Enviado", "24/06/2022 às 12:30");
        pedido.adicionarStatus(statusPedido1);
        statusPedido1.atualizarStatus();
        assertEquals("O pedido 1 está na etapa de Enviado\n" +
                "Data atualização: 24/06/2022 às 12:30", pedido.getStatusPedido());
    }

    @Test
    void naoDeveNotificarPedido(){
        Pedido pedido = new Pedido(1,"tênis");
        StatusPedido statusPedido = new StatusPedido("Em separação", "23/06/2022 às 17:30");
        statusPedido.atualizarStatus();
        assertEquals(null, pedido.getStatusPedido());
    }
}