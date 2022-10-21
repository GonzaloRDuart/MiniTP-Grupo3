package GenerarReporteTest;

import com.utn.frba.relacionamientopersonas.model.memoryRepos.RepositorioPersonas;
import com.utn.frba.relacionamientopersonas.model.persona.DataPersonas;
import com.utn.frba.relacionamientopersonas.model.persona.Persona;
import com.utn.frba.relacionamientopersonas.model.usuario.Usuario;
import com.utn.frba.relacionamientopersonas.model.usuario.UsuarioEstandar;
import com.utn.frba.relacionamientopersonas.service.utils.GenerarReporteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

public class GenerarReporteTest {

    @Test
    public void generarReportePersonasTest() throws Exception {
        Assertions.assertNotNull(GenerarReporteService.getInstance().generarReportePersonas());
    }

    @Test
    public void generarReporteDelegacionesTest() throws Exception {
        Persona personaPruebaSusa = new Persona("4223166", "Susana", "Molina", LocalDate.of(1980, 5, 18), "Berazategui", "Berazategui", "/futura/ruta1");
        Persona personaPruebaCoco = new Persona("4253215", "Coco", "Rallado", LocalDate.of(1995, 7, 12), "Avellaneda", "Sarandí", "/futura/ruta2");
        RepositorioPersonas.getInstance().addPersonas(personaPruebaCoco);
        RepositorioPersonas.getInstance().addPersonas(personaPruebaSusa);
        UsuarioEstandar userSusana = new UsuarioEstandar(personaPruebaSusa);
        UsuarioEstandar userCoco = new UsuarioEstandar(personaPruebaCoco);
        userSusana.enviarDelegacion(userCoco);
        userCoco.aceptarDelegacion(userCoco.getDelegaciones().get(0));
        userCoco.enviarDelegacion(userSusana);
        Assertions.assertNotNull(GenerarReporteService.getInstance().generarReporteDelegaciones());
    }

}
