package com.cjs.bookstore.repository;

import com.cjs.bookstore.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Authors, Long >
{
}
