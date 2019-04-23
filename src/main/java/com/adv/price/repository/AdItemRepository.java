package com.adv.price.repository;

import com.adv.price.domain.AdItem;
import com.adv.price.domain.AdOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdItemRepository extends JpaRepository<AdItem,Long> {

    Page<AdItem> findByOrOrderNull(Pageable var1);

    List<AdItem> findByOrderEquals(AdOrder order);

}
