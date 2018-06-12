/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.messages;

import entities.Event;
import entities.EventFacade;
import entities.Owner;
import entities.Pet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author bladt
 */
public class PetMessage implements JSONMessage<Pet> {

    public Integer id;
    public String name;
    public Date birth;
    public String species;
    public Date death;
    public Owner ownerId;
    public List<Integer> eventIds;

    public PetMessage(Pet se) {
        this.name = se.getName();
        this.birth = se.getBirth();
        this.death = se.getDeath();
        this.species = se.getSpecies();

        //Get petsids as list.
        Stream<Event> eventEntities = se.getEventList().stream();
        Stream<Integer> eventIds = eventEntities.map(c -> c.id);
        this.eventIds = eventIds.collect(Collectors.toList());
    }

    @Override
    public Pet toInternal() {
        ArrayList<Event> events = new ArrayList<>();
        EventFacade ef = new EventFacade();
        eventIds.forEach((id) -> {
            events.add(ef.findEventById(id));
        });
        return new Pet(name, birth, species, death, id, ownerId, events);
    }

}
