package com.example.coronapp.service;

import com.example.coronapp.entity.Hopital;
import com.example.coronapp.entity.Humain;
import com.example.coronapp.enumeration.EtatDeSante;
import com.example.coronapp.enumeration.Pays;
import com.example.coronapp.repository.IHopitalRepo;
import com.example.coronapp.utils.HunainUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class HopitalService {

  private final IHopitalRepo hopitalRepo;
  
  
  
}
