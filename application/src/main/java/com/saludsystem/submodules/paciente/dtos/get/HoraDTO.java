package com.saludsystem.submodules.paciente.dtos.get;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class HoraDTO {

    @Schema(example = "0")
    private long ticks;
    @Schema(example = "0")
    private int days;
    @Schema(example = "0")
    private int hours;
    @Schema(example = "0")
    private int milliseconds;
    @Schema(example = "0")
    private int microseconds;
    @Schema(example = "0")
    private int nanoseconds;
    @Schema(example = "0")
    private int minutes;
    @Schema(example = "0")
    private int seconds;
    @Schema(example = "0")
    private double totalDays;
    @Schema(example = "0")
    private double totalHours;
    @Schema(example = "0")
    private double totalMilliseconds;
    @Schema(example = "0")
    private double totalMicroseconds;
    @Schema(example = "0")
    private double totalNanoseconds;
    @Schema(example = "0")
    private double totalMinutes;
    @Schema(example = "0")
    private double totalSeconds;

}