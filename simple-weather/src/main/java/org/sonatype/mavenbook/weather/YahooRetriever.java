package org.sonatype.mavenbook.weather;

import java.io.InputStream;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

public class YahooRetriever {

	private static Logger log = Logger.getLogger(YahooRetriever.class);

	public InputStream retrieve(String zipcode) throws Exception {
		log.info( "Retrieving Weather Data" );
		String url = "http://weather.yahooapis.com/forecastrss?p=" + zipcode;
		//URLConnection conn = new URL(url).openConnection();
		
		/**************************************************************/
		String proxyHost="10.10.2.80";          //代理Ip地址  
        int port=8080;                         //代理提供的开放端口  
          
        // 设置代理 地址和密码  
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, port));  
  
        // 设置代理的密码验证  
        Authenticator auth = new Authenticator() {  
            private PasswordAuthentication pa =   
                new PasswordAuthentication("m083399", "2014wuxgz".toCharArray());  
            @Override  
            protected PasswordAuthentication getPasswordAuthentication() {  
                return pa;  
            }  
        };  
        
        Authenticator.setDefault(auth);  
        // 打开连接  
        System.out.println("connecting...");  
		URLConnection conn = new URL(url).openConnection(proxy);
		/**************************************************************/
		
		return conn.getInputStream();
	}

}
