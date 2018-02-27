package com.valuetrue.table.service;

import com.valuetrue.table.dao.PrinterDAO;
import com.valuetrue.table.model.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class PrinterServiceImpl implements PrinterService {

    private PrinterDAO printerDAO;

    @Autowired
    public void setPrinterDAO(PrinterDAO printerDAO) {
        this.printerDAO = printerDAO;
    }

    @Override
    public void savePrinter(Printer printer) {
        // Caculate total = price * quantity
        Integer total = printer.getPrice()* printer.getQuantity();
        printer.setTotal(total);

        this.printerDAO.savePrinter(printer);
    }

    @Override
    public void updatePrinter(Printer printer) {
        // Caculate total = price * quantity
        Integer total = printer.getPrice()* printer.getQuantity();
        printer.setTotal(total);

        this.printerDAO.updatePrinter(printer);
    }

    @Override
    public void deletePrinter(int id) {
        this.printerDAO.deletePrinter(id);
    }

    @Override
    public Printer getPrinterById(int id) {
        if(id != 0)
            return this.printerDAO.getPrinterById(id);
        else
            return this.printerDAO.getPrinterById(0);
    }

    @Override
    public List<Printer> getAllPrinters() {
        return this.printerDAO.getAllPrinters();
    }

    @Override
    public List<Printer> getAllPrintersByTableId(int table_id) {
        return this.printerDAO.getAllPrintersByTableId(table_id);
    }
}
