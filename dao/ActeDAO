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
import proiectOpera.model.Acte;

@Repository
@Transactional
public class ActeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Acte> list() {
        String sql = "SELECT * FROM ACTE";

        List<Acte> listActe = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Acte.class));

        return listActe;
    }

    public void save(Acte act) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Acte").usingColumns("id_act","durata", "titlu_piesa");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(act);
        insertActor.execute(param);
    }

    public Acte get(int id_act) {
        String sql = "SELECT * FROM ACTE WHERE id_act = ?";
        Object[] args = {id_act};
        Acte act = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Acte.class));
        return act;
    }

    public void update(Acte act) {
        String sql = "UPDATE ACTE SET id_act=:id_act, durata=:durata,titlu_piesa=:titlu_piesa, WHERE id_act=:id_act";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(act);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id_act) {
        String sql = "DELETE FROM ACTE WHERE id_act = ?";
        jdbcTemplate.update(sql,id_act);
    }
}

