package com.example.coronapp.service;

import com.example.coronapp.entity.Hopital;
import com.example.coronapp.entity.Humain;
import com.example.coronapp.enumeration.EtatDeSante;
import com.example.coronapp.enumeration.Ville;
import com.example.coronapp.repository.IHopitalRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class HopitalService {

    private final IHopitalRepo hopitalRepo;

    private final HumainService humainService;

    public List<Humain> soignerTousLesPatients(Hopital hopital) {

        hopital.getPatients().forEach(patient -> humainService.changerEtatDeSanteUnePersonne(patient, EtatDeSante.SAIN));

        List<Humain> patientsGueris = hopital.getPatients();

        hopital.setPatients(new ArrayList<>());

        hopitalRepo.save(hopital);

        return patientsGueris;
    }

    public boolean checkIfOneHospitalExistByVille(Ville ville) {
        Optional<Hopital> hopital = hopitalRepo.findFirstByVille(ville);
        return hopital.isPresent();
    }

    public List<Humain> getPatientsInHospital(Hopital hopital) {
        return humainService.getHumainStream(hopital.getPatients()).collect(Collectors.toList());
    }

}
