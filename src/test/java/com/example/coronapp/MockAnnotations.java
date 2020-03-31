package com.example.coronapp;

import com.example.coronapp.entity.Hopital;
import com.example.coronapp.entity.Humain;
import com.example.coronapp.enumeration.EtatDeSante;
import com.example.coronapp.enumeration.Nom;
import com.example.coronapp.enumeration.Ville;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MockAnnotations {

  @Mock
  private Humain humainMock;

  @Test
  public void mockAnnotation() {
    Mockito.when(humainMock.getNom()).thenReturn(Nom.JACQUES);
    assertThat(humainMock.getNom()).isEqualTo(Nom.JACQUES);

  }

  @Spy
  private Humain humainSpy;

  @Test
  public void spyAnnotation() {
    Mockito.when(humainSpy.getNom()).thenReturn(Nom.JACQUES);
    assertThat(humainSpy.getNom()).isEqualTo(Nom.JACQUES);

  }

  @Test
  public void spyVsMock() {
    humainMock.setEtat(EtatDeSante.SAIN);

    //Mock est un mock total. Il faut définir le comportement de chaque méthode que l' on souhaite utilisé car tous les paramètres ont  une valeur nulle (ou par défaut).
    assertThat(humainMock.getEtat()).isEqualTo(null);

    Mockito.when(humainMock.getEtat()).thenReturn(EtatDeSante.SAIN);
    assertThat(humainMock.getEtat()).isEqualTo(EtatDeSante.SAIN);

    humainSpy.setEtat(EtatDeSante.SAIN);
    //Spy n'est que un mocking partiel. Les méthodes non mockées ont un comportement normal
    assertThat(humainSpy.getEtat()).isEqualTo(EtatDeSante.SAIN);

  }

  @Captor
  ArgumentCaptor captor;

  @Test
  public void captorAnnotation() {
    humainMock.setNom(Nom.JACQUELINE);

    Mockito.verify(humainMock).setNom((Nom) captor.capture());
   assertThat(captor.getValue()).isEqualTo(Nom.JACQUELINE);
  }

  @Mock
  Hopital hopitalInjected;

  @InjectMocks
  Humain humain = Humain.builder().hopital(new Hopital()).build();


  @Test
  public void injectMockAnnotation() {
    Mockito.when(hopitalInjected.getVille()).thenReturn(Ville.LYON);
    assertThat(humain.getHopital().getVille()).isEqualTo(Ville.LYON);
  }


}
