package baki.rentAcar.dataAccess.abstracts;

import baki.rentAcar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BrandRepository extends JpaRepository<Brand, Integer> {
    boolean existsByName(String name); //spring jpa keywords

}
