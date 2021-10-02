package fag.ifeira.controller;

import fag.ifeira.entities.Usuario;
import fag.ifeira.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class RegistroController
{

    @Autowired
    UsuarioRepository usuarioRepository;


    @PostMapping("/registrar")
    public List<Usuario> registraUsuario(@RequestBody Usuario usuario){
        usuarioRepository.save(new Usuario(usuario.getEmail(), usuario.getSenha(), usuario.getNome()));
        return usuarioRepository.findAll();
    }



}
