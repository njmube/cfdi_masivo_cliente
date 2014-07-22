package com.telcel.gsrh.cfdi.masivo;

import java.util.List;
import org.apache.log4j.Logger;

import com.telcel.gsrh.cfdi.masivo.domain.SolicitudEnvioRecibo;
import com.telcel.gsrh.cfdi.masivo.domain.SolicitudUsuario;

public class App {
	private static Logger logger = Logger.getLogger(App.class);
	
    @SuppressWarnings("all")
	public static void main( String[] args ) {
    	//probarRecibosPorLocalidad(args);
    	
    	probarEnvioRecibos();
    }
    
    public static void probarRecibosPorLocalidad(String[] args) {
    	ClienteRmi clienteRmi = new ClienteRmi();
    	SolicitudUsuario solicitud = new SolicitudUsuario();
    	solicitud.setAnnio(2014);
    	solicitud.setCveLocalidad(args[0]);
    	solicitud.setPeriodo(12);
		//solicitud.setFormato("pdf");
		solicitud.setFormato("xml");
		solicitud.setRfcEmpresa("RDI841003QJ4");
    	
    	try {
    		List<String> archivosZip = clienteRmi.generarRecibosLocalidad(solicitud);
    		
    		if(archivosZip != null) {
    			for(String archivoZip : archivosZip) {
    				logger.info("Archivo creado : " + archivoZip);
    			}
    		}
    		
    		logger.info("Archivos generados para la solicitud " + solicitud);
        } catch (Exception e) {
            System.err.println("Error al procesar masivamente los recibos de la solicitud: " + solicitud);
            e.printStackTrace();
        }
    }
    
    public static void probarEnvioRecibos() {
    	ClienteRmi clienteRmi = new ClienteRmi();
    	SolicitudEnvioRecibo solicitud = new SolicitudEnvioRecibo();
    	solicitud.setAnnio(2014);
    	solicitud.setPeriodo(12);
    	solicitud.setNoEmpleado(-1);
    	solicitud.setRegion(0);
    	solicitud.setTpRecibo(245);
    	
    	try {
    		clienteRmi.generarEnviarRecibos(solicitud);
    		
    		logger.info("Solicitud procesada");
        } catch (Exception e) {
            System.err.println("Error al procesar masivamente los recibos de la solicitud: " + solicitud);
            e.printStackTrace();
        }
    }
}
