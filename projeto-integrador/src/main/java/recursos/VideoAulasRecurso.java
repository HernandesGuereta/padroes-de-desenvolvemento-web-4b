package recursos;

import java.util.List;

import entidades.VideoAulas;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("videoaulas")
public class VideoAulasRecurso {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<VideoAulas> listar() {
        return VideoAulas.listAll(Sort.ascending("titulo"));
    }

    @POST
    @Transactional
    public void salvar(VideoAulas videoaulas) {
        videoaulas.persist();
    }
}
