package group.example.KanbanHiringPortal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import group.example.KanbanHiringPortal.model.Candidate;
import group.example.KanbanHiringPortal.model.comment;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,String>{
	
	@Transactional
	@Modifying
	@Query(value="Update Candidate set status=:status  where candidateId=:id")
	public void update(@Param("status") int status,@Param("id") String id);
	
	@Query(value="Select c from Candidate c where c.candidateId=:value")
	public Candidate returnObj(@Param("value") String value);

	public Candidate findByCandidateId(String id);

	@Transactional
	@Modifying
	@Query(value="Update Candidate set gcm=:value  where candidateId=:id")
	public void updategcm(@Param("value") String objValue, @Param("id") String objId);

	@Transactional
	@Modifying
	@Query(value="Update Candidate set position=:value  where candidateId=:id")
	public void updateposition(@Param("value") String objValue, @Param("id") String objId);

	@Transactional
	@Modifying
	@Query(value="Update Candidate set duedate=:value  where candidateId=:id")
	public void updateduedate(@Param("value") String objValue, @Param("id") String objId);

	@Transactional
	@Modifying
	@Query(value="Update Candidate set project=:value  where candidateId=:id")
	public void updateproject(@Param("value") String objValue,@Param("id") String objId);

	
	@Query(value="Select c from Candidate c where c.gcm=:data")
	public List<Candidate> searchGcm(@Param("data") String inputData);

	@Query(value="Select c from Candidate c where c.position=:data")
	public List<Candidate> searchPosition(@Param("data") String inputData);

	@Query(value="Select c from Candidate c where c.project=:data")
	public List<Candidate> searchProject(@Param("data") String inputData);

	@Query(value="Select c from Candidate c where c.duedate=:data")
	public List<Candidate> searchDueDate(@Param("data") String inputData);

	@Query(value="Select c from Candidate c where c.candidateName=:data")
	public List<Candidate> searchCandidateName(@Param("data") String inputData);

	@Query(value="Select c from Candidate c where c.candidateId=:data")
	public List<Candidate> searchCandidateId(@Param("data") String inputData);
	
	
	
}
