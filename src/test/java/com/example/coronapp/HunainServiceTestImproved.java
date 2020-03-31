package com.example.coronapp;

import com.example.coronapp.entity.Humain;
import com.example.coronapp.enumeration.EtatDeSante;
import com.example.coronapp.enumeration.Nom;
import com.example.coronapp.repository.IHumainRepo;
import com.example.coronapp.service.HumainService;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class HunainServiceTestImproved {

    @Autowired
    private HumainService humainService;

    @Autowired
    private IHumainRepo humainRepo;

    private
    List<Humain> humains = new ArrayList<>();

    @BeforeEach
    public void before () {
        Humain jacques = Humain.builder()
                .nom(Nom.JACQUES)
                .etat(EtatDeSante.MALADE)
                .build();


        Humain paulette = Humain.builder()
            .nom(Nom.PAULETTE)
            .etat(EtatDeSante.MALADE)
            .build();

        humains = Arrays.asList(jacques, paulette);

        humainRepo.saveAll(humains);
    }

    @Test
    public void soigneTousLeMondeTest(){

       humains.forEach(humain -> humain.setEtat(EtatDeSante.SAIN));

       List<Humain> resultat = humainService.changeEtatToutLeMpnde(EtatDeSante.SAIN);

        assertThat(resultat)
                .usingFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(humains.toArray(new Humain[0]));

        assertThat(humainRepo.findAll())
                .usingFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(humains.toArray(new Humain[0]));


    }

    @AfterEach
    public void after(){
        humainRepo.deleteAll();
    }

}
