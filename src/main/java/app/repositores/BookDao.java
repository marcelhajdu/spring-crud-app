package app.repositores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.entities.Book;

@Repository
public interface BookDao extends CrudRepository<Book, Long> {

}
