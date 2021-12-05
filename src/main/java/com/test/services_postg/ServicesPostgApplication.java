package com.test.services_postg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.Normalizer;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@SpringBootApplication
public class ServicesPostgApplication {

	

	public static void main(String[] args) throws ParseException {
		BCryptPasswordEncoder B_CRIPT = new BCryptPasswordEncoder();

		SpringApplication.run(ServicesPostgApplication.class, args);

		String a = "Angola é um pais muíúto básico para fázer coisas conceição";
		String b = "0004";
		System.out.println(gerarUserName(a));
		System.out.println(gerarPassword());
		System.out.println(gerarIdenficationNumber(b));
		System.out.println(gere());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("dd/MM/yyyy -> "+dtf.format(LocalDateTime.now()));

	}
	
	public static String gere(){

		String f = "ACCN-0001";
		String[] g = f.split("-");
		StringBuilder c = new StringBuilder(g[0] + "-" + gerarIdenficationNumber(g[g.length - 1]) + "funciona");
		return c.toString();
	}

	public static String gerarUserName(String nome){
		StringBuilder c = new StringBuilder();
		String[] b = nome.split(" ");
		c = new StringBuilder(b[0] + " " + b[b.length-1]);
		return Normalizer.normalize(c, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

	public static String gerarPassword(){
		BCryptPasswordEncoder B_CRIPT = new BCryptPasswordEncoder();
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"abcdefghijklmnopqrstuvwxyz!@#$%&";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(10);
		for (int i = 0; i < 6; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return B_CRIPT.encode(sb.toString());
	}

	public static String gerarIdenficationNumber(String a){
		var s = "";
		var num = Integer.parseInt(a);
		num++;
		String newNum = Integer.toString(num);
		for (int i = newNum.length(); i < 4; i++) {
			s += "0";
		}
		var concatNum = s + newNum;
		return concatNum;
	}


}
