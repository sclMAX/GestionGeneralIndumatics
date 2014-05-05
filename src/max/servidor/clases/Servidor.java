package max.servidor.clases;

import max.clases.abmProperties;

import com.db4o.ObjectServer;
import com.db4o.cs.Db4oClientServer;
import com.db4o.cs.config.ServerConfiguration;

public class Servidor {

	private static Servidor instance = null;
	private static ObjectServer db = null;
	private static String DataBaseFile = null;
	private static int port = 8080;

	private Servidor() {
	}

	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new Servidor();
			instance.startServer();
		}
	}

	public void startServer() {
		DataBaseFile = abmProperties.getPropertie("DataBaseFile");
		port = Integer.parseInt(abmProperties.getPropertie("port"));
		db = Db4oClientServer.openServer(getConfig(), DataBaseFile, port);
	}

	public void stopServer() {
		if (db != null) {
			db.close();
		}
	}

	private static ServerConfiguration getConfig() {
		ServerConfiguration config = Db4oClientServer.newServerConfiguration();
		// DETALLES DE CONFIGURACION AQUI!!
		return config;
	}

	public static ObjectServer getInstance() {
		if (instance == null) {
			createInstance();
		}
		return db;
	}

}
