package proiectOpera.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proiectOpera.model.Piese_alb;

@Repository
@Transactional
public class Piese_albDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Piese_alb> show() {
        String sql = " select * from piese_alb";

        List<Piese_alb> listaPieseAlb = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Piese_alb.class));

        return listaPieseAlb;
    }
}

