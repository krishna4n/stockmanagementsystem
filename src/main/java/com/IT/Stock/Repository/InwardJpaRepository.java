package com.IT.Stock.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.IT.Stock.Model.Inward;

@Repository
public interface InwardJpaRepository extends JpaRepository<Inward,Long> {
@Query(value = "select * from inward order by inwardid desc limit 5", nativeQuery = true)
    List<Inward> findTop10Inward();
    @Query(value = "SELECT MAX(i.inwardid) FROM inward i WHERE i.storeid = :storeId", nativeQuery= true)
    Long findMaxInwardIdByStoreId(Long storeId);
}
