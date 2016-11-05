package dojo.amil.logic.wrapper;

import dojo.amil.model.Jogador;
import dojo.amil.model.Weapon;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno
 */
public class WrapperTest {
    private Collection<WrapperJogador> jogadores = null; 
    private WrapperJogador mWrapper1 = null;
    private WrapperJogador mWrapper2 = null;
    private Jogador jogador1;
    private Jogador jogador2;
    
    public WrapperTest() {
    }    
   
    
    @Before
    public void setUp() {
        HashMap<String, Weapon> hash = new HashMap<>();
        jogadores = new ArrayList<>();
        jogador1 = new Jogador();        
        jogador2 = new Jogador();
        
        jogador1.getAwards().setAxeMurderer(true);
        jogador1.getAwards().setiAmImortal(true);       
        jogador1.setDeaths(2);
        jogador1.setKills(10);
        jogador1.setNome("player2");
        jogador1.setRecordStreak(5);
        jogador1.setStreak(0);
        
        Weapon w = new Weapon();
        w.setKills(2);
        w.setNome("RPG");
        hash.put("RPG",w);
        
        w = new Weapon();
        w.setKills(8);
        w.setNome("M16");        
        hash.put("M16",w);        
        
        jogador1.setWeapons(hash);        
        jogador1.getKillTime().add(new Date());
        jogador1.getKillTime().add(new Date());
        jogador1.getKillTime().add(new Date());
        jogador1.getKillTime().add(new Date());
        jogador1.getKillTime().add(new Date());
        
        jogador2.getAwards().setAxeMurderer(true);
        jogador2.getAwards().setiAmImortal(true);       
        jogador2.setDeaths(10);
        jogador2.setKills(0);
        jogador2.setNome("player1");
        jogador2.setRecordStreak(0);
        jogador2.setStreak(0);
        
        w = new Weapon();                
        hash = new HashMap<>();
        hash.put("",w);
        jogador2.setWeapons(hash);     

        
        
        mWrapper1 = new WrapperJogador(jogador1);        
        jogadores.add(mWrapper1);        
        
        mWrapper2 = new WrapperJogador(jogador2);        
        jogadores.add(mWrapper2);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Teste para o metodo setAwardAxeMurderer, da classe Wrapper.
     */
    @Test
    public void testSetAwardAxeMurderer() {
        System.out.println("setAwardAxeMurderer");        
        Wrapper instance = new Wrapper();
        instance.setAwardAxeMurderer(jogador1, mWrapper1);
        assertTrue(mWrapper1.getAwards().isAxeMurderer());
        
        instance.setAwardAxeMurderer(jogador2, mWrapper2);
        assertFalse(mWrapper2.getAwards().isAxeMurderer());                   
    }

    /**
     * Teste para o metodo setAwardImortal, da class Wrapper.
     */
    @Test
    public void testSetAwardImortal() {
        System.out.println("setAwardImortal");        
        Wrapper instance = new Wrapper();
        instance.setAwardImortal(jogadores);
        WrapperJogador player1 = ((List<WrapperJogador>)jogadores).get(0);
        WrapperJogador player2 = ((List<WrapperJogador>)jogadores).get(1);
        
        assertFalse(player1.getAwards().isiAmImortal());        
        assertFalse(player2.getAwards().isiAmImortal());        
    }

    /**
     * Teste para o metodo setColocacao, da classe Wrapper.
     */
    @Test
    public void testSetColocacao() {
        System.out.println("setColocacao");        
        Wrapper instance = new Wrapper();
        instance.setColocacao(jogadores);                
        assertEquals(((List<WrapperJogador>) jogadores).get(0).getColocacao(), 1);
        assertEquals(((List<WrapperJogador>) jogadores).get(1).getColocacao(), 2);        
    }

    /**
     * Teste para o metodo setArmaFavorita, da classe Wrapper.
     */
    @Test
    public void testSetArmaFavorita() {
        System.out.println("setArmaFavorita"); 
        Wrapper instance = new Wrapper();
        instance.setArmaFavorita(jogadores);
        List<Weapon> weapons = ((List<WrapperJogador>) jogadores).get(0).getWeapons();
        assertEquals(weapons.get(0).getNome(), "M16"); 
    }
    
}
