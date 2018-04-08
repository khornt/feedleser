package com.horntvedt.camel.vgleser.database;


import com.horntvedt.camel.vgleser.dto.vgNyhet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;


@Component
public class EntryJDBC {

    private static final Logger logger = LoggerFactory.getLogger(EntryJDBC.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;


    private String insertNyhet = "insert into nyheter(title, link, id, updated, summary) VALUES(?,?,?,?,?)";
    private String updateNyhet = "update sistlest set guid = ? where id = 1";


    public int leggInnNyhet(vgNyhet nyhet) {
        int i;

        try {
            i = jdbcTemplate.update(insertNyhet, new Object[]{nyhet.getTitle(), nyhet.getLink(), nyhet.getId(),
                    nyhet.getUpdated(), nyhet.getSummary() });
            return i;
        } catch (Exception e) {
            return -1;
        }
    }


    public int updateNyhet(String id) {
        int i;

        try {
            i = jdbcTemplate.update(updateNyhet, new Object[]{ id });
            return i;
        } catch (Exception e) {
            return -1;
        }
    }




    public String hentSistlesteFeedEntry() {
        String entry = null;
        try {

            entry = jdbcTemplate.queryForObject("select guid from lekestue.sistlest where id = '1'", String.class);
        } catch (EmptyResultDataAccessException ex) {
            return "tomTom";
        }
        return entry;
    }




}
