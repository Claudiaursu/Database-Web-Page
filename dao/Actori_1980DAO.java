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
import proiectOpera.model.Actori_1980;

@Repository
@Transactional
public class Actori_1980DAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Actori_1980> show() {
     //   String sql = " select distinct id_actor, nume, prenume, titlu_piesa, data_nasterii, data_angajarii, tip_actor from Actori_1980";
        String sql = " select * from Actori_1980";

        List<Actori_1980> listaActori1980 = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Actori_1980.class));

        return listaActori1980;
    }
}

