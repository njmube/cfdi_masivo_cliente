package com.telcel.gsrh.cfdi.masivo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.telcel.gsrh.cfdi.masivo.config.ConfiguracionCliente;
import com.telcel.gsrh.cfdi.masivo.domain.SolicitudEnvioRecibo;
import com.telcel.gsrh.cfdi.masivo.domain.SolicitudUsuario;
import com.telcel.gsrh.cfdi.masivo.rmi.RmiService;

public class ClienteRmi {
	private static ApplicationContext context;
	private RmiService reciboRmiBean;
	
	public ClienteRmi() {
		
	}
	
	public List<String> generarRecibosLocalidad(SolicitudUsuario solicitud) throws Exception {
		context = new AnnotationConfigApplicationContext(ConfiguracionCliente.class);
		reciboRmiBean = context.getBean("reciboRmiBean", RmiService.class);
		
		return reciboRmiBean.generarRecibosLocalidad(solicitud);
	}
	
	public void generarEnviarRecibos(SolicitudEnvioRecibo solicitud) {
		context = new AnnotationConfigApplicationContext(ConfiguracionCliente.class);
		reciboRmiBean = context.getBean("reciboRmiBean", RmiService.class);
		
		reciboRmiBean.generarEnviarRecibos(solicitud);
	}
}
