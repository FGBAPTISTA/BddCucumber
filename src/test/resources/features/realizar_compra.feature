# language:pt
Funcionalidade: Realizar uma Compra
		Como um usuário
		Eu quero realizar uma compra com sucesso
		Para que eu possa testar Cucumber
		
Cenário: Deve realizar uma compra com sucesso
	Dado que acessei o site de compras
	Quando seleciono SignIn
	E informo "fabiob@dbserver.com.br" no campo email address 
	E a senha "teste123"
	E seleciono botão Sign In
	Então visualizo a página My Account  
	Quando clico Home
	E clico no botão Add to cart do produto "Faded Short Sleeve T-shirts"
	E clico no botão Proceed to checkout
	E valido se produto foi adicionado no carrinho
	E valido se os endereços estão corretos
	E clico no link Proceed to checkout
	Então visualizo a página Addresses
	Quando clico no botão Proceed to checkout Addresses
	Então visualizo a página Shipping
	Quando seto a flag Terms of service
	E clico no link Proceed to checkout Shipping
	Então visualizo a página Payment
	E valido o valor total da compra
	Quando clico no botão Pay by bank wire
	Então visualizo a página Order Summary
	Quando clico no botão I confirm my order
	Então visualizo a página Order Confirmation
	
Cenário: Deve realizar uma compra com sucesso com cadastro
	Dado que acessei o site de compras
	Quando clico no botão Add to cart do produto "Faded Short Sleeve T-shirts"
	E clico no botão Proceed to checkout
	E valido se produto foi adicionado no carrinho sem Address
	E clico no link Proceed to checkout
	Então visualizo a página Authentication
	Quando informo Email address
	E clico no botão Create an Account
	Então visualizo a página Create an Account 
	Quando clico em Mr.
	E informo o First name
	E informo o Last name
	E informo a Password
	E informo o Dia of Birth
	E informo o Mes of Birth
	E informo o Ano of Birth
	E informo a Company
	E informo o Address
	E informo a City
	E informo o State
	E informo o Zip
	E informo Home phone
	E clico no botão Register
	Então visualizo a página Addresses
	Quando clico no botão Proceed to checkout Addresses
	Então visualizo a página Shipping
	Quando seto a flag Terms of service
	E clico no link Proceed to checkout Shipping
	Então visualizo a página Payment
	E valido o valor total da compra
	Quando clico no botão Pay by bank wire
	Então visualizo a página Order Summary
	Quando clico no botão I confirm my order
	Então visualizo a página Order Confirmation	