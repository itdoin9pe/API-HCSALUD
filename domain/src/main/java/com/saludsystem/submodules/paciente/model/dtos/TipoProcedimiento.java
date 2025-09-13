package com.saludsystem.submodules.paciente.model.dtos;

public enum TipoProcedimiento
{
	// Procedimientos diagnósticos
	BIOPSIA, // Toma de muestra de tejido
	ENDOSCOPIA, // Visualización interna (ej: gastroscopía)
	RADIOGRAFIA, // Imágenes por rayos X
	RESONANCIA, // RMN
	TOMOGRAFIA, // TAC
	ECOGRAFIA, // Ultrasonido
	ANALISIS_SANGRE, // Hemograma, bioquímica
	ELECTROCARDIOGRAMA, // ECG

	// Procedimientos terapéuticos
	CIRUGIA_MAYOR, // Ej: Apendicectomía, reemplazo de cadera
	CIRUGIA_MENOR, // Ej: Extracción de lunar
	CATETERISMO, // Cardíaco o vascular
	TRANSFUSION, // Transfusión sanguínea
	DIALISIS, // Renal
	INTUBACION, // Vía aérea
	DRENAJE, // De abscesos o líquidos

	// Otros
	VACUNACION, // Administración de vacunas
	CURACION, // Cuidado de heridas
	SUTURA // Cierre de herida

}