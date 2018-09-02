package hd.boot.db.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hd.boot.db.jpa.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
