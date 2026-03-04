package com.example.demo.repository;

import com.example.demo.model.TrainRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainRouteRepository extends JpaRepository<TrainRoute, Long> {

    // ✅ Search by from and to station (FIXED — using Java field names)
    @Query("""
        SELECT tr
        FROM TrainRoute tr
        JOIN FETCH tr.train t
        JOIN tr.fromStation fs
        JOIN tr.toStation ts
        WHERE fs.stationId = :fromId
          AND ts.stationId = :toId
    """)
    List<TrainRoute> findRoutes(@Param("fromId") Long fromId,
                                @Param("toId") Long toId);

    // ✅ Get routes by trainId (FIXED)
    @Query("""
        SELECT tr
        FROM TrainRoute tr
        JOIN FETCH tr.train t
        WHERE t.train_id = :trainId
    """)
    List<TrainRoute> findByTrainId(@Param("trainId") Long trainId);
}