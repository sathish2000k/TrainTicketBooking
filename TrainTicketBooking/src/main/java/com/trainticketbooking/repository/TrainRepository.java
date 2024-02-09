package com.trainticketbooking.repository;

import org.springframework.stereotype.Repository;
import com.trainticketbooking.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface TrainRepository extends JpaRepository<Ticket, Long>{

}
