package recursos;

import java.util.List;

import entidades.Progresso;
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

@Path("progressos")
public class ProgressoRecurso {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Progresso> listar() {
        return Progresso.listAll(Sort.ascending("id"));
    }

    @POST
    @Transactional
    public void salvar(Progresso progresso){
        progresso.persist();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void excluir (@PathParam("id")Integer id) {
        Progresso progresso = Progresso.findById(id);

        if (progresso != null) {
        progresso.delete();
        }
    }

    @PUT 
    @Transactional
    @Path ("{id}")
    public void editar (@PathParam("id") Integer id, Progresso progresso){
        Progresso progressoExistente = Progresso.findById(id);
        if(progressoExistente != null){
            progressoExistente.aluno = progresso.aluno;
            progressoExistente.disciplina = progresso.disciplina;
        }
    }
}
