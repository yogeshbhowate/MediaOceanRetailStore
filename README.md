for running this app run command :  gradle jettyRun

GET request url : http://localhost:8080 : - for fetching product list

POST request url : http://localhost:8080/scanProduct?productId=1&quantity=2&billNumber=-1 : for scanning product, for new bill pass bill number -1

for creating new bill, made post request: http://localhost:8080/scanProduct?productId=1&quantity=2&billNumber=-1 

for adding product into bill, made post request: http://localhost:8080/scanProduct?productId=2&quantity=3&billNumber=1 
