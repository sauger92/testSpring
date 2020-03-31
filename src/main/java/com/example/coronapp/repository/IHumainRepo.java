package com.example.coronapp.repository;

import com.example.coronapp.entity.Hopital;
import com.example.coronapp.entity.Humain;
import com.example.coronapp.enumeration.EtatDeSante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IHumainRepo extends JpaRepository<Humain, Long> {

    List<Humain> findAllByEtat(EtatDeSante etatDeSante);


}
