package com.cisco.csvreader.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.io.Serializable;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "currency_data")
@Entity
@JsonPropertyOrder({ "id", "country", "currency" })
public class CurrencyData implements Serializable {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String country;
    private String currency;

    public CurrencyData(String country, String currency) {
        this.country = country;
        this.currency = currency;
    }
}
