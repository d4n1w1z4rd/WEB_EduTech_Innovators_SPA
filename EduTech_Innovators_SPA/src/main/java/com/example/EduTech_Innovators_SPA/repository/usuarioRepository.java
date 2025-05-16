package com.example.EduTech_Innovators_SPA.repository;

import com.example.EduTech_Innovators_SPA.model.usuario;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface  usuarioRepository extends JpaRepository<usuario,Long> {
    Optional <usuario> findByEmail(String email);
}
