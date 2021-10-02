package fag.ifeira.entities;

import fag.ifeira.utils.TipoDeUsuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "usuario")
@Entity
@Getter
@Setter
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_USUARIO")
    @SequenceGenerator(name = "ID_USUARIO", sequenceName = "ID_USUARIO", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = false;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "cnpj", unique = true)
    private String cnpj;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_de_usuario", nullable = false)
    private TipoDeUsuario tipoDeUsuario;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecoes;

    public Usuario(String email, String senha, String nome) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.ativo = true;
        this.tipoDeUsuario = TipoDeUsuario.CLIENTE;
    }

    public Usuario() {
    }
}