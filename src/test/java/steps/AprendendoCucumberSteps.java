package steps;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Assert;

import converters.DateConverter;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AprendendoCucumberSteps {
	@Dado("^que crei o arquivo corretamente$")
	public void queCreiOArquivoCorretamente() throws Throwable {
     System.out.println("passou aqui");

	}

	@Quando("^executa lo$")
	public void executaLo() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

	}

	@Então("^a especificação deve finalizar com sucesso$")
	public void aEspecificaçãoDeveFinalizarComSucesso() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

	}

	private int contador = 0;
	@Dado("^que o valor do contador é (\\d+)$")
	public void queOValorDoContadorÉ(int arg1) throws Throwable {
		contador = arg1;
	}

	@Quando("^eu incrementar em (\\d+)$")
	public void euIncrementarEm(int arg1) throws Throwable {
		contador = contador + arg1;
	}

	@Então("^o valor do contador será (\\d+)$")
	public void oValorDoContadorSerá(int arg1) throws Throwable {
	   System.out.println(arg1);
	   System.out.println(contador);
	   System.out.println(arg1==contador);
	   //Assert.assertTrue(arg1==contador);
	   Assert.assertEquals(arg1, contador);
  
	}
	
	Date entrega = new Date();
	
	@Dado("^que a entrega é dia (.*)$")
	public void queAEntregaÉDia(@Transform(DateConverter.class) Date data) throws Throwable {
		entrega = data;
		System.out.println(entrega);
	}

	@Quando("^a entrega atrasar em (\\d+) (|dia|dias|mes|meses)$")
	public void aEntregaAtrasarEmDias(int arg1, String tempo) throws Throwable {
		Calendar cal = Calendar.getInstance();
		cal.setTime(entrega);
		if (tempo.equals("dias")) {
			cal.add(Calendar.DAY_OF_MONTH,arg1);	
		}
		
		if (tempo.equals("meses")) {
			cal.add(Calendar.MONTH,arg1);	
		}

		entrega = cal.getTime();
}

	@Então("^a entrega será efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void aEntregaSeráEfetuadaEm(String data) throws Throwable {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = format.format(entrega);
		Assert.assertEquals(data, dataFormatada);
    
}
	
	@Dado("^que o ticket( especial)? é A.(\\d+)$")
	public void que_o_ticket_é_AF(String tipo, int arg1) throws Throwable {

	}

	@Dado("^que o valor da passagem é R\\$ (.*)$")
	public void que_o_valor_da_passagem_é_R$(Double numero) throws Throwable {
		System.out.println(numero);
	}

	@Dado("^que o nome do passageiro é \"(.*)\"$")
	public void que_o_nome_do_passageiro_é(String arg1) throws Throwable {
	
	}

	@Dado("^que o telefone do passageiro é (\\d+)-(\\d+)$")
	public void que_o_telefone_do_passageiro_é(int arg1, int arg2) throws Throwable {
	  
	}

	@Quando("^criar os steps$")
	public void criar_os_steps() throws Throwable {
	   
	}

	@Então("^o teste vai funcionar$")
	public void o_teste_vai_funcionar() throws Throwable {

	}


}
