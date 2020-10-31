package com.jvst.api.video.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvst.api.video.model.Video;
import com.jvst.api.video.repository.VideoRepository;

@Service
public class VideoService {

	@Autowired
	private VideoRepository videoRepository;
	
	public Video buscarVideoPorId(Long idVideo) {
		Optional<Video> video = this.videoRepository.findById(idVideo);
		if (!video.isPresent()) {
			throw new EmptyResultDataAccessException("Video não encontrada", 1);
		}
		return video.get();
	}
	
	public void salvarVideo(Video video) {
		this.videoRepository.save(video);
	}

}
