## orangebank

Es posible usar la interfaz de swagger para realizar los test para ello, la interfaz invoca a los métodos POST definidos en la prueba:

#TEST1

1- invocar en navegador: http://localhost:8080/swagger-ui.html#/orangebank-controller/createTransactionUsingPOST

2- copiar siguiente request:

{
"reference":"12345A",
"account_iban":"ES9820385778983000760236",
"date":"2019-07-16T16:55:42.000Z",
"amount":333333333193.38,
"fee":3.18,
"description":"Restaurant payment"
}

3- verificar response:

	code 400: Not enought amount in account balance for the next account: ES9820385778983000760236

#TEST2

1- http://localhost:8080/swagger-ui.html#/orangebank-controller/createTransactionUsingPOST

2- request:

{
"reference":"12345A",
"account_iban":"ES9820385778983000760236",
"date":"2019-07-16T16:55:42.000Z",
"amount":333333333193.38,
"fee":3.18,
"description":"Restaurant payment"
}

3- verificar response:

	code 200