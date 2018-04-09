package com.valuetrue.table.control;


import com.valuetrue.table.model.*;
import com.valuetrue.table.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;




@Controller
public class StatisticController {

    private Logger log = Logger.getLogger(ProductController.class);
    private TeamService teamService;
    private PrinterService printerService;
    private EmbroideryService embroideryService;
    private SewingService sewingService;
    private OrderTableService orderTableService;

    @Autowired
    public void setTeamService(TeamService teamService) {
        this.teamService = teamService;
    }

    @Autowired
    public void setPrinterService(PrinterService printerService) {
        this.printerService = printerService;
    }

    @Autowired
    public void setEmbroideryService(EmbroideryService embroideryService) {
        this.embroideryService = embroideryService;
    }

    @Autowired
    public void setSewingService(SewingService sewingService) {
        this.sewingService = sewingService;
    }

    @Autowired
    public void setOrderTableService(OrderTableService orderTableService) {
        this.orderTableService = orderTableService;
    }

    @RequestMapping(value="/statistics/{team_id}", method = RequestMethod.GET)
    public ModelAndView listTeamsByTeamId (@ModelAttribute("tableForm") TableForm tableForm, @PathVariable("team_id") int team_id) {
        // Initialize a ModelAndView
        ModelAndView model = new ModelAndView("views/statistics");

        // Get all Teams by team_id
        List<Team> listTeam = this.teamService.getAllTeamsByTeamId(team_id);

        // Setter for modelAttribute
        tableForm.setTeamList(listTeam);

        return model;
    }

    @RequestMapping(value = "/statistic", method = RequestMethod.POST)
    public @ResponseBody StatisticForm getStatisticByParam(String name,int team_id) {
        // Initialzie return statisticForm
        StatisticForm statisticForm = new StatisticForm();

        if(team_id == 1){
            // Get info Team by Name
            List<Printer> printerList = this.printerService.getAllPrinterByName(name);

            // Get info nameTable by id
            List<OrderTable> orderTableList = new ArrayList<OrderTable>();
            for(int i = 0 ; i < printerList.size(); i++){
                OrderTable orderTab = this.orderTableService.getOrderTableById(printerList.get(i).getTable_id());
                orderTableList.add(orderTab);
            }

            // Setter for TableForm
            statisticForm.setPrinterList(printerList);
            statisticForm.setOrderTableList(orderTableList);
        }else if (team_id == 2){
            // Get info Team by Name
            List<Embroidery> embroideryList = this.embroideryService.getAllEmbroideriesByName(name);

            // Get info nameTable by id
            List<OrderTable> orderTableList = new ArrayList<OrderTable>();
            for(int i = 0 ; i < embroideryList.size(); i++){
                OrderTable orderTab = this.orderTableService.getOrderTableById(embroideryList.get(i).getTable_id());
                orderTableList.add(orderTab);
            }

            // Setter for TableForm
            statisticForm.setEmbroideryList(embroideryList);
            statisticForm.setOrderTableList(orderTableList);
        }else if(team_id == 3){
            // Get info Team by Name
            List<Sewing> sewingList  = this.sewingService.getAllSewingByName(name);

            // Get info nameTable by id
            List<OrderTable> orderTableList = new ArrayList<OrderTable>();
            for(int i = 0 ; i < sewingList.size(); i++){
                OrderTable orderTab = this.orderTableService.getOrderTableById(sewingList.get(i).getTable_id());
                orderTableList.add(orderTab);
            }

            // Setter for TableForm
            statisticForm.setSewingList(sewingList);
            statisticForm.setOrderTableList(orderTableList);
        }

        return statisticForm;
    }


}
