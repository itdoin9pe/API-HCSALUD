    package com.saludSystem.entities.configuracion;

    import com.saludSystem.entities.catalogo.Plan;
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.util.Date;
    import java.util.UUID;

    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name = "hospital")
    public class SysSalud {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID hospitalId;

        private String nombre;

        private String direccion;

        private String celular;

        private String email;

        private String ruc;

        @Temporal(TemporalType.DATE)
        @Column(name = "fecha", nullable = false)
        private Date fecha;

        @Lob
        @Column(name = "foto", columnDefinition = "MEDIUMBLOB")
        private byte[] foto;

        /*
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "plan_id", nullable = true)
        private Plan planId;
         */

        private Integer estado;

    }
