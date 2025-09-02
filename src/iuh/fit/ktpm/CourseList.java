package iuh.fit.ktpm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Day la class quan li danh sach khoa hoc
 * 
 * @author Le Hoang Tan
 * @version 1.0
 * @since 2-Sep-2025 6:19:10 PM
 */
public class CourseList {
	private int count;
	private Course[] courses;
	
	public CourseList(int size) {		
		if (size <= 0) {
			throw new IllegalArgumentException("Length of the array must be greater than 0");
		}
		
		this.count = 0;
		this.courses = new Course[size];
	}

	//Getter
	public Course[] getCourses() {
		return Arrays.copyOf(courses, count);
	}
	
	public boolean addCourse(Course newCourse) {
		if (count >= this.courses.length) {
			throw new IllegalStateException("Course list is full");
		}
		
		if (exists(newCourse)) return false;
			
		this.courses[count++] = newCourse;
		return true;
	}
	
	private boolean exists(Course course) {
		for (int i = 0; i < count; i++) {
			if (courses[i].getId().equals(course.getId())) {
				return true;
			}
		}
		return false;
	}
	
	public String findDepartmentWithMostCourses() {
		if (count == 0) return null;
		Map<String, Integer> departmentCourses = new HashMap();

		for (int i = 0; i < count; i++) {
			departmentCourses.merge(courses[i].getDepartment(), 1, Integer::sum);
		}
		return Collections.max(departmentCourses.entrySet(), Map.Entry.comparingByKey()).getKey();
	}
	
	public Course[] findMaxCreditCourses() {
		Course[] sortCourseByCredit = Arrays.copyOf(courses, count);
		Arrays.sort(sortCourseByCredit, Comparator.comparingInt((Course c) -> c.getCredit()).reversed());
		
		int minQuantity = Math.min(3, count); // default min = 3, min = count if min > count
		return Arrays.copyOfRange(sortCourseByCredit, 0, minQuantity);
	}
	
	public boolean removeCourse(String id) {
		for (int i = 0; i < count; i++) {
			if (courses[i].getId().equals(id)) {
				for (int j = i + 1; j < count; j++) {
					courses[j - 1] = courses[j];
				}
				courses[--count] = null;
				return true;
			}
		}
		return false;
	}
	
	public Course[] searchCourse(String title) {
		Course[] coursesRes = new Course[count];
		int i = 0;
		for (int j = 0; j < count; j++) {
			if (courses[j].getTitle().toLowerCase().contains(title.toLowerCase())) {
				coursesRes[i] = courses[j];
				i++;
			}
		}
		return (i > 0) ? Arrays.copyOfRange(coursesRes, 0, i) : null;
	}
	
	public Course[] searchByDepartment(String department) {
		Course[] coursesRes = new Course[count];
		int i = 0;
		for (int j = 0; j < count; j++) {
			if (courses[j].getDepartment().equals(department)) {
				coursesRes[i] = courses[j];
				i++;
			}
		}
		return (i > 0) ? Arrays.copyOfRange(coursesRes, 0, i) : null;
	}
	
	public Course searchCourseById(String id) {
		for (int i = 0; i < count; i++) {
			if (courses[i].getId().equals(id)) {
				return courses[i];
			}
		}
		return null;
	}
	
	public Course[] sortCourses() {
		Course[] sortCourseByTitle = Arrays.copyOf(courses, count);
		Arrays.sort(sortCourseByTitle, Comparator.comparing(c -> c.getTitle()));
		return sortCourseByTitle;
	}
	
}