package rest;

import com.google.gson.Gson;
import entities.Pet;
import entities.PetFacade;
import entities.messages.JSONMessage;
import entities.messages.PetMessage;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;

@Path("pets")
public class PetResource {

    Gson gson = new Gson();
    PetFacade pf = new PetFacade();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PetResource
     */
    public PetResource() {
    }

    /**
     * Retrieves representation of an instance of rest.PetResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPets() {
        ArrayList<JSONMessage> messages = new ArrayList<>();
        for (Pet se : pf.getAllPets()) {
            messages.add(new PetMessage(se));
        }

        return gson.toJson(messages);


    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getSpecificJson(@PathParam("id") Integer id) {

        Pet p = pf.getAllPets().get(id);
        return gson.toJson(p);

    }

    /**
     * PUT method for updating or creating an instance of PetResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject getCount() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("petCount", pf.petCount());
        return jsonObj;
    }

}
