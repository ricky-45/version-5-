package group.example.KanbanHiringPortal.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import group.example.KanbanHiringPortal.Repository.CandidateRepository;
import group.example.KanbanHiringPortal.Repository.CommentRepository;
import group.example.KanbanHiringPortal.Repository.ImageRepository;
import group.example.KanbanHiringPortal.Repository.UserRepository;
import group.example.KanbanHiringPortal.model.Candidate;
import group.example.KanbanHiringPortal.model.Image;
import group.example.KanbanHiringPortal.model.ImageUploadResponse;
import group.example.KanbanHiringPortal.model.User;
import group.example.KanbanHiringPortal.model.comment;
import group.example.KanbanHiringPortal.model.search;
import group.example.KanbanHiringPortal.util.ImageUtility;
import lombok.Builder;

@Service
public class KanbanServices {
	
	@Autowired
	UserRepository Urepo;
	
	
	@Autowired
	CandidateRepository CRepo;
	
	@Autowired
	ImageRepository ImgRepo;
	
	@Autowired
	CommentRepository CoRepo;
	
	public User saveUser(User user) {
		return Urepo.save(user);
	}
	
	
	public User fetchUserByDasID(String dasId) {
		return Urepo.findByDasId(dasId);
	}
	
	
	public User fetchUserByDasIDAndPassword(String dasId,String password) {
		System.out.println("Login Service Hit");
		return Urepo.findByDasIdAndPassword(dasId, password);
	}
	
	public List<Candidate> findall(){
		return CRepo.findAll();
	}
	
	public void update(int status,String id) {
		System.out.println("The service hit");
		
		CRepo.update(status,id);
	}


	public Candidate getCandidateData(Candidate object) {
		String value=object.getCandidateId();
		return CRepo.returnObj(value);
	}


	public Candidate fetchUserByCandidateID(String Id) {
		// TODO Auto-generated method stub
		return CRepo.findByCandidateId(Id);
	}


	public Candidate saveCandidate(Candidate canObj) {
		// TODO Auto-generated method stub
		return CRepo.save(canObj);
	}


	public void updateGcm(String objValue, String objId) {
		// TODO Auto-generated method stub
		CRepo.updategcm(objValue,objId);
		
	}


	public void updatePosition(String objValue, String objId) {
		// TODO Auto-generated method stub
		System.out.println("Update Position Hit");
		System.out.println(objValue);
		System.out.println(objId);
		CRepo.updateposition(objValue,objId);
	}


	public void updateDuedate(String objValue, String objId) {
		// TODO Auto-generated method stub
		CRepo.updateduedate(objValue,objId);
		
	}


	public void updateProject(String objValue, String objId) {
		// TODO Auto-generated method stub
		CRepo.updateproject(objValue,objId);
		
	}


	public List<Candidate> searchingData(search searchObj) {
		// TODO Auto-generated method stub
		if(searchObj.getFilterValue().equals("gcm")) {
			return CRepo.searchGcm(searchObj.getInputData());
		}
		else if(searchObj.getFilterValue().equals("position")) {
			return (List<Candidate>) CRepo.searchPosition(searchObj.getInputData());
		}
		else if(searchObj.getFilterValue().equals("project")) {
			return CRepo.searchProject(searchObj.getInputData());
		}
		else if(searchObj.getFilterValue().equals("duedate")) {
			return CRepo.searchDueDate(searchObj.getInputData());
		}
		else if(searchObj.getFilterValue().equals("candidatename")) {
			return CRepo.searchCandidateName(searchObj.getInputData());
		}
		else if(searchObj.getFilterValue().equals("candidateid")) {
			return CRepo.searchCandidateId(searchObj.getInputData());
		}
		
		
		return null;
		

	}


	public List<comment> getAllComments(comment obj) {
		// TODO Auto-generated method stub
		
		return CoRepo.findAllComment(obj.getId());
		
	}


	public comment saveComment(comment comObj) {
		// TODO Auto-generated method stub
		return CoRepo.save(comObj);
	}


	public List<comment> getListOfComments(String id) {
		// TODO Auto-generated method stub
		return CoRepo.findAllComment(id);
	}


	public List<Candidate> writeSearchToCsv(search searchObj) {
		
		// TODO Auto-generated method stub
			List<Candidate> cand = null;
			if(searchObj.getFilterValue().equals("gcm")) {
				return CRepo.searchGcm(searchObj.getInputData());
			}
			else if(searchObj.getFilterValue().equals("position")) {
				return CRepo.searchPosition(searchObj.getInputData());
			}
			else if(searchObj.getFilterValue().equals("project")) {
				return CRepo.searchProject(searchObj.getInputData());
			}
			else if(searchObj.getFilterValue().equals("duedate")) {
				return CRepo.searchDueDate(searchObj.getInputData());
			}
			else if(searchObj.getFilterValue().equals("candidatename")) {
                return CRepo.searchCandidateName(searchObj.getInputData());
            }
            else if(searchObj.getFilterValue().equals("candidateid")) {
                return CRepo.searchCandidateId(searchObj.getInputData());
            }
			return cand;
		
	
	}


	public Image saveCandidateImage(Image image) {
		// TODO Auto-generated method stub
		return ImgRepo.save(image);
	}
	
	public List<Candidate> generateMonthlyReport(String inputValue) {
		// TODO Auto-generated method stub
		int inputValue1=Integer.parseInt(inputValue);
		return CRepo.findMonthlyData(inputValue1);
	}


	public List<Candidate> generateQuaterlyReport(String inputValue) {
		// TODO Auto-generated method stub
		int inputValue1=Integer.parseInt(inputValue);
		return CRepo.findQuaterlyData(inputValue1);
	}


	public List<Candidate> generateAverageReport(String inputValue)  {
		// TODO Auto-generated method stub
		   // TODO Auto-generated method stub
//        int average=0;
//        int sumOfDays=0;
//        List<Candidate> candList=CRepo.findLocationData(inputValue);
//        for(int i=0;i<candList.size();i++) {
//            Date duedate=new SimpleDateFormat("dd/mm/yyyy").parse(candList.get(i).getDuedate());
//            java.util.Date utilDate=new java.util.Date(candList.get(i).getDate().getTime());
		
        return null;
	}
			




	}
	

