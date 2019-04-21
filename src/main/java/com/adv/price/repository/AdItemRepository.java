package com.adv.price.repository;

import com.adv.price.domain.AdItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdItemRepository extends JpaRepository<AdItem,Long> {

    Page<AdItem> findByOrOrderNull(Pageable var1);

}
