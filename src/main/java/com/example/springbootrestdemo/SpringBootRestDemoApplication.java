package com.example.springbootrestdemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@SpringBootApplication
public class SpringBootRestDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootRestDemoApplication.class, args);

		System.out.println("Hello World");
	}

}


class Coffee {
	// final = readonly, const
	private String id;
	private String name;

	// 생성자 타입1
	public void Coffee(String name){
		this(UUID.randomUUID.toString(), name);
	}

	public void Coffee(String id, String name){
		this.id = id;
		this.name = name;
	}


	// 생성자 타입2
	public String getId(){
		return this.id; // 52p 예제 this 붙여야하지 않나?
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}


}


@RestController
class RestApiDemoController {
	private final List<Coffee> coffees = new ArrayList<>();

	public RestApiDemoController(){
		coffees.addAll(List.of(
				new Coffee()
//				new Coffee("Americano"),
//				new Coffee("Lattee"),
//				new Coffee("Orange Juice")
		));
	}

	@RequestMapping(value ="/coffees", method = RequestMethod.GET) // GETMapping(URI)
	List<Coffee> getCoffees(){
		return coffees;
	}
}