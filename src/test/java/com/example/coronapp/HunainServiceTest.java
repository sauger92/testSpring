package com.example.coronapp;

import com.example.coronapp.entity.Humain;
import com.example.coronapp.enumeration.EtatDeSante;
import com.example.coronapp.enumeration.Nom;
import com.example.coronapp.repository.IHumainRepo;
import com.example.coronapp.service.HumainService;
import com.example.coronapp.utils.HunainUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class HunainServiceTest {

    @Autowired
    private HumainService humainService;

    @Autowired
    private IHumainRepo humainRepo;

    @Test
    public void soigneTousLeMondeTest(){

        Humain jacques = Humain.builder()
                .nom(Nom.JACQUES)
                .etat(EtatDeSante.MALADE)
                .build();

        Humain paulette = Humain.builder()
                .nom(Nom.PAULETTE)
                .etat(EtatDeSante.MALADE)
                .build();

        List<Humain> humains = Arrays.asList(jacques, paulette);

        humainRepo.saveAll(humains);

       humains.forEach(humain -> humain.setEtat(EtatDeSante.SAIN));

        assertThat(humainService.soignerToutLeMonde())
                .usingFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(humains.toArray(new Humain[0]));

        assertThat(humainRepo.findAll())
                .usingFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(humains.toArray(new Humain[0]));


    }

}
