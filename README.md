## orangebank

Es posible usar la interfaz de swagger para realizar los test, la interfaz invoca a los métodos POST definidos en la prueba:

http://localhost:8080/accounts/transactions
http://localhost:8080/accounts/searches



####TEST1 CREAR TRANSACCION A CUENTA ES9820385778983000760236

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

####TEST2 CREAR TRANSACCION A CUENTA ES9820385778983000760236 CON CANTIDAD SUFICIENTE

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
	
	
###TEST3 CREAR TRANSACCIÓN A CUENTA INEXISTENTE EN EL SISTEMA

1- http://localhost:8080/swagger-ui.html#/orangebank-controller/createTransactionUsingPOST

2- request:

{
"reference":"12345A",
"account_iban":"ES9820385778983000760237",
"date":"2019-07-16T16:55:42.000Z",
"amount":333333333193.38,
"fee":3.18,
"description":"Restaurant payment"
}

3- verificar response:

	code 400: The account iban not present in accounts balances: ES9820385778983000760237
	

###TEST4 CREAR TRANSACCIÓN YA EXISTENTE EN EL SISTEMA	

3- verificar response:

	code 400: The transaction already exists 12346A
	
###TEST5 BUSCAR TRANSACCIÓN INEXISTENTE EN SISTEMA -->APARTADO "A" Readme_codechallenge.pdf

1-  request:

{
"reference":"12343WWWA",
"channel":"INTERNAL"
}

2- response:
{
  "transaction": "12343WWA",
  "status": "INVALID"
}
	
###TEST6 BUSCAR TRANSACCIÓN CON DATE ANTERIOR AL DÍA ACTUAL Y CHANNEL INTERNAL - PRECONDICIÓN TRANSACCION EXISTE CON "reference":"12343A", CON CAMPO "Date" ANTERIOR A HOY --> APARTADO "B" Readme_codechallenge.pdf


1- http://localhost:8080/swagger-ui.html#/orangebank-controller/searchTransactionsUsingPOST

2-  request:

{
"reference":"12343A",
"channel":"INTERNAL"
}

3- verificar response:

{
  "transaction": "12343A",
  "status": "SETTLED",
  "amount": 3193.38,
  "fee": 3.18
}

###TEST7 BUSCAR TRANSACCIÓN CON DATE ANTERIOR AL DÍA ACTUAL Y CHANNEL INTERNAL - PRECONDICIÓN TRANSACCION EXISTE CON "reference":"12343A", CON CAMPO "Date" ANTERIOR A HOY --> CORRESPONDE A APARTADO "C" Readme_codechallenge.pdf


1- http://localhost:8080/swagger-ui.html#/orangebank-controller/searchTransactionsUsingPOST

2-  request:

{
"reference":"12343A",
"channel":"INTERNAL"
}

3- verificar response:

{
  "transaction": "12343A",
  "status": "SETTLED",
  "amount": 3193.38,
  "fee": 3.18
}

###TEST8 BUSCAR TRANSACCIÓN CON IGUAL AL DÍA ACTUAL Y CHANNEL ATM - PRECONDICIÓN TRANSACCION EXISTE CON "reference":"12343A", CON CAMPO "Date" ANTERIOR A HOY --> CORRESPONDE A APARTADO "D" Readme_codechallenge.pdf
2-  request:

{
"reference":"11343A",
"channel":"ATM"
}

3- response

{
  "transaction": "11343A",
  "status": "PENDING",
  "amount": 3193.38
}

###TEST9 BUSCAR TRANSACCIÓN CON IGUAL AL DÍA ACTUAL Y CHANNEL ATM - PRECONDICIÓN HABERLA CREADO "reference":"11343A" CON CAMPO "Date" IGUAL A HOY-->CORRESPONDE A APARTADO "E" Readme_codechallenge.pdf

2-  request:

{
"reference":"11343A",
"channel":"INTERNAL"
}

3- response

{
  "transaction": "11343A",
  "status": "PENDING",
  "amount": 3193.38,
  "fee": 3.18
}


###TEST10 BUSCAR TRANSACCIÓN CON IGUAL AL DÍA POSTERIOR A HOY Y CHANNEL CLIENT - PRECONDICIÓN HABERLA CREADO "reference":"00343A" CON CAMPO "Date" POSTERIOR A HOY -->CORRESPONDE A APARTADO "F" Readme_codechallenge.pdf

2-  request:

{
"reference":"00343A",
"channel":"CLIENT"
}

3- response

{
  "transaction": "00343A",
  "status": "FUTURE",
  "amount": 3193.38
}

###TEST11 BUSCAR TRANSACCIÓN CON IGUAL AL DÍA POSTERIOR A HOY Y CHANNEL CLIENT - PRECONDICIÓN HABERLA CREADO "reference":"00343A" CON CAMPO "Date" POSTERIOR A HOY -->CORRESPONDE A APARTADO "G" Readme_codechallenge.pdf

2-  request:

{
"reference":"00343A",
"channel":"ATM"
}

3- response

{
  "transaction": "00343A",
  "status": "PENDING",
  "amount": 3193.38
}

###TEST11 BUSCAR TRANSACCIÓN CON IGUAL AL DÍA POSTERIOR A HOY Y CHANNEL CLIENT - PRECONDICIÓN HABERLA CREADO "reference":"00343A" CON CAMPO "Date" POSTERIOR A HOY -->CORRESPONDE A APARTADO "H" Readme_codechallenge.pdf

2-  request:

{
"reference":"00343A",
"channel":"INTERNAL"
}

3- response

{
  "transaction": "00343A",
  "status": "FUTURE",
  "amount": 3193.38,
  "fee": 3.18
}

#HOW TO EXECUTE


##Option 1:
1- git clone https://github.com/gustavo84/orangebank
2- cd orangebank
3- java -jar target/orangebank-0.1.0.jar


##Option 2:
1- git clone https://github.com/gustavo84/orangebank
2- cd orangebank
3- mvn clean install | java -jar target/orangebank-0.1.0.jar

