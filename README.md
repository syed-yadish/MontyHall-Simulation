#Monty Hall problem
```
Assume that you are on a TV-show where you can win money by picking the right box. The host shows you three boxes and explains that one of them contains money. Then the host asks you to pick a box without opening it. When you have selected a box the host opens one of the other two boxes which will be empty. Now you get the question if you want to change your choice or stick to your original choice of box.
```
##Conclusion 
```
The application simulates matches where the player does not change box and where he changes. As expected, it is best to switch the box which wins about 66.66% of the time.
```
####This application is written in React and Springboot Web Api.

##Running the api
```
cd api 
mvn clean install 
mvn spring-boot:run
```

##Running the tests
```
mvn test
```

##Running the frontend Application
```
cd client 
npm install 
npm start
```
