package fag.ifeira.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Table(name = "agendamento")
@Entity
@Getter
@Setter
public class Agendamento
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_AGENDAMENTO")
    @SequenceGenerator(name = "ID_AGENDAMENTO", sequenceName = "ID_AGENDAMENTO", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "pedido_id", nullable = false, unique = true)
    private Pedido pedido;

    @Column(name = "data_agendamento", nullable = false, unique = true)
    private Date dataAgendamento;

    @Column(name = "hora_agendamento", nullable = false, unique = true)
    private Time horaAgendamento;

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "endereco_id", nullable = false, unique = true)
    private Endereco endereco;

}