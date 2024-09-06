package ir.freeland.springboot.xml;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


import generated.Student;
import generated.Course;
import generated.Professor;


@SpringBootApplication
@EntityScan("ir.freeland.springboot.persistence.model")
public class XMLApplication {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		SpringApplication.run(XMLApplication.class, args);
		
		
		//student
		 File xmlfile = new ClassPathResource("Student.xml").getFile();
		 XmlMapper xmlMapper = new XmlMapper();
		 Student s = xmlMapper.readValue(xmlfile, Student.class);
		 
		 		 
		 Student s1 = new Student();
		 s1.setId("9913012006");
		 s1.setFirstName("Shaghayegh");
		 s1.setLastName("Seifi");
		 s1.setAge(23);
		 xmlMapper.writeValue(new File("Generated_Student.xml"), s1);
	
		 
		 //course		
		 xmlfile = new ClassPathResource("Course.xml").getFile();
		 Course c = xmlMapper.readValue(xmlfile, Course.class);
		 
	
		 Course c1 = new Course();
		 c1.setId("C101");
		 c1.setTitle("Programming");
		 c1.setCredits(3);
		 c1.setClassroom("117");
		 xmlMapper.writeValue(new File("Genareted_Course.xml"), c1);
		 
		 
		 
	     //Professor	
		  File jfile = new ClassPathResource("Professor.json").getFile();
		  ObjectMapper mapper = new ObjectMapper();
	      var t = mapper.readValue(jfile,  Professor.class);
		  Professor p1=new Professor();
		  p1.setFirstName("Dr.Bahram");
		  p1.setLastName("Sadeghi");
		  p1.setDepartment("Computer Science");
		  mapper.writeValue(new File("Generated_Professor.json"), p1); 
	
}		 

}
