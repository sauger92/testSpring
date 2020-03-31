package com.example.coronapp;

import com.example.coronapp.entity.Hopital;
import com.example.coronapp.entity.Humain;
import com.example.coronapp.enumeration.EtatDeSante;
import com.example.coronapp.enumeration.Nom;
import com.example.coronapp.enumeration.Pays;
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

    //Meme mock en utilisant BDDMockito
    BDDMockito.given(humainMock.getNom()).willReturn(Nom.JACQUES);
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

    humainMock.setEtat(EtatDeSante.SAIN);
    //Spy n'est que un mocking partiel. Les méthodes non mockées ont un comportement normal
    assertThat(humainMock.getEtat()).isEqualTo(EtatDeSante.SAIN);

  }

  @Captor
  ArgumentCaptor captor;

  @Test
  public void captorAnnotation() {
    humainMock.setPays(Pays.FRANCE);
    // Expliquer Verify
    Mockito.verify(humainMock).setPays((Pays) captor.capture());
   assertThat(captor.getValue()).isEqualTo(Pays.FRANCE);
  }

  @Mock
  Hopital hopital;

  @InjectMocks
  Humain humainInjected = Humain.builder().hopital(new Hopital()).build();


  @Test
  public void injectMockAnnotation() {
    Mockito.when(hopital.getPays()).thenReturn(Pays.FRANCE);
    assertThat(humainInjected.getHopital().getPays()).isEqualTo(Pays.FRANCE);
  }


}
