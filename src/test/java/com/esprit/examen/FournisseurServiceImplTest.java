/*
 * package com.esprit.examen; //import org.junit.Test; import
 * org.junit.jupiter.api.Test; import org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * 
 * import com.esprit.examen.entities.DetailFournisseur; import
 * com.esprit.examen.entities.Fournisseur; import
 * com.esprit.examen.repositories.FournisseurRepository; import
 * com.esprit.examen.services.FournisseurServiceImpl;
 * 
 * import java.util.List;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.junit.jupiter.api.Assertions.assertNotNull; import static
 * org.junit.jupiter.api.Assertions.assertNull; import static
 * org.junit.jupiter.api.Assertions.assertTrue;
 * 
 * import java.text.ParseException; import java.text.SimpleDateFormat; import
 * java.util.Date; import lombok.extern.slf4j.Slf4j;
 * 
 * 
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest
 * 
 * @Slf4j public class FournisseurServiceImplTest {
 * 
 * 
 * @Autowired FournisseurServiceImpl fserv;
 * 
 * @Autowired FournisseurRepository frepo;
 * 
 * @Test public void testRetrieveAllFournisseurs() {
 * 
 * List<Fournisseur> fournisseurs = fserv.retrieveAllFournisseurs(); int
 * expected = fournisseurs.size(); Fournisseur fa=new Fournisseur("test",
 * "test"); Fournisseur f = fserv.addFournisseur(fa); assertEquals(expected + 1,
 * fserv.retrieveAllFournisseurs().size());
 * fserv.deleteFournisseur(f.getIdFournisseur());; }
 * 
 * @Test public void testAddFournisseur(){ Fournisseur fa=new
 * Fournisseur("CodeFournisseur","LibelleFournisseur"); Fournisseur f =
 * fserv.addFournisseur(fa); assertNotNull(f.getIdFournisseur());
 * assertTrue(f.getLibelle().length() > 0);
 * fserv.deleteFournisseur(f.getIdFournisseur()); }
 * 
 * @Test public void testDeleteFournisseur() { Fournisseur fa=new
 * Fournisseur("CodeFournisseur","LibelleFournisseur"); Fournisseur f =
 * fserv.addFournisseur(fa); fserv.deleteFournisseur(f.getIdFournisseur());
 * assertNull(fserv.retrieveFournisseur(f.getIdFournisseur())); };
 * 
 * 
 * @Test public void testRetrieveFournisseur() { Fournisseur fa=new
 * Fournisseur("CodeFournisseur","LibelleFournisseur"); Fournisseur f =
 * fserv.addFournisseur(fa); Fournisseur fournisseur =
 * fserv.retrieveFournisseur(f.getIdFournisseur());
 * assertEquals(f.getIdFournisseur().longValue(),fournisseur.getIdFournisseur().
 * longValue());
 * 
 * }
 * 
 * @Test public void testSaveDetailFournisseur() { Fournisseur fa=new
 * Fournisseur(); DetailFournisseur dt =new
 * DetailFournisseur("adresse","matricule"); fa.setDetailFournisseur(dt);
 * Fournisseur fourn = frepo.save(fa); DetailFournisseur fs =
 * fserv.saveDetailFournisseur(fourn); assertNotNull(fs); assertNotNull(fa); }
 * 
 * @Test public void testUpdateFournisseur() { Fournisseur fr=new
 * Fournisseur("CodeFournisseur","LibelleFournisseur"); Fournisseur f1 =
 * fserv.addFournisseur(fr); Fournisseur f =
 * fserv.retrieveFournisseur(f1.getIdFournisseur()); f.setLibelle("test");
 * f.setCode("tst"); Fournisseur updatedFournisseur=fserv.updateFournisseur(f);
 * assertEquals(f.getLibelle(),updatedFournisseur.getLibelle()); }
 * 
 * }
 */