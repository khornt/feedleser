package com.horntvedt.vgleser.database;


import com.horntvedt.vgleser.dto.VgNyhet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class EntryJDBC {

    private static final Logger logger = LoggerFactory.getLogger(EntryJDBC.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;


    private static final String INNSERT_NYHET = "insert into nyheter(title, link, id, updated, summary, lagttil, guid) " +
                                    "VALUES(?,?,?,?,?,sysdate(),?)";
    private static final String UPDATE_NYHET = "update sistlest set guid = ? where id = 1";

    private static final String FINNES_FRA_FOER = "select count(*) from nyheter where id = '";



    public int leggInnNyhet(VgNyhet nyhet) {
        int i;

        try {
            i = jdbcTemplate.update(INNSERT_NYHET, new Object[]{nyhet.getTitle(), nyhet.getLink(), nyhet.getId(),
                    nyhet.getUpdated(), nyhet.getSummary(), UUID.randomUUID().toString() });
            return i;
        } catch (Exception e) {
            return -1;
        }
    }

    public int finnesFraFoer(String s) {

        int i;

        try {

            i = jdbcTemplate.queryForObject(FINNES_FRA_FOER + s + "'", Integer.class);
        } catch (EmptyResultDataAccessException ex) {
            return -1;
        }


        return i;
    }


    public int updateNyhet(String id) {
        int i;

        try {
            i = jdbcTemplate.update(UPDATE_NYHET, new Object[]{ id });
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
