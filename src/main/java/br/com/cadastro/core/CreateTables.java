package br.com.cadastro.core;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.com.cadastro.model.Candidato;

public final class CreateTables {

	public static void createTable(){
		Configuration configuration = new Configuration();
		
		configuration.addAnnotatedClass(Candidato.class);
		
		configuration.configure();
		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.create(true, true);
	}
}
