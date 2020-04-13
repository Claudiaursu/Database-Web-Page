package proiectOpera.dao;

import java.util.List;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proiectOpera.model.Regizori;

@Repository
@Transactional
public class RegizoriDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Regizori> list() {
        String sql = "SELECT * FROM REGIZORI";

        List<Regizori> listRegizori = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Regizori.class));

        return listRegizori;
    }

    public void save(Regizori regizor) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Regizori").usingColumns("id_regizor","nume","prenume", "data_nasterii", "data_angajarii");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(regizor);
        insertActor.execute(param);
    }

    public Regizori get(int id_regizor) {
        String sql = "SELECT * FROM REGIZORI WHERE id_regizor = ?";
        Object[] args = {id_regizor};
        Regizori regizor = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Regizori.class));
        return regizor;
    }

    public void update(Regizori regizor) {
        String sql = "UPDATE REGIZORI SET id_regizor=:id_regizor, nume=:nume, prenume=:prenume, data_nasterii=:data_nasterii,data_angajarii=:data_angajarii WHERE id_regizor=:id_regizor";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(regizor);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id_regizor) {
        String sql = "DELETE FROM REGIZORI WHERE id_regizor = ?";
        jdbcTemplate.update(sql,id_regizor);
    }
}

