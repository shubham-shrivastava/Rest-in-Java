**Wingify Store**
----
  _These api are used for fetching, creating, modifying and deleting various products available in the db._

* **App Documentation URL**

     **https://wingifystore.herokuapp.com/**

* **Base URL**

    **https://wingifystore.herokuapp.com/wingify**

* **Method:**
  
    _Getting all the products_

     `GET`
  
*  **URL Params**

  
    * **Required:**
 
          `none`

    * **Optional:**
 
        `year=[numeric]`
        `start=[numeric]`
        `limit=[numeric]`

* **Data Params**

     `None`

* **Success Response:**
  

    * **Code:** 200
    * **Content:** `{"addedOn": "2017-05-14T16:15:25.728Z","description": 
       "DescriptionOfP1","id": 1,"name": "Product1","price": 25.23 }`
 
* **Error Response:** 

    * **Code:** 401 UNAUTHORIZED 
    * **Content:** `you are not authorized`

  OR

   * **Code:** 404 NOT_FOUND 
    

* **Sample Call:**

       _curl -X GET --user [uname]:[password] https://wingifystore.herokuapp.com/wingify/products_

    **If you are running curl behind proxy, please make sure you have configured 
       curl to use proxy.**


* **Method:**
  
    _Getting only one products_

    `GET`
  
*  **URL Params**

  
    * **Required:**
 
    `productId=[numeric]`

    * **Optional:**
 
     `none`

* **Data Params**

    `none`

* **Success Response:**


     * **Code:** 200 
     * **Content:** `{"addedOn": "2017-05-14T16:15:25.728Z","description": "DescriptionOfP1","id": 1,"name": "Product1","price": 25.23 }`
 
* **Error Response:**


    * **Code:** 401 UNAUTHORIZED 
    * **Content:** `you are not authorized`

  OR

   * **Code:** 404 NOT_FOUND 
    

* **Sample Call:**

    _curl -X GET --user <uname>:<password> https://wingifystore.herokuapp.com/wingify/products/[id]_


* **Method:**
  
     _Adding products to db_

      `POST`
  
* **URL Params**

  
     * **Required:**
 
         `none`

     * **Optional:**
 
         `none`

* **Data Params**

    `{"addedOn": "2017-05-14T16:15:25.728Z","description": "DescriptionOfP1","name": 
     "Product1","price": 25.23 }`

* **Success Response:**


    * **Code:** 200
    * **Content:** `{"addedOn": "2017-05-14T16:15:25.728Z","description": "DescriptionOfP1","id": 1,"name": "Product1","price": 25.23 }`
 
* **Error Response:**

 
    * **Code:** 401 UNAUTHORIZED 
    * **Content:** `you are not authorized`

    

* **Sample Call:**

     _curl -H "Content-Type: application/json" -d "{\"addedOn\": \"2017-05-
   14T16:15:25.728Z\",\"description\": \"DescriptionOfP1\",\"name\": \"Product1\",\"price\": 25.23 }" -
   X POST --user [uname]:[password] https://wingifystore.herokuapp.com/wingify/products_

* **Notes:**

    **You can find username and password with the vendor.**


    **Please Note:** You won't be able to delete or update existing two product through the 
       API. This is for demo purpose. To perform deletion or updation you will have to add 
       product first using the POST.