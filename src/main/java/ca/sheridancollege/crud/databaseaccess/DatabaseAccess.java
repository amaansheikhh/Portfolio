package ca.sheridancollege.crud.databaseaccess;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class DatabaseAccess {
/*
    private NamedParameterJdbcTemplate jdbc;

    public DatabaseAccess(NamedParameterJdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public List<Avenger> getAvengers(){
        String query = "SELECT * FROM avengers";
        BeanPropertyRowMapper<Avenger> avengerBeanPropertyRowMapper =
                new BeanPropertyRowMapper<>(Avenger.class);
        List<Avenger> avengers = jdbc.query(query,avengerBeanPropertyRowMapper);
        return avengers;
    }


    public int addAvenger(Avenger avenger){
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "INSERT into avengers (name,age) values (:name, :age)";
        namedParameters.addValue("name",avenger.getName());
        namedParameters.addValue("age",avenger.getAge());
        int returnValue = jdbc.update(query,namedParameters);
        return returnValue;
    }

    // edit - first getAvenger based on id, then execute the update

        public Avenger getAvenger(Long id){
            log.info("Calling update on avenger with id {}",id);
            MapSqlParameterSource namedParameters = new MapSqlParameterSource();
            String query = "SELECT * from avengers where id =:id";
            namedParameters.addValue("id",id);
            BeanPropertyRowMapper<Avenger> avengerBeanPropertyRowMapper =
                    new BeanPropertyRowMapper<>(Avenger.class);
            Avenger avenger = null;

            try{
                avenger = jdbc.queryForObject(query, namedParameters, avengerBeanPropertyRowMapper);
            }catch (EmptyResultDataAccessException e){
                log.error("Avenger not found with id {}",id);
            }
            return avenger;
        }

        public int updateAvenger(Avenger avenger){
            log.info("Calling updateAvenger method with avenger {}",avenger);
            MapSqlParameterSource namedParameters = new MapSqlParameterSource();
            String query = "Update avengers set name =:name, age =:age where id=:id";
            namedParameters.addValue("id",avenger.getId());
            namedParameters.addValue("name",avenger.getName());
            namedParameters.addValue("age",avenger.getAge());

            return jdbc.update(query,namedParameters);

        }

        public long editAvenger(Long id){



            return id;

        }


    // delete
    public int deleteAvenger(Long id){
        log.info("Avenger to be deleted with id {}",id);
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "DELETE from avengers where id = :id ";
        namedParameters.addValue("id",id);

        return jdbc.update(query,namedParameters);
    }*/

}
