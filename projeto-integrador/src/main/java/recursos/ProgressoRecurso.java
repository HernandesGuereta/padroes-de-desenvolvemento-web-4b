package recursos;

import java.util.List;

import entidades.Progresso;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("progressos")
public class ProgressoRecurso {

    @GET
    public List<Progresso> listar() {
        return Progresso.listAll(Sort.ascending("id"));
    }

    @POST
    @Transactional
    public void salvar(Progresso progresso){
        progresso.persist();
    }
}
