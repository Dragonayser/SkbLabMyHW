package javaSkbllab.HW1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

interface MyInterface {
	void doSmth();
}

class MyClass1 implements MyInterface {
	public void doSmth() {
		System.out.println("MyClass1 is doing something");
	}
}

class MyClass2 implements MyInterface {
	public void doSmth() {
		System.out.println("MyClass2 is doing something");
	}
}

@SpringBootApplication
public class Hw1Application {

	private final MyInterface bean1;
	private MyInterface bean2;

	@Autowired
	public Hw1Application(MyInterface bean1) {
		this.bean1 = bean1;
	}

	@Autowired
	public void setBean2(MyInterface bean2) {
		this.bean2 = bean2;
	}

	public static void main(String[] args) {
		SpringApplication.run(Hw1Application.class, args);
	}

	@PostConstruct
	public void init() {
		System.out.println("Initializing MyApplication");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Destroying MyApplication");
	}

}
