package com.eventapp.participant_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eventapp.participant_service.model.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}

