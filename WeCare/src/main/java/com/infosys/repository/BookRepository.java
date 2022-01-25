package com.infosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.entity.BookingEntity;

public interface BookRepository extends JpaRepository<BookingEntity, Integer>{


}
