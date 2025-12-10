package com.eventapp.event_service.service;
import com.eventapp.event_service.model.event;
import com.eventapp.event_service.repository.eventRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class eventService {
    private final eventRepository repository;

    public eventService(eventRepository repository) {
        this.repository = repository;
    }

    public List<event> getAllEvents() {
        return repository.findAll();
    }

    public Optional<event> getEventById(Long id) {
        return repository.findById(id);
    }

    public event createEvent(event e) {
        return repository.save(e);
    }

    public event updateEvent(Long id, event updatedEvent) {
        return repository.findById(id).map(e -> {
            e.setName(updatedEvent.getName());
            e.setLocation(updatedEvent.getLocation());
            return repository.save(e);
        }).orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public void deleteEvent(Long id) {
        repository.deleteById(id);
    }

}
