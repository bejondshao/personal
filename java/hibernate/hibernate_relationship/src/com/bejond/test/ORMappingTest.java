package com.bejond.test;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by bejond on 16-1-19.
 */
public class ORMappingTest {
	private static SessionFactory sessionFactory;

	@BeforeClass
	public static void beforeClass() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}

	@Test
	public void testSchemaExport() {
		ServiceRegistry serviceRegistry =
			new StandardServiceRegistryBuilder().configure().build();

		MetadataImplementor metadataImplementor =
			(MetadataImplementor) new MetadataSources(serviceRegistry).buildMetadata();

		SchemaExport schemaExport = new SchemaExport(serviceRegistry, metadataImplementor);
		schemaExport.create(true, true);
	}
}
