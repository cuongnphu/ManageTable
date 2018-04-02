package com.valuetrue.table.service;

import com.valuetrue.table.dao.TeamDAO;
import com.valuetrue.table.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class TeamServiceImpl implements TeamService {

    private TeamDAO teamDAO;

    @Autowired
    public void setTeamDAO(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }


    @Override
    public void saveTeam(Team team) {
        if(team.getName()!= ""){
            team.setTotal(0);
            team.setEnable(true);
            this.teamDAO.saveTeam(team);
        }
    }

    @Override
    public void updateTeam(Team team) {
        if(team.getName()!= "")
            this.teamDAO.updateTeam(team);
    }

    @Override
    public void deleteTeam(int id) {
        this.teamDAO.deleteTeam(id);
    }

    @Override
    public Team getTeamById(int id) {
        if(id != 0)
            return this.teamDAO.getTeamById(id);
        else
            return this.teamDAO.getTeamById(0);
    }

    @Override
    public List<Team> getAllTeams() {
        return this.teamDAO.getAllTeams();
    }

    @Override
    public List<Team> getAllTeamsByTeamId(int team_id) {
        return this.teamDAO.getAllTeamsByTeamId(team_id);
    }
}
