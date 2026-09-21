package com.anshuman.storage;


import com.anshuman.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train,Long> {

}
