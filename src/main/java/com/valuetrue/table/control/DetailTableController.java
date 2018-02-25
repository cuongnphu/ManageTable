package com.valuetrue.table.control;


import com.valuetrue.table.model.TableForm;
import com.valuetrue.table.service.DetailTableService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;


@Controller
public class DetailTableController {

    private Logger log = Logger.getLogger(ProductController.class);
    private DetailTableService detailTableService;

    @Autowired
    public void setDetailTableService(DetailTableService detailTableService) {
        this.detailTableService = detailTableService;
    }

    @RequestMapping(value = "/detailtable",method = RequestMethod.GET)
    public ModelAndView addInformationTable(@ModelAttribute("tableForm") TableForm tableForm ) {

        ModelAndView model = new ModelAndView("info_table_detail");

        List<TableForm> listTabForm = this.detailTableService.getAllTableForm();
        log.info(listTabForm);

        model.addObject("listTableForm", listTabForm);

        return model;

    }


}
