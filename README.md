# Session-Manager
Session manager is an android library to store sessions very fast

[![](https://jitpack.io/v/medmedchiheb/Session-Manager.svg)](https://jitpack.io/#medmedchiheb/Session-Manager)
[![](https://camo.githubusercontent.com/cfcaf3a99103d61f387761e5fc445d9ba0203b01/68747470733a2f2f7472617669732d63692e6f72672f6477796c2f657374612e7376673f6272616e63683d6d6173746572)](https://jitpack.io/#medmedchiheb/Session-Manager)


# setup

add those lines to your build.gradle

step 1:
 ```
 allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  
  step 2: 
  ```
  dependencies {
	        implementation 'com.github.medmedchiheb:Session-Manager:1.0.8'
	}
  ```
  # start store sessions
  
   with session manager you can store sessions very fast, and any objects are supported by this library.
   
   start creating an instances of Session (in my case i'm using object, you can identify your object)
   
   ```
   Session<User> session=new Session<User>();
   ```
   
   store an object
   
   ```
    session.save(user);
   ```
   
   check if exists 
   ```
   session.exists();
   ```
   get object
   
   ```
   session.get(User.class);
   ```
   destroy a session 
   
   ```
   session.destroy();
   ```
   
   you can also set a listener when the session is destroyed
   
   ```
   session.setOnSessionDestroyed(this);
   ```
   
   finally an intersting feature, you can put property 
   
   ```
   session.putProperty("key","value");
   
   session.getString("key");
   
   session.existsString("key");
   ```
   
  # License 
  
  <pre>Copyright 2018 OctadevTn

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
</pre>
   
