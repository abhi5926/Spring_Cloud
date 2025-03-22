package com.example.SpringJDBCDemoProject.repo;

import com.example.SpringJDBCDemoProject.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.jdbc.core.JdbcOperationsExtensionsKt.query;

@Component
public class AlienRepo {

    public JdbcTemplate getTemplate() {
        return template;
    }
   @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    private JdbcTemplate template;

    public void save(Alien alien){
        String sql = "insert into alien (id, name, tech) values (?,?,?)";
        int rows = template.update(sql, alien.getId(),alien.getName(), alien.getTech());
        System.out.println(rows + "rows affected ");
    }

    public List<Alien> findAll(){
        String sql = "select * from alien";

        RowMapper<Alien> mapper = new RowMapper<Alien>() {
            @Override
            public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
            Alien a = new Alien();
            a.setId(rs.getInt(1));
            a.setName(rs.getString(2));
            a.setTech(rs.getString(1));
            return a;

            }
        };
        List<Alien> aliens = template.query(sql,mapper);
  return aliens;
    }
}
