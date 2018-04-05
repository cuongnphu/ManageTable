package com.valuetrue.table.control;


import com.valuetrue.table.model.Team;
import com.valuetrue.table.service.TeamService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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

        // Initialize params for sort by Column
        ArrayList<String> params = new ArrayList<>();
        params.add("team_id");

        // Get all Teams
        List<Team> listTeamForm = this.teamService.getAllTeamsOrderByParams(params,"ASC");

        // Add modelAttribute of spring-form in ModelView
        model.addObject("listTeamForm", listTeamForm);

        return model;
    }

    @RequestMapping(value = "/team",method=RequestMethod.POST)
    public ModelAndView saveTeam (@ModelAttribute("modelteam") Team team) {
        try{
            if(this.teamService.getTeamById(team.getId()) != null);
            this.teamService.updateTeam(team);
        }catch(EmptyResultDataAccessException e){
            log.info("Create a new Team !!!");
            this.teamService.saveTeam(team);
        }

        return new ModelAndView("redirect:/teams");
    }

    @RequestMapping(value = "/editteam/{id}",method = RequestMethod.GET)
    public ModelAndView editTeam (@ModelAttribute("modelTeam") Team team , @PathVariable("id") int id) {
        // Initilaize a new Model
        ModelAndView model = new ModelAndView("edit/edit_teams");

        // Get Team by Id
        Team teamer = this.teamService.getTeamById(id);

        // Initialize params for sort by Column
        ArrayList<String> params = new ArrayList<>();
        params.add("team_id");

        // Get all Teams
        List<Team> listTeamForm = this.teamService.getAllTeamsOrderByParams(params,"ASC");

        // Add modelAttribute of spring-form in ModelView
        model.addObject("modelTeam",teamer);
        model.addObject("listTeamForm", listTeamForm);

        return model;
    }

    @RequestMapping(value = "/updateteam",method = RequestMethod.POST)
    public ModelAndView updateTeam(@ModelAttribute("modelTeam") Team team){
        try{
            if(this.teamService.getTeamById(team.getId()) != null);
            log.info("Update a Team by id=" + team.getId());
            this.teamService.updateTeam(team);
        }catch(EmptyResultDataAccessException e){
            log.info("Create a new Team !!!");
            this.teamService.saveTeam(team);
        }

        return new ModelAndView("redirect:/teams");
    }

    @RequestMapping(value = "/deleteteam/{id}")
    public ModelAndView deleteTeam(@PathVariable("id") int id){
        // Get Team by Id
        Team teamer = this.teamService.getTeamById(id);
        if(teamer.isEnable() == false){
            log.info("Delete an Team by id = " + id );
            this.teamService.deleteTeam(id);
        }else
            log.info(" ==================== Action DELETE is not correctly !!!!  ============================== " + "\n" );

        return new ModelAndView("redirect:/teams");
    }

    @RequestMapping(value = "/checkteam", method = RequestMethod.POST)
    public @ResponseBody boolean checkTeamName(String nameCheck,int teamIdCheck) {
        // Get all Teams
        List<Team> listTeams = this.teamService.getAllTeams();
        for(int i = 0; i < listTeams.size();i++){
            if(nameCheck.equalsIgnoreCase(listTeams.get(i).getName().trim()) && teamIdCheck == listTeams.get(i).getTeam_id() ){
                return false;
            }
        }

        return true;
    }

    @RequestMapping(value = "/listteamname", method = RequestMethod.POST)
    public @ResponseBody List<Team> getListTeamName() {
        // Get all Teams by status Active
        List<Team> listTeams = this.teamService.getAllTeamsByActive();
        return listTeams;
    }

}

