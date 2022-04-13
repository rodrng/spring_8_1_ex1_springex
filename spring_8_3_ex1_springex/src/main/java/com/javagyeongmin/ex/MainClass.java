package com.javagyeongmin.ex;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���������� �Է����ּ���(dev, run):");
		Scanner scanner = new Scanner(System.in);
		
		String config = null;
		String str = scanner.next();
		
		if(str.equals("dev")) {
			config = "dev";
		} else {
			config = "run";
		}
		
		scanner.close();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load("applicationCTX_dev.xml","applicationCTX_run.xml");
		
		ServerInfo s_info = ctx.getBean("serverInfo",ServerInfo.class);
		System.out.println("ip:" + s_info.getIpNum());
		System.out.println("port:" + s_info.getPortNum());
		
		ctx.close();
		
	}

}