package com.IT.Stock.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.IT.Stock.Model.Outward;

@Repository
public interface OutwardJpaRepository extends JpaRepository<Outward,Long>{

    @Query(value = "select * from outward order by outwardid desc limit 5",nativeQuery = true)
    List<Outward> findTop10Outward();
}
