package dojo.amil.logic;

import dojo.amil.logic.wrapper.WrapperJogador;
import dojo.amil.logic.wrapper.WrapperPartida;
import java.util.List;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 *
 * @author Bruno
 */
public class LogReaderTest {
    private final static String INPUT = "23/04/2013 15:34:22 - New match 11348965 has started\n" +
                                        "23/04/2013 15:36:04 - Roman killed Nick using M16\n" +
                                        "23/04/2013 15:36:33 - <WORLD> killed Nick by DROWN\n" +
                                        "23/04/2013 15:39:22 - Match 11348965 has ended\n"+
                                        "24/04/2013 15:34:22 - New match 11348966 has started\n" +
                                        "24/04/2013 15:36:04 - Bruno killed Nick using M16\n" +
                                        "24/04/2013 15:36:04 - Bruno killed Roman using M4A1\n" +
                                        "24/04/2013 15:36:04 - Bruno killed Roman using M4A1\n" +
                                        "24/04/2013 15:36:04 - Bruno killed Roman using M4A1\n" +
                                        "24/04/2013 15:36:04 - Bruno killed Roman using M4A1\n" +
                                        "24/04/2013 15:36:04 - Bruno killed Roman using M16\n" +
                                        "24/04/2013 15:36:33 - <WORLD> killed Nick by DROWN\n" +
                                        "24/04/2013 15:39:22 - Match 11348965 has ended";   
    
    
    
    public LogReaderTest() {
    }  

    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }    
    

    /**
     * Test para o metodo, serializarPartida da classe LogReader.
     */
    @org.junit.Test
    public void testSerializarPartida() throws Exception {
        System.out.println("serializarPartida");        
        LogReader instance = new LogReader();
        List<WrapperPartida> expResult = null;
        List<WrapperPartida> result = instance.serializarPartida(INPUT);        
        assertNotEquals(expResult, result);                               
    }
    
    /**
     * Test para verificar a quantidade de partidas identificadas no input
     */   
    @org.junit.Test
    public void testQuantidadePartida() throws Exception{
        System.out.println("Quantidade de partidas identificadas");        
        LogReader instance = new LogReader();        
        List<WrapperPartida> result = instance.serializarPartida(INPUT);        
        assertEquals(result.size(), 2);        
    }
    
    /**
     * Test para verificar a quantidade de jogadores identificados por partida
     */
    @org.junit.Test
    public void testJogadoresPartida() throws Exception{
        System.out.println("Quantidade de jogadores identificados");        
        LogReader instance = new LogReader();        
        List<WrapperPartida> result = instance.serializarPartida(INPUT);                
        WrapperPartida partida1 = ((List<WrapperPartida>) result).get(0);
        WrapperPartida partida2 = ((List<WrapperPartida>) result).get(1);        
        assertEquals(partida1.getJogadores().size(), 2);        
        assertEquals(partida2.getJogadores().size(), 3);        
    }    
    
    /**
     * Test para verificar a quantidade de kills
     */
    @org.junit.Test
    public void testJogadoresKills() throws Exception{
        System.out.println("Quantidade de Kills");        
        LogReader instance = new LogReader();        
        List<WrapperPartida> result = instance.serializarPartida(INPUT);                
        WrapperPartida partida1 = ((List<WrapperPartida>) result).get(0);
        WrapperPartida partida2 = ((List<WrapperPartida>) result).get(1);        
        
        List<WrapperJogador> jogadores1 = ((List<WrapperJogador>) partida1.getJogadores());
        List<WrapperJogador> jogadores2 = ((List<WrapperJogador>) partida2.getJogadores());
        
        
        assertEquals(jogadores1.get(0).getKills(), 1);        
        assertEquals(jogadores1.get(1).getKills(), 0);        
        
        assertEquals(jogadores2.get(0).getKills(), 6);        
        assertEquals(jogadores2.get(1).getKills(), 0);      
        assertEquals(jogadores2.get(2).getKills(), 0);  
    }     
    
    /**
     * Test para verificar a quantidade de Deaths
     */
    @org.junit.Test
    public void testJogadoresDeaths() throws Exception{
        System.out.println("Quantidade de Deaths");        
        LogReader instance = new LogReader();        
        List<WrapperPartida> result = instance.serializarPartida(INPUT);                
        WrapperPartida partida1 = ((List<WrapperPartida>) result).get(0);
        WrapperPartida partida2 = ((List<WrapperPartida>) result).get(1);        
        
        List<WrapperJogador> jogadores1 = ((List<WrapperJogador>) partida1.getJogadores());
        List<WrapperJogador> jogadores2 = ((List<WrapperJogador>) partida2.getJogadores());
        
        
        assertEquals(jogadores1.get(0).getKills(), 1);        
        assertEquals(jogadores1.get(1).getKills(), 0);        
        
        assertEquals(jogadores2.get(0).getKills(), 6);        
        assertEquals(jogadores2.get(1).getKills(), 0);      
        assertEquals(jogadores2.get(2).getKills(), 0);  
    }    
    
    /**
     * Test para verificar o nome do vencedor
     */
    @org.junit.Test
    public void testJogadoresVencedor() throws Exception{
        System.out.println("Nome do vencedor");        
        LogReader instance = new LogReader();        
        List<WrapperPartida> result = instance.serializarPartida(INPUT);                
        WrapperPartida partida1 = ((List<WrapperPartida>) result).get(0);
        WrapperPartida partida2 = ((List<WrapperPartida>) result).get(1);        
        
        List<WrapperJogador> jogadores1 = ((List<WrapperJogador>) partida1.getJogadores());
        List<WrapperJogador> jogadores2 = ((List<WrapperJogador>) partida2.getJogadores());        
        
        assertEquals(jogadores1.get(0).getNome(), "Roman");        
        assertEquals(jogadores2.get(0).getNome(), "Bruno");               
               
    }    
    
    /**
     * Test para verificar se os awards foram aplicados
     */
    @org.junit.Test
    public void testJogadoresAward() throws Exception{
        System.out.println("Nome do vencedor");        
        LogReader instance = new LogReader();        
        List<WrapperPartida> result = instance.serializarPartida(INPUT);                
        WrapperPartida partida1 = ((List<WrapperPartida>) result).get(0);
        WrapperPartida partida2 = ((List<WrapperPartida>) result).get(1);        
        
        List<WrapperJogador> jogadores1 = ((List<WrapperJogador>) partida1.getJogadores());
        List<WrapperJogador> jogadores2 = ((List<WrapperJogador>) partida2.getJogadores());        
        
        assertEquals(jogadores1.get(0).getAwards().isAxeMurderer(), false);                              
        assertEquals(jogadores1.get(0).getAwards().isiAmImortal(), true);                              
        assertEquals(jogadores1.get(1).getAwards().isAxeMurderer(), false); 
        assertEquals(jogadores1.get(1).getAwards().isiAmImortal(), false); 
        
        assertEquals(jogadores2.get(0).getAwards().isAxeMurderer(), true);                              
        assertEquals(jogadores2.get(0).getAwards().isiAmImortal(), true);                              
        assertEquals(jogadores2.get(1).getAwards().isAxeMurderer(), false);                              
        assertEquals(jogadores2.get(1).getAwards().isiAmImortal(), false);  
    }   
    
    /**
     * Test para verificar a arma favorita do vencedor
     */
    @org.junit.Test
    public void testJogadoresArmaFavorita() throws Exception{
        System.out.println("Nome do vencedor");        
        LogReader instance = new LogReader();        
        List<WrapperPartida> result = instance.serializarPartida(INPUT);                
        WrapperPartida partida1 = ((List<WrapperPartida>) result).get(0);
        WrapperPartida partida2 = ((List<WrapperPartida>) result).get(1);        
        
        List<WrapperJogador> jogadores1 = ((List<WrapperJogador>) partida1.getJogadores());
        List<WrapperJogador> jogadores2 = ((List<WrapperJogador>) partida2.getJogadores());        
        
        assertEquals(jogadores1.get(0).getWeapons().get(0).getNome(), "M16");        
        assertEquals(jogadores2.get(0).getWeapons().get(0).getNome(), "M4A1");                              
    }       
        
    
    
}
