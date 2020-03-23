package com.example.coronapp.service;

import com.example.coronapp.entity.Hopital;
import com.example.coronapp.entity.Humain;
import com.example.coronapp.enumeration.EtatDeSante;
import com.example.coronapp.enumeration.Pays;
import com.example.coronapp.repository.IHopitalRepo;
import com.example.coronapp.utils.HunainUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class HopitalService {

  private final IHopitalRepo hopitalRepo;

  /**
   * Ajouter un nouveau patient a l'hopital.
   * Si le patient n'est pas malade alors on throw une exception.
   *
   * @param patient patient devant
   * @param hopital hopital acceuillant le patient
   * @return l'hopital contenant le nouveau patient
   */
  public Hopital ajouterPatient(Humain patient, Hopital hopital) {

    if (patient.getEtat() != EtatDeSante.MALADE) {
      throw new RuntimeException("Le malade n'est pas malade");
    }

    if (hopital.getPatients() == null) {
      hopital.setPatients(new LinkedList<>());
    }

    hopital.getPatients().add(patient);

    hopitalRepo.save(hopital);

    return hopital;

  }

  public Hopital getHopitalByCountry(Pays pays) {
    return hopitalRepo.findFirstByPays(pays).orElseThrow(() -> new RuntimeException("Aucun pays pour le code donné !"));
  }

}
