package com.cisco.csvreader.api;

import com.cisco.csvreader.model.CurrencyData;
import com.cisco.csvreader.service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;


@RestController
@RequestMapping("api/v1/infos")
public class CSVController {

    @Autowired
    private CSVService csvService;

    @PostMapping
    public void uploadTheInfos(@RequestParam("file") MultipartFile file) throws IOException {
        csvService.postCSVData(file);
    }

    @GetMapping
    public List<CurrencyData> retrieveTheInfo(){
        List<CurrencyData> csvData = csvService.getCSVData();
        return csvData;
    }
}
