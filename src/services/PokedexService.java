package services;

import config.HibernateConfig;
import models.Pokedex;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.w3c.dom.Text;

import java.util.List;

public class PokedexService {

    public void crearPokedex(String nome, String misc, double peso){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Pokedex novaPokedex = new Pokedex();
            novaPokedex.setNome(nome);
            novaPokedex.setMisc(misc);
            novaPokedex.setPeso(peso);
            session.save(novaPokedex);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao crear a Pokedex: " + e.getMessage());
        }
    }

    public List<Pokedex> listarPokedex(){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Pokedex", Pokedex.class).getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao lista-los gatos: " + e.getMessage());
            return null;
        }
    }

    public void actualizarPokedex(Pokedex pokedex) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(pokedex);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao actualizar a pokedex: " + e.getMessage());
        }
    }

    public void eliminarAllPokedex() {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Ejecuta la consulta de borrado masivo y devuelve el número de filas eliminadas
            int filasBorradas = session.createQuery("delete from Pokedex").executeUpdate();

            transaction.commit();
            System.out.println("Eliminadas " + filasBorradas + " entradas correctamente.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Revierte los cambios si ocurre algún error
            }
            System.out.println("Erro ao eliminar todas as entradas: " + e.getMessage());
        }
    }

}
