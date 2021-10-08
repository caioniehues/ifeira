package fag.ifeira.controller;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fag.ifeira.entities.Usuario;
import fag.ifeira.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("")
public class RegistroController
{

    @Autowired
    UsuarioRepository usuarioRepository;



    @PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    String registraUsuario(@RequestBody Usuario usuario) throws IOException {
        usuarioRepository.save(new Usuario(usuario.getEmail(), usuario.getSenha(), usuario.getNome()));
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(usuarioRepository.findById(1l).get());

    }



}
