package br.senai.sc.pwAvancada.connection;

import javax.faces.bean.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

@ApplicationScoped
public class ConectionFactory {

	private static EntityManager manager;
    

    public static EntityManager getConnection() {
    	EntityManagerFactory emf = null;
        manager = null;
        emf = Persistence.createEntityManagerFactory("escolaEducacionalPU");
        manager = emf.createEntityManager();
        if (!manager.isOpen()) {
        	JOptionPane.showMessageDialog(null, "Conexão fechada");
        }
        return manager;
    }
}
