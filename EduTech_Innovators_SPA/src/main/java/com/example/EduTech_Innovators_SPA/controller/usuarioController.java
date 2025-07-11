package com.example.EduTech_Innovators_SPA.controller;
import com.example.EduTech_Innovators_SPA.model.usuario;
import com.example.EduTech_Innovators_SPA.service.usuarioService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/usuario")
@CrossOrigin
public class usuarioController {
    @Autowired
    private usuarioService serv; 
    
    @PostMapping("/registrar")
    public usuario registrar(@RequestBody usuario u){
        return serv.registrarUsuario(u);
    }

    @PostMapping("/login")
    public Map<String,String> login(@RequestBody usuario u){
        Optional<usuario>user = serv.autenticar(u.getEmail(), u.getPassword());
        Map<String,String> response= new HashMap<>();
        if (user.isPresent()) {
            response.put("result", "OK");
            response.put("nombre", user.get().getNombre());
        }else{
            response.put("result", "error");
        }
        return response;
    }
}
