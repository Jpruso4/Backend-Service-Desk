package com.serviceDesk.runner.application.util;

public class Constantes {
	// Controladores
	public static final String INCIDENTE_CONTROLLER = "/incidentes";;
	// Mensajes
	public static final String MENSAJE_REGISTRAR = "Se realizó el registro correctamente";
	public static final String MENSAJE_DE_ACTUALIZACION_ESTADO_EXITOSA = "El estado ha sido actualizado correctamente";
	public static final String MENSAJE_DE_ACTUALIZACION_EXITOSA = "Sé actualizó correctamente";
	public static final String MENSAJE_ELIMINACION_EXITOSA = "Sé eliminó correctamente";
	// Codigos mensajes
	public static final int COD_RESPUESTA_REGISTRO = 001;
	public static final int COD_RESPUESTA_ACTUALIZAR_ESTADO = 002;
	public static final int COD_RESPUESTA_ACTUALIZAR = 003;
	public static final int COD_RESPUESTA_ELIMINAR = 004;
	// Estados tablas
	public static final byte ESTADO_ACTIVO = 1;
	public static final byte ESTADO_INACTIVO = 0;
	// Mensajes Error
    public static final String MENSAJE_NULO = "Sin resultados en la consulta";
    public static final String USUARIO_INEXISTENTE = "El usuario no existe";
    public static final String MAQUINA_INEXISTENTE = "La maquina no existe";
    public static final String TECNICO_INEXISTENTE = "El tecnico no existe";
    public static final String TIPO_DE_INCIDENTE_INEXISTENTE = "El tipo de incidente no existe";
}
