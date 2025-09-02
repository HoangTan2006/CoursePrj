package iuh.fit.ktpm;

/**
 * Day la class mo ta thong tin khoa hoc
 * 
 * @author Le Hoang Tan
 * @version 1.0
 * @since 2-Sep-2025 6:00:10 PM
 */
public class Course {
	private String id;
	private String title;
	private int credit;
	private String department;
	
	public Course() {}

	public Course(String id, String title, int credit, String department) {
		setId(id);
		setTitle(title);
		setCredit(credit);
		this.department = department;
	}

	//Getter
	public String getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getCredit() {
		return credit;
	}
	
	public String getDepartment() {
		return department;
	}

	//Setter
	public void setId(String id) {
		if (id.length() < 3) {
			throw new IllegalArgumentException("Id phai co tren 3 ky tu");
		}
		
		for (char c : id.toCharArray()) {
			if (!Character.isLetterOrDigit(c)) {
				throw new IllegalArgumentException("Id chi co the chua chu cai hoac chu so");
			}
		}
	
		this.id = id;
	}

	public void setTitle(String title) {
		if (title == null || title.isEmpty()) {
			throw new IllegalArgumentException("Ten khong duoc de trong");
		}
		this.title = title;
	}

	public void setCredit(int credit) {
		if (credit <= 0) {
			throw new IllegalArgumentException("So tin chi phai lon hon 0");
		}
		this.credit = credit;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return String.format("|%-6s |%-35s |%-8s |%-30s|%n", id, title, credit, department);
	}
}
