package com.mydoctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mydoctor.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
