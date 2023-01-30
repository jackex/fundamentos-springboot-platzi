package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MiPrimerBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.bean.OperacionMatematica;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MiPrimerBean miPrimerBean;
	private OperacionMatematica operacionMatematica;
	private MyBeanWithProperties myBeanWithProperties;

	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MiPrimerBean miPrimerBean, OperacionMatematica operacionMatematica, MyBeanWithProperties myBeanWithProperties){
		this.componentDependency = componentDependency;
		this.miPrimerBean = miPrimerBean;
		this.operacionMatematica = operacionMatematica;
		this.myBeanWithProperties = myBeanWithProperties;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args){
		this.componentDependency.hablar();
		this.miPrimerBean.print();
		this.operacionMatematica.realizarOperacion(10);
		System.out.println(this.myBeanWithProperties.function());
	}
}
