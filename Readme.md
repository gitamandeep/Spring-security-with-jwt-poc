# Poc for Authentication and Authorization using jwt and spring security

### Steps to run the app 
* Run MVN clean install
* In application.properties modify spring.datasource.username=YOURSQLUSERNAME
  spring.datasource.password=YOURSQLPASSWORD
* Run DemoApplication

### Enpoints
* Login with password (http://localhost:8081/api/v1/auth/login)   
in **Body** pass : {
  "username": "987654321",
  "password": "aman123"
}, a jwt token is generated for further access to apis.

* Login with Otp 
  * Step 1: Gerate OTP (http://localhost:8081/api/v1/auth/generate-otp) 
  in **Param** pass {username=987654321}, an otp will be generated.
  * Step 2 : Login With Otp (http://localhost:8081/api/v1/auth/otp-login)
    in **Body** pass :{
    "username": "987654321",
    "otp" : "genrated_OTP_value"
}, a jwt token is generated for further access to apis.

* Test api (http://localhost:8081/api/v1/admin/test) ,provide generated jwt in header to access this api.