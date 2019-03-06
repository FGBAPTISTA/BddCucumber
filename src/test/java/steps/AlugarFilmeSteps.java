package steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import entidades.AluguelService;
import entidades.Filme;
import entidades.NotaAluguel;
import entidades.TipoAluguel;
import junit.framework.Assert;
import utils.DateUtils;

public class AlugarFilmeSteps {
	
	private Filme filme;
	private AluguelService aluguel = new AluguelService() ;
	private NotaAluguel nota;
	private String erro;
	private TipoAluguel tipoAluguel;
	
	@Dado("^um filme com estoque de (\\d+) unidades$")
	public void um_filme_com_estoque_de_unidades(int arg1) throws Throwable {
	   filme = new Filme();
	   filme.setEstoque(arg1);
	}

	@Dado("^que o preço do aluguel seja R\\$ (\\d+)$")
	public void que_o_preço_do_aluguel_seja_R$(int arg1) throws Throwable {
		filme.setAluguel(arg1);
	}

	@Dado("^um filme$")
	public void um_filme(DataTable table) throws Throwable {
	    Map<String, String> map = table.asMap(String.class, String.class);
	    filme = new Filme();
	    filme.setEstoque(Integer.parseInt(map.get("estoque")));
	    filme.setAluguel(Integer.parseInt(map.get("preco")));
	    String tipo = map.get("tipo");
	    tipoAluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL: tipo.equals("extendido")? TipoAluguel.EXTENDIDO: TipoAluguel.COMUM;	    
	}
	
	@Quando("^alugar$")
	public void alugar() throws Throwable {
		try {
		nota = aluguel.alugar(filme, tipoAluguel);
		} catch (RuntimeException e) {
			erro = e.getMessage();
		}
	}

	@Então("^o preço do aluguel será R\\$ (\\d+)$")
	public void o_preço_do_aluguel_será_R$(int arg1) throws Throwable {
		Assert.assertEquals(arg1, nota.getPreco());
	}

	@Então("^o estoque do filme será (\\d+) unidade$")
	public void o_estoque_do_filme_será_unidade(int arg1) throws Throwable {
	   Assert.assertEquals(arg1, filme.getEstoque());
	}
	
	@Então("^não será possível por falta de estoque$")
	public void não_será_possível_por_falta_de_estoque() throws Throwable {
		Assert.assertEquals("filme sem estoque", erro);
		}	

	@Dado("^que o tipo de aluguel seja (.*)$")
	public void que_o_tipo_de_aluguel_seja_extendido(String tipo) throws Throwable {
		
		tipoAluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL: tipo.equals("extendido")? TipoAluguel.EXTENDIDO: TipoAluguel.COMUM;
	}

	@Então("^a data de entrega será em (\\d+) dias?$")
	public void a_data_de_entrega_será_em_dias(int arg1) throws Throwable {
		Date dataEsperada = DateUtils.obterDataDiferencaDias(arg1);
		Date dataReal = nota.getDataEntrega();
		
		DateFormat format = new SimpleDateFormat ("dd/MM/yyyy");
		Assert.assertEquals(format.format(dataEsperada),format.format(dataReal) ); 
	}

	@Então("^a pontuação recebida será de (\\d+) pontos?$")
	public void a_pontuação_recebida_será_de_pontos(int arg1) throws Throwable {
		Assert.assertEquals(arg1, nota.getPontuacao());
	}
	
}
