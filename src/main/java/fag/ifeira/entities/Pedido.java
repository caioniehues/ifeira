package fag.ifeira.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "pedido")
@Entity
@Getter
@Setter
public class Pedido
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PEDIDO")
    @SequenceGenerator(name = "ID_PEDIDO", sequenceName = "ID_PEDIDO", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private Usuario usuario;

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "agendamento_id", nullable = false, unique = true)
    private Agendamento agendamento;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pedido_id", unique = true)
    private List<Item> items;

}