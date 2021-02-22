# Spring Boot and Redis via Docker

### 📖 Information

<ul style="list-style-type:disc">
  <li>a</li>
  <li>b</li>
  <li>c</li>
  <li>d</li>
  <li>e
      <ul>
        <li>e1</li>
      </ul>
  </li>
</ul>

### 🔨 Run the App

<b>1 )</b> Install <b>Docker Desktop</b>. Here is the installation <b>link</b> : https://docs.docker.com/docker-for-windows/install/

<b>2 )</b> Run <b>Redis</b> on <b>Docker</b> Container
```
    docker run -p 6379:6379 --name my-redis -d redis
```

<b>2 )</b> Show <b>container</b> whih runs on <b>Docker</b>
```
    docker ps
```

<b>3 )</b> Open <b>h2 console</b> to access its <b>database</b>
```
    http://localhost:8080/h2-console
```

<b>4 )</b> Enter <b>url</b>,<b>username</b> and <b>password</b> which are defined in <b>Spring datasource Properties</b> in <b>application.yml</b> to login its database
```
    url: jdbc:h2:mem:testdb
    username: sa
    password: password
```

<b>5 )</b> Determine if all values which are coming from <b>data.sql</b> under <b>resources</b> folder are stored.


<b>6 )</b> To see all the employees, run this url with its <b>GET</b> request in <b>Postman</b>
```
http://localhost:8080/api/v1/employee/find/all
```

<b>7 )</b> To see one of the employee, run this url with its <b>GET</b> request in <b>Postman</b>
```
http://localhost:8080/api/v1/employee/find/1
```

<b>8 )</b> </b>
```
http://localhost:8080/api/v1/employee/find/1
```

<b>9 )</b> To save an employee, run this url with its <b>POST</b> request in <b>Postman</b> and write this body
```
http://localhost:8080/api/v1/employee/save

{
    "firstName": "Mark",
    "lastName": "Holly",
    "email": "markholly@example.com",
    "phone": "111-222-4444"
}
```
<b>11 )</b> To update of any employee, run this url with its <b>PUT</b> request in <b>Postman</b> and write this body
```
http://localhost:8080/api/v1/employee/update/4

{
    "firstName": "James",
    "lastName": "Holly",
    "email": "jamesholly@example.com",
    "phone": "111-222-5555"
}
```
<b>11 )</b> To delete of any employee, run this url with its <b>DELETE</b> request in <b>Postman</b>
```
http://localhost:8080/api/v1/employee/delete/4
```

### Screenshots

<details>
<summary>Click here to show the screenshots of project</summary>
    <p> Figure 1 </p>
    <img src ="screenshots\redis_1.PNG">
    <p> Figure 2 </p>
    <img src ="screenshots\redis_2.PNG">
    <p> Figure 3 </p>
    <img src ="screenshots\redis_3.PNG">
    <p> Figure 4 </p>
    <img src ="screenshots\redis_4.PNG">
    <p> Figure 5 </p>
    <img src ="screenshots\redis_5.PNG">
    <p> Figure 6 </p>
    <img src ="screenshots\redis_6.PNG">
    <p> Figure 7 </p>
    <img src ="screenshots\redis_7.PNG">
    <p> Figure 8 </p>
    <img src ="screenshots\redis_8.PNG">
    <p> Figure 9 </p>
    <img src ="screenshots\redis_9.PNG">
    <p> Figure 10 </p>
    <img src ="screenshots\redis_10.PNG">
</details>