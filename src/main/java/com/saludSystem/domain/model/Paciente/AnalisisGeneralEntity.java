package com.saludSystem.infrastructure.adapters.in.controllers.Paciente;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(schema = "pacientes_analisis_general")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class AnalisisGeneral {

    private UUID pacienteAnalisisGeneralId;

    

}
