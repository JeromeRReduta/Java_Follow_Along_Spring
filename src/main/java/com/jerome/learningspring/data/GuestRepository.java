package com.jerome.learningspring.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
public interface GuestRepository extends CrudRepository<Guest, Long> {
}
