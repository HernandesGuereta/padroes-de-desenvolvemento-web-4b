package recursos;

import java.util.List;

import entidades.Resumos;
import entidades.Turma;
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

@Path("turmas")
public class TurmaRecurso {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Turma> listar() {
        return Turma.listAll(Sort.ascending("nome"));
    }

    @POST
    @Transactional
    public void salvar(Turma turma){
        turma.persist();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void excluir (@PathParam("id")Integer id) {
        Turma turma= Turma.findById(id);

        if (turma != null) {
        turma.delete();
        }
    }

    @PUT
    @Transactional
    @Path("{id}")
    public void editar(@PathParam("id") Integer id, Turma turma) {
        Turma turmaExistente = Turma.findById(id);
        if (turmaExistente != null) {
            turmaExistente.nome = turma.nome;
        }
    }
}
