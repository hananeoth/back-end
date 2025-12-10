package com.eventapp.participant_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventapp.participant_service.model.Participant;
import com.eventapp.participant_service.repository.ParticipantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    public Optional<Participant> getParticipantById(Long id) {
        return participantRepository.findById(id);
    }

    public Participant createParticipant(Participant p) {
        return participantRepository.save(p);
    }

    public void deleteParticipant(Long id) {
        participantRepository.deleteById(id);
    }
}
