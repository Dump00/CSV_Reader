package com.cisco.csvreader.repository;

import com.cisco.csvreader.model.CurrencyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CSVRepository extends JpaRepository<CurrencyData, Long> {
}
