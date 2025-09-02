package iuh.fit.ktpm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Day la class chay chuong trinh quan li khoa hoc
 * 
 * @author Le Hoang Tan
 * @version 1.0
 * @since 2-Sep-2025 7:19:10 PM
 */
public class Test {
	public static void main(String[] args) {
		CourseList courseList = new CourseList(100);
		String header = String.format(
				"+-------+------------------------------------+---------+------------------------------+\n" +
				"|%-6s |%-35s |%-8s |%-30s|%n" +
				"+-------+------------------------------------+---------+------------------------------+",
				"Id", "Title", "Credit", "Department");
		String endLine = "+-------+------------------------------------+---------+------------------------------+\n";
		initData(courseList);

		int option;
		Scanner scanner = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("\n----Hệ thống quản lí khóa học----\n");
				System.out.println("1. Thêm khóa học\n");
				System.out.println("2. Xem danh sách khóa học\n");
				System.out.println("3. Xóa khóa học theo ID\n");
				System.out.println("4. Tìm khóa học theo ID\n");
				System.out.println("5. Tìm khóa học theo ten\n");
				System.out.println("6. Tìm khóa học theo khoa\n");
				System.out.println("7. Sắp xếp khóa học theo ten\n");
				System.out.println("8. Tìm 5 khóa học có số tín chỉ lớn nhất\n");
				System.out.println("9. Tìm khoa có nhiều khóa học nhất\n");
				System.out.println("0. Thoát\n");

				option = scanner.nextInt();
				scanner.nextLine();
				
				switch (option) {

					case 1: {
						String id, title, department;
						int credit;
					
						System.out.print("Nhap id khoa hoc: ");
						id = scanner.nextLine();

						System.out.print("Nhap ten khoa hoc: ");
						title = scanner.nextLine();

						System.out.print("Nhap so tin chi khoa hoc: ");
						credit = scanner.nextInt();
						scanner.nextLine();

						System.out.print("Nhap khoa phu trach khoa hoc: ");
						department = scanner.nextLine();

						Course course = new Course(id, title, credit, department);

						if (courseList.addCourse(course)) {
							System.out.println("Them khoa hoc thanh cong");
						} else {
							System.out.println("Them khoa hoc that bai");
						}
						
						System.out.println("Nhap enter de tiep tuc");
						scanner.nextLine();
						break;
					}

					case 2: {
						System.out.println(header);
						for (Course c : courseList.getCourses()) {
							System.out.print(c);
						}
						System.out.println(endLine);
						
						System.out.println("Nhap enter de tiep tuc");
						scanner.nextLine();
						break;
					}
					
					case 3: {
						
						System.out.print("Nhap id khoa hoc: ");
						String id = scanner.nextLine();
						
						if (courseList.removeCourse(id)) {
							System.out.println("Xoa thanh cong");							
						} else {
							System.err.print("Xoa khong thanh cong, id khong ton tai");							
						}
						
						System.out.println("Nhap enter de tiep tuc");
						scanner.nextLine();
						break;
					}
					
					case 4: {
						System.out.print("Nhap id khoa hoc: ");
						String id = scanner.nextLine();
						
						Course course = courseList.searchCourseById(id);
						
						if (course != null) {
							System.out.println(header);
							System.out.print(course);
							System.out.println(endLine);
						} else {
							System.out.println("Id khong ton tai");
						}
						
						System.out.println("Nhap enter de tiep tuc");
						scanner.nextLine();
						break;
					}
					
					case 5: {
						System.out.print("Nhap ten khoa hoc: ");
						String title = scanner.nextLine();
						
						Course[] course = courseList.searchCourse(title);
						
						if (course != null) {
							System.out.println(header);
							for (Course c : course) {
								System.out.print(c);
							}
							System.out.println(endLine);
						} else {
							System.out.println("Khong the tim thay khoa hoc lien quan");
						}
						
						System.out.println("Nhap enter de tiep tuc");
						scanner.nextLine();
						break;
					}
					
					case 6: {
						System.out.print("Nhap ten khoa phu trach: ");
						String department = scanner.nextLine();
						
						Course[] courses = courseList.searchByDepartment(department);
						
						if (courses != null) {
							System.out.println(header);
							for (Course c : courses) {
								System.out.print(c);
							}
							System.out.println(endLine);
						} else {
							System.out.println("Khong the tim thay khoa hoc lien quan");
						}
						
						System.out.println("Nhap enter de tiep tuc");
						scanner.nextLine();
						break;
					}
					
					case 7: {
						Course[] courses = courseList.sortCourses();
						if (courses != null) {
							System.out.println(header);
							for (Course c : courses) {
								System.out.print(c);
							}
							System.out.println(endLine);
						} else {
							System.out.println("Danh sach khoa hoc hien dang trong");
						}
						
						System.out.println("Nhap enter de tiep tuc");
						scanner.nextLine();
						break;
					}
					
					case 8: {
						Course[] courses = courseList.findMaxCreditCourses();
						if (courses != null) {
							System.out.println(header);
							for (Course c : courses) {
								System.out.print(c);
							}
							System.out.println(endLine);
						} else {
							System.out.println("Danh sach khoa hoc hien dang trong");
						}
						
						System.out.println("Nhap enter de tiep tuc");
						scanner.nextLine();
						break;
					}
					
					case 9: {
						String department = courseList.findDepartmentWithMostCourses();
						
						if (department != null) {
							System.out.printf("Khoa co nhieu khoa hoc nhat: %s\n", department);
						} else {
							System.out.println("Danh sach khoa hoc hien dang trong");
						}
						
						System.out.println("Nhap enter de tiep tuc");
						scanner.nextLine();
						break;
					}
					
					case 0: {
						System.out.println("Da thoat chuong trinh");
						System.exit(0);
						break;
					}
					
					default: 
						System.out.println("Vui long chon 1 trong cac lua chon trong menu");
				}
			} catch (RuntimeException re) {
				System.err.println(re.getMessage());
			}
		}
	}
	
	private static void initData(CourseList courseList) {
		Course[] coursesData = new Course[] {
	            new Course("C001", "Introduction to Programming", 3, "Computer Science"),
	            new Course("C002", "Data Structures", 4, "Computer Science"),
	            new Course("C003", "Database Systems", 3, "Information Technology"),
	            new Course("C004", "Operating Systems", 4, "Computer Science"),
	            new Course("C005", "Computer Networks", 3, "Information Technology"),
	            new Course("C006", "Software Engineering", 3, "Software"),
	            new Course("C007", "Artificial Intelligence", 4, "Computer Science"),
	            new Course("C008", "Web Development", 3, "Information Technology"),
	            new Course("C009", "Mobile Application Development", 3, "Software"),
	            new Course("C010", "Cybersecurity Fundamentals", 3, "Information Security")
	        };
		
		try {
			for (Course course : coursesData) {
				if (!courseList.addCourse(course)) {
					System.out.printf("\nThem khoa hoc %s khong thanh cong\n", course.getId());
				}
			}
		} catch (IllegalStateException ex) {
			System.err.print(ex.getMessage());
		}
		
	}
}
