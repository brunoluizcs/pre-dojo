package dojo.amil.controller;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import dojo.amil.logic.LogReader;
import dojo.amil.logic.wrapper.WrapperPartida;
import dojo.amil.model.Input;
import java.text.ParseException;
import java.util.List;
import javax.inject.Inject;



/**
 * @author Bruno
 * Classe controller utilizada para intermediar as requisições http;
 */
@Controller
public class PartidaController {    
    /**
     * Variavel utilizada para comunicação com a view.
     */
    @Inject private Result result;


    /**    
     * Metodo atende chamadas para a URL /partida 
     * @param input Objeto contendo o input a ser processado.
     * @throws ParseException
     */

    @Consumes("application/json")
    @Post("/partida")
    public void partida(Input input) throws ParseException {
        List<WrapperPartida> partidas = new LogReader().serializarPartida(input.getLog());                 
        result.use(Results.json()).from(partidas,"partidas").include("jogadores").recursive().serialize();        
    }   
   
}