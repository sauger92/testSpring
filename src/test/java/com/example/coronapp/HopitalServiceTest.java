package com.example.coronapp;

import com.example.coronapp.entity.Hopital;
import com.example.coronapp.entity.Humain;
import com.example.coronapp.enumeration.EtatDeSante;
import com.example.coronapp.enumeration.Nom;
import com.example.coronapp.repository.IHopitalRepo;
import com.example.coronapp.service.HopitalService;
import com.example.coronapp.service.HumainService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class HopitalServiceTest {

    @MockBean
    private IHopitalRepo hopitalRepo;

    @MockBean
    private HumainService humainService;

    @Autowired
    private HopitalService hopitalService;

    @Captor
    ArgumentCaptor captor;

    private Hopital hopital;

    private List<Humain> humains;

    @BeforeEach
    public void initData() {
            Humain jacques = Humain.builder()
                .nom(Nom.JACQUES)
                .etat(EtatDeSante.MALADE)
                .build();

        Humain paulette = Humain.builder()
                .nom(Nom.PAULETTE)
                .etat(EtatDeSante.MALADE)
                .build();

        humains = Arrays.asList(jacques, paulette);

        hopital = Hopital.builder()
                .patients(humains)
                .build();

        Mockito.when(humainService.changerEtatDeSanteUnePersonne(Mockito.any(Humain.class), Mockito.eq(EtatDeSante.SAIN)))
                .thenAnswer(i -> {
                    Humain humain = (Humain) i.getArguments()[0];
                    humain.setEtat((EtatDeSante) i.getArguments()[1]);
                    return humain;
                });

        Mockito.when(hopitalRepo.save((Hopital) captor.capture())).thenReturn(null);

    }

    @Test
    public void soignerTousLesPatients() {


        List<Humain> resultat = hopitalService.soignerTousLesPatients(hopital);

        Assertions.assertThat(captor.getValue())
                .isEqualToComparingFieldByField(Hopital.builder().patients(new ArrayList<>()).build());

        humains.forEach(humain -> humain.setEtat(EtatDeSante.SAIN));

        Assertions.assertThat(resultat).containsExactlyInAnyOrder(humains.toArray(new Humain[0]));



    }
}
