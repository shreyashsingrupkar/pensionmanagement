package com.pensioner.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pensioner.entity.Pensioner;
@Repository
public interface PensionerRepo extends JpaRepository<Pensioner, Long> {

}