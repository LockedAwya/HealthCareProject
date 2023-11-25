package com.example.HealthCareProject.entity;

import com.example.HealthCareProject.entity.common.Common;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Appointment"
)
public class Appointment extends Common {
//    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE) //todo
    @JoinColumn(name = "appointment_slot_id", unique = true)
    private AppointmentSlot appointmentSlot;

//    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    private Date timeCreated;

    //@Column(name="status")
    /**
     * 0: pending
     * 1: accepted
     * 2: rejected
     */
    //private int status = 0;
    @Column(name="message")
    private String message;

    public Appointment(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
        //this.status = status;
    }
}
