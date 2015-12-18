package com.baiwang.ofd.rest;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Controller;

import com.baiwang.ofd.dto.Message;

@Controller
@Path("/util")
public class HelloWorld {

	@Path("/hello")
    @GET
    @Produces({ MediaType.TEXT_PLAIN })
    public String hello() {
		System.out.println("welcome!");
        return "Welcome!";
    }
	
	@Path("/xml")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	public Message getXml(String message){
		
//		msg.setId(UUID.randomUUID().toString());
//		SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Message msg = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
			Unmarshaller um = jaxbContext.createUnmarshaller();  
	        msg = (Message)um.unmarshal(new ByteArrayInputStream(message.getBytes())); 
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
         
        
//		msg.setPostedAt(smp.format(new Date()));
		return msg;
		
	}
}
