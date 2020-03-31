package com.example.coronapp.service;

import com.example.coronapp.entity.Humain;
import com.example.coronapp.enumeration.EtatDeSante;
import com.example.coronapp.enumeration.Nom;
import com.example.coronapp.repository.IHumainRepo;
import com.example.coronapp.utils.HunainUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.coronapp.enumeration.Pays.US;

@Service
@RequiredArgsConstructor
@Slf4j
public class HumainService {

  private final IHumainRepo humainRepo;


  public List<Humain> soignerToutLeMonde(){

    return null;
  }














  /* public List<Humain> soignerToutLeMonde(){
     List<Humain> humains = humainRepo.findAll();

    List<Humain> malades = humains
            .stream()
            .filter(humain -> humain.getEtat().equals(EtatDeSante.MALADE))
            .collect(Collectors.toList());

    malades.forEach(humain ->HunainUtils.changeEtatDeSanteHumain(humain, EtatDeSante.SAIN));

    return humainRepo.saveAll(malades);

}*/

















  public List<Humain> changeEtatToutLeMpnde(EtatDeSante etatDeSante) {

    List<Humain> malades = humainRepo.findAllByEtat(etatDeSante.equals(EtatDeSante.SAIN) ? EtatDeSante.MALADE : EtatDeSante.SAIN );

    malades.forEach(humain -> HunainUtils.changeEtatDeSanteHumain(humain, EtatDeSante.SAIN));

    return humainRepo.saveAll(malades);
  }



}
