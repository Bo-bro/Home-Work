package org.demo.helpers;

import org.demo.models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
//            return new Configuration()
//                    .configure("D:\\Repo\\second_app_dao-practice\\src\\main\\resouces\\hibernate.cfg.xml").buildSessionFactory();


            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                    .configure( "hibernate.cfg.xml" )
                    .build();
            Metadata metadata=  new MetadataSources(standardRegistry)
                    .addAnnotatedClass(Office.class)
                    .addAnnotatedClass(Manager.class)
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(Order.class)
                    .addAnnotatedClass(Product.class)

                   .addAnnotatedClass(Salesreps.class)
                    .addResource( "Office.hbm.xml" )
                    .addResource( "Customer.hbm.xml" )
                    .addResource( "Order.hbm.xml" )
                   .addResource( "Product.hbm.xml" )
                  .addResource( "Salesreps.hbm.xml" )


                    .getMetadataBuilder()
                   // .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
                    .build();

            SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()

                    .build();

            return sessionFactory;
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

}