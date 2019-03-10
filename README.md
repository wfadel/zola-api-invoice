# zola-api-invoice

This service is used to create and search Zola invoices

### How To Compile

* mvn clean install
* Login to docker
* docker build -t wfadel83/zola-api-invoice .
* docker push wfadel83/zola-api-invoice:latest

### Run the Application
* docker-compose up

### Stop the application
* docker-compose down

### Create an invoice
curl -X POST -H 'Content-Type: application/json' -H 'Accept: application/json' -d '{"invoice_number":"in01","po_number":"po01","due_date":"2019-08-01","amount_cents":44123}' http://localhost:8080/v1/invoices

### Search for invoices
curl -X GET -H -H 'Accept: application/json' http://localhost:8080/v1/invoices?invoice_number=in01&po_number=po01&offset=0&limit=5
