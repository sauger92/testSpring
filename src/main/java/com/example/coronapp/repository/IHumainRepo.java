package com.example.coronapp.repository;

import com.example.coronapp.entity.Hopital;
import com.example.coronapp.entity.Humain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IHumainRepo extends JpaRepository<Humain, Long> {


}
