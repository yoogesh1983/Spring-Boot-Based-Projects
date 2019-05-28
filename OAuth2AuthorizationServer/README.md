# What is the Application about? </br>
- This is an <b>OAuth2</b> Spring Security application that handles the <b>AuthorizationServer</b> part
- A video lecture related to this project can be found at <a href="https://www.youtube.com/watch?v=wxebTn_a930" target="_blank">C:/Users/yooge/OneDrive\01 - Notes/My_Web_Site/06_Spring_Framework/01_Spring_Security/03_Videos/02_OAuth2 Authorization Server.mp4</a></br>

# How to Compile the Application? </br>
> Right click on project select Run -> Maven build .... </br>
> Under Main Tab in Goal Section do the following -> clean install </br>
> Under JRE tab, select alternate JRE and select the JDK you have setup from Runtime environment </br>
> Save a name as SpringBootJarCompiler and then save </br>

# How to run the application in a Tradional way? </br>
> select com.codetutr.config.dispatcher.ServletInitializer.java -> run as -> Java Application </br>

# How to run the application in a SpringBoot Runner way? </br>
> Click to Run icon -> Run Configurtaion -> Double click to SpringBootAPP -> And configure a Runner </br>
> Save a name as SpringBootJarRunner and then save </br>

The application can now be browsed at http://localhost:8888/portal/dispatcher/home </br>

# Steps to generate Cert As mentained in a Video </br>
> keytool -genkeypair -alias JWT_KEY -keyalg RSA -keypass password -keystore jwt.jks -storepass password
> keytool -importkeystore -srckeystore JWT_KEY.jks -destkeystore jwt.jks -deststoretype pkcs12 </br>

By the way, if the Resource server wants to use the public key of this cert, then below command can be fired </br>

> keytool -list -rfc --keystore jwt.jks | openssl x509 -inform pem -pubkey








