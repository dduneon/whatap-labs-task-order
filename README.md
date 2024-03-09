# Order API

요구사항에 따른 응답을 제공하는 REST API 입니다

## ERD 설계
![image](https://github.com/dduneon/whatap-labs-task-order/assets/84072084/f92cabd6-fcf8-49be-9bee-f617c49f4d17)

## API 명세
![image](https://github.com/dduneon/whatap-labs-task-order/assets/84072084/e1513926-21b0-42eb-808c-e19b7ff0f3eb)

![image](https://github.com/dduneon/whatap-labs-task-order/assets/84072084/9bec3df0-8b25-4e86-8ed1-59b8877eb50c)

## API 사용 예시

### `GET /api/orders`

> 모든 주문 정보를 가져오는 요청

요청
```http
GET http://localhost:7020/api/orders
```
응답
```http
HTTP/1.1 200 OK
{
  "count": 3,
  "orders": [
    {
      "orderId": 1,
      "productId": 1
    },
    {
      "orderId": 2,
      "productId": 1
    },
    {
      "orderId": 3,
      "productId": 1
    }
  ]
}
```

<br>

### `GET /api/orders/{orderId}`

> 특정 주문 상세 정보를 가져오는 요청

요청
```http
GET /api/orders/1
```
응답
```http
HTTP/1.1 200 OK
{
  "orderId": 1,
  "productDetail": {
    "id": 1,
    "name": "상품명",
    "description": "상품설명"
  }
}
```

<br>

요청
```http
GET /api/orders/1111
```
응답
```http
HTTP/1.1 404 Not Found
{
  "message": "Order(id=1111) 를 찾을 수 없습니다",
  "status": 404
}
```

<br>

### `POST /api/orders`

> 상품 주문 요청

요청
```http
POST /api/orders
Content-Type: application/json
{
  "productId": 1
}
```
응답
```http
HTTP/1.1 201 Created
```

<br>

요청
```http
POST /api/orders
Content-Type: application/json
{
  "productId": 1000
}
```
응답
```http
HTTP/1.1 404 Not Found
{
  "message": "Product(id=1000) 를 찾을 수 없습니다",
  "status": 404
}
```

<br>

요청
```http
POST /api/orders
Content-Type: application/json
{
}
```
응답
```http
HTTP/1.1 400 Bad Request
{
  "title": "Constraint Violation",
  "status": 400,
  "violations": [
    {
      "field": "orderProduct.orderCreateRequestDto.productId",
      "message": "productId 필드가 비어 있습니다"
    }
  ]
}
```

<br>

### `PUT /api/orders`

> 주문 수정 요청

요청
```http
PUT http://localhost:7020/api/orders
Content-Type: application/json
{
  "orderId": 1,
  "productId": 3
}
```
응답
```http
HTTP/1.1 204 No Content
```

<br>

요청
```http
PUT http://localhost:7020/api/orders
Content-Type: application/json
{
  "orderId": 100,
  "productId": 3
}
```
응답
```http
HTTP/1.1 404 Not Found
{
  "message": "Order(id=100) 를 찾을 수 없습니다",
  "status": 404
}
```

<br>

요청
```http
PUT http://localhost:7020/api/orders
Content-Type: application/json
{
  "orderId": 1,
  "productId": 1000
}
```
응답
```http
HTTP/1.1 404 Not Found
{
  "message": "Product(id=1000) 를 찾을 수 없습니다",
  "status": 404
}
```

<br>

요청
```http
PUT http://localhost:7020/api/orders
Content-Type: application/json
{
  "productId": 1
}
```
응답
```http
HTTP/1.1 400 Bad Request
{
  "title": "Constraint Violation",
  "status": 400,
  "violations": [
    {
      "field": "changeProduct.orderUpdateRequestDto.orderId",
      "message": "orderId 필드가 비어 있습니다"
    }
  ]
}
```

<br>

### `DELETE /api/orders/{orderId}`

> 주문 삭제 요청

요청
```http
DELETE http://localhost:7020/api/orders/2
```
응답
```http
HTTP/1.1 204 No Content
```

<br>

요청
```http
DELETE http://localhost:7020/api/orders/1111
```
응답
```http
HTTP/1.1 404 Not Found
{
  "message": "Order(id=1111) 를 찾을 수 없습니다",
  "status": 404
}
```

<br>

### `GET /api/sleep?interval=`

> Sleep 요청

요청
```http
GET http://localhost:7020/api/sleep
```
응답
```http
HTTP/1.1 204 No Content

<Response body is empty>Response code: 204 (No Content); Time: 10889ms (10 s 889 ms);
```

<br>

요청
```http
GET http://localhost:7020/api/sleep?interval=5
```
응답
```http
HTTP/1.1 204 No Content

<Response body is empty>Response code: 204 (No Content); Time: 5013ms (5 s 13 ms);
```
