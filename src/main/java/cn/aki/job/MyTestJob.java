package cn.aki.job;

import org.springframework.stereotype.Component;

@Component("myTestJob")
public class MyTestJob {
	public void execute(){
		System.err.println("this is myTestJob");
	}
}
