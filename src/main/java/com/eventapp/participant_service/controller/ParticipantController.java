package com.eventapp.participant_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eventapp.participant_service.model.Participant;
import com.eventapp.participant_service.service.ParticipantService;

import java.util.List;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @GetMapping
    public List<Participant> getAllParticipants() {
        return participantService.getAllParticipants();
    }

    @GetMapping("/{id}")
    public Participant getParticipantById(@PathVariable Long id) {
        return participantService.getParticipantById(id)
                .orElseThrow(() -> new RuntimeException("Participant not found"));
    }

    @PostMapping
    public Participant createParticipant(@RequestBody Participant p) {
        return participantService.createParticipant(p);
    }

    @DeleteMapping("/{id}")
    public void deleteParticipant(@PathVariable Long id) {
        participantService.deleteParticipant(id);
    }
}

