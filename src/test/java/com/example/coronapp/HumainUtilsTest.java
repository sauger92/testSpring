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
    Humain malade = Humain.builder().dateDebutMaladie(new Date()).etat(EtatDeSante.MALADE).build();
    Humain resultat = HunainUtils.changeEtatDeSanteHumain(malade, EtatDeSante.SAIN);
    assertEquals(EtatDeSante.SAIN, resultat.getEtat() );
    assertNull(resultat.getDateDebutMaladie());

  }

  @Test
  void changeEtatHumainThrow() {
    assertThrows(RuntimeException.class, () ->
        HunainUtils.changeEtatDeSanteHumain(Humain.builder().etat(EtatDeSante.SAIN).build(), EtatDeSante.SAIN));
  }
}
