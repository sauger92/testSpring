package com.example.coronapp.entity;

import com.example.coronapp.enumeration.Pays;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Hopital {

  @Id
  private Long id;

  @OneToMany(targetEntity=Humain.class, mappedBy="hopital")
  private List<Humain> patients;

  private Pays pays;
}
