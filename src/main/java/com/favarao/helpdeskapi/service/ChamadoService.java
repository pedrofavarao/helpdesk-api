package com.favarao.helpdeskapi.service;

import com.favarao.helpdeskapi.repository.ChamadoRepository;
import com.favarao.helpdeskapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChamadoService {
    @Autowired
    private ChamadoRepository chamadoRepository;
    @Autowired
    private UserRepository userRepository;

}
