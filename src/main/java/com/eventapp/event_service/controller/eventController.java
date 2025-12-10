package com.eventapp.event_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eventapp.event_service.model.event;
import com.eventapp.event_service.service.eventService;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class eventController {

    @Autowired
    private eventService eventService;

    @GetMapping
    public List<event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
public event getEventById(@PathVariable Long id) {
    return eventService.getEventById(id)
    .orElseThrow(() -> new RuntimeException("Event not found"));
}


    @PostMapping
    public event createEvent(@RequestBody event e) {
        return eventService.createEvent(e);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }
}
