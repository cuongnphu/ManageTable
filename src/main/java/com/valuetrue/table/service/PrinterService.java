package com.valuetrue.table.service;

import com.valuetrue.table.model.Printer;

import java.util.List;


public interface PrinterService {

    public void savePrinter(Printer printer);
    public void updatePrinter(Printer printer);
    public void deletePrinter(int id);
    public Printer getPrinterById(int id);
    public List<Printer> getAllPrinters();
    public List<Printer> getAllPrintersByTableId(int table_id);
    public List<Printer> getAllPrinterByName(String name);
}
