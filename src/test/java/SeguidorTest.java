import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeguidorTest {

    @Test
    void deveNotificarUmSeguidor(){
        Perfil perfil = new Perfil("Jose");
        Seguidor seguidor = new Seguidor("Maria");
        seguidor.ativarNotificacao(perfil);
        perfil.postar();
        assertEquals("Maria, foi feita uma nova publicação no perfil Jose!", seguidor.getUltimaNotificacao());
    }

    @Test
    void deveNotificarSeguidores(){
        Perfil perfil = new Perfil("Jose");
        Seguidor seguidor = new Seguidor("Maria");
        Seguidor seguidor1 = new Seguidor("João");
        seguidor.ativarNotificacao(perfil);
        seguidor1.ativarNotificacao(perfil);
        perfil.postar();
        assertEquals("Maria, foi feita uma nova publicação no perfil Jose!", seguidor.getUltimaNotificacao());
        assertEquals("João, foi feita uma nova publicação no perfil Jose!", seguidor1.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarSeguidor(){
        Perfil perfil = new Perfil("Jose");
        Seguidor seguidor = new Seguidor("Maria");
        perfil.postar();
        assertEquals(null, seguidor.getUltimaNotificacao());
    }

    @Test
    void deveNotificarSeguidorPerfilJose(){
        Perfil perfil = new Perfil("Jose");
        Perfil perfil1 = new Perfil("Silva");
        Seguidor seguidor = new Seguidor("Maria");
        Seguidor seguidor1 = new Seguidor("João");
        seguidor.ativarNotificacao(perfil);
        seguidor1.ativarNotificacao(perfil1);
        perfil.postar();
        assertEquals("Maria, foi feita uma nova publicação no perfil Jose!", seguidor.getUltimaNotificacao());
        assertEquals(null, seguidor1.getUltimaNotificacao());
    }

}