package com.adv.price.repository;

import com.adv.price.domain.AdOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdOrderRepository extends JpaRepository<AdOrder,Long> {
    Page<AdOrder> findAllByEnabledTrue(Pageable var1);
}
