package hu.laszlovaspal.database;

import org.springframework.data.repository.CrudRepository;

public interface SimpleEntityRepository extends CrudRepository<SimpleEntity, Long> {
}
