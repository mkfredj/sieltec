package service.impl;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import service.IMailService;
import dao.IMailDao;

@ManagedBean(name = "mailService", eager = true)
@ApplicationScoped
public class MailService implements IMailService, Serializable {

	private Logger logger = LogManager.getLogger(this.getClass().getName());
	
	@ManagedProperty(value = "#{mailDao}")
	private IMailDao mailDao;

	public IMailDao getMailDao() {
		return mailDao;
	}

	public void setMailDao(IMailDao mailDao) {
		this.mailDao = mailDao;
	}
	
	public MailService() {
		super();
		logger.trace("MailService instanciated");
	}

	@Override
	public void sendMail(String to, String subject, String body) {
		mailDao.sendMail(to, subject, body);
	}

}
