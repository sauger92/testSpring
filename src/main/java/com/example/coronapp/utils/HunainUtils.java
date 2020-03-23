package com.example.coronapp.utils;

import com.example.coronapp.entity.Humain;
import com.example.coronapp.enumeration.EtatDeSante;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Utils de gestion des objets Humain
 */
@Slf4j
public class HunainUtils {
  private HunainUtils() {
  }

  /**
   * Infecte ou guéri  un humain
   *
   * @param humain pour qui l'Etat de santé doit être modifié
   * @return l'humain update
   */
  public static Humain changeEtatHumain(Humain humain, EtatDeSante etatDeSante) {
    if (humain.getEtat().equals(etatDeSante)) {
      throw new RuntimeException("L'etat est deja le même !");
    }
    humain.setEtat(etatDeSante);
    humain.setDateAdmission(etatDeSante.equals(EtatDeSante.MALADE) ? new Date() : null);

    log.info("{} est {}", humain.getNom(), etatDeSante.name().toLowerCase());
    return humain;
  }


}
