package com.example.coronapp;

import com.example.coronapp.entity.Humain;
import com.example.coronapp.enumeration.EtatDeSante;
import com.example.coronapp.utils.HunainUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class HumainUtilsTest {

  @Test
  void changeEtatHumainEquals() {
    Humain malade = Humain.builder().dateAdmission(new Date()).etat(EtatDeSante.MALADE).build();
    Humain resultat = HunainUtils.changeEtatHumain(malade, EtatDeSante.SAIN);

    assertEquals(resultat.getEtat(), EtatDeSante.SAIN);
    assertNull(resultat.getDateAdmission());

    assertThat(resultat.getDateAdmission()).isNull();
    Humain resultatAttendu = Humain.builder().etat(EtatDeSante.SAIN).build();
    assertThat(resultat).isEqualToComparingFieldByField(resultatAttendu);

  }

  @Test
  void changeEtatHumainThrow() {
    assertThrows(RuntimeException.class, () ->
        HunainUtils.changeEtatHumain(Humain.builder().etat(EtatDeSante.SAIN).build(), EtatDeSante.SAIN));
  }
}
