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
import proiectOpera.model.Aparitie;


@Repository
@Transactional
public class AparitieDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Aparitie> list() {
        String sql = "SELECT * FROM APARITIE";

        List<Aparitie> listaAparitii = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Aparitie.class));

        return listaAparitii;
    }

    public void save(Aparitie aparitie) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Aparitie").usingColumns("id_obiect_vestimentar","id_actor");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(aparitie);
        insertActor.execute(param);
    }

    public Aparitie get(int id_obiect_vestimentar, int id_actor) {
        String sql = "SELECT * FROM APARITIE WHERE id_obiect_vestimentar = ? and id_actor=?";
        Object[] args = {id_obiect_vestimentar, id_actor};
        Aparitie aparitie = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Aparitie.class));
        return aparitie;
    }

    public void update(Aparitie aparitie, int id_obiect_vestimentar_vechi, int id_actor_vechi) {
        String sql = "UPDATE APARITIE SET id_obiect_vestimentar=:id_obiect_vestimentar, id_actor=:id_actor WHERE id_obiect_vestimentar=" + id_obiect_vestimentar_vechi + " and id_actor=" + id_actor_vechi;
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(aparitie);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id_obiect_vestimentar, int id_actor) {
        String sql = "DELETE FROM APARITIE WHERE id_obiect_vestimentar= ? and id_actor=?";
        jdbcTemplate.update(sql, id_obiect_vestimentar, id_actor);
    }
}

