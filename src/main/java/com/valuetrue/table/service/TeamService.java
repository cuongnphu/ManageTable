package com.valuetrue.table.service;

import com.valuetrue.table.model.Team;
import java.util.List;



public interface TeamService {

    public void saveTeam(Team team);
    public void updateTeam(Team team);
    public void deleteTeam(int id);
    public Team getTeamById(int id);
    public List<Team> getAllTeams();
    public List<Team> getAllTeamsByTeamId(int team_id);
}
