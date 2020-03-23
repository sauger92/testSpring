package com.example.coronapp;

import com.example.coronapp.entity.Hopital;
import com.example.coronapp.entity.Humain;
import com.example.coronapp.enumeration.EtatDeSante;
import com.example.coronapp.enumeration.Nom;
import com.example.coronapp.enumeration.Pays;
import com.example.coronapp.repository.IHopitalRepo;
import com.example.coronapp.repository.IHumainRepo;
import com.example.coronapp.service.HopitalService;
import com.example.coronapp.service.HumainService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static com.example.coronapp.enumeration.Pays.US;

@SpringBootTest
@Slf4j
public class HumainServiceTest {

  @Autowired
  private IHopitalRepo hopitalRepo;

  @Autowired
  private IHumainRepo humainRepo;

  @Autowired
  private HumainService humainService;

  @Autowired
  private HopitalService hopitalService;

  private Humain jacques;

  private Humain jacqueline;

  private Humain

  @BeforeEach
  void beforeEach() {
    jacques = Humain.builder().nom(Nom.JACQUES).etat(EtatDeSante.SAIN).build();
    jacqueline  = Humain.builder().nom(Nom.JACQUELINE).etat(EtatDeSante.MALADE).build();
    hopitalRepo.save(Hopital.builder()
                            .pays(Pays.US)
                            .build());

    humainRepo.saveAll(Arrays.asList(Humain.builder().nom(Nom.JACQUES).etat(EtatDeSante.SAIN).build(),
                                     Humain.builder().nom(Nom.JACQUELINE).etat(EtatDeSante.MALADE).build()));

  }

  @AfterEach
  void afterEach(){
    humainRepo.deleteAll();
    hopitalRepo.deleteAll();
  }
  @Test
  public void sortirHumain() {


  }
}
