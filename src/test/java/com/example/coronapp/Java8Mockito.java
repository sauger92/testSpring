package com.example.coronapp;

import com.example.coronapp.entity.Hopital;
import com.example.coronapp.enumeration.Ville;
import com.example.coronapp.repository.IHopitalRepo;
import com.example.coronapp.service.HopitalService;
import com.example.coronapp.service.HumainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class Java8Mockito {

    @MockBean
    private IHopitalRepo hopitalRepoMock;

    @MockBean
    private HumainService humainService;

    @Autowired
    private HopitalService hopitalService;

    @Test
    public void testOptional() {
        /**
         * Avant Mockito 2 :
         * when(hopitalRepoMock.findFirstByVille(Ville.PARIS).thenReturn(Optionql.empty());
         */
        assertThat(hopitalService.checkIfOneHospitalExistByVille(Ville.PARIS)).isEqualTo(false);
    }

    @Test
    public void testStream() {
        /**
         * Avant Mockito 2 :
         * when(humainService.getHumainStream(anyCollection())).thenReturn(Stream.empty());
         */
        assertThat(hopitalService.getPatientsInHospital(Hopital.builder().build()))
        .isEmpty();
    }


}
