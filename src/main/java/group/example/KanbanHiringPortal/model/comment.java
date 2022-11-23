package group.example.KanbanHiringPortal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class comment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int pId;
	
	@Column(name="id")
	public String id;
	
	@Column(name="comment")
	public String comment;
	
	public comment() {
		
	}
	
	public comment(String v1,String v2) {
		id=v1;
		comment=v2;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
