package controllers;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import models.Student;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class StudentController extends Controller {

	public static Result allStudents() {
		List<Student> students = Student.finder.all();
		
		// To get one student pass the id of the student record.
		// Student oneStudent = Student.finder.byId("67"); // pass the student id here.
		// System.out.println(oneStudent.getName());
		
		return ok(Json.toJson(students));
	}
	
	public static Result addStudent() {
//		System.out.println("Add Student Controller");
		JsonNode json = request().body().asJson();

		/*Student s = new Student();
		s.name = json.get("name").asText();
		s.email = json.get("email").asText();
		s.age = Integer.parseInt(json.get("age").asText());*/
		
		Student s = Json.fromJson(json, Student.class);
		
		// save
		s.save();
		
		return ok(Json.toJson(s));
	}
	
	public static Result deleteStudent() {
//		System.out.println("Delete Student Method");
		
		JsonNode json = request().body().asJson();
		Student s = Json.fromJson(json, Student.class);
		
		// delete
		s.delete();
		
		return ok(Json.toJson(s));
	}
	
	public static Result updateStudent() {
//		System.out.println("Update Student Method");
		JsonNode json = request().body().asJson();
		Student s = Json.fromJson(json, Student.class);
		
		// update student
		s.update();
		
		return ok(Json.toJson(s));
	}
}
