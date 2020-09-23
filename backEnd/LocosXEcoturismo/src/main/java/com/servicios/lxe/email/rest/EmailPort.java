/**
 * 
 */
package com.servicios.lxe.email.rest;

/**
 * @author rodri
 *
 */
public interface EmailPort {

	public boolean sendEmail(EmailBody emailBody);
}
