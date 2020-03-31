package com.example.coronapp;

import com.example.coronapp.entity.Humain;
import com.example.coronapp.enumeration.EtatDeSante;
import com.example.coronapp.enumeration.Nom;
import com.example.coronapp.repository.IHumainRepo;
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
public class MockBeanTest {

    @Autowired
    private HumainService humainService;

    @MockBean
    private IHumainRepo humainRepoMock;

    private List<Humain> humains = new ArrayList<>();


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

        Mockito.when(humainRepoMock.findAllByEtat(EtatDeSante.MALADE)).thenReturn(humains);


        Mockito.when(humainRepoMock.saveAll(Mockito.anyCollection()))
                //On retourne l'argument recu en paramètre par la méthode saveAll
                .thenAnswer(invocation -> invocation.getArguments()[0]);

    }


    @Test
    public void changeEtatToutLeMondeTest() {
        List<Humain> result = humainService.changeEtatToutLeMonde(EtatDeSante.SAIN);

        humains.forEach(humain -> humain.setEtat(EtatDeSante.SAIN));
        Assertions.assertThat(result).usingFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(humains.toArray(new Humain[0]));

    }
}
