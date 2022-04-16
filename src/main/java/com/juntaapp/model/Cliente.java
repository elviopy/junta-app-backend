package com.juntaapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "ci")
    private String ci;

    @Column(name = "deudaAnterior")
    private Long deudaAnterior;

    @Column(name = "lecturaAnterior")
    private Long lecturaAnterior;

    @Column(name = "lecturaActual")
    private Long lecturaActual;

    @Column(name = "consumo")
    private Long consumo;

    @Column(name = "importeConsumo")
    private Long importeConsumo;

    @Column(name = "multa")
    private Long multa;

    @Column(name = "derechoConexion")
    private Long derechoConexion;

    @Column(name = "totalPagar")
    private Long totalPagar;

    @Column(name = "esLeido")
    private String esLeido;

    @Column(name = "esPagado")
    private String esPagado;

    @Column(name = "fechaModificacion")
    private Date fechaModificacion;

    @Column(name = "fechaLectura")
    private Date fechaLectura;

}
