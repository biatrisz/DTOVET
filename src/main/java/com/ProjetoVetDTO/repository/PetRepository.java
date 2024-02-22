package com.ProjetoVetDTO.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoVetDTO.entities.Pet;

public interface PetRepository extends JpaRepository <Pet, Long>{

}
