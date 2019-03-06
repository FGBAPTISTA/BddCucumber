package steps;

import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthScrollBarUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import junit.framework.Assert;

public class RealizarCompraSteps {
	private WebDriver driver;
	
	@Dado("^que acessei o site de compras$")
	public void queAcesseiOSiteDeCompras() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fabiob\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.automationpractice.com/index.php?");	 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Quando("^seleciono SignIn$")
	public void selecionoSignIn() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
	}

	@Quando("^informo \"(.*?)\" no campo email address$")
	public void informoNoCampoEmailAddress(String arg1) throws Throwable {
		driver.findElement(By.id("email")).sendKeys(arg1);
	}

	@Quando("^a senha \"(.*?)\"$")
	public void aSenha(String arg1) throws Throwable {
		driver.findElement(By.id("passwd")).sendKeys(arg1);
	}

	@Quando("^seleciono botão Sign In$")
	public void selecionoBotãoSignIn() throws Throwable {
	   driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
	}

	@Então("^visualizo a página My Account$")
	public void visualizoAPáginaMyAccount() throws Throwable {
		String textoMyAccount = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();
		Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", textoMyAccount);
	}

	@Quando("^clico Home$")
	public void clicoHome() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/a/span")).click();
	}

	@Quando("^clico no botão Add to cart do produto \"(.*?)\"$")
	public void clicoNoBotãoAddToCartDoProduto(String arg1) throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span")).click();
	}

	@Quando("^clico no botão Proceed to checkout$")
	public void clicoNoBotãoProceedToCheckout() throws Throwable {
		driver.findElement(By.linkText("Proceed to checkout")).click();	
	}

	@Quando("^valido se produto foi adicionado no carrinho$")
	// antes  //*[@id=\"product_1_1_0_135380\"]/td[2]/p/a
	public void validoSeProdutoFoiAdicionadoNoCarrinho() throws Throwable {
		String descricaoProduto = driver.findElement(By.xpath("//*[@id=\"product_1_1_0_135380\"]/td[2]/p/a")).getText();
		Assert.assertEquals("Faded Short Sleeve T-shirts", descricaoProduto);
	}

	@Quando("^valido se os endereços estão corretos$")
	public void validoSeOsEndereçosEstãoCorretos() throws Throwable {
		String deliveryAddress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[3]/div[1]/ul/li[2]/span")).getText();
		Assert.assertEquals("FABIO BAPTISTA", deliveryAddress);

		String invoiceAddress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[3]/div[2]/ul/li[4]/span")).getText();
		Assert.assertEquals("zz, Alabama 00000", invoiceAddress);
	}

	@Quando("^clico no link Proceed to checkout$")
	public void clicoNoLinkProceedToCheckout() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();		
		
	}	

	@Então("^visualizo a página Addresses$")
	public void visualizoAPáginaAddresses() throws Throwable {
		String textoAddress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText();
		Assert.assertEquals("ADDRESSES", textoAddress);
	}

	@Quando("^clico no botão Proceed to checkout Addresses$")
	public void clicoNoBotãoProceedToCheckoutAddresses() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")).click();

	}

	@Então("^visualizo a página Shipping$")
	public void visualizoAPáginaShipping() throws Throwable {
		String textoShipping = driver.findElement(By.xpath("//*[@id=\"carrier_area\"]/h1")).getText();
		Assert.assertEquals("SHIPPING", textoShipping);

	}

	@Quando("^seto a flag Terms of service$")
	public void setoAFlagTermsOfService() throws Throwable {
		driver.findElement(By.id("cgv")).click();
	}

	@Quando("^clico no link Proceed to checkout Shipping$")
	public void clicoNoLinkProceedToCheckoutShipping() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
	}

	@Então("^visualizo a página Payment$")
	public void visualizoAPáginaPayment() throws Throwable {
		String textoPaymento = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText();
		Assert.assertEquals("PLEASE CHOOSE YOUR PAYMENT METHOD", textoPaymento);
	}
	
	@Então("^valido o valor total da compra$")
	public void validoOValorTotalDaCompra() throws Throwable {
	  String totalProducts = driver.findElement(By.id("total_product")).getText().substring(1);
	  float totalProductsF = Float.parseFloat(totalProducts);
	  
	  String totalShipping = driver.findElement(By.id("total_shipping")).getText().substring(1);
	  float totalShippingF = Float.parseFloat(totalShipping);
	  
	  String tax = driver.findElement(By.id("total_tax")).getText().substring(1);
	  float taxF =  Float.parseFloat(tax);
	  
	  String total = driver.findElement(By.id("total_price_container")).getText().substring(1);
	  float totalF =  Float.parseFloat(total);
	  
	  float totalCompraF = totalProductsF + totalShippingF + taxF;
	  
	  Assert.assertEquals(totalCompraF, totalF);
		  
	}	

	@Quando("^clico no botão Pay by bank wire$")
	public void clicoNoBotãoPayByBankWire() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
	}

	@Então("^visualizo a página Order Summary$")
	public void visualizoAPáginaOrderSummary() throws Throwable {
		String textoOrderSummary = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText();
		Assert.assertEquals("ORDER SUMMARY", textoOrderSummary);
	}
	
	@Quando("^clico no botão I confirm my order$")
	public void clicoNoBotãoIConfirmMyOrder() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span")).click();
	}

	@Então("^visualizo a página Order Confirmation$")
	public void visualizoAPáginaOrderConfirmation() throws Throwable {
		String textoOrderConfirmation = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText();
		Assert.assertEquals("ORDER CONFIRMATION", textoOrderConfirmation);
	}	
	
	@Quando("^valido se produto foi adicionado no carrinho sem Address$")
	public void validoSeProdutoFoiAdicionadoNoCarrinhoSemAddress() throws Throwable {
		String descricaoProduto = driver.findElement(By.xpath("//*[@id=\"product_1_1_0_0\"]/td[2]/p/a")).getText();
		Assert.assertEquals("Faded Short Sleeve T-shirts", descricaoProduto);

	}

	@Então("^visualizo a página Authentication$")
	public void visualizoAPáginaAuthentication() throws Throwable {
		String textoAuthentication = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText();
		Assert.assertEquals("AUTHENTICATION", textoAuthentication);
	}

	@Quando("^informo Email address$")
	public void informoEmailAddress() throws Throwable {
		driver.findElement(By.id("email_create")).sendKeys("fabio9@db.com.br");
	}

	@Quando("^clico no botão Create an Account$")
	public void clicoNoBotãoCreateAnAccount() throws Throwable {
		driver.findElement(By.id("SubmitCreate")).click();
	}

	@Então("^visualizo a página Create an Account$")
	public void visualizoAPáginaCreateAnAccount() throws Throwable {
		String textoPersonalInformation = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/h3")).getText();
		Assert.assertEquals("YOUR PERSONAL INFORMATION", textoPersonalInformation);
	}

	@Quando("^clico em Mr\\.$")
	public void clicoEmMr() throws Throwable {
	   driver.findElement(By.id("id_gender1")).click();
	}

	@Quando("^informo o First name$")
	public void informoOFirstName() throws Throwable {
		driver.findElement(By.id("customer_firstname")).sendKeys("Marcelo Silva");
	}

	@Quando("^informo o Last name$")
	public void informoOLastName() throws Throwable {
		driver.findElement(By.id("customer_lastname")).sendKeys("Silva dos Santos");
	}

	@Quando("^informo a Password$")
	public void informoAPassword() throws Throwable {
		driver.findElement(By.id("passwd")).sendKeys("teste123");
	}

	@Quando("^informo o Dia of Birth$")
	public void informoODiaOfBirth() throws Throwable {
		driver.findElement(By.id("days")).sendKeys("1");
	}

	@Quando("^informo o Mes of Birth$")
	public void informoOMesOfBirth() throws Throwable {
		driver.findElement(By.id("months")).sendKeys("January");		
	}

	@Quando("^informo o Ano of Birth$")
	public void informoOAnoOfBirth() throws Throwable {
		driver.findElement(By.id("years")).sendKeys("2000");
	}

	@Quando("^informo a Company$")
	public void informoACompany() throws Throwable {
		driver.findElement(By.id("company")).sendKeys("DB");
	}

	@Quando("^informo o Address$")
	public void informoOAddress() throws Throwable {
		driver.findElement(By.id("address1")).sendKeys("Av. Nilo Peçanha");
	}

	@Quando("^informo a City$")
	public void informoACity() throws Throwable {
		driver.findElement(By.id("city")).sendKeys("Porto Alegre");	
	}

	@Quando("^informo o State$")
	public void informoOState() throws Throwable {
		driver.findElement(By.id("id_state")).sendKeys("Alabama");
	}

	@Quando("^informo o Zip$")
	public void informoOZip() throws Throwable {
		driver.findElement(By.id("postcode")).sendKeys("00000");
	}

	@Quando("^informo Home phone$")
	public void informoHomePhone() throws Throwable {
		driver.findElement(By.id("phone")).sendKeys("519898989");
	}

	@Quando("^clico no botão Register$")
	public void clicoNoBotãoRegister() throws Throwable {
		driver.findElement(By.id("submitAccount")).click();
	}

}
