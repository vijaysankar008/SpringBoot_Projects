package com.seedjobs.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seedjobs.products.domain.ConsumerEntity;
@Repository
public interface ConsumerRepository extends JpaRepository<ConsumerEntity, String> {

}
