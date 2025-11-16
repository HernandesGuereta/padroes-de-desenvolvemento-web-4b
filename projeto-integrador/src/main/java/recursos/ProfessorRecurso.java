package recursos;

import java.util.List;

import entidades.Professor;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("professores")
public class ProfessorRecurso {

    @GET
    public List<Professor> listar() {
        return Professor.listAll(Sort.ascending("nome"));
    }

    @POST
    @Transactional
    public void salvar(Professor professor) {
        professor.persist();
    }
}
