package recursos;

import java.util.List;

import entidades.Aluno;
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

@Path("resumos")
public class ResumoRecurso {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Resumos> listar() {
        return Resumos.listAll(Sort.ascending("nome"));
    }

    @POST
    @Transactional
    public void salvar(Resumos resumo){
        resumo.persist();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void excluir (@PathParam("id")Integer id) {
        Resumos resumos = Resumos.findById(id);

        if (resumos != null) {
        resumos.delete();
        }
    }

    @PUT 
    @Transactional
    @Path ("{id}")
    public void editar (@PathParam("id") Integer id, Resumos resumos){
        Resumos resumosExistente = Resumos.findById(id);
        if(resumosExistente != null){
            resumosExistente.aluno = resumos.aluno;
            resumosExistente.nome = resumos.nome;
        }   
    }
}
