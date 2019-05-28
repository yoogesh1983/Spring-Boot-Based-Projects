# What is the Application about? </br>
- This is an <b>OAuth2</b> Spring Security application that handles the <b>AuthorizationServer</b> part
- A video lecture related to this project can be found <a href="">C:/Users/yooge/OneDrive\01 - Notes/My_Web_Site/06_Spring_Framework/01_Spring_Security/03_Videos/02_OAuth2 Authorization Server.mp4</a></br>

# How to Compile the Application? </br>
> Right click on project select Run -> Maven build .... </br>
> Under Main Tab in Goal Section do the following -> clean install </br>
> Under JRE tab, select alternate JRE and select the JDK you have setup from Runtime environment </br>
> Save a name as SpringBootJarCompiler and then save </br>

# How to run the application in a Tradional way? </br>
> select com.codetutr.config.dispatcher.ServletInitializer.java ----> run as -----> Java Application </br>

# How to run the application in a SpringBoot Runner way? </br>
> Click to Run icon ----> Run Configurtaion ------> Double click to SpringBootAPP ---> And configure a Runner </br>
> Save a name as SpringBootJarRunner and then save </br>

The application can now be browsed at http://localhost:8888/portal/dispatcher/home </br>

if not run successfully, You may need to do the following installation</br>

> npm install phantomjs-prebuilt@2.1.16 --ignore-scripts </br>
> npm install npm-run-all --save-dev </br>
> npm install -g nodemon </br>

# How to clone a project (Using VisualStudio Code) </br>
> Ctrl+Shift+p </br>
> git clone </br>
> Enter a URL </br>
> select a folder you want to save the the project into your local</br>
> Close the project from Visual code and again open the particular project inside the folder i.e. REACTContact_SSR </br>

Run a following command to commit git from visualcode (Otherwise it will not show the username password modal popup) </br>
> git config --global user.email "yoogesh1983@gmail.com" </br>
> git config --global user.name "Yoogesh"</br>








#URL: 
======
http://localhost:8888/portal/dispatcher/home

Steps to compile:
=================

1) Right click on project select Run ----> Maven build .... 
2) Under Main Tab in Goal Section do the following ---> clean install
3) Under JRE tab, select alternate JRE and select the JDK you have setup from Runtime environment
4) Save a name as SpringBootJarCompiler and then save


Steps to Run an application Using Tradional way
===============================================

1) select com.codetutr.springboot.SpringBootJarApplication.java ----> run as -----> Java Application 


Steps to Run an application Using SpringBoot way
===============================================

1) Click to Run icon ----> Run Configurtaion ------> Double click to SpringBootAPP ---> And configure a Runner 
2) Save a name as SpringBootJarRunner and then save

Process to generate a file
==========================
#Generate a cert
keytool -genkeypair -alias JWT_KEY -keyalg RSA -keypass password -keystore jwt.jks -storepass password

#Import a cert into a folder
keytool -importkeystore -srckeystore JWT_KEY.jks -destkeystore jwt.jks -deststoretype pkcs12

#This one will be used to get the public key from the cert. Resource server will use it
keytool -list -rfc --keystore jwt.jks | openssl x509 -inform pem -pubkey








