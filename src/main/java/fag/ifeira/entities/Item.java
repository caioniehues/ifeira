package fag.ifeira.entities;

import fag.ifeira.utils.UnidadeDeMedida;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "item")
@Entity
@Setter
@Getter
public class Item
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_ITEM")
    @SequenceGenerator(name = "ID_ITEM", sequenceName = "ID_ITEM", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "preco_unidade_de_medida", nullable = false, precision = 19, scale = 2)
    private BigDecimal precoUnidadeDeMedida;

    @Enumerated
    @Column(name = "unidade_de_medida", nullable = false)
    private UnidadeDeMedida unidadeDeMedida;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "fornecedor_id", nullable = false)
    private Usuario fornecedor;

}