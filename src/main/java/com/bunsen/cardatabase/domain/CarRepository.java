package com.bunsen.cardatabase.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car,Long> {
    // Fetch cars by color
    List<Car> findByColor(@Param("color") String color);

    // Fetch cars by model year
    List<Car> findByModelYear(int modelYear);

    // Fetch cars by brand and model
    List<Car> findByBrandAndModel(String brand, String model);

    // Fetch cars by brand or color
    List<Car> findByBrandOrColor(String brand, String color);

    // Fetch cars by brand and sort by year
    List<Car> findByBrandOrderByModelYearAsc(String brand);

    // Fetch cars by brand using SQL
    @Query("select c from Car c where c.brand = ?1")
    List<Car> findByBrand(String brand);

    // Fetch cars by brand using SQL
    @Query("select c from Car c where c.brand like %?1")
    List<Car> findByBrandEndsWith(String brand);
}