package com.mruruc;

import com.mruruc.models.Author;
import com.mruruc.models.Course;
import com.mruruc.models.Lecture;
import com.mruruc.models.embeded.DeliveryAddress;
import com.mruruc.models.embeded.Order;
import com.mruruc.models.embeded.OrderId;
import com.mruruc.models.resource.Video;
import com.mruruc.repositories.AuthorRepository;
import com.mruruc.repositories.CourseRepository;
import com.mruruc.repositories.OrderRepository;
import com.mruruc.repositories.VideoRepository;
import com.mruruc.services.AuthorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
//@PropertySources(
//		{
//				@PropertySource("classpath:application-mysql.properties")
//				// @PropertySource("classpath:application-postgres.properties")
//		}
//)
public class DiveToJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiveToJpaApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AuthorService service, CourseRepository repository){
		return args -> {
//			 var author = new Author("John", "Doe", "john_doe21@gmail.com", LocalDate.of(1999, 1, 1),
//					 List.of(new Course("JPA and ORM","Learning JPA with SpringBoot")
//							 ,new Course("Hibernate and ORM","Object Relation Mapping Tool")));
//			 service.addAuthor(author);
			// service.authors().forEach(System.out::println);

			repository.findAll().forEach(System.out::println);
			System.out.println("test");
		};
	}



}
