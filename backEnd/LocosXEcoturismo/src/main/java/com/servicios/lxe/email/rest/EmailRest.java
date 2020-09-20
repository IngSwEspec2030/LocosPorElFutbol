/**
 * 
 */
package com.servicios.lxe.email.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author rodri
 *
 */
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/email")
public class EmailRest {

	@Autowired
	private EmailPort emailPort;
	
	@PostMapping("/send")
	@ResponseBody
	public boolean SendEmail(@RequestBody EmailBody emailBody)  {
		return emailPort.sendEmail(emailBody);
	}
}
