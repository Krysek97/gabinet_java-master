package com.gabinet.gabinet.visit;

import com.gabinet.gabinet.client.Client;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Table(name = "VISIT")
@Entity
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "visit_id")
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String note;
    private Long clientId;


    public Visit() {
    }

    public Visit(LocalDate date, String note) {
        this.date = date;
        this.note = note;
    }

    public Visit(Long id, LocalDate date, String note, Long clientId) {
        this.id = id;
        this.date = date;
        this.note = note;
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", date=" + date +
                ", note='" + note + '\'' +
                ", clientId=" + clientId +
                '}';
    }
}
