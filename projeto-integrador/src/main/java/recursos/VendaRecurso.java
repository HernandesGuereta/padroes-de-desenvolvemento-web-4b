package recursos;

import java.util.List;

import entidades.Venda;
import io.quarkus.panache.common.Sort;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("vendas")
public class VendaRecurso {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Venda> listar() {
        return Venda.listAll(Sort.ascending("horario"));
    }
}