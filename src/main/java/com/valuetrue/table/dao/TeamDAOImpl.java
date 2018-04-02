package com.valuetrue.table.dao;

import com.valuetrue.table.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



@Repository
public class TeamDAOImpl implements TeamDAO {

    private JdbcTemplate jdbcTemplateServlet;

    // JdbcTemplate setter <property name="jdbcTemplateServlet" ... /> in servlet-context.xml
    @Autowired
    public void setJdbcTemplateServlet(JdbcTemplate jdbcTemplateServlet) {
        this.jdbcTemplateServlet = jdbcTemplateServlet;
    }


    // SAVE a new Team
    @Override
    public void saveTeam(Team team) {
        String sql = "insert into Team(name,team_id,total,enable) value(?,?,?,?)";
        jdbcTemplateServlet.update(sql, new Object[]{team.getName(), team.getTeam_id(), team.getTotal(),team.isEnable()});
    }

    // UPDATE a particular Team
    @Override
    public void updateTeam(Team team) {
        String sql = "update Team set name =?, team_id =?, total =?, enable =? where id=?";
        jdbcTemplateServlet.update(sql, new Object[]{team.getName(), team.getTeam_id(), team.getTotal(), team.isEnable() , team.getId()});
    }

    // DELETE a particular Team by Id
    @Override
    public void deleteTeam(int id) {
        String sql = "delete from Team where id=?";
        jdbcTemplateServlet.update(sql, new Object[]{id});
    }


    // GET a particular Team by Id
    @Override
    public Team getTeamById(int id) {
        String sql = "select * from Team where id=?";
        Team team = (Team) jdbcTemplateServlet.queryForObject(sql, new Object[]{id}, new RowMapper<Team>() {
            @Override
            public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
                Team teamer = new Team();
                teamer.setId(rs.getInt(1));
                teamer.setName(rs.getString(2));
                teamer.setTeam_id(rs.getInt(3));
                teamer.setTotal(rs.getInt(4));
                teamer.setEnable(rs.getBoolean(5));
                return teamer;
            }
        });
        return team;
    }

    // GET all Team
    @Override
    public List<Team> getAllTeams() {
        String sql = "select * from Team";
        List<Team> teamList = jdbcTemplateServlet.query(sql, new ResultSetExtractor<List<Team>>() {
            @Override
            public List<Team> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Team> list = new ArrayList<Team>();
                while (rs.next()) {
                    Team teamer = new Team();
                    teamer.setId(rs.getInt(1));
                    teamer.setName(rs.getString(2));
                    teamer.setTeam_id(rs.getInt(3));
                    teamer.setTotal(rs.getInt(4));
                    teamer.setEnable(rs.getBoolean(5));
                    list.add(teamer);
                }
                return list;
            }
        });
        return teamList;
    }

    // GET all teams by Team_Id
    @Override
    public List<Team> getAllTeamsByTeamId(int team_id) {
        String sql = "select * from Team where team_id=?";
        List<Team> teamList = jdbcTemplateServlet.query(sql, new Object[]{team_id} ,new ResultSetExtractor<List<Team>>() {
            @Override
            public List<Team> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Team> list = new ArrayList<Team>();
                while (rs.next()) {
                    Team teamer = new Team();
                    teamer.setId(rs.getInt(1));
                    teamer.setName(rs.getString(2));
                    teamer.setTeam_id(rs.getInt(3));
                    teamer.setTotal(rs.getInt(4));
                    teamer.setEnable(rs.getBoolean(5));
                    list.add(teamer);
                }
                return list;
            }
        });
        return teamList;
    }
}
