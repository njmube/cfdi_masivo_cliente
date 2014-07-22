package com.telcel.gsrh.cfdi.masivo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.telcel.gsrh.cfdi.masivo.rmi.RmiService;

@Configuration
public class ConfiguracionCliente {

	@Bean(name="reciboRmiBean")
	public RmiProxyFactoryBean rmiProxyFactoryBean() {
		RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
		rmiProxyFactoryBean.setServiceUrl("rmi://10.191.148.70:1099/reciboService");
		//rmiProxyFactoryBean.setServiceUrl("rmi://10.188.82.10:1099/reciboService");
		rmiProxyFactoryBean.setServiceInterface(RmiService.class);
		rmiProxyFactoryBean.setRefreshStubOnConnectFailure(true);
		
		return rmiProxyFactoryBean;
	}
}
