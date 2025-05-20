package com.example.EduTech_Innovators_SPA.service;

import com.example.EduTech_Innovators_SPA.model.Producto;
import com.example.EduTech_Innovators_SPA.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> geProductos(){
         return productoRepository.obteneProductos();
    }
    
}
