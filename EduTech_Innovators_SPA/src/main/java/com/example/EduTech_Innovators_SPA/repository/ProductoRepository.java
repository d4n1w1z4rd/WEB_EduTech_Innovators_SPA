package com.example.EduTech_Innovators_SPA.repository;

import com.example.EduTech_Innovators_SPA.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRepository {

    // Arreglo que guardara todos los libros
    private List<Producto> listaProductos = new ArrayList<>();

    // Metodo que retorna todoa los libros
    public List<Producto> obteneProductos() {
        return listaProductos;
    }

    // Buscar un libro por su id
    public Producto buscarPorId(int id) {
        for (Producto producto : listaProductos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }


    public Producto guardar(Producto pro) {
        // Generar nuevo ID secuencial
        long nuevoId = 1;
        for (Producto l : listaProductos) {
            if (l.getId() >= nuevoId) {
                nuevoId = l.getId() + 1;
            }
        }

        // Crear una nueva instancia con los datos del libro recibido
        Producto producto = new Producto();
        producto.setId((int) nuevoId); // ID generado automáticamente
        producto.setTitulo(pro.getTitulo());
        producto.setPrecio(pro.getPrecio());
        producto.setHoras(pro.getHoras());

        // Agregar el nuevo libro a la lista
        listaProductos.add(producto);

        return producto;
    }

    public Producto actualizar(Producto pro) {
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getId() == pro.getId()) {
                id = pro.getId();
                idPosicion = i;
            }
        }

        Producto producto1 = new Producto();
        producto1.setId(id);
        producto1.setTitulo(pro.getTitulo());
        producto1.setPrecio(pro.getPrecio());
        producto1.setHoras(pro.getHoras());

        producto1.set(idPosicion, producto1);
        return producto1;
    }

    public void eliminar(int id) {
        // alternativa 1
        // Libro libro = buscarPorId(id);
        // if (libro != null) {
        // listaLibros.remove(libro);
        // }
        //
        // // alternativa 2
        // int idPosicion = 0;
        // for (int i = 0; i < listaLibros.size(); i++) {
        // if (listaLibros.get(i).getId() == id) {
        // idPosicion = i;
        // break;
        // }
        // }
        // if (idPosicion > 0) {
        // listaLibros.remove(idPosicion);
        // }

        // otra alternativa
        listaProductos.removeIf(x -> x.getId() == id);
    }

    public int totalProducto() {
        return listaProductos.size();
    }
}
