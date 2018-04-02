package com.valuetrue.table.model;




public class Team {

    // Initialize column in table
    private Integer id;
    private String name;
    private Integer team_id;
    private Integer total;
    private boolean enable;

    // Implement constructor
    public Team(Integer id, String name, Integer team_id, Integer total, boolean enable) {
        this.id = id;
        this.name = name;
        this.team_id = team_id;
        this.total = total;
        this.enable = enable;
    }

    public Team() {
        this.id = 0;
    }

    // Implement Getter & Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "Team [id=" + id + ", name=" + name + ", team_id=" + team_id +", total=" + total + ", enable =" + enable + "]";
    }
}

