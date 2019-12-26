package com.fis.springcloudconfigserver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.core.io.UrlResource;
import org.springframework.util.StringUtils;

public class TestClass {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		File remote = new UrlResource(StringUtils
				.cleanPath("file://spring-cloud-config-server/spring_config_git_repo/Limit-Service.properties"))
						.getFile();
		System.out.println("remote::" + remote.isDirectory());
	}
}
