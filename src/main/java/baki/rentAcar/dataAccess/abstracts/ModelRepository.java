package baki.rentAcar.dataAccess.abstracts;

import baki.rentAcar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {


}
