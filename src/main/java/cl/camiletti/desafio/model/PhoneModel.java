package cl.camiletti.desafio.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "phones")
public class PhoneModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String number;
    private String cityCode;
    private String countryCode;
}
