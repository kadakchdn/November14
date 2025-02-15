package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomMethods 
{
	public static String getRamdomEmail()
	{
	  String name=RandomStringUtils.randomAlphabetic(4);
	  
	  String email=name+"@gmail.com";
	  
	  return email;
	}

}
