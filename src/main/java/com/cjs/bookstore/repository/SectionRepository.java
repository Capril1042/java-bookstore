package com.cjs.bookstore.repository;

import com.cjs.bookstore.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long>
{
}
