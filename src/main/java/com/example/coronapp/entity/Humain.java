package com.example.coronapp.entity;

import com.example.coronapp.enumeration.EtatDeSante;
import com.example.coronapp.enumeration.Nom;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Humain {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Nom nom;

  private EtatDeSante etat;

  /**
   * Date à laquelle l'humain tombe malade ou null si l'humain n'est pas malade
   */
  private Date dateDebutMaladie;

  @ManyToOne
  private Hopital hopital;


}
