# Spring Boot and Redis via Docker

<img src="screenshots\redis_12.PNG" alt="Main Information" width="800" height="600">

### 📖 Information

<ul style="list-style-type:disc">
  <li>Redis is a <b>caching process</b> and it prevents every request coming from system from database</li>
  <li>If there is any request which has been implemented system before, the response will be come from cache , otherwise the result is obtained from database process containing sql results.</li>
  <li>It prevents traffic conjustion in system and comfort the usage of RAM</li>
  <li>Here are the explation of this project</li>
  <li>e
      <ul>
        <li>If a <b>request</b> of findAll is called in Postman, there is <b>no cache</b> procedure</li>
        <li>If a <b>request</b> of finding any values which are located in h2 database like in first 3 values is called, there is a <b>cache</b> procedure</li>
        <li>If a <b>request</b> of saving value is called in Postman is called, there is <b>no cache</b> procedure</li>
        <li>If a <b>request</b> of finding any value which is stored by a save request is called, there is a <b>cache</b> procedure</li>
        <li>ıf a <b>request</b> of finding any values with providing a cachable condition is firstly called, there is <b>no cache</b> procedure. When it is called before, there is a <b>cache</b> procedure</li>
        <li>If a <b>request</b> of updating any value is called, there is <b>no cache</b> procedure</li>
        <li>If a <b>request</b> of deleting any value is called, there is <b>no cache</b> procedure</li>
      </ul>
  </li>
  <li>While <b>condition</b> of <b>Cachable</b> means that a <b>condition</b> process which has been firstly evaluated by a invoked method determines if check if the data with the given key exists and it returns the result, <b>unless</b> of of <b>Cachable</b> means that the process looks up the cache which was called and returns the result after executing the method.</li>
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
    <p> Figure 11 </p>
    <img src ="screenshots\redis_11.PNG">
</details>