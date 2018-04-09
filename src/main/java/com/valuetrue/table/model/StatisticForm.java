package com.valuetrue.table.model;

import java.util.List;

public class StatisticForm {

    // Initialize variable for model
    private List<OrderTable> orderTableList;
    private List<Printer> printerList;
    private List<Embroidery> embroideryList;
    private List<Sewing> sewingList;
    private List<Team> teamList;

    // Getter & Settter
    public List<OrderTable> getOrderTableList() {
        return orderTableList;
    }

    public void setOrderTableList(List<OrderTable> orderTableList) {
        this.orderTableList = orderTableList;
    }

    public List<Printer> getPrinterList() {
        return printerList;
    }

    public void setPrinterList(List<Printer> printerList) {
        this.printerList = printerList;
    }

    public List<Embroidery> getEmbroideryList() {
        return embroideryList;
    }

    public void setEmbroideryList(List<Embroidery> embroideryList) {
        this.embroideryList = embroideryList;
    }

    public List<Sewing> getSewingList() {
        return sewingList;
    }

    public void setSewingList(List<Sewing> sewingList) {
        this.sewingList = sewingList;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

}
