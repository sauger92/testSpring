package com.example.coronapp.service;

import com.example.coronapp.entity.Humain;
import com.example.coronapp.enumeration.EtatDeSante;
import com.example.coronapp.repository.IHumainRepo;
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


  private final HopitalService hopitalService;

  /**
   * Méthode simulant le non respet du confinement
   * Tout le mobde tombe malade
   *
   * @param humains n'ayant pas respecte le cnofinement (Ooh les vilains)
   */
  public void sortirHumain(List<Humain> humains) {
    humains.forEach(humain -> {
      humain.setEtat(EtatDeSante.MALADE);
      humainRepo.save(humain);
      hopitalService.ajouterPatient(humain, hopitalService.getHopitalByCountry(US));
    });

  }

  /**
   * Tous les humains decident de sortir de chez eux pendant le confinemet
   */
  public void springBreak() {
    sortirHumain(humainRepo.findAll().stream().filter(humain -> humain.getEtat().equals(EtatDeSante.SAIN)).collect(Collectors.toList()));
  }

}
