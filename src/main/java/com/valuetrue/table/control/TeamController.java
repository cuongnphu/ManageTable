package com.valuetrue.table.control;


import com.valuetrue.table.model.Team;
import com.valuetrue.table.service.TeamService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class TeamController {

    private Logger log = Logger.getLogger(ProductController.class);
    private TeamService teamService;

    @Autowired
    public void setTeamService(TeamService teamService) {
        this.teamService = teamService;
    }

    @RequestMapping(value="/teams", method = RequestMethod.GET)
    public ModelAndView listTeams (@ModelAttribute("modelteam") Team team) {
        // Initialize a ModelAndView
        ModelAndView model = new ModelAndView("views/teams");

        // Get all orderTable
        List<Team> listTeamForm = this.teamService.getAllTeams();

        // Add modelAttribute of spring-form in ModelView
        model.addObject("listTeamForm", listTeamForm);

        return model;
    }

    @RequestMapping(value = "/team",method=RequestMethod.POST)
    public ModelAndView saveOrderTable (@ModelAttribute("modelteam") Team team) {
        try{
            if(this.teamService.getTeamById(team.getId()) != null);
            this.teamService.updateTeam(team);
        }catch(EmptyResultDataAccessException e){
            log.info("Create a new Team !!!");
            this.teamService.saveTeam(team);
        }

        return new ModelAndView("redirect:/teams");
    }

}

