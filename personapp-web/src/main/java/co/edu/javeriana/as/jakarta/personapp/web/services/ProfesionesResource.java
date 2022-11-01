package co.edu.javeriana.as.jakarta.personapp.web.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.google.gson.Gson;

import co.edu.javeriana.as.jakarta.personapp.ejb.beans.ProfesionFacadeLocal;
import co.edu.javeriana.as.jakarta.personapp.ejb.entities.Profesion;
import co.edu.javeriana.as.jakarta.personapp.web.dto.ProfesionDTO;

@Path("profesiones")
@RequestScoped
public class ProfesionesResource {
    @Context
    private UriInfo context;

    @EJB
    private ProfesionFacadeLocal profesionFacadeLocal;

    public ProfesionesResource() {

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        try {
            List<Profesion> profesiones = profesionFacadeLocal.findAll();
            ArrayList<ProfesionDTO> profesionDTOs = new ArrayList<>();
            for (Profesion profesion : profesiones) {
                profesionDTOs.add(profesionToDTO(profesion));
            }
            return Response.ok(new Gson().toJson(profesionDTOs)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getId(@PathParam("id") String id) {
        try {
            Profesion profesion = profesionFacadeLocal.find(Integer.parseInt(id));
            return Response.ok(new Gson().toJson(profesionToDTO(profesion))).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
      

    @POST
    @Path("/actualizar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProfesion(ProfesionDTO profesionDTO) {
        try {
            profesionFacadeLocal.create(dtoToProfesion(profesionDTO));
            profesionDTO = profesionToDTO(profesionFacadeLocal.find(profesionDTO.getId()));
            return Response.ok(new Gson().toJson(profesionDTO)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/actualizar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProfesion(ProfesionDTO profesionDTO) {
        try {
            Profesion profesion = dtoToProfesion(profesionDTO);
            profesion.setEstudiosList(profesionFacadeLocal.find(profesionDTO.getId()).getEstudiosList());
            profesionFacadeLocal.edit(profesion);
            profesionDTO = profesionToDTO(profesionFacadeLocal.find(profesionDTO.getId()));
            return Response.ok(new Gson().toJson(profesionDTO)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.notModified().build();
        }
    }

    @DELETE
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteProfesion(@PathParam("id") String id) {
        try {
            Profesion profesion = profesionFacadeLocal.find(Integer.parseInt(id));
            profesionFacadeLocal.remove(profesion);
            return Response.ok(new Gson().toJson(profesionToDTO(profesion))).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.notModified().build();
        }
    }

    static public Profesion dtoToProfesion(ProfesionDTO profesionDTO) {
        Profesion profesion = new Profesion();
        profesion.setDes(profesionDTO.getDes());
        profesion.setId(profesionDTO.getId());
        profesion.setNom(profesionDTO.getNom());
        profesion.setEstudiosList(new ArrayList<>());
        return profesion;
    }

    static public ProfesionDTO profesionToDTO(Profesion profesion) {
        ProfesionDTO profesionDTO = new ProfesionDTO();
        profesionDTO.setId(profesion.getId());
        profesionDTO.setDes(profesion.getDes());
        profesionDTO.setNom(profesion.getNom());
        return profesionDTO;
    }
}
