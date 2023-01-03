package com.app.mydoctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mydoctor.domain.Messages;


@Repository
public interface MessageRepository extends JpaRepository<Messages, Long> {

}
