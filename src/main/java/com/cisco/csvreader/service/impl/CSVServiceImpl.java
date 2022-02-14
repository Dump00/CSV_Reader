package com.cisco.csvreader.service.impl;

import com.cisco.csvreader.model.CurrencyData;
import com.cisco.csvreader.repository.CSVRepository;
import com.cisco.csvreader.service.CSVService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CSVServiceImpl implements CSVService {

    @Autowired
    private CSVRepository csvRepository;

    @Override
    public void postCSVData(MultipartFile file) throws IOException {
        InputStream is = file.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(br, CSVFormat.DEFAULT);
        Iterable<CSVRecord> csvRecords = csvParser.getRecords();
        for (CSVRecord csvRecord : csvRecords) {
            CurrencyData currencyData = new CurrencyData();
            currencyData.setCountry(csvRecord.get(0).trim());
            currencyData.setCurrency(csvRecord.get(1).trim());
            csvRepository.save(currencyData);
        }
    }

    @Override
    public List<CurrencyData> getCSVData() {
        List<CurrencyData> result = csvRepository.findAll();
        return result;
    }
}

