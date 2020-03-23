package com.example.coronapp;

import com.example.coronapp.entity.Humain;
import com.example.coronapp.enumeration.EtatDeSante;
import com.example.coronapp.utils.HunainUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class HumainUtilsTestAssertJ {

  @Test
  void changeEtatHumainEquals() {
    Humain malade = Humain.builder().dateAdmission(new Date()).etat(EtatDeSante.MALADE).build();
    Humain resultat = HunainUtils.changeEtatHumain(malade, EtatDeSante.SAIN);
    Humain resultatAttendu = Humain.builder().etat(EtatDeSante.SAIN).build();
    Assertions.assertThat(resultat).isEqualToComparingFieldByField(resultatAttendu);
    Assertions.assertThat(resultat.getDateAdmission()).isNull();


  }

  @Test
  void changeEtatHumainThrow() {

    Assertions.assertThatExceptionOfType(RuntimeException.class)
              .isThrownBy(() -> HunainUtils.changeEtatHumain(Humain.builder().etat(EtatDeSante.SAIN).build(), EtatDeSante.SAIN))
              .withMessage("L'etat est deja le même !");
  }
}
