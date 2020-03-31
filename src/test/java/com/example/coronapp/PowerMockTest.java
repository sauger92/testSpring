package com.example.coronapp;

import com.example.coronapp.entity.Humain;
import com.example.coronapp.enumeration.EtatDeSante;
import com.example.coronapp.service.HumainService;
import com.example.coronapp.utils.HunainUtils;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringRunner.class)
@PowerMockIgnore({"com.sun.org.apache.xerces.*", "javax.xml.*", "javax.xml.transform.*", "org.xml.*", "javax.management.*", "javax.net.ssl.*", "com.sun.org.apache.xalan.internal.xsltc.trax.*"})
@PrepareForTest(HunainUtils.class)
public class PowerMockTest {

    @Autowired
    private HumainService humainService;

    //Test junit 4 car powermock n'est pas compatible avec Junit 5
    @Test
    public void changerEtatDeSanteUnePersonneTest() {


            Humain humain = Humain.builder().etat(EtatDeSante.MALADE).build();


            PowerMockito.mockStatic(HunainUtils.class);
            PowerMockito.when(HunainUtils.changeEtatDeSanteHumain(humain, EtatDeSante.SAIN))
                    .thenReturn(Humain.builder().etat(EtatDeSante.SAIN).build());

            Assertions.assertThat(humainService.changerEtatDeSanteUnePersonne(humain, EtatDeSante.SAIN))
                    .isEqualToComparingFieldByField(humain);

    }
}
