package co.edu.javeriana.as.jakarta.personapp.web.services;

import co.edu.javeriana.as.jakarta.personapp.ejb.beans.PersonaFacadeLocal;
import co.edu.javeriana.as.jakarta.personapp.ejb.beans.ProfesionFacadeLocal;
import co.edu.javeriana.as.jakarta.personapp.ejb.entities.Estudios;
import co.edu.javeriana.as.jakarta.personapp.ejb.entities.EstudiosPK;
import co.edu.javeriana.as.jakarta.personapp.ejb.entities.Persona;
import co.edu.javeriana.as.jakarta.personapp.ejb.entities.Profesion;
import co.edu.javeriana.as.jakarta.personapp.ejb.entities.Telefono;
import co.edu.javeriana.as.jakarta.personapp.web.dto.EstudiosDTO;
import co.edu.javeriana.as.jakarta.personapp.web.dto.PersonaDTO;
import co.edu.javeriana.as.jakarta.personapp.web.dto.ProfesionDTO;
import co.edu.javeriana.as.jakarta.personapp.web.dto.TelefonoDTO;

import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("personas")
@RequestScoped
public class PersonasResource {

    @Context
    private UriInfo context;

    @EJB
    private PersonaFacadeLocal personaFacadeLocal;

    @EJB
    private ProfesionFacadeLocal profesionFacadeLocal;

    public PersonasResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        try {
            List<Persona> personas = personaFacadeLocal.findAll();
            ArrayList<PersonaDTO> personaDTOs = new ArrayList<>();
            for (Persona persona : personas) {
                personaDTOs.add(personaToDTO(persona));
            }
            return Response.ok(new Gson().toJson(personaDTOs)).build();
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
            Persona persona = personaFacadeLocal.find(Integer.parseInt(id));
            return Response.ok(new Gson().toJson(personaToDTO(persona))).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/actualizar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPersona(PersonaDTO personaDTO) {
        try {
            Persona persona = dtoToPersona(personaDTO);
            personaFacadeLocal.create(persona);
            persona = personaFacadeLocal.find(personaDTO.getCc());
            return Response.ok(new Gson().toJson(personaToDTO(persona))).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.notModified().build();
        }
    }

    @PUT
    @Path("/actualizar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePersona(PersonaDTO personaDTO) {
        try {
            Persona persona = dtoToPersona(personaDTO);
            personaFacadeLocal.edit(persona);
            persona = personaFacadeLocal.find(personaDTO.getCc());
            return Response.ok(new Gson().toJson(personaToDTO(persona))).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.notModified().build();
        }
    }

    @DELETE
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePersona(@PathParam("id") String id) {
        try {
            Persona persona = personaFacadeLocal.find(Integer.parseInt(id));
            personaFacadeLocal.remove(persona);
            return Response.ok(new Gson().toJson(personaToDTO(persona))).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.notModified().build();
        }
    }

    private PersonaDTO personaToDTO(Persona persona) {
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setCc(persona.getCc());
        personaDTO.setNombre(persona.getNombre());
        personaDTO.setApellido(persona.getApellido());
        personaDTO.setEdad(persona.getEdad());
        personaDTO.setGenero(persona.getGenero());
        ArrayList<TelefonoDTO> telefonoDTOs = new ArrayList<>();
        for (Telefono telefono: persona.getTelefonoList()) {
            TelefonoDTO telefonoDTO = new TelefonoDTO();
            telefonoDTO.setNum(telefono.getNum());
            telefonoDTO.setOper(telefono.getOper());
            telefonoDTOs.add(telefonoDTO);
        }
        personaDTO.setTelefonoList(telefonoDTOs);
        ArrayList<EstudiosDTO> estudiosDTOs = new ArrayList<>();
        for (Estudios estudios: persona.getEstudiosList()) {
            EstudiosDTO estudiosDTO = new EstudiosDTO();
            estudiosDTO.setFecha(estudios.getFecha());
            estudiosDTO.setUniver(estudios.getUniver());
            ProfesionDTO profesionDTO = new ProfesionDTO();
            Profesion profesion = estudios.getProfesion();
            profesionDTO.setId(profesion.getId());
            profesionDTO.setDes(profesion.getDes());
            profesionDTO.setNom(profesion.getNom());
            estudiosDTO.setProfesion(profesionDTO);
            estudiosDTOs.add(estudiosDTO);
        }
        personaDTO.setEstudiosList(estudiosDTOs);
        return personaDTO;
    }

    private Persona dtoToPersona(PersonaDTO personaDTO) {
        Persona persona = new Persona();
        persona.setCc(personaDTO.getCc());
        persona.setNombre(personaDTO.getNombre());
        persona.setApellido(personaDTO.getApellido());
        persona.setEdad(personaDTO.getEdad());
        persona.setGenero(personaDTO.getGenero());
        ArrayList<Telefono> telefonos = new ArrayList<>();
        for (TelefonoDTO telefonoDTO : personaDTO.getTelefonoList()) {
            Telefono telefono = new Telefono();
            telefono.setNum(telefonoDTO.getNum());
            telefono.setOper(telefonoDTO.getOper());
            telefono.setDuenio(persona);
            telefonos.add(telefono);
        }
        persona.setTelefonoList(telefonos);
        ArrayList<Estudios> estudioss = new ArrayList<>();
        for (EstudiosDTO estudiosDTO : personaDTO.getEstudiosList()) {
            Estudios estudios = new Estudios();
            estudios.setFecha(estudiosDTO.getFecha());
            estudios.setUniver(estudiosDTO.getUniver());
            estudios.setPersona(persona);
            estudios.setProfesion(profesionFacadeLocal.find(estudiosDTO.getProfesion().getId()));
            estudios.setEstudiosPK(new EstudiosPK(estudios.getProfesion().getId(), persona.getCc()));
            estudioss.add(estudios);
        }
        persona.setEstudiosList(estudioss);
        return persona;
    }
}
