package fag.ifeira.controller;

import fag.ifeira.entities.Usuario;
import fag.ifeira.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/registro")
public class RegistroController
{

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping()
    public String fodase(){
        return "teste de requisição get";
    }

    @GetMapping("/teste")
    public List<Usuario> teste(){

        return usuarioRepository.findAll();
    }

    @PostMapping("/user")
    public String testeDeUsuario(){
        Usuario usuario = new Usuario("caioniehues@gmail.com", "testedesenha");
        Usuario usuario1 = new Usuario("caioniehues@gmail.com", "testedesenha");
        Usuario usuario2 = new Usuario("caioniehues@gmail.com", "testedesenha");
        Usuario usuario3 = new Usuario("caioniehues@gmail.com", "testedesenha");
        Usuario usuario4 = new Usuario("caioniehues@gmail.com", "testedesenha");
        usuarioRepository.save(usuario);
        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);
        usuarioRepository.save(usuario3);
        usuarioRepository.save(usuario4);
        return "teste de salvar";
    }

}
