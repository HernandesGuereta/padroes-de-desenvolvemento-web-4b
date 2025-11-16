package recursos;

import java.util.List;

import entidades.Planner;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("planners")
public class PlannerRecurso {

    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public List<Planner> listar() {
        return Planner.listAll(Sort.ascending("agenda"));
    }

    @POST
    @Transactional
    public void salvar(Planner planner){
        planner.persist();
    }
}
