package com.jvst.api.tag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvst.api.tag.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{

}
