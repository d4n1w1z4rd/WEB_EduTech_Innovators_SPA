package com.example.EduTech_Innovators_SPA.model;

import java.util.Optional;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class usuario {
    @Id 
    @GeneratedValue(strategy =  GenerationType.IDENTITY )
    private long id;
    
    private String nombre;
    private String email;
    private String password;
    
    public static Optional <usuario> map(Object o) {
        throw new UnsupportedOperationException("Unimplemented method 'map' ");
    }
}
