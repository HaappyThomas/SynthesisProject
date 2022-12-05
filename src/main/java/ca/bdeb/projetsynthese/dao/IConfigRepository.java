package ca.bdeb.projetsynthese.dao;

import ca.bdeb.projetsynthese.models.Config;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConfigRepository extends JpaRepository<Config, Integer> {
    Config findByUserEmail(String userEmail);
}
