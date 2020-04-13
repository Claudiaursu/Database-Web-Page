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
import proiectOpera.model.piese;

@Repository
@Transactional
public class pieseDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<piese> list() {
        String sql = "SELECT * FROM PIESE p JOIN REGIZORI r ON r.id_regizor = p.id_regizor";

        List<piese> listPiese = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(piese.class));

        return listPiese;
    }

    public void save(piese piese_opera) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("piese").usingColumns("titlu_piesa","gen_piesa", "nr_reprez_luna", "pret_bilet", "id_regizor", "nr_pauze");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(piese_opera);
        insertActor.execute(param);
    }

    public piese get(String titlu_piesa) {
        String sql = "SELECT * FROM PIESE WHERE titlu_piesa = ?";
        Object[] args = {titlu_piesa};
        piese piesa_opera = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(piese.class));
        return piesa_opera;
    }

    public void update(piese piesa) {
        String sql = "UPDATE PIESE SET titlu_piesa=:titlu_piesa, gen_piesa=:gen_piesa, nr_reprez_luna=:nr_reprez_luna, pret_bilet=:pret_bilet,id_regizor=:id_regizor,nr_pauze=:nr_pauze WHERE titlu_piesa=:titlu_piesa";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(piesa);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(String titlu_piesa) {
        String sql = "DELETE FROM PIESE WHERE titlu_piesa = ?";
        jdbcTemplate.update(sql,titlu_piesa);
    }
}

