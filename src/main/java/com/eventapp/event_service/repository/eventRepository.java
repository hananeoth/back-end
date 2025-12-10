package com.eventapp.event_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eventapp.event_service.model.event;

public interface eventRepository extends JpaRepository<event, Long> {

}
