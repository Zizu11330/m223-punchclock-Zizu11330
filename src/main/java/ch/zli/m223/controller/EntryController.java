package ch.zli.m223.controller;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.dto.EntryDto;
import ch.zli.m223.model.Entry;
import ch.zli.m223.service.EntryService;

@Path("/entries")
@Tag(name = "Entries", description = "Handling of entries")
public class EntryController {

    @Inject
    EntryService entryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Entries.", description = "Returns a list of all entries.")
    public List<Entry> index() {
        return entryService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new entry.", description = "Creates a new entry and returns the newly added entry. Returns 400 if checkIn or checkOut is missing or checkIn is not before checkOut.")
    public Entry create(@Valid @NotNull EntryDto entryDto) {
        return entryService.createEntry(toEntity(entryDto));
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Updates an entry.", description = "Replaces checkIn and checkOut of an existing entry. Returns 400 if checkIn or checkOut is missing or checkIn is not before checkOut, and 404 if the entry does not exist.")
    public Entry update(@PathParam("id") Long id, @Valid @NotNull EntryDto entryDto) {
        return entryService.updateEntry(id, toEntity(entryDto));
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Deletes an entry.", description = "Deletes an existing entry. Returns 204 on success and 404 if the entry does not exist.")
    public void delete(@PathParam("id") Long id) {
        entryService.deleteEntry(id);
    }

    private Entry toEntity(EntryDto entryDto) {
        if (entryDto == null) {
            return null;
        }
        Entry entry = new Entry();
        entry.setCheckIn(entryDto.checkIn());
        entry.setCheckOut(entryDto.checkOut());
        return entry;
    }

}
