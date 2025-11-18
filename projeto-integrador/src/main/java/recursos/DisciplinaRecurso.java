package recursos;

import java.util.List;

import entidades.Disciplina;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("disciplinas")
public class DisciplinaRecurso {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Disciplina> listar() {
        return Disciplina.listAll(Sort.ascending("nome"));
    }

    @POST
    @Transactional
    public void salvar(Disciplina disciplina){
        disciplina.persist();
    }
}
