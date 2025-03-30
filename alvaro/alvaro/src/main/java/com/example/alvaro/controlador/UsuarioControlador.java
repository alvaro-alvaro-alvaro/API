package com.example.alvaro.controlador;

import com.example.alvaro.model.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioControlador {

    private List<Usuario> usuarios = new ArrayList<>();
    private Long siguienteId = 1L;

    // POST - Crear usuario
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        usuario.setId(siguienteId++);
        usuarios.add(usuario);
        return usuario;
    }

    // GET - Obtener todos los usuarios
    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    // PUT - Actualizar usuario
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                usuario.setNombre(usuarioActualizado.getNombre());
                usuario.setEdad(usuarioActualizado.getEdad());
                usuario.setCiudad(usuarioActualizado.getCiudad());
                usuario.setCodigoPostal(usuarioActualizado.getCodigoPostal());
                usuario.setDni(usuarioActualizado.getDni());
                usuario.setCorreo(usuarioActualizado.getCorreo());
                return usuario;
            }
        }
        return null;
    }

    // DELETE - Eliminar usuario
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarios.removeIf(usuario -> usuario.getId().equals(id));
    }
}
