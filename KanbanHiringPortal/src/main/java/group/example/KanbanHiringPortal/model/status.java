package group.example.KanbanHiringPortal.model;

public class status {
	public int status;
	public String id;
	
	public status() {}
	
	public status(int v1,String v2) {
		status=v1;
		id=v2;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
