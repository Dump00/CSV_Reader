package com.cisco.csvreader.service;


import com.cisco.csvreader.model.CurrencyData;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CSVService {
    void postCSVData(MultipartFile file) throws IOException;
    List<CurrencyData> getCSVData();
}
