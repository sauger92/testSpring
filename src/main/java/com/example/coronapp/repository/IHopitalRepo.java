package com.example.coronapp.repository;

import com.example.coronapp.entity.Hopital;
import com.example.coronapp.enumeration.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IHopitalRepo extends JpaRepository<Hopital, Long> {

     Optional<Hopital> findFirstByVille(Ville ville);

}
