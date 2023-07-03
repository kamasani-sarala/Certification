package com.certified.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.certified.entity.Certification;


@Repository
public interface CertificationRepository extends JpaRepository<Certification, Integer> {

	public List<Certification> findByeId(Integer id);
	

		@Query("from Certification c where c.cId=:cId")
		public Certification getCertificationbycId(@Param(value="cId")Integer cId );

		
		@Query("from Certification c where c.duration=:duration and c.cost=:cost")
		public Certification findCertificationByDurationandCost(@Param(value="duration") int duration,@Param(value="cost") int cost);

		
		
		
	}
