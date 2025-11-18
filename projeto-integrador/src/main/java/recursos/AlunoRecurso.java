package recursos;

import java.util.List;

import entidades.Aluno;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("alunos")
public class AlunoRecurso {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Aluno> listar() {
        return Aluno.listAll(Sort.ascending("nome"));
    }

    @POST
    @Transactional
    public void salvar(Aluno aluno){
        aluno.persist();
    }
}

