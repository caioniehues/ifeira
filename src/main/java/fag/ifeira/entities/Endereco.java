package fag.ifeira.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "endereco")
@Entity
@Getter
@Setter
public class Endereco
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "cep")
    private String cep;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "localidade")
    private String localidade;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "uf")
    private String uf;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private Usuario usuario;

}