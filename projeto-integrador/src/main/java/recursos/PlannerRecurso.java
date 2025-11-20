package recursos;

import java.util.List;

import entidades.Planner;
import entidades.Resumos;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
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

    @DELETE
    @Path("{id}")
    @Transactional
    public void excluir (@PathParam("id")Integer id) {
        Planner planner = Planner.findById(id);

        if (planner != null) {
        planner.delete();
        }
    }

    @PUT
    @Transactional
    @Path("{id}")
    public void editar(@PathParam("id") Integer id, Planner planner) {
        Planner plannerExistente = Planner.findById(id);
        if (plannerExistente != null) {
            plannerExistente.agenda = planner.agenda;
            plannerExistente.aluno = planner.aluno;
            plannerExistente.prioridades = planner.prioridades;
            plannerExistente.tarefas = planner.tarefas;
        }
    }
}
