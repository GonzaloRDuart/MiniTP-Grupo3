package CargaPersonasTest;

import com.utn.frba.relacionamientopersonas.model.memoryRepos.RepositorioPersonas;
import com.utn.frba.relacionamientopersonas.model.persona.DataPersonas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

public class CargaPersonasTest {

    @Test
    public void cargaPersonas() throws Exception {
        DataPersonas.getInstance().crearPersona();
        RepositorioPersonas r = RepositorioPersonas.getInstance();
        Assertions.assertEquals(r.getPersonas().size(),2);
    }
}
