/**
 * 
 */
package com.servicios.lxe.interfaces;

import com.servicios.lxe.dto.EmailBody;

/**
 * @author rodri
 *
 */
public interface IEmailPort {

	public boolean sendEmail(EmailBody emailBody);
}
