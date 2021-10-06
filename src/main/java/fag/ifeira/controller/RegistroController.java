package fag.ifeira.controller;

import fag.ifeira.entities.Usuario;
import fag.ifeira.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class RegistroController
{

    @Autowired
    UsuarioRepository usuarioRepository;


    @PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<Usuario> registraUsuario(@RequestBody Usuario usuario){
        usuarioRepository.save(new Usuario(usuario.getEmail(), usuario.getSenha(), usuario.getNome()));
        return usuarioRepository.findAll();
    }



}
