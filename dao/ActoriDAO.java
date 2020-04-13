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
import proiectOpera.model.Actori;

@Repository
@Transactional
public class ActoriDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Actori> show() {
        String sql = "SELECT * FROM ACTORI ";

        List<Actori> listaActori = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Actori.class));

        return listaActori;
    }

    public void save(Actori actor) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Actori").usingColumns("id_actor","nume", "prenume", "data_nasterii", "data_angajarii","tip_actor","titlu_piesa");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(actor);
        insertActor.execute(param);
    }

    public Actori get(int id_actor) {
        String sql = "SELECT * FROM ACTORI WHERE id_actor = ?";
        Object[] args = {id_actor};
        Actori actor = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Actori.class));
        return actor;
    }

    public void update(Actori actor) {
        String sql = "UPDATE ACTORI SET id_actor=:id_actor, nume=:nume, prenume=:prenume,data_nasterii=:data_nasterii, data_angajarii=:data_angajarii, tip_actor=:tip_actor, titlu_piesa=:titlu_piesa WHERE id_actor=:id_actor";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(actor);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id_actor) {
        String sql = "DELETE FROM ACTORI WHERE id_actor= ?";
        jdbcTemplate.update(sql,id_actor);
    }
}

