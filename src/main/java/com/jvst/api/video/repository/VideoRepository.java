package com.jvst.api.video.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvst.api.video.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long>{

}
