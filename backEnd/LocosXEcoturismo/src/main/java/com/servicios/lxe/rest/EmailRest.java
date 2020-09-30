/**
 * 
 */
package com.servicios.lxe.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.servicios.lxe.dto.EmailBody;
import com.servicios.lxe.interfaces.IEmailPort;


/**
 * @author rodri
 *
 */
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/email")
public class EmailRest {

	@Autowired
	private IEmailPort emailPort;
	
	@PostMapping("/send")
	@ResponseBody
	public boolean SendEmail(@RequestBody EmailBody emailBody)  {
		return emailPort.sendEmail(emailBody);
	}
}
